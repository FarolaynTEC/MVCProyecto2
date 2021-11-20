package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
        
/**
 * Clase para las consultas de la clase centroAtencion
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaCentroAtencion extends Conexion{
  
  public boolean registrar(CentroAtencion CA) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    
    String sql = "INSERT INTO CentroAtencion(codigoCentroAtencion,"
            + "nombre,ubicacion,capacidadMaxPac,"
            + "tipoDeCentro) VALUES (?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, CA.getCodigoCentroAtencion());
      ps.setString(2, CA.getNombre());
      ps.setString(3, CA.getUbicacion());
      ps.setInt(4, CA.getCapacidadMaxPac());
      ps.setString(5, CA.getTipoDeCentro());
      ps.execute();
      return true;
    }catch(SQLException e){
      System.err.println(e);
      return false;
    }finally{
      try{
        con.close();
      }catch(SQLException e){
      System.err.println(e);
      }
    }
  }
}
