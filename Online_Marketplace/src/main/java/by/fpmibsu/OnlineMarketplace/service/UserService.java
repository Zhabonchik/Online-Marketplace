package by.fpmibsu.OnlineMarketplace.service;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.DAO.UserDao;
import by.fpmibsu.OnlineMarketplace.DAO.VendorDao;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.exception.ValidationException;
import by.fpmibsu.OnlineMarketplace.validation.CustomError;
import by.fpmibsu.OnlineMarketplace.validation.RegisterUserValidator;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class UserService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private static final UserService INSTANCE = new UserService();
    private final RegisterUserValidator  registerUserValidator= RegisterUserValidator.getInstance();
    private final UserDao userDao = new UserDao();
    private final VendorDao vendorDao = new VendorDao();
    @SneakyThrows
    public int create(User user, String link) throws ValidationException {
        LOGGER.info("creating connection in create");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in create -> userDao");
        userDao.setConnection(connection);
        vendorDao.setConnection(connection);
        ImageDao imageDao = new ImageDao();
        LOGGER.info("setting connection in create -> imageDao");
        imageDao.setConnection(connection);
        var validationResult = registerUserValidator.isValid(user);
        if(userDao.findByLogin(user.getLogin_()).getID_user_() != 0 || vendorDao.findByLogin(user.getLogin_()).getID_vendor_() != 0){
            LOGGER.error("in create: A user with this login already exists");
            throw new RuntimeException("A user with this login already exists");
        }
        if(!validationResult.isValid()){
            LOGGER.error("in create: user is invalid");
            throw new ValidationException(validationResult.getErrors());
        } else {
            LOGGER.info("finding image by link in create");
            Image image = imageDao.findByLink(link);
            if(image.getID_image_() != 0){
                user.setID_image_(image.getID_image_());
            } else {
                int id = imageDao.create(new Image(1, link));
                user.setID_image_(id);
            }
            LOGGER.info("getting answer in create");
            int answer = userDao.create(user);
            LOGGER.info("closing connection in create");
            connection.close();
            return answer;
        }
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
