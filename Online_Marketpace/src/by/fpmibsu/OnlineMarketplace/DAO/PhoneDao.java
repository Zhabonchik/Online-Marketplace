package by.fpmibsu.OnlineMarketplace.DAO;
import by.fpmibsu.OnlineMarketplace.entity.Phone;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import by.fpmibsu.OnlineMarketplace.DAO.DaoException;
public class PhoneDao extends AbstractDao<Phone>{
    private static final String SQL_SELECT_ALL_PHONES = "SELECT * FROM Phone";
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM Phone WHERE ID_Product=?";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM Phone WHERE ID_Product=?";
    public PhoneDao(){
        this.connection = null;
    }
    public List<Phone> findAll() throws DaoException{
        List<Phone> Phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_ALL_PHONES);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Camera_Megapixels"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                Phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return Phones;
    }

    @Override
    public Phone findById(long id) throws DaoException {
        Phone phone = new Phone();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phone;
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
        }
        return result;
    }

    @Override
    public int delete(Phone entity) throws DaoException {
        return delete(entity.getID_product_());
    }

    @Override
    public int create(Phone entity) throws DaoException{
        String query = "INSERT INTO Phone VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        int result;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, entity.getName_());
            preparedStatement.setString(2, entity.getManufacturer_());
            preparedStatement.setString(3, entity.getDescription_());
            preparedStatement.setLong(4, entity.getID_image_());
            preparedStatement.setString(5, entity.getOperational_system_());
            preparedStatement.setInt(6, entity.getRAM_());
            preparedStatement.setInt(7, entity.getROM_());
            preparedStatement.setInt(8, entity.getProduction_year_());
            preparedStatement.setFloat(9, entity.getScreen_diagonal_());
            preparedStatement.setString(10, entity.getScreen_resolution_());
            preparedStatement.setInt(11, entity.getBattery_capacity_());
            preparedStatement.setString(12, entity.getCamera_megapixels_());
            preparedStatement.setFloat(13, entity.getWidth_());
            preparedStatement.setFloat(14, entity.getLength_());
            preparedStatement.setFloat(15, entity.getThickness_());
            preparedStatement.setFloat(16, entity.getWeight_());
            result = preparedStatement.executeUpdate();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(preparedStatement);
        }
        return result;
    }

    @Override
    public boolean update(Phone entity) throws DaoException {
        int result;
        Statement statement = null;
        try {
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM Phone WHERE ID_Product = %d", entity.getID_product_()));
            resultSet.updateString("Name", entity.getName_());
            resultSet.updateString("Manufacturer", entity.getManufacturer_());
            resultSet.updateString("Description", entity.getDescription_());
            resultSet.updateLong("ID_Image", entity.getID_image_());
            resultSet.updateString("Operational_System", entity.getOperational_system_());
            resultSet.updateInt("RAM", entity.getRAM_());
            resultSet.updateInt("ROM", entity.getROM_());
            resultSet.updateInt("Production_Year", entity.getProduction_year_());
            resultSet.updateFloat("Screen_Diagonal", entity.getScreen_diagonal_());
            resultSet.updateString("Screen_Resolution", entity.getScreen_resolution_());
            resultSet.updateInt("Battery_Capacity", entity.getBattery_capacity_());
            resultSet.updateString("Camera_Megapixels", entity.getCamera_megapixels_());
            resultSet.updateFloat("Width", entity.getWidth_());
            resultSet.updateFloat("Length", entity.getLength_());
            resultSet.updateFloat("Thickness", entity.getThickness_());
            resultSet.updateFloat("Weight", entity.getWeight_());
            resultSet.updateRow();
        } catch(SQLException e){
            throw new DaoException(e);
        } finally{
            close(statement);
        }
        return true;
    }

    public List<Phone> findByRAM(int RAM) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE RAM = ?");
            preparedStatement.setInt(1, RAM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
    public List<Phone> findByROM(int ROM) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE ROM = ?");
            preparedStatement.setInt(1, ROM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
    public List<Phone> findByManufacturer(String Manufacturer) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE Manufacturer = ?");
            preparedStatement.setString(1, Manufacturer);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }

    public List<Phone> findByRAM_ROM(int RAM, int ROM) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE RAM = ?AND ROM = ?");
            preparedStatement.setInt(1, RAM);
            preparedStatement.setInt(2, ROM);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
    public List<Phone> findByBatteryCapacity(int capacity) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE Battery_Capacity = ?");
            preparedStatement.setLong(1, capacity);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
    public List<Phone> findByRAM_ROM_CAPACITY_PRODUCTION_YEAR(int RAM, int ROM, int capacity, int year) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE RAM = ? AND ROM = ? AND Battery_Capacity = ? AND Production_Year = ?");
            preparedStatement.setInt(1, RAM);
            preparedStatement.setInt(2, ROM);
            preparedStatement.setInt(3, capacity);
            preparedStatement.setInt(4, year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
    public List<Phone> findByPRODUCTION_YEAR(int year) throws DaoException {
        List <Phone> phones = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("SELECT * FROM Phone WHERE Production_Year = ?");
            preparedStatement.setInt(1, year);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Phone phone = new Phone();
                phone.setID_product_(resultSet.getLong("ID_Product"));
                phone.setName_(resultSet.getString("Name"));
                phone.setManufacturer_(resultSet.getString("Manufacturer"));
                phone.setDescription_(resultSet.getString("Description"));
                phone.setID_image_(resultSet.getLong("ID_Image"));
                phone.setOperational_system_(resultSet.getString("Operational_System"));
                phone.setRAM_(resultSet.getInt("RAM"));
                phone.setROM_(resultSet.getInt("ROM"));
                phone.setProduction_year_(resultSet.getInt("Production_Year"));
                phone.setScreen_diagonal_(resultSet.getFloat("Screen_Diagonal"));
                phone.setScreen_resolution_(resultSet.getString("Screen_Resolution"));
                phone.setBattery_capacity_(resultSet.getInt("Battery_Capacity"));
                phone.setCamera_megapixels_(resultSet.getString("Camera_Megapixels"));
                phone.setWidth_(resultSet.getFloat("Width"));
                phone.setLength_(resultSet.getFloat("Length"));
                phone.setThickness_(resultSet.getFloat("Thickness"));
                phone.setWeight_(resultSet.getFloat("Weight"));
                phones.add(phone);
            }
        } catch (SQLException e){
            throw new DaoException(e);
        } finally {
            close(preparedStatement);
        }
        return phones;
    }
}
