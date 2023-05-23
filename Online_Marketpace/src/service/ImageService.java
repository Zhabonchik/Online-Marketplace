package service;

import by.fpmibsu.OnlineMarketplace.DAO.DaoException;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.sql.Connection;
import java.util.List;

public class ImageService extends Service<Image> {
    private ImageDao imageDao = new ImageDao();
    public ImageService(Connection connection){
        this.connection = connection;
        imageDao.setConnection(connection);
    }
    @Override
    public JSONArray findAll() throws DaoException {
        List <Image> images = imageDao.findAll();
        JSONArray jsonArray = new JSONArray();
        for(Image image : images){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", image.getID_image_());
            jsonObject.put("link", image.getLink_());
            jsonArray.add(jsonObject);
        }
        return jsonArray;
    }

    @Override
    public JSONArray findById(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        Image image = imageDao.findById(Long.parseLong(request.getParameter("id")));
        jsonObject.put("id", image.getID_image_());
        jsonObject.put("link", image.getLink_());
        jsonArray.add(jsonObject);
        return jsonArray;
    }
    public JSONArray findByLink(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        Image image = imageDao.findByLink(request.getParameter("id"));
        jsonObject.put("id", image.getID_image_());
        jsonObject.put("link", image.getLink_());
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray deleteById(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("deleted image", imageDao.delete(Long.parseLong(request.getParameter("id"))));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray create(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        long id = Long.parseLong(request.getParameter("id"));
        String link = request.getParameter("link");
        jsonObject.put("created image", imageDao.create(new Image(id, link)));
        jsonArray.add(jsonObject);
        return jsonArray;
    }

    @Override
    public JSONArray update(HttpServletRequest request) throws DaoException {
        JSONArray jsonArray =  new JSONArray();
        JSONObject jsonObject = new JSONObject();
        long id = Long.parseLong(request.getParameter("id"));
        String link = request.getParameter("link");
        jsonObject.put("updated image", imageDao.update(new Image(id, link)));
        jsonArray.add(jsonObject);
        return jsonArray;
    }
}
