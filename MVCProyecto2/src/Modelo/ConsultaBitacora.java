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
public class ConsultaBitacora extends Conexion {
  
  public boolean registrarBitacora (Bitacora bit) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Bitacora (idBitacora,"
            + "identificadorCita ,fecha,hora ,"
            + "nombreAutor  ) VALUES (?,?,?,?,?)";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, bit.getIdBitacora());
      ps.setInt(2, bit.getIdentificadorCita());
      ps.setString(3, bit.getFecha());
      ps.setString(4, bit.getHora());
      ps.setString(5, bit.getNombreAutor());
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
  
  public boolean modificarBitacora (Bitacora bit) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Bitacora SET "
            + "fecha=?,hora=?,nombreAutor=? "
            + "WHERE idBitacora=?";
    
    try{
      ps = con.prepareStatement(sql);
      
      ps.setString(1, bit.getFecha());
      ps.setString(2, bit.getHora());
      ps.setString(3, bit.getNombreAutor());
      ps.setInt(4, bit.getIdBitacora());
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
  
  public boolean eliminarBitacora (Bitacora bit) throws SQLException{
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Bitacora WHERE idBitacora=?";
    
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, bit.getIdBitacora());
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
  
  public static void cargarTablaBitacora(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT idBitacora, nombreAutor,"
          + "identificadorCita, fecha, hora FROM Bitacora");
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
