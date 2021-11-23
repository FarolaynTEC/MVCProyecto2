package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Consultas de la clase paciente.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultaPaciente extends Conexion {

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
  
    public boolean registrarVacunas (Vacuna Vac) throws SQLException {
    PreparedStatement ps = null;
    Connection con = connect();
    String sql = "INSERT INTO Vacuna(cedulaPaciente ,fechaAplicacion,"
        + "nombreVacuna ,farmaceutica, numLote) VALUES (?,?,?,?,?)";
    try{
      ps = con.prepareStatement(sql);
      ps.setInt(1, Vac.getCedulaPaciente());
      ps.setString(2, Vac.getNombrePaciente());
      ps.setString (3, Vac.getFechaNacimiento());
      ps.setString(4, Vac.getTipoSangre());
      ps.setString(5, Vac.getNacionalidad());
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
