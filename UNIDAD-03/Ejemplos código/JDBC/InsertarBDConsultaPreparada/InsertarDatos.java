import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    public static void main(String[] args) {
        String archivo = "datos.csv";
        String url = "jdbc:mysql://localhost:3306/Personal";
        String usuario = "root";
        String contraseña = "root";

        String sql = "INSERT INTO personas (nombre, edad, ciudad) VALUES (?, ?, ?)";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
             BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    String nombre = datos[0];
                    int edad = Integer.parseInt(datos[1]);
                    String ciudad = datos[2];

                    try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                        stmt.setString(1, nombre);
                        stmt.setInt(2, edad);
                        stmt.setString(3, ciudad);
                        stmt.executeUpdate();
                    }
                } else {
                    System.err.println("Formato incorrecto en la línea: " + linea);
                }
            }
            System.out.println("Datos insertados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar o insertar datos en la base de datos: " + e.getMessage());
        }
    }
}
