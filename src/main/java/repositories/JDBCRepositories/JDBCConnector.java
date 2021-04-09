package repositories.JDBCRepositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/javaCoreProgect_DB";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1";
    private static Connection connection;
    private static PreparedStatement statement;

    private JDBCConnector(){}

    public static PreparedStatement getStatement(String sql){
        if(connection == null){
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return statement;
    }

    public static void closeConnection(){
        try {
            statement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
