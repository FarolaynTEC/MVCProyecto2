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
 * Consultas de la clase Vacuna.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaVacuna extends Conexion{
  
  /**
   * Metodo que consulta las vacunas
   * @param Vac
   * @param modeloTabla
   * @return
   * @throws SQLException 
   */
  public boolean consultarvacunas (Vacuna Vac, DefaultTableModel modeloTabla) throws SQLException {
    PreparedStatement ps = null;
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    Connection con = connect();
    String sql = "SELECT nombreVacuna, fechaAplicacion, farmaceutica, "
        + "numLote  from Vacuna WHERE cedulaPaciente=? ";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Vac.getCedulaPaciente());
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
