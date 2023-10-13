package Pharm;

/**
 *
 * @author:
 * 	10905743
 * 	10907767
 * 	10907327
 * 	10868933
 * 	10897531
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pharma";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection ConnectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}

