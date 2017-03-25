import java.sql.*;
import java.io.*;

/**
 * Created by GL on 2017-03-25.
 */
public class Connector {

    // Database login information
    static String ORA_ACCOUNT = "ora_r7h0b";
    static String ORA_PASSWORD = "a43952150";

    private static Connection con;

    public static Connection getConnection() {
        try {
            // Make the connection
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:ug", ORA_ACCOUNT, ORA_PASSWORD);

            if (!con.isClosed()) {
                return con;
            }
        } catch (SQLException e) {
            StringWriter sw = new StringWriter();
            e.printStackTrace(new PrintWriter(sw));
            String exceptionAsString = sw.toString();
            System.out.println(exceptionAsString);
        }
        return null;
    }
}
