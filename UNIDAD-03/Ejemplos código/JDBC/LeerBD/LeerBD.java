import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class LeerBD {
	
	public static void main(String[] args) throws ClassNotFoundException {

		// conexiones
		Connection conexion = null;
//		Connection conexion2 = null;
//		Connection conexion3 = null;

		// usuario y clave
		String user = "root";
		String password = "root";
		try {

			// una sola cadena de Conexión, en un sólo parámetro se concatena el
			// usuario y el password
			String url1 = "jdbc:mysql://localhost:3306/tienda?user=" + user + "&password=" + password;
			String url2 = "jdbc:mysql://localhost:3306/tienda?user=" + "root" + "&password=" + "root";
			conexion = DriverManager.getConnection(url2);
			if (conexion != null) {
				System.out.println("Conexión 1: Conexión a mibase satisfactoria");
			}

			
            // Se crea un Statement, para realizar la consulta
            Statement s = conexion.createStatement();

            // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from fabricante");

            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (rs.next()) {
            	  System.out.println(rs.getInt("codigo") + " " + rs.getString(2));  
            }
            
            String sqlInsert= "insert into fabricante (nombre) values (?)";
            PreparedStatement ps =conexion.prepareStatement(sqlInsert);
            ps.setString(1, "VENANCIO");
            int resultado = ps.executeUpdate();
            
            String sqlUpdate= "update fabricante set nombre = 'VENANCIOCAMB' where nombre like '%VENANCIO%'";
            PreparedStatement ps2 =conexion.prepareStatement(sqlUpdate);
       
            resultado = ps2.executeUpdate();
            
            String sqlDelete= "delete from fabricante where nombre like '%VENANCIO%'";
            PreparedStatement ps3 =conexion.prepareStatement(sqlDelete);
       
            resultado = ps3.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally { // Se cierra la Conexión con la base de datos.
            try {
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
	}
}
