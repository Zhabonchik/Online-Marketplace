package by.fpmibsu.OnlineMarketplace.controller;

import by.fpmibsu.OnlineMarketplace.entity.Phone;
import by.fpmibsu.OnlineMarketplace.entity.Review;
import by.fpmibsu.OnlineMarketplace.service.PhoneService;
import by.fpmibsu.OnlineMarketplace.service.ReviewService;
import by.fpmibsu.OnlineMarketplace.servlet.Servlet;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PhoneController implements Controller{
    private static final Logger LOGGER = LogManager.getLogger(PhoneController.class);
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("getting phone in processGet");
        Phone phone = PhoneService.getInstance().getPhoneById(Long.parseLong(request.getParameter("phoneId")));
        LOGGER.info("setting request attribute in processGet");
        request.setAttribute("PhoneToDisplay", phone);
        LOGGER.info("getting image link in processGet");
        String imageLink = PhoneService.getInstance().imageRef(phone.getID_image_());
        LOGGER.info("setting image link in processGet");
        request.setAttribute("ImageToDisplay", imageLink);
        LOGGER.info("getting reviews in processGet");
        List<Review> reviews = ReviewService.getInstance().getReviewsByProduct(Long.parseLong(request.getParameter("phoneId")));
        LOGGER.info("setting reviews in request attribute");
        request.setAttribute("ReviewsToDisplay", reviews);
        LOGGER.info("forwarding to phone in processGet");
        request.getRequestDispatcher(JspHelper.getPath("phone")).forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
