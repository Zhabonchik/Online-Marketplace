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

public class HomePageController implements Controller{
    private static final Logger LOGGER = LogManager.getLogger(HomePageController.class);
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("getting all phones in processGet");
        List<Phone> phones = PhoneService.getInstance().getAllPhones();
        for(int i = 1; i <= 6; ++i){
            LOGGER.info("setting Phone attribute in processGet");
            request.setAttribute(String.format("Phone%d", i), phones.get(i-1));
            LOGGER.info("getting image link in processGet");
            String imageLink = PhoneService.getInstance().imageRef(phones.get(i-1).getID_image_());
            LOGGER.info("setting image link attribute in processGet");
            request.setAttribute(String.format("Image%d", i), imageLink);
        }
        request.getRequestDispatcher(JspHelper.getPath("home")).forward(request, response);
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
