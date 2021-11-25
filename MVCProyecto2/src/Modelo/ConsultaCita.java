/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * Clase para las consultas de la clase Cita
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaCita extends Conexion {
  
  public boolean registrarCita (Cita cita) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Citas (cedulaPaciente,"
            + "fechaCita,observaciones,"
            + "estadoDeCita, especialidad ) VALUES (?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getCedulaPaciente());
      ps.setString(2, cita.getFechaCita());
      ps.setString(3, cita.getObservaciones());
      ps.setString(4, cita.getEstadoDeCita());
      ps.setString(5, cita.getEspecialidad());
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
  
  public boolean modificarCita (Cita cita) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Citas SET estadoDeCita=?  WHERE cedulaPaciente=?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, cita.getEstadoDeCita());
      ps.setInt(2, cita.getCedulaPaciente());
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
   
  public boolean eliminarCita (Cita cita) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Citas WHERE cedulaPaciente=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getCedulaPaciente());
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
  
  public static void cargarTablaCita(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPaciente,"
          + "identificador, observaciones FROM Citas");
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
  
  public static void cargarTablaCita1(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT "
          + "identificador, fechaCita, especialidad, estadoDeCita FROM Citas");
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
  
    
    public boolean consultarCitasEspecialidad (Cita cit, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT nombrePaciente,"
          + " identificador, observaciones, fechaCita, estadoDeCita FROM "
          + "Citas C INNER JOIN Paciente P ON C.cedulaPaciente=P.cedulaPaciente"
          + " WHERE C.especialidad = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, cit.getEspecialidad());
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
    
    public boolean consultarCitasEstado(Cita cit, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT nombrePaciente,"
          + " identificador, observaciones, fechaCita, estadoDeCita FROM "
          + "Citas C INNER JOIN Paciente P ON C.cedulaPaciente=P.cedulaPaciente"
          + " WHERE C.estadoDeCita = ?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, cit.getEstadoDeCita());
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
