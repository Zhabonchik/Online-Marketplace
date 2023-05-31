package by.fpmibsu.OnlineMarketplace.service;

import by.fpmibsu.OnlineMarketplace.DAO.ConnectionPool;
import by.fpmibsu.OnlineMarketplace.DAO.ImageDao;
import by.fpmibsu.OnlineMarketplace.DAO.UserDao;
import by.fpmibsu.OnlineMarketplace.DAO.VendorDao;
import by.fpmibsu.OnlineMarketplace.entity.Image;
import by.fpmibsu.OnlineMarketplace.entity.User;
import by.fpmibsu.OnlineMarketplace.entity.Vendor;
import by.fpmibsu.OnlineMarketplace.exception.ValidationException;
import by.fpmibsu.OnlineMarketplace.validation.RegisterUserValidator;
import by.fpmibsu.OnlineMarketplace.validation.RegisterVendorValidator;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;

public class VendorService {
    private static final Logger LOGGER = LogManager.getLogger(UserService.class);
    private static final VendorService INSTANCE = new VendorService();
    private final RegisterVendorValidator registerVendorValidator= RegisterVendorValidator.getInstance();
    private final VendorDao vendorDao = new VendorDao();
    private final UserDao userDao = new UserDao();
    @SneakyThrows
    public int create(Vendor vendor, String link) throws ValidationException {
        LOGGER.info("creating connection in create");
        Connection connection = ConnectionPool.getConnectionPool().getConnection();
        LOGGER.info("setting connection in create -> vendorDao");
        vendorDao.setConnection(connection);
        ImageDao imageDao = new ImageDao();
        vendorDao.setConnection(connection);
        userDao.setConnection(connection);
        LOGGER.info("setting connection in create -> imageDao");
        imageDao.setConnection(connection);
        var validationResult = registerVendorValidator.isValid(vendor);
        if(vendorDao.findByLogin(vendor.getLogin_()).getID_vendor_() != 0 || userDao.findByLogin(vendor.getLogin_()).getID_user_() != 0){
            LOGGER.error("in create: A vendor with this login already exists");
            throw new RuntimeException("A vendor with this login already exists");
        }
        if(!validationResult.isValid()){
            LOGGER.error("in create: vendor is invalid");
            throw new ValidationException(validationResult.getErrors());
        } else {
            LOGGER.info("finding image by link in create");
            Image image = imageDao.findByLink(link);
            if(image.getID_image_() != 0){
                vendor.setID_image_(image.getID_image_());
            } else {
                int id = imageDao.create(new Image(1, link));
                vendor.setID_image_(id);
            }
            LOGGER.info("getting answer in create");
            int answer = vendorDao.create(vendor);
            LOGGER.info("closing connection in create");
            connection.close();
            return answer;
        }
    }

    public static VendorService getInstance(){
        return INSTANCE;
    }
}
