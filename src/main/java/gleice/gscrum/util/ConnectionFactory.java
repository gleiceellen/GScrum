package gleice.gscrum.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

        private static Connection con;
        
        public static Connection getConnection() {
                try {
                        if(con == null){
                                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                                con = DriverManager.getConnection("jdbc:mysql://localhost/gscrum", "root", "");
//                                DriverManager.registerDriver(new org.postgresql.Driver());
//                                con = DriverManager.getConnection("jdbc:postgresql://localhost/gscrum", "postgres", "postgres");
                        }
                        return con;
                } catch (SQLException e) {
                        throw new RuntimeException(e);
                }
        }

}
