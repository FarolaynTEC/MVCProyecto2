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
 * Consultas de la clase ConsultaPaciente.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaPaciente extends Conexion {

  /**
   * Metodo que registra un paciente
   * @param Pac
   * @return
   * @throws SQLException 
   */
  public boolean registrarPaciente (Paciente Pac) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Paciente(cedulaPaciente,"
        + "nombrePaciente ,fechaNacimiento ,tipoSangre, nacionalidad,"
        + "lugarRecidincia, telefono, correoElectronico) VALUES "
        + "(?,?,?,?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Pac.getCedulaPaciente());
      ps.setString(2, Pac.getNombrePaciente());
      ps.setString (3, Pac.getFechaNacimiento());
      ps.setString(4, Pac.getTipoSangre());
      ps.setString(5, Pac.getNacionalidad());
      ps.setString(6, Pac.getLugarResidencia());
      ps.setString(7, Pac.getTelefono());
      ps.setString(8, Pac.getCorreoElectronico());
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
   * Metodo que modifica un paciente
   * @param Pac
   * @return
   * @throws SQLException 
   */
  public boolean modificarPaciente (Paciente Pac) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "UPDATE Paciente SET nombrePaciente=?,"
        + "fechaNacimiento=?,tipoSangre=?,nacionalidad=?,lugarRecidincia=?, "
        + "telefono=?, correoElectronico=? WHERE cedulaPaciente=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setString(1, Pac.getNombrePaciente());
      ps.setString (2, Pac.getFechaNacimiento());
      ps.setString(3, Pac.getTipoSangre());
      ps.setString(4, Pac.getNacionalidad());
      ps.setString(5, Pac.getLugarResidencia());
      ps.setString(6, Pac.getTelefono());
      ps.setString(7, Pac.getCorreoElectronico());
      ps.setInt(8, Pac.getCedulaPaciente());
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
   * Metodo que elimina un paciente
   * @param Pac
   * @return
   * @throws SQLException 
   */
  public boolean eliminarPaciente (Paciente Pac) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "DELETE FROM Paciente WHERE cedulaPaciente=?";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Pac.getCedulaPaciente());
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
   * Metodo que registra una Vacuna
   * @param Vac
   * @return
   * @throws SQLException 
   */
  public boolean registrarVacunas (Vacuna Vac) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Vacuna(cedulaPaciente ,fechaAplicacion,"
        + "nombreVacuna ,farmaceutica, numLote) VALUES (?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Vac.getCedulaPaciente());
      ps.setString(2, Vac.getFechaAplicacion());
      ps.setString (3, Vac.getNombreVacuna());
      ps.setString(4, Vac.getFarmaceutica());
      ps.setString(5, Vac.getNumLote());
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
   *Este metodo carga la los datos de la tabla Paciente
   * @param modeloTabla
   */  
  public static void cargarTablaPaciente1(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPaciente,"
          + "nombrePaciente, fechaNacimiento, nacionalidad FROM Paciente");
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
   *Este metodo carga la los datos de la tabla Paciente
   * @param modeloTabla
   */  
  public static void cargarTablaPaciente2(DefaultTableModel modeloTabla){
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    try{
      
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://;"
              + "databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT tipoSangre, "
          + "lugarRecidincia, telefono, correoElectronico FROM Paciente");
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
