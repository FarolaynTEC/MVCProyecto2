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
public class ConsultaFuncionario extends Conexion {
  
  public boolean registrarFuncionario (Funcionario fun) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Funcionario(cedulaFuncionario ,"
            + "nombreFuncionario,fechaVigencia ,tipoFuncionario ,"
            + "codigoCentroAtencion, areaTrabajo) VALUES (?,?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, fun.getCedulaFuncionario());
      ps.setString(2, fun.getNomFuncionario());
      ps.setString (3, fun.getFechaIngreso());
      ps.setString(4, fun.getTipoFuncionario());
      ps.setInt(5, fun.trabajaEn.getCodigoCentroAtencion());
      ps.setString(6, fun.areaTrabajo.getNomAreaTrabajo());
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
  
  public boolean modificarFuncionario (Funcionario fun) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Funcionario SET nombreFuncionario=?"
            + "fechaVigencia=? ,tipoFuncionario=?,codigoCentroAtencion=?,"
            + "areaTrabajo=? WHERE cedulaFuncionario=?";
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, fun.getNomFuncionario());
      ps.setString (2, fun.getFechaIngreso());
      ps.setString(3, fun.getTipoFuncionario());
      ps.setInt(4, fun.trabajaEn.getCodigoCentroAtencion());
      ps.setString(5, fun.areaTrabajo.getNomAreaTrabajo());
      ps.setInt(6, fun.getCedulaFuncionario());
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
  
  public boolean eliminarFuncionario (Funcionario fun) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Funcionario WHERE cedulaFuncionario=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, fun.getCedulaFuncionario());
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
  
  public boolean buscarFuncionario (Funcionario fun) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    
    Connection con = connect();
    String sql = "SELECT * FROM Funcionario WHERE cedulaFuncionario=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, fun.getCedulaFuncionario());
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
