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
 *
 * @author Alejandra Merino
 */
public class ConsultaCita extends Conexion {
  
  public boolean registrarCita (Cita cita) throws SQLException{
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Citas (cedulaPaciente , identificador,"
            + "fechaCita,observaciones,diagnostico,"
            + "estadoDeCita ) VALUES (?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getCedulaPaciente());
      ps.setInt(2, cita.getIdentificador());
      ps.setString(3, cita.getFechaCita());
      ps.setString(4, cita.getObservaciones());
      ps.setString(5, cita.diagnostico.getNombreDiagnostico());
      ps.setString(6, cita.getEstadoDeCita());
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
    System.out.print("Aqui2");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Citas SET cedulaPaciente=?, "
            + "fechaCita=?,observaciones=?,diagnostico=?,"
            + "estadoDeCita=? WHERE identificador=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getCedulaPaciente());
      ps.setString(2, cita.getFechaCita());
      ps.setString(3, cita.getObservaciones());
      ps.setString(4, cita.diagnostico.getNombreDiagnostico());
      ps.setString(5, cita.getEstadoDeCita());
      ps.setInt(6, cita.getIdentificador());
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
    System.out.print("Aqui2");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Citas WHERE identificador=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, cita.getIdentificador());
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
          + "identificador, fechaCita, observaciones, especialidad FROM Citas");
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
