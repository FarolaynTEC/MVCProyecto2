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
      ps.setString(5, fun.getTrabajaEn());
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
      ps.setString(4, fun.getTrabajaEn());
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
  
  public boolean registrarDoctor (Doctor doc) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Funcionario(cedulaFuncionario ,"
            + "nombreFuncionario,fechaVigencia ,tipoFuncionario ,"
            + "codigoCentroAtencion, areaTrabajo) VALUES (?,?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, doc.getCedulaFuncionario());
      ps.setString(2, doc.getNomFuncionario());
      ps.setString (3, doc.getFechaIngreso());
      ps.setString(4, doc.getTipoFuncionario());
      ps.setString(5, doc.getTrabajaEn());
      ps.setString(6, doc.areaTrabajo.getNomAreaTrabajo());
      ps.execute();
    }catch(SQLException e){
      System.err.println(e);
      return false;
    } 
    String sql2 = "INSERT INTO Doctor (cedulaFuncionario ,"
            + "codigoMedico,especialidad VALUES (?,?,?)";
    try{
      ps = con.prepareStatement(sql2);
      ps.setInt(1, doc.getCedulaFuncionario());
      ps.setInt(2, doc.getCodigoMedico());
      ps.setString (3, doc.getEspecialidad());
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
  
  public boolean modificarDoctor (Doctor doc) {
    System.out.print("Aqui1");
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Funcionario SET nombreFuncionario=?"
            + "fechaVigencia=? ,tipoFuncionario=?,codigoCentroAtencion=?,"
            + "areaTrabajo=? WHERE cedulaFuncionario=?";
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, doc.getNomFuncionario());
      ps.setString (2, doc.getFechaIngreso());
      ps.setString(3, doc.getTipoFuncionario());
      ps.setString(5, doc.getTrabajaEn());
      ps.setString(5, doc.areaTrabajo.getNomAreaTrabajo());
      ps.setInt(6, doc.getCedulaFuncionario());
      ps.execute();
    }catch(SQLException e){
      System.err.println(e);
      return false;
    }String sql2 = "UPDATE Doctor SET codigoMedico=?"
            + "especialidad=? WHERE cedulaFuncionario=?";
    try{
      ps = con.prepareStatement(sql2);
      ps.setInt(1, doc.getCodigoMedico());
      ps.setString (2, doc.getEspecialidad());
      ps.setInt(3, doc.getCedulaFuncionario());
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
   *Este metodo carga la los datos de la tabla Funcionario
   * @param modeloTabla
   */  
  public static void cargarTablaFuncionario(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaFuncionario,"
              + "nombreFuncionario, tipoFuncionario, fechaVigencia,"
              + "areaTrabajo  FROM Funcionario");
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
   *Este metodo carga la los datos de la tabla Funcionario
   * @param modeloTabla
   */  
  public static void cargarTablaFuncionarioDoctor(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreFuncionario,"
              + " codigoMedico, especialidad  FROM Funcionario f INNER JOIN "
              + "Doctor d on f.cedulaFuncionario = d.cedulaFuncionario");
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
