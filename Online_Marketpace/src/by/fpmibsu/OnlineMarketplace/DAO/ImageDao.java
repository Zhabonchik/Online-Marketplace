package by.fpmibsu.OnlineMarketplace.DAO;
import by.fpmibsu.OnlineMarketplace.entity.Image;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class ImageDao extends AbstractDao<Image>{
    private static final String SQL_SELECT_ALL_IMAGES = "SELECT * FROM Image";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Image WHERE ID_Image=?";
    private static final String SQL_SELECT_BY_LINK = "SELECT * FROM Image WHERE =?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM Image WHERE Image_Link=?";
    public ImageDao(){
        this.connection = null;
    }
    @Override
    public List<Image> findAll() throws DaoException {
        PreparedStatement preparedStatement = null;
        List<Image> images = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_IMAGES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Image image= new Image();
                image.setID_image_(resultSet.getLong("ID_Image"));
                image.setLink_(resultSet.getString("Image_Link"));
                images.add(image);
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return images;
    }

    @Override
    public Image findById(long id) throws DaoException {
        PreparedStatement preparedStatement = null;
        Image image = new Image();
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                image.setID_image_(resultSet.getLong("ID_Image"));
                image.setLink_(resultSet.getString("Image_Link"));
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return image;
    }

    public Image findByLink(String link) throws DaoException {
        PreparedStatement preparedStatement = null;
        Image image = new Image();
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_LINK);
            preparedStatement.setString(1, link);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                image.setID_image_(resultSet.getLong("ID_Image"));
                image.setLink_(resultSet.getString("Image_Link"));
            }
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return image;
    }

    @Override
    public int delete(long id) throws DaoException {
        int result;
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_DELETE_BY_ID);
            preparedStatement.setLong(1, id);
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    @Override
    public int delete(Image entity) throws DaoException {
        return delete(entity.getID_image_());
    }

    @Override
    public int create(Image entity) throws DaoException {
        int result;
        String query = "INSERT INTO Image VALUES (?)";
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,entity.getLink_());
            preparedStatement.executeUpdate();
            result = preparedStatement.getGeneratedKeys().getInt(1);
        }catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    @Override
    public boolean update(Image entity) throws DaoException {
        String query = "SELECT * FROM Image WHERE ID_Image = %d";
        Statement statement = null;
        try{
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format(query, entity.getID_image_()));
            resultSet.updateString("Image_Link",  entity.getLink_());
            resultSet.updateRow();
        } catch(SQLException e){

        } finally{
            close(statement);
        }
        return true;
    }
}
