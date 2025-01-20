package ejercicioTienda.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicioTienda.domain.Producto;

public class ProductoJDBC {
	  private final String SQL_INSERT = "INSERT INTO Productos (nombre, precio, codigoFabricante) VALUES (?, ?, ?)";
	  private final String SQL_UPDATE = "UPDATE Productos SET nombre=?, precio=?, codigoFabricante=? WHERE codigo=?";
	  private final String SQL_DELETE = "DELETE Productos WHERE codigo=?";
	  private final String SQL_SELECT = "SELECT codigo,nombre,precio,codigoFabricante FROM Productos ORDER BY nombre";
	  private final String SQL_SELECT_PRODUCTO = "SELECT nombre,precio,codigoFabricante FROM Productos WHERE codigo=?";
	  

	  public int insert(String nombre, double precio, int codigoFabricante) {
	      Connection conexion = null;
	      PreparedStatement sentencia = null;
	      int filas = 0, index;
	      
	      try {
	          index = 1;
	          conexion = ConexionTienda.getConnection();
	       
	          sentencia = conexion.prepareStatement(SQL_INSERT);          
	          sentencia.setString(index++, nombre);
	          sentencia.setDouble(index++, precio);
	          sentencia.setInt(index++, codigoFabricante);          
	          filas = sentencia.executeUpdate();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      } finally {
	    	  ConexionTienda.close(sentencia);
	    	  ConexionTienda.close(conexion);
	      }
	      return filas;
	  }

	  public int update(int codigo, String nombre, double precio, int codigoFabricante) {
	      Connection conexion = null;
	      PreparedStatement sentencia = null;
	      int filas = 0, index;
	      try {
	          index = 1;
	          conexion = ConexionTienda.getConnection();
	          sentencia = conexion.prepareStatement(SQL_UPDATE);
	          sentencia.setString(index++, nombre);
	          sentencia.setDouble(index++, precio);
	          sentencia.setInt(index++, codigoFabricante);
	          sentencia.setInt(index, codigo);
	          filas = sentencia.executeUpdate();
	      } catch (SQLException sqle) {
	          sqle.printStackTrace();
	      } finally {
	    	  ConexionTienda.close(sentencia);
	    	  ConexionTienda.close(conexion);
	      }
	      return filas;
	  }
	  
	  public int delete(int codigo) {
	      Connection conexion = null;
	      PreparedStatement sentencia = null;
	      int filas = 0;
	      try {
	          conexion = ConexionTienda.getConnection();
	          sentencia = conexion.prepareStatement(SQL_DELETE);
	          sentencia.setInt(1, codigo);
	          filas = sentencia.executeUpdate();
	      } catch (SQLException sqle) {
	          sqle.printStackTrace();
	      } finally {
	    	  ConexionTienda.close(sentencia);
	    	  ConexionTienda.close(conexion);
	      }
	      return filas;

	  }

	  public List<Producto> select() {

	      Connection conexion = null;
	      PreparedStatement sentencia = null;
	      ResultSet resultadosConsulta = null;
	      Producto producto = null;
	      List<Producto> productos = new ArrayList<Producto>();

	      try {
	          conexion = ConexionTienda.getConnection();
	          sentencia = conexion.prepareStatement(SQL_SELECT);
	          
	          
	          resultadosConsulta = sentencia.executeQuery();
	          while (resultadosConsulta.next()) {
	              int codigo = resultadosConsulta.getInt("codigo");
	              String nombre = resultadosConsulta.getString("nombre");
	              double precio = resultadosConsulta.getDouble("precio");
	              int codigoFabricante = resultadosConsulta.getInt("codigoFabricante");
	              
	              producto = new Producto(codigo, nombre, precio, codigoFabricante);
	              productos.add(producto);
	          }
	      } catch (SQLException sqle) {
	          sqle.printStackTrace();
	      } finally {
	    	  ConexionTienda.close(resultadosConsulta);
	    	  ConexionTienda.close(sentencia);
	    	  ConexionTienda.close(conexion);
	      }
	      return productos;
	  }
	  
	  public Producto select(int codigo) {

	      Connection conexion = null;
	      PreparedStatement sentencia = null;
	      ResultSet resultadosConsulta = null;
	      Producto producto = null;
	      
	      try {        
	          conexion = ConexionTienda.getConnection();
	          sentencia = conexion.prepareStatement(SQL_SELECT_PRODUCTO);
	          sentencia.setInt(1, codigo);     
	          resultadosConsulta = sentencia.executeQuery();
	          
	          String nombre = "ERROR";
	          double precio = -1.0;
	          int codigoFabricante = -1;
	          if (resultadosConsulta.next( ) ) { // solo hay 1 resultado
		          nombre = resultadosConsulta.getString("nombre");
		          precio = resultadosConsulta.getDouble("precio");
		          codigoFabricante = resultadosConsulta.getInt("codigoFabricante");
	          } else {
	        	  System.err.println("ERROR: al intentar obtener Producto");
	          }
	          producto = new Producto(codigo, nombre, precio, codigoFabricante);
	      } catch (SQLException sqle) {
	          sqle.printStackTrace();
	      } finally {
	    	  ConexionTienda.close(resultadosConsulta);
	    	  ConexionTienda.close(sentencia);
	    	  ConexionTienda.close(conexion);
	      }
	      
	      return producto;
	  }	  
}
