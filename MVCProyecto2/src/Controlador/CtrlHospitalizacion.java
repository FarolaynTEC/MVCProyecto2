/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Hospitalizacion;
import Modelo.ConsultaHospitalizacion;
import Vista.Hospitalizar;
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
 *
 * @author Alejandra Merino
 */
public class CtrlHospitalizacion implements ActionListener{
  private Hospitalizacion modHos;
  private ConsultaHospitalizacion modHosC;
  private Hospitalizar vistaHos;

  public CtrlHospitalizacion(Hospitalizacion modHos, ConsultaHospitalizacion modHosC, Hospitalizar vistaHos) {
    this.modHos = modHos;
    this.modHosC = modHosC;
    this.vistaHos = vistaHos;
    
    this.vistaHos.btnGuardarPaciente.addActionListener(this);
    this.vistaHos.btnEditarPaciente.addActionListener(this);
    this.vistaHos.btnEliminarPaciente.addActionListener(this);
    this.vistaHos.btnLimpiarPaciente.addActionListener(this);
    this.vistaHos.btnVolverPaciente.addActionListener(this);
  }
  
  public void iniciar(){
    vistaHos.setTitle("Registro de Hospitalizaciones");
    vistaHos.setLocationRelativeTo(null);
    cargarTablaHospitalizacion();
    cargarTablaHospitalizacion1();
    obtenerCedulasPacientesHospitalizacion();
    obtenerNombresPacientesHospitalizacion();
    obtenerEspecialidadesHospi();
    obtenerIdFuncionarios();
    obtenerDiagnosticoHospitalizacion();
    obtenerCentroAtencion();
  }
  
  private void cargarTablaHospitalizacion (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaHos.tablaPaciente.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaHos.tablaPaciente.getColumnCount(); i++){
        vistaHos.tablaPaciente.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaHospitalizacion.cargarTablaHospitalizacion(modeloTabla);
  }
    private void cargarTablaHospitalizacion1 (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaHos.tablaPaciente1.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaHos.tablaPaciente1.getColumnCount(); i++){
        vistaHos.tablaPaciente1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaHospitalizacion.cargarTablaHospitalizacion1(modeloTabla);
  }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Hospitalizacion
    if(e.getSource() == vistaHos.btnGuardarPaciente){
      modHos.setCentroAtencion(Integer.parseInt(vistaHos.cmbCentro.
          getSelectedItem().toString()));
      modHos.setCedulaPAcienteInternado(Integer.parseInt(vistaHos.
          cmbCedulaPaciente.getSelectedItem().toString()));
      modHos.setNombrePacienteInternado(vistaHos.cmbCedulaPaciente.
          getSelectedItem().toString());
      modHos.setDiagnosticoInter(vistaHos.cmbDiagnostico.
          getSelectedItem().toString());
      modHos.setFechaInicio(vistaHos.txtFechaInicio.getText());
      modHos.setFechaFin(vistaHos.txtFechaFin.getText());
      modHos.setEspecialidadHospi(vistaHos.cmbEspecialidad.getSelectedItem().
          toString());
      modHos.setFuncionarioEncargado(Integer.parseInt
    (vistaHos.cmbFuncionario.getSelectedItem().toString()));
     
      try {
        if(modHosC.registrarHospitalizacion(modHos)){
          JOptionPane.showMessageDialog(null,"Registro de Hospitalizacion"
              + " guardado");
          cargarTablaHospitalizacion();
          cargarTablaHospitalizacion1();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton editar Hospitalizacion
    if(e.getSource()== vistaHos.btnEditarPaciente){
      modHos.setCentroAtencion(Integer.parseInt(vistaHos.cmbCentro.
          getSelectedItem().toString()));
      modHos.setCedulaPAcienteInternado(Integer.parseInt(vistaHos.
          cmbCedulaPaciente.getSelectedItem().toString()));
      modHos.setNombrePacienteInternado(vistaHos.cmbCedulaPaciente.
          getSelectedItem().toString());
      modHos.setDiagnosticoInter(vistaHos.cmbDiagnostico.
          getSelectedItem().toString());
      modHos.setFechaInicio(vistaHos.txtFechaInicio.getText());
      modHos.setFechaFin(vistaHos.txtFechaFin.getText());
      modHos.setEspecialidadHospi(vistaHos.cmbEspecialidad.getSelectedItem().
          toString());
      modHos.setFuncionarioEncargado(Integer.parseInt
    (vistaHos.cmbFuncionario.getSelectedItem().toString()));
      
      try {
        if(modHosC.modificarHospitalizacion(modHos)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          cargarTablaHospitalizacion();
          cargarTablaHospitalizacion1();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el id de paciente "
              + "ingresado no existe");
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar Hospitalizacion
    if(e.getSource() == vistaHos.btnEliminarPaciente){
      modHos.setCedulaPAcienteInternado(Integer.parseInt(vistaHos.cmbCedulaPaciente.getSelectedItem().toString()));
      try {
        if(modHosC.eliminarHospitalizacion(modHos)){
          JOptionPane.showMessageDialog(null,"Registro de Hospitalizacion"
              + " eliminado");
          cargarTablaHospitalizacion();
          cargarTablaHospitalizacion1();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==vistaHos.btnLimpiarPaciente){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==vistaHos.btnVolverPaciente){
       
    }
  }
  
  /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    vistaHos.txtFechaInicio.setText(null);
    vistaHos.txtFechaFin.setText(null);
  }
  
  public void obtenerCedulasPacientesHospitalizacion(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Paciente");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPaciente "
          + "from Paciente order by cedulaPaciente");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaPaciente"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbCedulaPaciente.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  public void obtenerNombresPacientesHospitalizacion(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Paciente");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombrePaciente "
          + "from Paciente order by nombrePaciente");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombrePaciente"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbNombrePaciente.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  public void obtenerDiagnosticoHospitalizacion(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Diagnostico");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreDiagnostico "
          + "from Diagnostico order by nombreDiagnostico");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreDiagnostico"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbDiagnostico.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  public void obtenerEspecialidadesHospi(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Especialidad");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT AreaTrabajo from "
          + "AreaTrabajo order by AreaTrabajo");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("AreaTrabajo"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbEspecialidad.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  public void obtenerIdFuncionarios(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Funcionario");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaFuncionario  from "
          + "Funcionario order by cedulaFuncionario");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaFuncionario"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbFuncionario.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  public void obtenerCentroAtencion(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Lugar");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT codigoCentroAtencion from "
          + "CentroAtencion order by codigoCentroAtencion");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("codigoCentroAtencion"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } vistaHos.cmbCentro.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
}
