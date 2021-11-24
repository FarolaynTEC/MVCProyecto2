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
  
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Hospitalizacion
    if(e.getSource() == vistaHos.btnGuardarPaciente){
      modHos.setCedulaPAcienteInternado(Integer.parseInt(vistaHos.cmbCedulaPaciente.getSelectedItem().toString()));
      modHos.setNombrePacienteInternado(vistaHos.cmbCedulaPaciente.getSelectedItem().toString());
      modHos.diagnosticoInter.setNombreDiagnostico(vistaHos.cmbDiagnostico.getSelectedItem().toString());
      modHos.setFechaInicio(vistaHos.txtFechaInicio.getText());
      modHos.setFechaFin(vistaHos.txtFechaFin.getText());
      
      try {
        if(modHosC.registrarHospitalizacion(modHos)){
          JOptionPane.showMessageDialog(null,"Registro de Hospitalizacion"
              + " guardado");
          cargarTablaHospitalizacion ();
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
      modHos.setCedulaPAcienteInternado(Integer.parseInt(vistaHos.cmbCedulaPaciente.getSelectedItem().toString()));
      modHos.setNombrePacienteInternado(vistaHos.cmbCedulaPaciente.getSelectedItem().toString());
      modHos.diagnosticoInter.setNombreDiagnostico(vistaHos.cmbDiagnostico.getSelectedItem().toString());
      modHos.setFechaInicio(vistaHos.txtFechaInicio.getText());
      modHos.setFechaFin(vistaHos.txtFechaFin.getText());
      
      try {
        if(modHosC.modificarHospitalizacion(modHos)){
          JOptionPane.showMessageDialog(null,"Modificación realizada");
          cargarTablaHospitalizacion ();
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
          cargarTablaHospitalizacion ();
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
  
  
  
}
