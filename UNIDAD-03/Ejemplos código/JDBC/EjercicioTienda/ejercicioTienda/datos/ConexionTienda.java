package ejercicioTienda.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionTienda {

    private static String JDBC_URL = "jdbc:mysql://localhost:3306/ejercicioTienda";
    private static String JDBC_USER = "root";
    private static String JDBC_PASS = "abc123.";
    
    public static synchronized Connection getConnection() throws SQLException {
    	Connection conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
       
        return conexion;
    }

    public static void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public static void close(PreparedStatement ps) {
    	try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
  
    public static void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
