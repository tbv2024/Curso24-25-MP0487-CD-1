package ejercicioTienda.Tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ejercicioTienda.datos.ConexionTienda;

public class CargarDatosBDTienda {
	
	public static void cargarDatosBDTienda() {
        
        Statement declaracion = null;    
        Connection conexion = null;
        
        try {
            conexion = ConexionTienda.getConnection();
            declaracion = conexion.createStatement();

            // Insertar datos en la tabla Fabricantes
            String insertarFabricantes = "INSERT INTO Fabricantes (nombre) VALUES "
                    + "('Fabricante 1'), "
                    + "('Fabricante 2'), "
                    + "('Fabricante 3'), "
                    + "('Fabricante 4')";
            declaracion.executeUpdate(insertarFabricantes);

            // Insertar datos en la tabla Productos
            String insertarProductos = "INSERT INTO Productos (nombre, precio, codigoFabricante) VALUES "
                    + "('Producto 1-1', 20.34 , 1), "
                    + "('Producto 2-1', 32.64 , 2), "
                    + "('Producto 3-1', 21.74 , 3), "
                    + "('Producto 4-1', 354.84 , 4), "
                    + "('Producto 1-2', 344.94 , 1), "
                    + "('Producto 2-2', 65.14 , 2), "
                    + "('Producto 3-2', 30.20 , 3), "
                    + "('Producto 4-2', 120.00 , 4) ";
            declaracion.executeUpdate(insertarProductos);
            
            ConexionTienda.close(conexion);
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
