package by.fpmibsu.OnlineMarketplace.service;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.DAO.PhoneDao;
import by.fpmibsu.OnlineMarketplace.DAO.ReviewDao;
import by.fpmibsu.OnlineMarketplace.entity.Phone;
import by.fpmibsu.OnlineMarketplace.entity.Review;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;

public class ReviewService {
    private static final Logger LOGGER = LogManager.getLogger(ReviewService.class);
    private static final ReviewService INSTANCE = new ReviewService();
    private final ReviewDao reviewDao = new ReviewDao();
    @SneakyThrows
    public List<Review> getReviewsByProduct(Long id){
        LOGGER.info("getting connection in getReviewsByProduct");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in getReviewsByProduct");
        reviewDao.setConnection(connection);
        LOGGER.info("getting reviews in getReviewsByProduct");
        List<Review> reviews = reviewDao.findByProductId(id);
        LOGGER.info("closing connection in getReviewsByProduct");
        connection.close();
        return reviews;
    }

    @SneakyThrows
    public int create(Long phoneId, Long userId, String review) throws IllegalArgumentException{
        LOGGER.info("getting connection in create");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in create");
        reviewDao.setConnection(connection);
        LOGGER.info("checking review in create");
        if(review == null || review.isEmpty()){
            throw new IllegalArgumentException("Review can't be empty");
        }
        LOGGER.info("creating reviews in create");
        Review review1 = new Review(userId, phoneId, review);
        int answer = reviewDao.create(review1);
        LOGGER.info("closing connection in create");
        connection.close();
        return answer;
    }

    public static ReviewService getInstance(){
        return INSTANCE;
    }
}
