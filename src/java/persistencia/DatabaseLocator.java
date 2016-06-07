package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anubis
 */
public class DatabaseLocator {
        public static Connection getConnection() throws SQLException, ClassNotFoundException{
    
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb?DateTimeBehavior=convertToNull", "root", "1234");
        return conn;

    }
}
