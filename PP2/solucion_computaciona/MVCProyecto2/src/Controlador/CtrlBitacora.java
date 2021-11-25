/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Bitacora;
import Modelo.ConsultaBitacora;
import Vista.BitacoraV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Esta es una clase de Controlador de Bitacora
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlBitacora implements ActionListener {
  private Bitacora modBit;
  private ConsultaBitacora modBitC;
  private BitacoraV vistaBit;
  
  /**
   * Constructor de la clase CtrlBitacora
   * @param modBit
   * @param modBitC
   * @param vistaBit 
   */
  public CtrlBitacora(Bitacora modBit, ConsultaBitacora modBitC, BitacoraV vistaBit) {
    this.modBit = modBit;
    this.modBitC = modBitC;
    this.vistaBit = vistaBit;
    
    this.vistaBit.btnGuardarBitacora.addActionListener(this);
    this.vistaBit.btnEditarBitacora.addActionListener(this);
    this.vistaBit.btnEliminarBitacora.addActionListener(this);
    this.vistaBit.btnLimpiarBitacora.addActionListener(this);
    this.vistaBit.btnVolverBitacora.addActionListener(this);
  }
  
  /**
   * Metodo que inicializa elementos graficos de la ventana Bitacora
   */
  public void iniciar(){
    vistaBit.setTitle("Bitácoras");
    vistaBit.setLocationRelativeTo(null);
    cargarTablaBitacora();
    obtenerNombresFuncionarios();
    obtenerIdCita();
  }
  
  /**
   * Metodo que carga la tabla de Bitacora de la BD
   */
  private void cargarTablaBitacora(){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaBit.tablaBitacora.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaBit.tablaBitacora.getColumnCount(); i++){
        vistaBit.tablaBitacora.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }ConsultaBitacora.cargarTablaBitacora(modeloTabla);
  }
  
  /**
   * Metodo que controla la acciones de cada boton de la ventana Bitacora
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Bitacora
    if(e.getSource() == vistaBit.btnGuardarBitacora){
      modBit.setIdBitacora(Integer.parseInt(vistaBit.txtIDBitacora.getText()));
      modBit.setIdentificadorCita(Integer.parseInt(vistaBit.cmbCitaBitacora.
          getSelectedItem().toString()));
      modBit.setNombreAutor(vistaBit.cmbNombreBitacora.getSelectedItem().toString());
      modBit.setFecha(vistaBit.txtFechaBitacora.getText());
      modBit.setHora(vistaBit.txtHoraBitacora.getText());
      
      try {
        if(modBitC.registrarBitacora(modBit)){
          JOptionPane.showMessageDialog(null,"Registro de Bitácora"
              + " guardado");
          cargarTablaBitacora();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton editar Bitacora
    if(e.getSource()==vistaBit.btnEditarBitacora){
      modBit.setIdBitacora(Integer.parseInt(vistaBit.txtIDBitacora.getText()));
      modBit.setIdentificadorCita(Integer.parseInt(vistaBit.cmbCitaBitacora.getSelectedItem().toString()));
      modBit.setNombreAutor(vistaBit.cmbNombreBitacora.getSelectedItem().toString());
      modBit.setFecha(vistaBit.txtFechaBitacora.getText());
      modBit.setHora(vistaBit.txtHoraBitacora.getText());
      
      try {
        if(modBitC.modificarBitacora(modBit)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          cargarTablaBitacora();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el id de bitácora "
              + "ingresado no existe");
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar Bitacora
    if(e.getSource() == vistaBit.btnEliminarBitacora){
      modBit.setIdBitacora(Integer.parseInt(vistaBit.txtIDBitacora.getText()));
      try {
        if(modBitC.eliminarBitacora(modBit)){
          JOptionPane.showMessageDialog(null,"Registro de Bitácora"
              + " eliminado");
          cargarTablaBitacora();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==vistaBit.btnLimpiarBitacora){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==vistaBit.btnVolverBitacora){}
    
  }
  
  /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    vistaBit.txtIDBitacora.setText(null);
    vistaBit.txtFechaBitacora.setText(null);
    vistaBit.txtHoraBitacora.setText(null);
  }
  
    /**
   * Método para insertar el nombre de los funcionarios en el
   * combobox llamado cmbNombreBitacora
   */  
    public void obtenerNombresFuncionarios(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Funcionario");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreFuncionario from "
          + "Funcionario order by cedulaFuncionario");
      rs = st.executeQuery();
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreFuncionario"));
        } rs.close();
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaBit.cmbNombreBitacora.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
    /**
   * Método para insertar los id de las citas en el
   * combobox llamado cmbCitaBitacora
   */  
    public void obtenerIdCita(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Cita");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT identificador from "
          + "Citas order by cedulaPaciente");
      rs = st.executeQuery();
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("identificador"));
        } rs.close();
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaBit.cmbCitaBitacora.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
}
