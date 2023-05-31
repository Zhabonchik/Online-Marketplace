package by.fpmibsu.OnlineMarketplace.DAO;

import by.fpmibsu.OnlineMarketplace.OtherClasses.PasswordHash;
import by.fpmibsu.OnlineMarketplace.entity.Vendor;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VendorDao extends AbstractDao<Vendor>{
    private static final String SQL_SELECT_ALL_VENDORS = "SELECT * FROM Vendor";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Vendor WHERE ID_Vendor=?";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM Vendor WHERE Login=?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM Vendor WHERE ID_Vendor=?";
    public VendorDao(){
        this.connection = null;
    }
    @Override
    public List<Vendor> findAll() throws DaoException {
        List<Vendor> vendors = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_VENDORS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Vendor vendor = new Vendor();
                vendor.setID_vendor_(resultSet.getLong("ID_Vendor"));
                vendor.setLogin_(resultSet.getString("Login"));
                vendor.setPassword_(resultSet.getString("Password"));
                vendor.setName_(resultSet.getString("Name"));
                vendor.setSurname_(resultSet.getString("Surname"));
                vendor.setContacts_(resultSet.getString("Contacts"));
                vendor.setID_image_(resultSet.getLong("ID_Image"));
                vendors.add(vendor);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return vendors;
    }

    @Override
    public Vendor findById(long id) throws DaoException {
        Vendor vendor = new Vendor();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                vendor.setID_vendor_(resultSet.getLong("ID_Vendor"));
                vendor.setLogin_(resultSet.getString("Login"));
                vendor.setPassword_(resultSet.getString("Password"));
                vendor.setName_(resultSet.getString("Name"));
                vendor.setSurname_(resultSet.getString("Surname"));
                vendor.setContacts_(resultSet.getString("Contacts"));
                vendor.setID_image_(resultSet.getLong("ID_Image"));
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return vendor;
    }

    public Vendor findByLogin(String login) throws DaoException {
        Vendor vendor = new Vendor();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                vendor.setID_vendor_(resultSet.getLong("ID_Vendor"));
                vendor.setLogin_(resultSet.getString("Login"));
                vendor.setPassword_(resultSet.getString("Password"));
                vendor.setName_(resultSet.getString("Name"));
                vendor.setSurname_(resultSet.getString("Surname"));
                vendor.setContacts_(resultSet.getString("Contacts"));
                vendor.setID_image_(resultSet.getLong("ID_Image"));
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return vendor;
    }

    @Override
    public int delete(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return result;
    }

    @Override
    public int delete(Vendor entity) throws DaoException {
        return delete(entity.getID_vendor_());
    }

    @Override
    public int create(Vendor entity) throws DaoException {
        String query = "INSERT INTO Vendor VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        int result = 0;
        try {
            preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            String password = "";
            try {
                Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
                password = pbkdf2PasswordEncoder.encode(entity.getPassword_());
            } catch (Exception e){

            }
            preparedStatement.setString(1, entity.getLogin_());
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, entity.getName_());
            preparedStatement.setString(4, entity.getSurname_());
            preparedStatement.setString(5, entity.getContacts_());
            preparedStatement.setLong(6, entity.getID_image_());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs != null && rs.next()){
                result = rs.getInt(1);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return result;
    }

    @Override
    public boolean update(Vendor entity) throws DaoException {
        Statement statement = null;
        int result;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Vendor WHERE ID_Vendor = %d", entity.getID_vendor_()));
            String password = "";
            try {
                Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
                password = pbkdf2PasswordEncoder.encode(entity.getPassword_());
            } catch (Exception e){

            }
            resultSet.updateString("Login", entity.getLogin_());
            resultSet.updateString("Password", password);
            resultSet.updateString("Name", entity.getName_());
            resultSet.updateString("Surname", entity.getSurname_());
            resultSet.updateString("Contacts", entity.getContacts_());
            resultSet.updateLong("ID_Image", entity.getID_image_());
            resultSet.updateRow();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return true;
    }
}
