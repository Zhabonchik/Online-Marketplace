package controller;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionCreator;
import by.fpmibsu.OnlineMarketplace.exception.MyException;
import org.json.simple.JSONArray;
import service.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;

public class Controller {
    public static final Controller INSTANCE = new Controller();
    public static final Controller getInstance(){
        return INSTANCE;
    }
    public JSONArray proceedRequest(HttpServletRequest request) throws MyException {
        String entity = request.getParameter("entity");
        String reqType = request.getParameter("request");
        JSONArray jsonArray = new JSONArray();
        switch(entity){
            case "image" :
                try {
                    Connection connection = ConnectionCreator.createConnection();
                    ImageService imageService = new ImageService(connection);
                    switch(reqType){
                        case "findAll" :
                            jsonArray = imageService.findAll();
                            break;
                        case "findById" :
                            jsonArray = imageService.findById(request);
                            break;
                        case "findByLink" :
                            jsonArray = imageService.findByLink(request);
                            break;
                        case "deleteById":
                            jsonArray = imageService.deleteById(request);
                            break;
                        case "create":
                            jsonArray = imageService.create(request);
                            break;
                        case "update" :
                            jsonArray = imageService.update(request);
                            break;
                        default:
                            throw new MyException("No such request for image");
                    }
                    connection.close();
                } catch(Exception exception){
                    throw new MyException(exception.getMessage());
                }
                break;
            case "order" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with order");
                }
                break;
            case "phone" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with phone");
                }
                break;
            case "review" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with review");
                }
                break;
            case "user" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with user");
                }
                break;
            case "vendor" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with vendor");
                }
                break;
            case "catalog" :
                try {

                } catch(Exception exception){
                    throw new MyException("Something wrong with catalog");
                }
                break;
            default:
                throw new MyException("No such entity");
        }
        return jsonArray;
    }
}
