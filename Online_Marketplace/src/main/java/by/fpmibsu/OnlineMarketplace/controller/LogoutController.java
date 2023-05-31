package by.fpmibsu.OnlineMarketplace.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutController implements Controller{
    private static final Logger LOGGER = LogManager.getLogger(LogoutController.class);
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("invalidating session in processGet");
        request.getSession().invalidate();
        LOGGER.info("redirecting to home in processGet");
        response.sendRedirect("/marketplace/home");
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("invalidating session in processPost");
        request.getSession().invalidate();
        LOGGER.info("redirecting to home in processPost");
        response.sendRedirect("/marketplace/home");
    }
}
