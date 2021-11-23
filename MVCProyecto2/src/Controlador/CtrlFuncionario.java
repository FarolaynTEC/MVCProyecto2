package Controlador;

import Modelo.ConsultaFuncionario;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.AreaTrabajo;
import Vista.FuncionarioV;
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
 * Controlados de la clase Funcionario.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlFuncionario implements ActionListener {
  
  private Funcionario modFun;
  private Doctor modDoc;
  private Enfermero modEnf;
  private ConsultaFuncionario modC;
  private FuncionarioV frm;

  public CtrlFuncionario(Funcionario modFun, ConsultaFuncionario modC,
        Doctor modDoc,Enfermero modEnf, FuncionarioV frm) {
    this.modFun = modFun;
    this.modDoc = modDoc;
    this.modEnf = modEnf;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnEliminarFuncionario1.addActionListener(this);
    this.frm.btnEliminarSecretario.addActionListener(this);
    this.frm.btnGuardarFuncionario.addActionListener(this);
    this.frm.btnAgregarEspecialidad.addActionListener(this);
    this.frm.btnEditarsecretario.addActionListener(this);
    this.frm.btnEditarFuncionario.addActionListener(this);
    this.frm.btnEditarFuncionario1.addActionListener(this);
    this.frm.btnEliminarFuncionario.addActionListener(this);
    this.frm.btnGuardarSecretario.addActionListener(this);
    this.frm.btnGuardarFuncionario2.addActionListener(this);
    this.frm.btnLimpiar.addActionListener(this);
    this.frm.btnVolver.addActionListener(this);
  }
    
  /**
   * Inicializador de la ventana Funcionarios
   */
  public void iniciar(){
    frm.setTitle("Funcionarios");
    frm.setLocationRelativeTo(null);
    cargarTablaFuncionario();
    cargarTablaFuncionarioEnfermero();
    cargarTablaFuncionarioDoctor();
    obtenerAreaFuncionario();
    obtenerLugarTrabajo();
  }
  
  /**
   * 
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e){
    //Boton guardar Secritario
    if(e.getSource() == frm.btnGuardarSecretario){
      System.out.println("Aqui en boton guardar secre");
      modFun.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modFun.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modFun.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modFun.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modFun.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modFun.setAreaTrabajo(areaTrabajo);
      try {
        if(modC.registrarFuncionario(modFun)){
          JOptionPane.showMessageDialog(null,"Registro de Funcionario guardado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton guardar Doctor
    if(e.getSource()==frm.btnGuardarFuncionario){
      modDoc.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modDoc.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modDoc.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modDoc.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modDoc.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modDoc.setAreaTrabajo(areaTrabajo);
      modDoc.setCodigoMedico(Integer.parseInt(frm.txtCedulaDoctor.getText()));
      modDoc.setEspecialidad(frm.txtEspecialidad.getText());
      try {
        if(modC.registrarDoctor(modDoc)){
          JOptionPane.showMessageDialog(null,"Registro de Doctor guardado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,e);
      }
    }
    
    //Boton guardar enfermero
    if(e.getSource()==frm.btnGuardarFuncionario2){
      modEnf.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modEnf.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modEnf.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modEnf.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modEnf.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modEnf.setAreaTrabajo(areaTrabajo);
      int aCargo;
      if(frm.jRadioButton1.isSelected()==true){
        aCargo=1;
      }else if(frm.jRadioButton1.isSelected()==true){
        aCargo=0;
      }else{
        aCargo=0;
      }
      modEnf.setIndicadorExpCapacitacion(aCargo);
      int expCapa;
      if(frm.jRadioButton5.isSelected()==true){
        expCapa=1;
      }else if(frm.jRadioButton6.isSelected()==true){
        expCapa=0;
      }else{
        expCapa=0;
      }
      modEnf.setIndicadorExpCapacitacion(expCapa);
      try {
        if(modC.registrarEnfermero(modEnf)){
          JOptionPane.showMessageDialog(null,"Registro de enfermero guardado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,e);
      }
    }
    
    
    //Boton editar Secretario
    if(e.getSource()==frm.btnEditarsecretario){
      modFun.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modFun.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modFun.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modFun.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modFun.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modFun.setAreaTrabajo(areaTrabajo);
      try {
        if(modC.modificarFuncionario(modFun)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton editar Doctor
    if(e.getSource()==frm.btnEditarFuncionario){
      modDoc.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modDoc.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modDoc.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modDoc.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modDoc.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modDoc.setAreaTrabajo(areaTrabajo);
      modDoc.setCodigoMedico(Integer.parseInt(frm.txtCedulaDoctor.getText()));
      modDoc.setEspecialidad(frm.txtEspecialidad.getText());
      try {
        if(modC.modificarDoctor(modDoc)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton editar Enfermero
    if(e.getSource()==frm.btnEditarsecretario){
      modEnf.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modEnf.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modEnf.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modEnf.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modEnf.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.
          getSelectedItem().toString());
      modEnf.setAreaTrabajo(areaTrabajo);
      int aCargo;
      if(frm.jRadioButton1.isSelected()==true){
        aCargo=1;
      }else if(frm.jRadioButton1.isSelected()==true){
        aCargo=0;
      }else{
        aCargo=0;
      }
      modEnf.setIndicadorExpCapacitacion(aCargo);
      int expCapa;
      if(frm.jRadioButton5.isSelected()==true){
        expCapa=1;
      }else if(frm.jRadioButton6.isSelected()==true){
        expCapa=0;
      }else{
        expCapa=0;
      }
      modEnf.setIndicadorExpCapacitacion(expCapa);
      try {
        if(modC.modificarEnfermero(modEnf)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar secretario
    if(e.getSource()==frm.btnEliminarSecretario){
      modFun.setCedulaFuncionario(Integer.parseInt
          (frm.txtCedulaFuncionario.getText()));
      try {
        if(modC.eliminarFuncionario(modFun)){
          JOptionPane.showMessageDialog(null,"Registro de secretario eliminado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar Doctor
    if(e.getSource()==frm.btnEliminarFuncionario){
      modDoc.setCedulaFuncionario(Integer.parseInt
          (frm.txtCedulaFuncionario.getText()));
      try {
        if(modC.eliminarDoctor(modDoc)){
          JOptionPane.showMessageDialog(null,"Registro de doctor eliminado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }

    //Boton eliminar Enfermero
    if(e.getSource()==frm.btnEliminarFuncionario1){
      modEnf.setCedulaFuncionario(Integer.parseInt
          (frm.txtCedulaFuncionario.getText()));
      try {
        if(modC.eliminarEnfermero(modEnf)){
          JOptionPane.showMessageDialog(null,"Registro de enfermero eliminado");
          limpiar();
          cargarTablaFuncionario();
          cargarTablaFuncionarioEnfermero();
          cargarTablaFuncionarioDoctor();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR, el funcionario "
              + "ingresado no existe");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==frm.btnLimpiar){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==frm.btnVolver){
       
    }
    
  }
  
    /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    frm.txtCedulaFuncionario.setText(null);
    frm.txtCedulaDoctor.setText(null);
    frm.txtEspecialidad.setText(null);
    frm.txtFechaFuncionario.setText(null);
    frm.txtNombreFuncionario.setText(null);
  }
  
    /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaCentroA.
   */
  private void cargarTablaFuncionario(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaFuncionario.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaFuncionario.getColumnCount(); i++){
      frm.tablaFuncionario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaFuncionario.cargarTablaFuncionario(modeloTabla);
  }
  
  /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaCentroA.
   */
  private void cargarTablaFuncionarioDoctor(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaDoctor.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaFuncionario.getColumnCount(); i++){
      frm.tablaFuncionario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaFuncionario.cargarTablaFuncionarioDoctor(modeloTabla);
  }
  
    /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaCentroA.
   */
  private void cargarTablaFuncionarioEnfermero(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaEnfermero.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaEnfermero.getColumnCount(); i++){
      frm.tablaEnfermero.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaFuncionario.cargarTablaFuncionarioEnfermero(modeloTabla);
  }
  
    /**
   * Método para insertar las areas de los funcionarios en el
   * combobox llamado cmbAreaFuncionario
   */  
  public void obtenerAreaFuncionario(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Área");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT * from "
          + "AreaTrabajo order by areaTrabajo");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("areaTrabajo"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbAreaFuncionario.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
    /**
   * Método para insertar las areas de los funcionarios en el
   * combobox llamado cmbAreaFuncionario
   */  
    public void obtenerLugarTrabajo(){
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
      } frm.cmbTrabajaEn.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
}
