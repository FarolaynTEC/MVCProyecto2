/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * Clase para las consultas de la clase ConsultaDiagnosticoTratamiento
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaDiagnosticoTratamiento extends Conexion {
  
  /**
   * Metodo que registra un diagnostico
   * @param dia
   * @return
   * @throws SQLException 
   */
  public boolean registrarDiagnostico (Diagnostico dia) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Diagnostico(identificador,"
            + "nombreDiagnostico,observaciones,nivel)"
            + "VALUES (?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, dia.getIdentificadorCita());
      ps.setString(2, dia.getNombreDiagnostico());
      ps.setString(3, dia.getObservaciones());
      ps.setString(4, dia.getNivel());
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
   * Metodo que modifica un diagnostico
   * @param dia
   * @return
   * @throws SQLException 
   */
  public boolean modificarDiagnostico (Diagnostico dia) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Diagnostico SET "
            + " nombreDiagnostico=? , observaciones=? , nivel=? "
            + " WHERE identificador=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, dia.getNombreDiagnostico());
      ps.setString(2, dia.getObservaciones());
      ps.setString(3, dia.getNivel());
      ps.setInt(4, dia.getIdentificadorCita());
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
   * Metodo que elimina un diagnostico
   * @param dia
   * @return
   * @throws SQLException 
   */
  public boolean eliminarDiagnotico (Diagnostico dia) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Diagnostico WHERE identificador =?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, dia.getIdentificadorCita());
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
   * Metodo que carga la tabla de diagnostico
   * @param modeloTabla 
   */
  public static void cargarTablaDiagnotico (DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT identificador,"
          + "nombreDiagnostico, observaciones, nivel FROM Diagnostico");
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
   * Metodo que registra un tratamiento
   * @param tra
   * @return
   * @throws SQLException 
   */
  public boolean registrarTratamiento (Tratamiento tra) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Tratamiento (identificador,"
            + "nombreTratameinto,dosis,tipoTratamiento)"
            + "VALUES (?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, tra.getIdentificadorCita());
      ps.setString(2, tra.getNombreTratamiento());
      ps.setString(3, tra.getDosis());
      ps.setString(4, tra.getTipoTratamiento());
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
   * Metodo que modifica un tratamiento
   * @param tra
   * @return
   * @throws SQLException 
   */
  public boolean modificarTratamiento (Tratamiento tra) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Tratamiento SET "
            + "nombreTratameinto=?,dosis=?,tipoTratamiento=?"
            + " WHERE identificador=?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, tra.getNombreTratamiento());
      ps.setString(2, tra.getDosis());
      ps.setString(3, tra.getTipoTratamiento());
      ps.setInt(4, tra.getIdentificadorCita());
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
   * Metodo que elimina un tratamiento
   * @param tra
   * @return
   * @throws SQLException 
   */
  public boolean eliminarTratamiento (Tratamiento tra) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Tratamiento WHERE identificador =?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, tra.getIdentificadorCita());
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
   * Metodo que carga la tabla de tratamiento
   * @param modeloTabla 
   */
  public static void cargarTablaTratamiento (DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT identificador, "
              + "nombreTratameinto, dosis, tipoTratamiento FROM Tratamiento");
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
  
    public boolean consultarCitasEstado(Diagnostico dia, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT identificador,nombreDiagnostico, observaciones, "
        + "nivel FROM Diagnostico  WHERE nivel = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, dia.getNivel());
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
    
  public boolean consultarNombre (Diagnostico dia, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT identificador,nombreDiagnostico, observaciones, "
        + "nivel FROM Diagnostico  WHERE nombreDiagnostico = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, dia.getNivel());
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
  
  public boolean consultarNombreTrata (Tratamiento tra, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT identificador,nombreTratameinto, dosis,"
        + "tipoTratamiento FROM Tratamiento  WHERE nombreTratameinto = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, tra.getNombreTratamiento());
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
  
    public boolean consultarTipoTrata (Tratamiento tra, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT identificador,nombreTratameinto, dosis,"
        + "tipoTratamiento FROM Tratamiento  WHERE tipoTratamiento = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, tra.getTipoTratamiento());
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
