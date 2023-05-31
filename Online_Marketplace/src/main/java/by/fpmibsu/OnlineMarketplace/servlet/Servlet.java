package by.fpmibsu.OnlineMarketplace.servlet;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.controller.Controller;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@MultipartConfig
//@WebServlet("/marketplace/*")
@WebServlet(urlPatterns = "/marketplace/*")
public class Servlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(Servlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("setting attribute doGet");
        req.setAttribute("method", "doGet");
        LOGGER.info("processing request and response");
        process(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOGGER.info("setting attribute doPost");
        req.setAttribute("method", "doPost");
        LOGGER.info("processing request and response");
        process(req,resp);
    }

    @SneakyThrows
    public void process(HttpServletRequest req, HttpServletResponse resp){
        Controller controller = (Controller) req.getAttribute("controller");
        if(controller != null){
            if(req.getAttribute("method").equals("doPost")){
                LOGGER.info("doPost Controller processing request and response");
                controller.processPost(req, resp);
            } else {
                LOGGER.info("doGet Controller processing request and response");
                controller.processGet(req, resp);
            }
        } else {
            LOGGER.error("no controller found");
            req.setAttribute("error", "Controller Error");
            req.getRequestDispatcher(JspHelper.getPath("error")).forward(req, resp);
        }
    }
    public void destroy(){
        LOGGER.info("closing connection pool");
        ConnectionPool.getConnectionPool().close();
        LOGGER.info("destroying servlet");
    }
}
