package by.fpmibsu.OnlineMarketplace.controller;

import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.service.ReviewService;
import by.fpmibsu.OnlineMarketplace.util.JspHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReviewsController implements Controller{
    private static final Logger LOGGER = LogManager.getLogger(ReviewsController.class);
    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("processing user in session in processGet");
        if(request.getSession().getAttribute("user") != null){
            LOGGER.info("user is not null in processGet");
            request.getRequestDispatcher(JspHelper.getPath("review")).forward(request, response);
        } else {
            LOGGER.info("user is null in processGet");
            response.sendRedirect("/marketplace/login");
        }
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long phoneId = Long.parseLong(request.getParameter("phoneId"));
        String review = (String)request.getParameter("review");
        Long userId = ((User)request.getSession().getAttribute("user")).getID_user_();
        int answer = 0;
        try{
            LOGGER.info("creating review in processPost");
            answer = ReviewService.getInstance().create(phoneId, userId, review);
        }catch(IllegalArgumentException e){
            LOGGER.error("Review text is empty in process Post");
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher(JspHelper.getPath("review")).forward(request, response);
        }
        response.sendRedirect(String.format("/marketplace/phone?phoneId=%d",phoneId));
    }
}
