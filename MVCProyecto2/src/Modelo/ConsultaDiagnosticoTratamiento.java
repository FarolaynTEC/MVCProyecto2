/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alejandra Merino
 */
public class ConsultaDiagnosticoTratamiento extends Conexion {
  
  public boolean registrarDiagnostico (Diagnostico dia) throws SQLException{
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Diagnostico (identificador,"
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
  
  public boolean modificarBitacora (Cita cita) throws SQLException{
    System.out.print("Aqui2");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Citas SET "
            + "fechaCita=?,observaciones=?,diagnostico=?,"
            + "estadoDeCita=? WHERE identificador=?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, cita.getFechaCita());
      ps.setString(2, cita.getObservaciones());
      ps.setString(3, cita.diagnostico.getNombreDiagnostico());
      ps.setString(4, cita.getEstadoDeCita());
      ps.setInt(5, cita.getIdentificador());
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
