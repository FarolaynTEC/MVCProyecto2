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
 * Consultas de la clase ConsultaHospitalizacion.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaHospitalizacion extends Conexion {
  
  /**
   * Metodo que registra una hospitalizacion
   * @param hos
   * @return
   * @throws SQLException 
   */
  public boolean registrarHospitalizacion (Hospitalizacion hos) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Hospitalizacion (centroAtencion,"
        + "cedulaPacienteInternado, nombrePacienteInternado ,diagnostico, fechaInicio ,"
        + "fechaFin, especialidadHospitalizacion, funcionarioEncargado) VALUES "
        + "(?,?,?,?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, hos.getCentroAtencion());
      ps.setInt(2, hos.getCedulaPAcienteInternado());
      ps.setString (3, hos.getNombrePacienteInternado());
      ps.setString(4, hos.getDiagnosticoInter());
      ps.setString(5, hos.getFechaInicio());
      ps.setString(6, hos.getFechaFin());
      ps.setString(7, hos.getEspecialidadHospi());
      ps.setInt(8, hos.getFuncionarioEncargado());
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
   * Metodo que modifica una hospitalizacion
   * @param hos
   * @return
   * @throws SQLException 
   */
  public boolean modificarHospitalizacion (Hospitalizacion hos) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Hospitalizacion SET nombrePacienteInternado=?,"
        + "diagnostico=?,fechaInicio=?,fechaFin=?,especialidadHospitalizacion=?, "
        + "funcionarioEncargado=? WHERE cedulaPacienteInternado=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, hos.getNombrePacienteInternado());
      ps.setString(2, hos.getDiagnosticoInter());
      ps.setString(3, hos.getFechaInicio());
      ps.setString(4, hos.getFechaFin());
      ps.setString(5, hos.getEspecialidadHospi());
      ps.setInt(6, hos.getFuncionarioEncargado());
      ps.setInt(7, hos.getCedulaPAcienteInternado());
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
   * Metodo que elimina una hospitalizacion
   * @param hos
   * @return
   * @throws SQLException 
   */
  public boolean eliminarHospitalizacion (Hospitalizacion hos) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Hospitalizacion WHERE cedulaPacienteInternado=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, hos.getCedulaPAcienteInternado());
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
   * Metodo que carga la primera parte de una tabla de hospitalizacion
   * @param modeloTabla 
   */
  public static void cargarTablaHospitalizacion (DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT "
              + "cedulaPacienteInternado, nombrePacienteInternado, diagnostico"
              + " FROM Hospitalizacion");
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
   * Metodo que carga la segunda parte de una tabla de hospitalizacion
   * @param modeloTabla 
   */
  public static void cargarTablaHospitalizacion1 (DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT "
              + "cedulaPacienteInternado,fechaInicio, fechaFin,"
          + " especialidadHospitalizacion ,funcionarioEncargado FROM Hospitalizacion");
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
   * Metodo que carga la primera parte de la tabla de consulta pacinete de 
   * hospitalizacion
   * @param modeloTabla 
   */
    public boolean consultarCedulaPacInter (Hospitalizacion hos, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT centroAtencion,cedulaPacienteInternado, "
        + "nombrePacienteInternado,diagnostico, funcionarioEncargado "
        + "FROM Hospitalizacion  WHERE cedulaPacienteInternado = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, hos.getCedulaPAcienteInternado());
      rs = ps.executeQuery();
      rsmd = rs.getMetaData();
      columnas = rsmd.getColumnCount();
      
      while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice=0; indice<columnas; indice++){
          fila[indice]=rs.getObject(indice+1);
        }
        modeloTabla.addRow(fila);
      }
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
   * Metodo que carga la Segunda parte de la tabla de consulta pacinete de 
   * hospitalizacion
   * @param modeloTabla 
   */
    public boolean consultarCedulaPacInter2 (Hospitalizacion hos, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT nombrePacienteInternado,fechaInicio,"
        + " fechaFin,especialidadHospitalizacion FROM Hospitalizacion  "
        + "WHERE cedulaPacienteInternado = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, hos.getCedulaPAcienteInternado());
      rs = ps.executeQuery();
      rsmd = rs.getMetaData();
      columnas = rsmd.getColumnCount();
      
      while(rs.next()){
        Object[] fila = new Object[columnas];
        for(int indice=0; indice<columnas; indice++){
          fila[indice]=rs.getObject(indice+1);
        }
        modeloTabla.addRow(fila);
      }
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
