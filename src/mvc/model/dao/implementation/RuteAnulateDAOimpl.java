package mvc.model.dao.implementation;

import mvc.model.conection.DatabaseManager;
import mvc.model.dao.DaoExeption;
import mvc.model.dao.RuteDAO;
import mvc.model.entity.Rute;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuteAnulateDAOimpl implements RuteDAO {
    private static final String SQL_INSERT = "INSERT INTO public.\"ruteanulate\" (\"persid\", \"dataplecarii\", \"oraplecarii\", \"locatieinitiala\", \"datasosirii\", \"orasosirii\", \"destinatie\", \"durata\", \"nrsaptamanii\", \"locuridisponibileconfort\", \"locuriconfort\", \"pretconfort\", \"locuridisponibileeco\", \"locurieco\", \"preteco\", \"idziua\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_SELECT_ALL = "SELECT \"persid\", \"codcursa\", \"dataplecarii\", \"oraplecarii\", \"locatieinitiala\", \"datasosirii\", \"orasosirii\", \"destinatie\", \"durata\", \"nrsaptamanii\", \"locuridisponibileconfort\", \"locuriconfort\", \"pretconfort\", \"locuridisponibileeco\", \"locurieco\", \"preteco\", \"idziua\" FROM public.\"ruteanulate\";";
    private static final String SQL_SELECT_BY_ID = "SELECT \"persid\", \"codcursa\", \"dataplecarii\", \"oraplecarii\", \"locatieinitiala\", \"datasosirii\", \"orasosirii\", \"destinatie\", \"durata\", \"nrsaptamanii\", \"locuridisponibileconfort\", \"locuriconfort\", \"pretconfort\", \"locuridisponibileeco\", \"locurieco\", \"preteco\", \"idziua\" FROM public.\"ruteanulate\" WHERE \"persid\" = ?;";
    private static final String SQL_DELETE_BY_ID = "DELETE FROM public.\"ruteanulate\" WHERE \"persid\"=?;";
    private static final String SQL_DELETE_BY_OBJECT = "DELETE FROM public.\"ruteanulate\" WHERE \"persid\" = ? and \"dataplecarii\" = ? and \"oraplecarii\" = ? and \"locatieinitiala\" = ? and \"datasosirii\" = ? and \"orasosirii\" = ? and \"destinatie\" = ? and \"durata\" = ? and \"nrsaptamanii\" = ? and \"locuridisponibileconfort\" = ? and \"locuriconfort\" = ? and \"pretconfort\" = ? and \"locuridisponibileeco\" = ? and \"locurieco\" = ? and \"preteco\" = ? and \"idziua\" = ? ;";
    private static final String SQL_UPDATE = "UPDATE public.\"ruteanulate\" SET \"dataplecarii\"=?, \"oraplecarii\"=?, \"locatieinitiala\"=?, \"datasosirii\"=?, \"orasosirii\"=?, \"destinatie\"=?, \"durata\"=?, \"nrsaptamanii\"=?, \"locuridisponibileconfort\"=?, \"locuriconfort\"=?, \"pretconfort\"=?, \"locuridisponibileeco\"=?, \"locurieco\"=?, \"preteco\"=?, \"idziua\"=? WHERE \"persid\" = ?;";

    @Override
    public List<Rute> findAll() throws DaoExeption {
        List<Rute> rutes = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Rute ruta = new Rute();

                ruta.setPersID(resultSet.getInt("persid"));
                ruta.setCodCursa(resultSet.getInt("codcursa"));
                ruta.setDataPlecarii(resultSet.getString("dataplecarii"));
                ruta.setOraPlecarii(resultSet.getString("oraplecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("locatieinitiala"));
                ruta.setDataSosirii(resultSet.getString("datasosirii"));
                ruta.setOraSosirii(resultSet.getString("orasosirii"));
                ruta.setDestinatie(resultSet.getInt("destinatie"));
                ruta.setDurata(resultSet.getLong("durata"));
                ruta.setNrSaptamanii(resultSet.getInt("nrsaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("locuridisponibileconfort"));
                ruta.setLocConfort(resultSet.getInt("locuriconfort"));
                ruta.setPretConfort(resultSet.getFloat("pretconfort"));
                ruta.setLocDisponEco(resultSet.getInt("locuridisponibileeco"));
                ruta.setLocEco(resultSet.getInt("locurieco"));
                ruta.setPretEco(resultSet.getFloat("preteco"));
                ruta.setIdZiua(resultSet.getInt("idziua"));

                rutes.add(ruta);
            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rutes;
    }

    @Override
    public Rute findEntityById(Integer id) throws DaoExeption {
        Rute ruta = new Rute();

        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                ruta.setPersID(resultSet.getInt("persid"));
                ruta.setCodCursa(resultSet.getInt("codcursa"));
                ruta.setDataPlecarii(resultSet.getString("dataplecarii"));
                ruta.setOraPlecarii(resultSet.getString("oraplecarii"));
                ruta.setLocatieInitiala(resultSet.getInt("locatieinitiala"));
                ruta.setDataSosirii(resultSet.getString("datasosirii"));
                ruta.setOraSosirii(resultSet.getString("orasosirii"));
                ruta.setDestinatie(resultSet.getInt("destinatie"));
                ruta.setDurata(resultSet.getLong("durata"));
                ruta.setNrSaptamanii(resultSet.getInt("nrsaptamanii"));
                ruta.setLocDisponConfort(resultSet.getInt("locuridisponibileconfort"));
                ruta.setLocConfort(resultSet.getInt("locuriconfort"));
                ruta.setPretConfort(resultSet.getFloat("pretconfort"));
                ruta.setLocDisponEco(resultSet.getInt("locuridisponibileeco"));
                ruta.setLocEco(resultSet.getInt("locurieco"));
                ruta.setPretEco(resultSet.getFloat("preteco"));
                ruta.setIdZiua(resultSet.getInt("idziua"));

            }

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return ruta;
    }


    @Override
    public boolean delete(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_DELETE_BY_OBJECT);
            statement.setInt(1,rute.getPersID());
            statement.setString(2, rute.getDataPlecarii());
            statement.setString(3, rute.getOraPlecarii());
            statement.setInt(4, rute.getLocatieInitiala());
            statement.setString(5, rute.getDataSosirii());
            statement.setString(6, rute.getOraSosirii());
            statement.setInt(7, rute.getDestinatie());
            statement.setLong(8, rute.getDurata());
            statement.setInt(9, rute.getNrSaptamanii());
            statement.setInt(10, rute.getLocDisponConfort());
            statement.setInt(11, rute.getLocConfort());
            statement.setFloat(12, rute.getPretConfort());
            statement.setInt(13, rute.getLocDisponEco());
            statement.setInt(14, rute.getLocEco());
            statement.setFloat(15, rute.getPretEco());
            statement.setInt(16, rute.getIdZiua());
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
    public boolean create(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_INSERT);
            statement.setInt(1, rute.getPersID());
            statement.setString(2, rute.getDataPlecarii());
            statement.setString(3, rute.getOraPlecarii());
            statement.setInt(4, rute.getLocatieInitiala());
            statement.setString(5, rute.getDataSosirii());
            statement.setString(6, rute.getOraSosirii());
            statement.setInt(7, rute.getDestinatie());
            statement.setLong(8, rute.getDurata());
            statement.setInt(9, rute.getNrSaptamanii());
            statement.setInt(10, rute.getLocDisponConfort());
            statement.setInt(11, rute.getLocConfort());
            statement.setFloat(12, rute.getPretConfort());
            statement.setInt(13, rute.getLocDisponEco());
            statement.setInt(14, rute.getLocEco());
            statement.setFloat(15, rute.getPretEco());
            statement.setInt(16, rute.getIdZiua());
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
    public Rute update(Rute rute) throws DaoExeption {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean bool = false;

        try{
            connection = DatabaseManager.getConnection();
            statement = connection.prepareStatement(SQL_UPDATE);
            statement.setString(1, rute.getDataPlecarii());
            statement.setString(2, rute.getOraPlecarii());
            statement.setInt(3, rute.getLocatieInitiala());
            statement.setString(4, rute.getDataSosirii());
            statement.setString(5, rute.getOraSosirii());
            statement.setInt(6, rute.getDestinatie());
            statement.setLong(7, rute.getDurata());
            statement.setInt(8, rute.getNrSaptamanii());
            statement.setInt(9, rute.getLocDisponConfort());
            statement.setInt(10, rute.getLocConfort());
            statement.setFloat(11, rute.getPretConfort());
            statement.setInt(12, rute.getLocDisponEco());
            statement.setInt(13, rute.getLocEco());
            statement.setFloat(14, rute.getPretEco());
            statement.setInt(15, rute.getIdZiua());
            statement.setInt(16, rute.getPersID());
            statement.executeUpdate();
            if (statement.getUpdateCount() != 0) bool = true;

        }catch (SQLException e){
            throw new DaoExeption(e);
        }finally {
            close(statement);
            close(connection);
        }
        return rute;
    }

    @Override
    public List<Rute> findRuteByID(Integer id) throws DaoExeption {
        return new ArrayList<>(List.of(findEntityById(id)));
    }
}
