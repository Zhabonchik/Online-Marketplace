package by.fpmibsu.OnlineMarketplace.DAO;
import by.fpmibsu.OnlineMarketplace.entity.Role;
import by.fpmibsu.OnlineMarketplace.entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.fpmibsu.OnlineMarketplace.OtherClasses.PasswordHash;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public class UserDao extends AbstractDao<User> {
    private static final String SQL_SELECT_ALL_USERS = "SELECT * FROM Users";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Users WHERE ID_User=?";
    private static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM Users WHERE Login=?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM Users WHERE ID_User=?";
    public UserDao(){
        this.connection = null;
    }
    @Override
    public List<User> findAll() throws DaoException {
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setID_user_(resultSet.getLong("ID_User"));
                user.setLogin_(resultSet.getString("Login"));
                user.setPassword_(resultSet.getString("Password"));
                user.setName_(resultSet.getString("Name"));
                user.setSurname_(resultSet.getString("Surname"));
                user.setContacts_(resultSet.getString("Contacts"));
                user.setID_image_(resultSet.getLong("ID_Image"));
                boolean is_Admin = resultSet.getBoolean("Is_Admin");
                if(is_Admin){
                    user.setRole_(Role.Admin);
                } else {
                    user.setRole_(Role.Customer);
                }
                users.add(user);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return users;
    }

    @Override
    public User findById(long id) throws DaoException {
        User user = new User();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user.setID_user_(resultSet.getLong("ID_User"));
                user.setLogin_(resultSet.getString("Login"));
                user.setPassword_(resultSet.getString("Password"));
                user.setName_(resultSet.getString("Name"));
                user.setSurname_(resultSet.getString("Surname"));
                user.setContacts_(resultSet.getString("Contacts"));
                user.setID_image_(resultSet.getLong("ID_Image"));
                boolean is_Admin = resultSet.getBoolean("Is_Admin");
                if(is_Admin){
                    user.setRole_(Role.Admin);
                } else {
                    user.setRole_(Role.Customer);
                }
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return user;
    }

    public User findByLogin(String login) throws DaoException {
        User user = new User();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                user.setID_user_(resultSet.getLong("ID_User"));
                user.setLogin_(resultSet.getString("Login"));
                user.setPassword_(resultSet.getString("Password"));
                user.setName_(resultSet.getString("Name"));
                user.setSurname_(resultSet.getString("Surname"));
                user.setContacts_(resultSet.getString("Contacts"));
                user.setID_image_(resultSet.getLong("ID_Image"));
                boolean is_Admin = resultSet.getBoolean("Is_Admin");
                if(is_Admin){
                    user.setRole_(Role.Admin);
                } else {
                    user.setRole_(Role.Customer);
                }
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return user;
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
    public int delete(User entity) throws DaoException {
        return delete(entity.getID_user_());
    }

    @Override
    public int create(User entity) throws DaoException {
        String query = "INSERT INTO Users VALUES (?,?,?,?,?,?,?)";
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
            boolean isAdmin;
            if(entity.getRole_().equals(Role.Admin)){
                isAdmin = true;
            } else {
                isAdmin = false;
            }
            preparedStatement.setBoolean(1, isAdmin);
            preparedStatement.setString(2, entity.getLogin_());
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, entity.getName_());
            preparedStatement.setString(5, entity.getSurname_());
            preparedStatement.setString(6, entity.getContacts_());
            preparedStatement.setLong(7, entity.getID_image_());
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
    public boolean update(User entity) throws DaoException {
        Statement statement = null;
        int result;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Users WHERE ID_User = %d", entity.getID_user_()));
            String password = "";
            try {
                Pbkdf2PasswordEncoder pbkdf2PasswordEncoder = new Pbkdf2PasswordEncoder();
                password = pbkdf2PasswordEncoder.encode(entity.getPassword_());
            } catch (Exception e){

            }
            boolean isAdmin = entity.getRole_().equals(Role.Admin);
            resultSet.updateBoolean("Is_Admin", isAdmin);
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
