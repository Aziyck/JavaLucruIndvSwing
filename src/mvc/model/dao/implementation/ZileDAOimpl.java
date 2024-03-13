package mvc.model.dao.implementation;

import mvc.model.conection.DatabaseManager;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.ZileDAO;
import mvc.model.entity.Zile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZileDAOimpl implements ZileDAO {
    private static final String SQL_SELECT_ALL = "SELECT \"persid\", \"idziua\", \"numezi\" FROM public.\"zile\";";
    private static final String SQL_INSERT = "INSERT INTO public.\"zile\"(\"persid\", \"numezi\") VALUES (?,?);";
    private static final String SQL_SELECT_BY_ID = "SELECT \"persid\", \"idziua\", \"numezi\" FROM public.\"zile\" WHERE \"persid\" = ?;";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"zile\" WHERE \"persid\"=?;";
    private static final String SQL_DELETE_BY_OBJECT = "DELETE FROM public.\"zile\" WHERE \"persid\" = ? and \"numezi\" = ?;";
    private static final String SQL_UPDATE = "UPDATE public.\"zile\" SET \"numezi\" = ? WHERE \"persid\" = ?;";
    @Override
    public List<Zile> findAll() throws DaoExeption {
        List<Zile> ziles = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Zile zile = new Zile();

                zile.setPersID(resultSet.getInt("persid"));
                zile.setIdZiua(resultSet.getInt("idziua"));
                zile.setNumeZi(resultSet.getString("numezi"));

                ziles.add(zile);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return ziles;
    }

    @Override
    public Zile findEntityById(Integer id) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        Zile zile = new Zile();

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                zile.setPersID(resultSet.getInt("persid"));
                zile.setIdZiua(resultSet.getInt("idziua"));
                zile.setNumeZi(resultSet.getString("numezi"));

            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return zile;
    }

    @Override
    public boolean delete(Zile zile) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
            statement.setInt(1, zile.getPersID());
            statement.setString(2, zile.getNumeZi());
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
    public boolean create(Zile zile) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, zile.getPersID());
            statement.setString(2, zile.getNumeZi());
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
    public Zile update(Zile zile) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, zile.getNumeZi());
            statement.setInt(2, zile.getPersID());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return zile;
    }

    @Override
    public List<Zile> findZileByID(Integer id) throws DaoExeption {
        return Arrays.asList(findEntityById(id));
    }
}
