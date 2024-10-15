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
    private static final Logger logger = Logger.getLogger(ConnectionDataBase.class);

    static {
        new DOMConfigurator().doConfigure
                ("loggerConfig.xml", Logger.getRootLogger().getLoggerRepository());
    }


    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER_NAME, PASS);
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        File file = new File("loggerConfig.xml");
        if (!file.exists()) {
            System.out.println("File not found: " + file.getAbsolutePath());
        }

    }
}


