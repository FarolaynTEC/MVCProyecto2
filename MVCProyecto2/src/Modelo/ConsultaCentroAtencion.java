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
  
  public boolean eliminar(CentroAtencion CA) throws SQLException{
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

  public boolean buscar(CentroAtencion CA) throws SQLException{
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con = connect();
    
    try{
    cargarTablaCentroAtencionBuscado(DefaultTableModel modeloTabla, int cABuscado)
    ps = con.prepareStatement(sql);
      ps.setInt(1, CA.getCodigoCentroAtencion());
      rs = ps.executeQuery();
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
   *Este metodo carga la los datos de la tabla centroAtencion
   * @param modeloTabla
   */  
  public static void cargarTablaCentroAtencionBuscado
        (DefaultTableModel modeloTabla, int cABuscado){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT *  FROM "
              + "CentroAtencion WHERE codigoCentroAtencion = "+cABuscado);
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
  
}
