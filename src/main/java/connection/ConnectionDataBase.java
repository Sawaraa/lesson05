package connection;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDataBase {

    private static final String URL = "jdbc:mysql://localhost:3306/onlineStore";
    private static final String USER_NAME = "root";
    private static final String PASS = "root";

    private static ConnectionDataBase instance;
    private Connection connection;

    private ConnectionDataBase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER_NAME, PASS);
        } catch (ClassNotFoundException e) {
            System.out.println("Database driver class can't be found!" + e);
        } catch (SQLException e) {
            System.out.println("Database connection creation failed!" + e);
        }
    }

    public Connection getConnection() throws SQLException {
        return connection;
    }

    public static ConnectionDataBase getInstance() {
        if (instance == null) {
            instance = new ConnectionDataBase();
        } else
            try {
                if (instance.getConnection().isClosed()) {
                    instance = new ConnectionDataBase();
                }
            } catch (SQLException e) {
                System.out.println("Database access error!" + e);
            }
        return instance;
    }

}


