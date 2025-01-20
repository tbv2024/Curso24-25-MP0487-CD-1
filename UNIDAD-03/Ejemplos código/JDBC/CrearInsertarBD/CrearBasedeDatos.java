
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class CrearBasedeDatos {
    public static void main(String[] args) {
        // URL de la base de datos, usuario y contraseña
        String url = "jdbc:mysql://localhost:3306/";
        String usuario = "root";
        String contraseña = "abc123.";
        String nombreBD = "empresaJava";

        Connection conexion = null;
        Statement declaracion = null;

        try {
            // Conectar al servidor
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            declaracion = conexion.createStatement();

            // Crear la base de datos
            declaracion.executeUpdate("drop database if exists " + nombreBD);
            String crearBD = "CREATE DATABASE IF NOT EXISTS " + nombreBD;
            
            declaracion.executeUpdate(crearBD);
            declaracion.executeUpdate("use "+ nombreBD);
          

            // Crear tabla departamento
            String crearTablaDepartamento = "CREATE TABLE IF NOT EXISTS departamento ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "nombre VARCHAR(50) NOT NULL"
                + ")";
            declaracion.executeUpdate(crearTablaDepartamento);

            // Crear tabla empleado
            String crearTablaEmpleado = "CREATE TABLE IF NOT EXISTS empleado ("
                + "id INT PRIMARY KEY AUTO_INCREMENT,"
                + "nombre VARCHAR(50) NOT NULL,"
                + "apellido VARCHAR(50) NOT NULL,"
                + "edad INT,"
                + "departamento_id INT,"
                + "FOREIGN KEY (departamento_id) REFERENCES departamento(id)"
                + ")";
            declaracion.executeUpdate(crearTablaEmpleado);

            System.out.println("Base de datos y tablas creadas exitosamente.");
            System.out.println("\n");
            // Insertar datos en la tabla departamento
            String insertarDepartamentos = "INSERT INTO departamento (nombre) VALUES "
                    + "('Recursos Humanos'), "
                    + "('IT'), "
                    + "('Ventas'), "
                    + "('Marketing')";
            declaracion.executeUpdate(insertarDepartamentos);

            // Insertar datos en la tabla empleado
            String insertarEmpleados = "INSERT INTO empleado (nombre, apellido, edad, departamento_id) VALUES "
                    + "('Juan', 'Pérez', 30, 1), "
                    + "('Ana', 'García', 28, 2), "
                    + "('Carlos', 'Sánchez', 35, 3), "
                    + "('Laura', 'Fernández', 25, 4)";
            declaracion.executeUpdate(insertarEmpleados);

            System.out.println("Datos insertados correctamente en las tablas.");
            System.out.println("\n");
                      
            // Como procesar las tuplas que devuelve una consulta:
            ResultSet rs = declaracion.executeQuery("Select * from empleado");
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String n = rs.getString(2);
                String d = rs.getString(3);
                int c = rs.getInt(4);

                System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " "+ rs.getString(3) +" "+ rs.getInt(4)); 
            }
            System.out.println("\n");
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (conexion != null) conexion.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
