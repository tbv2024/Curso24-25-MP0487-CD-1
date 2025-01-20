package ejercicioTienda.Tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioTienda.datos.ConexionTienda;


public class CrearBDTienda {
	
    public static void crearBDTienda()  {
       
        String JDBC_URL = "jdbc:mysql://localhost:3306/";
        String JDBC_USER = "root";
        String JDBC_PASS = "abc123.";
        String nombreBD = "ejercicioTienda";
        
        Connection conexion = null;
        Statement declaracion = null;    
        
        // Conectar al servidor
        try {
        	conexion = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        } catch (SQLException e) {
        	e.printStackTrace();
        	System.out.println("ERROR conexión a base datos");
        }

        try {
            // Conectar al servidor
            declaracion = conexion.createStatement();

            // Crear la base de datos
            declaracion.executeUpdate("drop database if exists " + nombreBD);
            String crearBD = "CREATE DATABASE IF NOT EXISTS " + nombreBD;         
            declaracion.executeUpdate(crearBD);
            
            declaracion.executeUpdate("use "+ nombreBD);
            
            // Crear tabla Fabricante
            String crearTablaDepartamento = "CREATE TABLE IF NOT EXISTS Fabricantes ("
                + "codigo INT PRIMARY KEY AUTO_INCREMENT,"
                + "nombre VARCHAR(50) NOT NULL"
                + ")";
            declaracion.executeUpdate(crearTablaDepartamento);

            // Crear tabla Productos
            String crearTablaEmpleado = "CREATE TABLE IF NOT EXISTS Productos ("
                + "codigo INT PRIMARY KEY AUTO_INCREMENT,"
                + "nombre VARCHAR(50) NOT NULL,"
                + "precio DECIMAL(5,2),"
                + "codigoFabricante INT,"
                + "FOREIGN KEY (codigoFabricante) REFERENCES Fabricantes(codigo)"
                + ")";
            declaracion.executeUpdate(crearTablaEmpleado);
            
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


