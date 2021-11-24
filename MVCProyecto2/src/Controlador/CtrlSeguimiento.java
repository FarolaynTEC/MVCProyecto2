/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.RegistroSeguimiento;
import Modelo.ConsultaSeguimiento;
import Vista.Seguimiento;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Alejandra Merino
 */
public class CtrlSeguimiento implements ActionListener{
  private RegistroSeguimiento modSegui;
  private ConsultaSeguimiento modSeguiC;
  private Seguimiento vistaSegui;

  public CtrlSeguimiento(RegistroSeguimiento modSegui, ConsultaSeguimiento modSeguiC, Seguimiento vistaSegui) {
    this.modSegui = modSegui;
    this.modSeguiC = modSeguiC;
    this.vistaSegui = vistaSegui;
    
    this.vistaSegui.btnGuardarSeguimiento.addActionListener(this);
    this.vistaSegui.btnEditarSeguimiento.addActionListener(this);
    this.vistaSegui.btnEliminarSeguimiento.addActionListener(this);
    this.vistaSegui.btnLimpiar.addActionListener(this);
    this.vistaSegui.btnVolver.addActionListener(this);
  }
  
  public void iniciar(){
    vistaSegui.setTitle("Registro de seguimiento");
    vistaSegui.setLocationRelativeTo(null);
    cargarTablaSeguimiento();
    obtenerCedulaPaciente();
    obtenerFuncionarios();
    obtenerTratamiento();
  }
  
  private void cargarTablaSeguimiento (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaSegui.tablaSeguimiento.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaSegui.tablaSeguimiento.getColumnCount(); i++){
        vistaSegui.tablaSeguimiento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaSeguimiento.cargarTablaSeguimiento(modeloTabla);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Seguimiento
    if(e.getSource() == vistaSegui.btnGuardarSeguimiento){
      modSegui.setCedilaPacienteInternado(Integer.parseInt
          (vistaSegui.cmbCedulaPacientes.getSelectedItem().toString()));
      modSegui.setFechaSeguimiento(vistaSegui.txtFechaSeguimiento.getText());
      modSegui.funcionarioSegui.setCedulaFuncionario(Integer.parseInt(vistaSegui.cmbFuncionario.getSelectedItem().toString()));
      modSegui.setTratamientoAsociado(vistaSegui.cmbTratamiento.getSelectedItem().toString());
      
      try {
        if(modSeguiC.registrarSeguimiento(modSegui)){
          JOptionPane.showMessageDialog(null,"Registro de Seguimiento"
              + " guardado");
          cargarTablaSeguimiento ();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton editar Seguimiento
    if(e.getSource()== vistaSegui.btnEditarSeguimiento){
      modSegui.setCedilaPacienteInternado(Integer.parseInt
          (vistaSegui.cmbCedulaPacientes.getSelectedItem().toString()));
      modSegui.setFechaSeguimiento(vistaSegui.txtFechaSeguimiento.getText());
      modSegui.funcionarioSegui.setCedulaFuncionario(Integer.parseInt(vistaSegui.cmbFuncionario.getSelectedItem().toString()));
      modSegui.setTratamientoAsociado(vistaSegui.cmbTratamiento.getSelectedItem().toString());
      
      try {
        if(modSeguiC.modificarSeguimiento(modSegui)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          cargarTablaSeguimiento ();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el id de paciente "
              + "ingresado no existe");
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar Seguimiento
    if(e.getSource() == vistaSegui.btnEliminarSeguimiento){
      modSegui.setCedilaPacienteInternado(Integer.parseInt
          (vistaSegui.cmbCedulaPacientes.getSelectedItem().toString()));
      try {
        if(modSeguiC.eliminarSeguimiento(modSegui)){
          JOptionPane.showMessageDialog(null,"Registro de Seguimiento"
              + " eliminado");
          cargarTablaSeguimiento ();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==vistaSegui.btnLimpiar){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==vistaSegui.btnVolver){
       
    }
  }
  
  /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    vistaSegui.txtFechaSeguimiento.setText(null);
  }
  
   /**
   * Método para insertar las cedulas de los pacientes en el
   * combobox llamado cmbCedulaPacientes
   */  
  public void obtenerCedulaPaciente(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Paciente");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPaciente "
          + "FROM Paciente ORDER BY cedulaPaciente");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaPaciente"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaSegui.cmbCedulaPacientes.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
        /**
   * Método para insertar las cedulas de los funcionarios en el
   * combobox llamado cmbFuncionario
   */  
  public void obtenerFuncionarios(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Funcionario");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaFuncionario"
          + " FROM Funcionario ORDER BY cedulaFuncionario");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaFuncionario"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaSegui.cmbFuncionario.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
        /**
   * Método para insertar las cedulas de los funcionarios en el
   * combobox llamado cmbFuncionario
   */  
  public void obtenerTratamiento(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Tratamiento");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreTratameinto"
          + " FROM Tratamiento ORDER BY nombreTratameinto");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreTratameinto"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaSegui.cmbTratamiento.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
}
