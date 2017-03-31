package gleice.gscrum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        public Connection getConnection() {
                try {
                        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                        return DriverManager.getConnection("jdbc:mysql://localhost/gscrum", "root", "");
//                        DriverManager.registerDriver(new org.postgresql.Driver());
//                        return DriverManager.getConnection("jdbc:postgresql://localhost/gscrum", "postgres", "postgres");
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
