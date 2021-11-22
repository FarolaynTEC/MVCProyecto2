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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlados de la clase Funcionario.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlFuncionario {
  
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
    this.frm = frm;
    this.frm.btnAgregarEspecialidad.addActionListener((ActionListener) this);
    this.frm.btnEditarFuncionario.addActionListener((ActionListener) this);
    this.frm.btnEditarFuncionario1.addActionListener((ActionListener) this);
    this.frm.btnEliminarFuncionario.addActionListener((ActionListener) this);
    this.frm.btnEliminarFuncionario1.addActionListener((ActionListener) this);
    this.frm.btnGuardarFuncionario.addActionListener((ActionListener) this);
    this.frm.btnGuardarFuncionario2.addActionListener((ActionListener) this);
    this.frm.btnLimpiar.addActionListener((ActionListener) this);
    this.frm.btnVolver.addActionListener((ActionListener) this);
  }
    
  /**
   * Inicializador de la ventana Funcionarios
   */
  public void iniciar(){
    frm.setTitle("Funcionarios");
    frm.setLocationRelativeTo(null);
  }
  
  /**
   * 
   * @throws java.sql.SQLException
   * @override
   * @param e 
   */
  public void actionPerformed(ActionEvent e){
    AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.getSelectedItem().toString());
    
    //Boton guardar Secritario
    if(e.getSource()==frm.btnGuardarSecretario){
      modFun.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modFun.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modFun.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modFun.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modFun.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
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
      modDoc.setAreaTrabajo(areaTrabajo);
      modDoc.setCodigoMedico(Integer.parseInt(frm.txtCedulaDoctor.getText()));
      modDoc.setEspecialidad(frm.txtEspecialidad.getText());
      try {
        if(modC.registrarDoctor(modDoc)){
          JOptionPane.showMessageDialog(null,"Registro de Doctor guardado");
          limpiar();
          cargarTablaFuncionario();
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
      modEnf.setAreaTrabajo(areaTrabajo);
      boolean aCargo;
      if(frm.jRadioButton1.isSelected()==true){
        aCargo=true;
      }else if(frm.jRadioButton1.isSelected()==true){
        aCargo=false;
      }else{
        aCargo=false;
      }
      modEnf.setIndicadorExpCapacitacion(aCargo);
      boolean expCapa;
      if(frm.jRadioButton5.isSelected()==true){
        expCapa=true;
      }else if(frm.jRadioButton6.isSelected()==true){
        expCapa=false;
      }else{
        expCapa=false;
      }
      modEnf.setIndicadorExpCapacitacion(expCapa);
      try {
        if(modC.registrarEnfermero(modDoc)){
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
    
    
    //Boton editar enfermero
    if(e.getSource()==frm.btnEditarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt(frm.txtCodigoCentro.getText()));
      mod.setNombre(frm.txtNombreCentro.getText());
      mod.setUbicacion(frm.txtUbicacionCentro.getText());
      mod.setCapacidadMaxPac(Integer.parseInt(frm.txtCantidadCentro.getText()));
      mod.setTipoDeCentro(frm.cmbTipoCentro.getSelectedItem().toString());
      
      try {
        if(modC.modificar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención modificado");
          limpiar();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar
    if(e.getSource()==frm.btnEliminarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt
        (frm.txtCodigoCentro.getText()));
      try {
        if(modC.eliminar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención eliminado");
          limpiar();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
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
    if(e.getSource()==frm.btnVolverCentro){
       
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
}
