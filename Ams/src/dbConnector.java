import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class dbConnector {
        private static final String URL = "jdbc:mysql://localhost:3307/amsdb";
        private static final String USER = "root";
        private static final String PASSWORD ="@Adnan498";
        private static Connection connection;

        public static Connection getConnection() {
            if (connection != null) {
                return connection;
            } else {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    return connection;
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

        public static void closeConnection() {
            try {
                if (connection != null && !connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
