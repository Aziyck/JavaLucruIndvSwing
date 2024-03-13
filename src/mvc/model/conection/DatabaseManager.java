package mvc.model.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
//    private static Connection connection = null;
    private static String url = "jdbc:postgresql://localhost:5432/GaraFeroviara";
    private static String user = "postgres";
    private static String password = "";

    private DatabaseManager(){}

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(url,user,password);

        return connection;
    }

}
