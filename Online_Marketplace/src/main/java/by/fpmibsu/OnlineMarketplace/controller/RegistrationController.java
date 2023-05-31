package by.fpmibsu.OnlineMarketplace.controller;

import by.fpmibsu.OnlineMarketplace.controller.Controller;
import by.fpmibsu.OnlineMarketplace.entity.Role;
import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.entity.Vendor;
import by.fpmibsu.OnlineMarketplace.exception.ValidationException;
import by.fpmibsu.OnlineMarketplace.service.UserService;
import by.fpmibsu.OnlineMarketplace.service.VendorService;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;
import by.fpmibsu.OnlineMarketplace.validation.CustomError;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationController implements Controller {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationController.class);
    private UserService userService = UserService.getInstance();
    private VendorService vendorService = VendorService.getInstance();
    @SneakyThrows
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedOperationException{
        LOGGER.info("forwarding to registration in processGet");
        request.getRequestDispatcher(JspHelper.getPath("registration")).forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws UnsupportedOperationException, ServletException, IOException {
        if(request.getParameter("role").equals("USER")) {
            LOGGER.info("creating customer in processPost");
            User user = new User(0, Role.Customer, (String) request.getParameter("login"), (String) request.getParameter("password"),
                    (String) request.getParameter("name"), (String) request.getParameter("surname"), (String) request.getParameter("contacts"), 1);
            try{
                if(userService.create(user, (String)request.getParameter("imageref")) > 0){
                    LOGGER.info("setting session attribute -> customer in processPost");
                    request.getSession().setAttribute("user", user);
                    LOGGER.info("redirecting to home in processPost");
                    response.sendRedirect("/marketplace/home");
                }
            } catch (ValidationException e){
                LOGGER.error("customer with such login already exists");
                request.getRequestDispatcher(JspHelper.getPath("error")).forward(request, response);
                response.getWriter().write("User with such login already exists");
            }
            catch (RuntimeException e){
                LOGGER.error("exception in processPost/customer");
                response.getWriter().write(e.getMessage());
            }
        } else {
            LOGGER.info("creating vendor in processPost");
            Vendor vendor = new Vendor(0, (String) request.getParameter("login"), (String) request.getParameter("password"),
                    (String) request.getParameter("name"), (String) request.getParameter("surname"), (String) request.getParameter("contacts"), 1);
            try{
                if(vendorService.create(vendor, (String)request.getParameter("imageref")) > 0){
                    LOGGER.info("setting session attribute -> vendor in processPost");
                    request.getSession().setAttribute("vendor", vendor);
                    LOGGER.info("redirecting to home in processPost");
                    response.sendRedirect("/marketplace/home");
                }
            } catch (ValidationException e){
                LOGGER.error("vendor with such login already exists");
                request.getRequestDispatcher(JspHelper.getPath("error")).forward(request, response);
                response.getWriter().write("Vendor with such login already exists");
            }
            catch (RuntimeException e){
                LOGGER.error("exception in processPost/vendor");
                response.getWriter().write(e.getMessage());
            }
        }
    }
}
