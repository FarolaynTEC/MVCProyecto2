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
 *Consultas de la clase ConsultaSeguimiento.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaSeguimiento extends Conexion {
  
  /**
   * Metodo que registra un seguimiento
   * @param segui
   * @return
   * @throws SQLException 
   */
  public boolean registrarSeguimiento (RegistroSeguimiento segui) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO RegistroDeSeguimiento(cedulaPacienteInternado,"
        + "funcionarioSeguimiento ,observacionDeEvolucion ,tratameintoAsociado,"
        + " fechaSeguimiento   ) VALUES (?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, segui.getCedilaPacienteInternado());
      ps.setInt(2, segui.getFuncionarioSegui());
      ps.setString(3, segui.getObservacionEvolucion());
      ps.setString(4, segui.getTratamientoAsociado());
      ps.setString(5, segui.getFechaSeguimiento());
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
   * Metodo que modifica un seguimiento
   * @param segui
   * @return
   * @throws SQLException 
   */
  public boolean modificarSeguimiento (RegistroSeguimiento segui) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE RegistroDeSeguimiento SET "
            + "funcionarioSeguimiento =?,observacionDeEvolucion =?, "
            + "tratameintoAsociado=?,fechaSeguimiento=?  WHERE cedulaPacienteInternado =?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setInt(1, segui.getFuncionarioSegui());
      ps.setString(2, segui.getObservacionEvolucion());
      ps.setString(3, segui.getTratamientoAsociado());
      ps.setString(4, segui.getFechaSeguimiento());
      ps.setInt(5, segui.getCedilaPacienteInternado());
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
   * Metodo que elimina un seguimiento
   * @param segui
   * @return
   * @throws SQLException 
   */
  public boolean eliminarSeguimiento (RegistroSeguimiento segui) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM RegistroDeSeguimiento WHERE cedulaPacienteInternado=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, segui.getCedilaPacienteInternado());
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
   * Metodo que carga la tabla de seguimiento
   * @param modeloTabla 
   */
  public static void cargarTablaSeguimiento (DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPacienteInternado, "
          + "funcionarioSeguimiento, fechaSeguimiento, observacionDeEvolucion, "
              + "tratameintoAsociado FROM RegistroDeSeguimiento");
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
