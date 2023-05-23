package service;

import by.fpmibsu.OnlineMarketplace.DAO.DaoException;
import by.fpmibsu.OnlineMarketplace.DAO.ReviewDao;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import by.fpmibsu.OnlineMarketplace.entity.Review;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;

public class ReviewService extends Service<Review> {

    private ReviewDao reviewDao = new ReviewDao();
    public ReviewService(Connection connection){
        this.connection = connection;
        reviewDao.setConnection(connection);
    }

    @Override
    public JSONArray findAll() throws DaoException {
        List<Review> reviews = reviewDao.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Review review : reviews){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id_user", review.getID_user_());
            jsonObject.put("id_product", review.getID_product_());
            jsonObject.put("review", review.getReview_());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray findByUserId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        List<Review> reviews = reviewDao.findByUserId(Long.parseLong(request.getParameter("id_user")));
        for(Review review : reviews){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id_user", review.getID_user_());
            jsonObject.put("id_product", review.getID_product_());
            jsonObject.put("review", review.getReview_());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray findByProductId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        List<Review> reviews = reviewDao.findByProductId(Long.parseLong(request.getParameter("id_product")));
        for(Review review : reviews){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id_user", review.getID_user_());
            jsonObject.put("id_product", review.getID_product_());
            jsonObject.put("review", review.getReview_());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray findByUserIdAndProductId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        List<Review> reviews = reviewDao.findByUserIdAndProductId(Long.parseLong(request.getParameter("id_user")), Long.parseLong(request.getParameter("id_product")));
        for(Review review : reviews){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id_user", review.getID_user_());
            jsonObject.put("id_product", review.getID_product_());
            jsonObject.put("review", review.getReview_());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    public JSONArray deleteByUserId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deleted image", reviewDao.deleteByUserId(Long.parseLong(request.getParameter("id_user"))));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    public JSONArray deleteByProductId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deleted review", reviewDao.deleteByUserIdAndProductId(Long.parseLong(request.getParameter("id_user")), Long.parseLong(request.getParameter("id_product"))));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    public JSONArray deleteByUserIdAndProductId(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deleted review", reviewDao.deleteByProductId(Long.parseLong(request.getParameter("id_product"))));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray create(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        long id_user = Long.parseLong(request.getParameter("id_user"));
        long id_product = Long.parseLong(request.getParameter("id_product"));
        String review = request.getParameter("review");
        jsonObject.put("created review", reviewDao.create(new Review(id_user, id_product, review)));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray update(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        long id_user = Long.parseLong(request.getParameter("id_user"));
        long id_product = Long.parseLong(request.getParameter("id_product"));
        String review = request.getParameter("review");
        jsonObject.put("updated review", reviewDao.update(new Review(id_user, id_product, review)));
        jsonArray.add(jsonObject);
        return jsonArray;
    }
}
