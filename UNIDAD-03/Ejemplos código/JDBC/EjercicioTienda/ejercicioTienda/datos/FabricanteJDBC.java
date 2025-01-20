package ejercicioTienda.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ejercicioTienda.domain.Fabricante;

public class FabricanteJDBC {
  private final String SQL_INSERT = "INSERT INTO Fabricantes (nombre) VALUES (?)";
  private final String SQL_UPDATE = "UPDATE Fabricantes SET nombre=? WHERE codigo=?";
  private final String SQL_DELETE = "DELETE Fabricantes WHERE codigo=?";
  private final String SQL_SELECT = "SELECT codigo,nombre FROM Fabricantes ORDER BY nombre";

  public int insert(String nombre) {
      Connection conexion = null;
      PreparedStatement sentencia = null;
      int filas = 0, index;
      
      try {
          index = 1;
          conexion = ConexionTienda.getConnection();
          sentencia = conexion.prepareStatement(SQL_INSERT);
          sentencia.setString(index++, nombre);
          filas = sentencia.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      } finally {
    	  ConexionTienda.close(sentencia);
    	  ConexionTienda.close(conexion);
      }
      return filas;
  }

  public int update(int codigo, String nombre) {
      Connection conexion = null;
      PreparedStatement sentencia = null;
      int filas = 0, index;
      try {
          index = 1;
          conexion = ConexionTienda.getConnection();
          sentencia = conexion.prepareStatement(SQL_UPDATE);
          sentencia.setString(index++, nombre);
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

  public List<Fabricante> select() {

      Connection conexion = null;
      PreparedStatement sentencia = null;
      ResultSet resultadosConsulta = null;
      Fabricante fabricante = null;
      List<Fabricante> fabricantes = new ArrayList<Fabricante>();

      try {
          conexion = ConexionTienda.getConnection();
          sentencia = conexion.prepareStatement(SQL_SELECT);
          resultadosConsulta = sentencia.executeQuery();
          while (resultadosConsulta.next()) {
              int codigo = resultadosConsulta.getInt("codigo");
              String nombre = resultadosConsulta.getString(2);
              fabricante = new Fabricante(codigo, nombre);
              fabricantes.add(fabricante);
          }
      } catch (SQLException sqle) {
          sqle.printStackTrace();
      } finally {
    	  ConexionTienda.close(resultadosConsulta);
    	  ConexionTienda.close(sentencia);
    	  ConexionTienda.close(conexion);
      }
      return fabricantes;
  }

}
