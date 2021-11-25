package Modelo;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
        
/**
 * Clase para las consultas de la clase centroAtencion
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaCentroAtencion extends Conexion{
  
  /**
   * Metodo que registra un centro de atencion
   * @param CA
   * @return
   * @throws SQLException 
   */
  public boolean registrar(CentroAtencion CA) throws SQLException{
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO CentroAtencion(nombre,ubicacion,capacidadMaxPac,"
            + "tipoDeCentro) VALUES (?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, CA.getNombre());
      ps.setString(2, CA.getUbicacion());
      ps.setInt(3, CA.getCapacidadMaxPac());
      ps.setString(4, CA.getTipoDeCentro());
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
  
  /**
   * Metodo que modifica un centro de atencion
   * @param CA
   * @return
   * @throws SQLException 
   */
  public boolean modificar(CentroAtencion CA) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE CentroAtencion SET "
            + "nombre=?,ubicacion=?,capacidadMaxPac=?,"
            + "tipoDeCentro=? WHERE codigoCentroAtencion=?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, CA.getNombre());
      ps.setString(2, CA.getUbicacion());
      ps.setInt(3, CA.getCapacidadMaxPac());
      ps.setString(4, CA.getTipoDeCentro());
      ps.setInt(5, CA.getCodigoCentroAtencion());
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
  
  /**
   * Metodo que elimina un centro de atencion
   * @param CA
   * @return
   * @throws SQLException 
   */
  public boolean eliminar(CentroAtencion CA) throws SQLException{
    System.out.print("Aqui3");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM CentroAtencion WHERE codigoCentroAtencion=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, CA.getCodigoCentroAtencion());
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
 
  
   /**
   *Este metodo carga la los datos de la tabla centroAtencion
   * @param modeloTabla
   */  
  public static void cargarTablaCentroAtencion(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
              + "Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT *  FROM CentroAtencion");
      rs = st.executeQuery();
      rsmd = rs.getMetaData();
      columnas = rsmd.getColumnCount();
      
      while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice=0; indice<columnas; indice++){
          fila[indice]=rs.getObject(indice+1);
        }
        modeloTabla.addRow(fila);
      }
    }catch(SQLException e){
      
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Metodo que busca un area de atencion
   * @param id
   * @return
   * @throws SQLException 
   */
  public boolean buscarAreaAtencion(int id) throws SQLException{
    ResultSet rs;
    Connection connect = DriverManager.getConnection("jdbc:sqlserver://;databaseName="
    + "Proyecto_POO2;user=usuariosql;password=root1");
    PreparedStatement st = connect.prepareStatement("SELECT * FROM CentroAtencion WHERE codigoCentroAtencion = "+id);
      rs = st.executeQuery();
        if(rs.last()){
            return true;
        }
        else{
            return false;
        }
  }
}
