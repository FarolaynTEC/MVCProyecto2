package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Consultas de la clase TipoCentro y AreaTrabajo.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaTipoCentro extends Conexion {
  
  /**
   * Metodo que registra un Area de trabajo
   * @param AT
   * @return
   * @throws SQLException 
   */
  public boolean registrarAreaTrabajo (AreaTrabajo AT) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO AreaTrabajo(AreaTrabajo) VALUES (?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, AT.getNomAreaTrabajo());
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
   * Metodo que elimina un Area de trabajo
   * @param AT
   * @return
   * @throws SQLException 
   */
  public boolean EliminarAreaTrabajo (AreaTrabajo AT) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM AreaTrabajo WHERE AreaTrabajo=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, AT.getNomAreaTrabajo());
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
   * Metodo que registra un tipo de centro de atencion
   * @param TCA
   * @return
   * @throws SQLException 
   */
  public boolean registrarTipoCentroAtencion (TipoCentroAtencion TCA) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO TiposCentrosAtencion(tipoDeCentro) VALUES (?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, TCA.getTipoCentro());
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
   * Metodo que elimina un tipo de centro de atencion
   * @param TCA
   * @return
   * @throws SQLException 
   */
  public boolean EliminarTipoCentroAtencion (TipoCentroAtencion TCA) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM TiposCentrosAtencion WHERE tipoDeCentro=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, TCA.getTipoCentro());
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
   *Este metodo carga la los datos de la tabla AreaTrabajo
   * @param modeloTabla
   */  
  public static void cargarTablaAreaTrabajo(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * FROM AreaTrabajo");
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
   *Este metodo carga la los datos de la tabla tipoDeCentro
   * @param modeloTabla
   */  
  public static void cargarTablaTipoDeCentro(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * FROM TiposCentrosAtencion");
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
