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
    //Boton guardar Seguimiento
    if(e.getSource() == vistaSegui.btnGuardarSeguimiento){
      modSegui.setCedilaPacienteInternado(Integer.parseInt(vistaSegui.txtCedulaPaciente.getText()));
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
      modSegui.setCedilaPacienteInternado(Integer.parseInt(vistaSegui.txtCedulaPaciente.getText()));
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
      modSegui.setCedilaPacienteInternado(Integer.parseInt(vistaSegui.txtCedulaPaciente.getText()));
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
    vistaSegui.txtCedulaPaciente.setText(null);
    vistaSegui.txtFechaSeguimiento.setText(null);
  }
  
  
  
}
