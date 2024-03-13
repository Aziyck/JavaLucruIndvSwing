package mvc.model.dao.implementation;


import mvc.model.conection.DatabaseManager;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.LocatiiDAO;
import mvc.model.entity.Locatii;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LocatiiDAOimpl implements LocatiiDAO {
    private static final String SQL_SELECT_ALL = "SELECT \"persid\", \"idlocatie\", \"numelocatie\" FROM public.\"locatii\";";
    private static final String SQL_INSERT = "INSERT INTO public.\"locatii\"(\"persid\", \"numelocatie\") VALUES (?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT \"persid\", \"idlocatie\", \"numelocatie\" FROM public.\"locatii\" WHERE \"persid\" = ?;";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"locatii\" WHERE \"persid\"=?;";
    private static final String SQL_DELETE_BY_OBJECT = "DELETE FROM public.\"locatii\" WHERE \"persid\" = ? and \"numelocatie\" = ?;";
    private static final String SQL_UPDATE = "UPDATE ublic.\"locatii\" SET \"numelocatie\" = ? WHERE \"persid\" = ?;";
    @Override
    public List<Locatii> findAll() throws DaoExeption {
        List<Locatii> locatiis = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Locatii locatii = new Locatii();

                locatii.setPersID(resultSet.getInt("persid"));
                locatii.setIdLocatie(resultSet.getInt("idlocatie"));
                locatii.setNumeLocatie(resultSet.getString("numelocatie"));

                locatiis.add(locatii);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return locatiis;
    }

    @Override
    public Locatii findEntityById(Integer id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        Locatii locatii = new Locatii();

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){

                locatii.setPersID(resultSet.getInt("persid"));
                locatii.setIdLocatie(resultSet.getInt("idlocatie"));
                locatii.setNumeLocatie(resultSet.getString("numelocatie"));
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return locatii;
    }

    @Override
    public boolean delete(Locatii locatii) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
            statement.setInt(1, locatii.getPersID());
            statement.setString(2, locatii.getNumeLocatie());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return bool;
    }

    @Override
    public boolean delete(Integer id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_ID);
            statement.setInt(1, id);
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return bool;
    }

    @Override
    public boolean create(Locatii locatii) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, locatii.getPersID());
            statement.setString(2, locatii.getNumeLocatie());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return bool;
    }

    @Override
    public Locatii update(Locatii locatii) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, locatii.getNumeLocatie());
            statement.setInt(2, locatii.getPersID());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return locatii;
    }

    @Override
    public List<Locatii> findLocatiiByID(Integer id) throws DaoExeption {
        return Arrays.asList(findEntityById(id));
    }
}
