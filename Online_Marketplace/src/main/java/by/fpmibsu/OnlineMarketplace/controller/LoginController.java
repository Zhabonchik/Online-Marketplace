package by.fpmibsu.OnlineMarketplace.controller;

import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.entity.Vendor;
import by.fpmibsu.OnlineMarketplace.service.LoginService;
import by.fpmibsu.OnlineMarketplace.service.VendorService;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller{
    private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("getting RequestDispatcher in processGet");
        request.getRequestDispatcher(JspHelper.getPath("login")).forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("getting login from request in processPost");
        String login = request.getParameter("login");
        LOGGER.info("getting password from request in processPost");
        String password = request.getParameter("password");
        try{
            LOGGER.info("creating user in processPost");
            boolean no_user = false;
            User user = new User();
            Vendor vendor = new Vendor();
            try {
                 user = LoginService.getInstance().findUser(login, password);
            } catch (RuntimeException e){
                no_user = true;
            }
            if(no_user) {
                try {
                    vendor = LoginService.getInstance().findVendor(login, password);
                } catch (RuntimeException e){
                    throw new RuntimeException(e.getMessage());
                }
            }
            if(!no_user) {
                LOGGER.info("setting session attribute -> user in processPost");
                request.getSession().setAttribute("user", user);
                LOGGER.info("setting request attribute -> user in processPost");
                request.setAttribute("user", user);
                LOGGER.info("redirecting to home in processPost");
            } else {
                LOGGER.info("setting session attribute -> vendor in processPost");
                request.getSession().setAttribute("vendor", vendor);
                LOGGER.info("setting request attribute -> vendor in processPost");
                request.setAttribute("vendor", vendor);
                LOGGER.info("redirecting to home in processPost");
            }
            response.sendRedirect("/marketplace/home");
        } catch(RuntimeException e){
            LOGGER.error("Runtime exception in processPost");
            response.sendRedirect(String.format("/marketplace/login?error=%s",e.getMessage()));
        } catch(Exception e){
            LOGGER.error("Exception in processPost");
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher(JspHelper.getPath("error")).forward(request, response);
        }
    }
}
