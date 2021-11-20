package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Conexión con la base de datos
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class Conexion {
  
 private String url;
 public Connection connect;

  /**
   * Método para conectarse a la base de datos por medio del driver JDBC para realizar operaciones.
   */
  public Connection connect() {
    String pUrl;
    pUrl = "jdbc:sqlserver://;databaseName=Proyecto_POO2;user=usuariosql;password=root1";
    this.url = pUrl;
    
    try {
      connect = DriverManager.getConnection(url);
      if (connect != null) {
        System.out.println("Connected");
      }
    } catch (SQLException ex) {
      System.out.println(ex);
    }
    return connect; 
  }
  
  //* Metdo para cerrar la conexion sql server*//
  public void close() {
    try {
      connect.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
