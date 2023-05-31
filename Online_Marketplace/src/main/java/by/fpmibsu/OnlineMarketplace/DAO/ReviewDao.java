package by.fpmibsu.OnlineMarketplace.DAO;

import by.fpmibsu.OnlineMarketplace.entity.Review;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewDao extends AbstractDaoSimple<Review> {
    private static final String SQL_SELECT_ALL_REVIEWS = "SELECT * FROM Review";
    private static final String SQL_SELECT_BY_ID_User = "SELECT * FROM Review WHERE ID_User=?";
    private static final String SQL_SELECT_BY_ID_Product = "SELECT * FROM Review WHERE ID_Product=?";
    private static final String SQL_SELECT_BY_ID_User_AND_ID_Product = "SELECT * FROM Review WHERE ID_User=? AND ID_Product=?";
    private static final String SQL_DELETE_BY_ID_User = "DELETE FROM Review WHERE ID_User=?";
    private static final String SQL_DELETE_BY_ID_Product = "DELETE FROM Review WHERE ID_Product=?";
    private static final String SQL_DELETE_BY_ID_User_AND_ID_Product = "DELETE FROM Review WHERE ID_User=? AND ID_Product=?";

    public ReviewDao(){
        this.connection = null;
    }

    @Override
    public List<Review> findAll() throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_REVIEWS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Review review = new Review();
                review.setID_user_(resultSet.getLong("ID_User"));
                review.setID_product_(resultSet.getLong("ID_Product"));
                review.setReview_(resultSet.getString("Review"));
                reviews.add(review);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return reviews;
    }
    public List<Review> findByUserId(long id) throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_User);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Review review = new Review();
                review.setID_user_(resultSet.getLong("ID_User"));
                review.setID_product_(resultSet.getLong("ID_Product"));
                review.setReview_(resultSet.getString("Review"));
                reviews.add(review);
            }
        }catch(SQLException e){
            throw new DaoException(e);
        }finally {
            close(preparedStatement);
        }
        return reviews;
    }

    public List<Review> findByProductId(long id) throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_Product);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Review review = new Review();
                review.setID_user_(resultSet.getLong("ID_User"));
                review.setID_product_(resultSet.getLong("ID_Product"));
                review.setReview_(resultSet.getString("Review"));
                reviews.add(review);
            }
        }catch(SQLException e){
            throw new DaoException(e);
        }finally {
            close(preparedStatement);
        }
        return reviews;
    }
    public List<Review> findByUserIdAndProductId(long idU, long idP) throws DaoException {
        List<Review> reviews = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID_User_AND_ID_Product);
            preparedStatement.setLong(1, idU);
            preparedStatement.setLong(2, idP);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Review review = new Review();
                review.setID_user_(resultSet.getLong("ID_User"));
                review.setID_product_(resultSet.getLong("ID_Product"));
                review.setReview_(resultSet.getString("Review"));
                reviews.add(review);
            }
        }catch(SQLException e){
            throw new DaoException(e);
        }finally {
            close(preparedStatement);
        }
        return reviews;
    }
    public int deleteByUserId(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_User);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int deleteByProductId(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_Product);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    public int deleteByUserIdAndProductId(long idU, long idP) throws DaoException {
        PreparedStatement preparedStatement = null;
        int result;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID_User_AND_ID_Product);
            preparedStatement.setLong(1, idU);
            preparedStatement.setLong(2, idP);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }
    public int delete(Review entity) throws DaoException {
        return deleteByUserIdAndProductId(entity.getID_user_(), entity.getID_product_());
    }

    public int create(Review entity) throws DaoException {
        int result = 0;
        String query = "INSERT INTO Review VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, entity.getID_user_());
            preparedStatement.setLong(2, entity.getID_product_());
            preparedStatement.setString(3, entity.getReview_());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if(rs != null && rs.next()){
             result = rs.getInt(1);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    public boolean update(Review entity) throws DaoException {
        Statement statement = null;
        int result = 0;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Reviews WHERE ID_User = %d AND ID_Product = %d", entity.getID_user_(), entity.getID_product_()));
            resultSet.updateString("Review", entity.getReview_());
            resultSet.updateRow();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally {
            close(statement);
        }
        return true;
    }
}
