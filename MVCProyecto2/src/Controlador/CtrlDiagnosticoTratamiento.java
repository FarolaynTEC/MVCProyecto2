/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Diagnostico;
import Modelo.Tratamiento;
import Modelo.ConsultaDiagnosticoTratamiento;
import Vista.DiagnosticoTratamiento;
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
public class CtrlDiagnosticoTratamiento implements ActionListener{
  private Diagnostico modDia;
  private Tratamiento modTra;
  private ConsultaDiagnosticoTratamiento modDiaTra;
  private DiagnosticoTratamiento vistaDiaTra;

  public CtrlDiagnosticoTratamiento(Diagnostico modDia, Tratamiento modTra, ConsultaDiagnosticoTratamiento modDiaTra, DiagnosticoTratamiento vistaDiaTra) {
    this.modDia = modDia;
    this.modTra = modTra;
    this.modDiaTra = modDiaTra;
    this.vistaDiaTra = vistaDiaTra;
    
    this.vistaDiaTra.btnLimpiarDiag.addActionListener(this);
    this.vistaDiaTra.btnGuardarDiagnostico.addActionListener(this);
    this.vistaDiaTra.btnEditarDiagnostico.addActionListener(this);
    this.vistaDiaTra.btnEliminarDiagnostico.addActionListener(this);
    this.vistaDiaTra.btnLimpiarCentro2.addActionListener(this);
    this.vistaDiaTra.btnGuardarTratamiento.addActionListener(this);
    this.vistaDiaTra.btnEditarTratamiento.addActionListener(this);
    this.vistaDiaTra.btnEliminarTratamiento.addActionListener(this);
    this.vistaDiaTra.btnVolverCentro.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana
   */
  public void iniciar(){
    vistaDiaTra.setTitle("Diagnósticos y tratamientos");
    vistaDiaTra.setLocationRelativeTo(null);
    cargarTablaDiagnostico();
    cargarTablaTratamiento();
  }
  
  private void cargarTablaDiagnostico (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiaTra.tablaDiagnostico.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaDiaTra.tablaDiagnostico.getColumnCount(); i++){
        vistaDiaTra.tablaDiagnostico.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaDiagnosticoTratamiento.cargarTablaDiagnotico(modeloTabla);
    }
  
  private void cargarTablaTratamiento (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiaTra.tablaTratamiento.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaDiaTra.tablaDiagnostico.getColumnCount(); i++){
        vistaDiaTra.tablaTratamiento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaDiagnosticoTratamiento.cargarTablaTratamiento(modeloTabla);
    }
  
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Diagnostico
    if(e.getSource() == vistaDiaTra.btnGuardarDiagnostico){
      modDia.setIdentificadorCita(Integer.parseInt(vistaDiaTra.txtIDCita.getText()));
      modDia.setNombreDiagnostico(vistaDiaTra.txtNombreDiagnostico.getText());
      modDia.setObservaciones(vistaDiaTra.txtObservacionDiagnostico.getText());
      modDia.setNivel(vistaDiaTra.cbxNiveles.getSelectedItem().toString());
      
      try {
        if(modDiaTra.registrarDiagnostico(modDia)){
          JOptionPane.showMessageDialog(null,"Registro de Diagnóstico"
              + " guardado");
          cargarTablaDiagnostico();
          cargarTablaTratamiento();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton guardar Tratamiento
    if(e.getSource() == vistaDiaTra.btnGuardarTratamiento){
      modTra.setIdentificadorCita(Integer.parseInt(vistaDiaTra.txtIdTrata.getText()));
      modTra.setNombreTratamiento(vistaDiaTra.txNombreTratamiento.getText());
      modTra.setDosis(vistaDiaTra.txtDosisTratamiento.getText());
      modTra.setTipoTratamiento(vistaDiaTra.txtTipoTratamiento.getText());
      
      try {
        if(modDiaTra.registrarTratamiento(modTra)){
          JOptionPane.showMessageDialog(null,"Registro de Tratamiento "
              + " guardado");
          cargarTablaDiagnostico();
          cargarTablaTratamiento();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton eliminar Area
    if(e.getSource() == vistaDiaTra.btnEliminarDiagnostico){
      modDia.setIdentificadorCita(Integer.parseInt(vistaDiaTra.txtIDCita.getText()));
      try {
        if(modDiaTra.eliminarDiagnotico(modDia)){
          JOptionPane.showMessageDialog(null,"Registro de Diagnóstico"
              + " eliminado");
          cargarTablaDiagnostico();
          cargarTablaTratamiento();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton eliminar Tipo Centro
    if(e.getSource() == vistaDiaTra.btnEliminarTratamiento){
      modTra.setIdentificadorCita(Integer.parseInt(vistaDiaTra.txtIdTrata.getText()));
      try {
        if(modDiaTra.eliminarTratamiento(modTra)){
          JOptionPane.showMessageDialog(null,"Registro de Tratamiento"
              + " eliminado");
          cargarTablaDiagnostico();
          cargarTablaTratamiento();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==vistaDiaTra.btnLimpiarDiag){
      limpiarDiagnostico();
    }
    
    //Boton limpiar
    if(e.getSource()==vistaDiaTra.btnLimpiarCentro2){
      limpiarTratamiento();
    }
    
    //boton Volver
    if(e.getSource()==vistaDiaTra.btnVolverCentro){
       
    }
    
  }
  
    /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiarDiagnostico(){
    vistaDiaTra.txtIDCita.setText(null);
    vistaDiaTra.txtNombreDiagnostico.setText(null);
    vistaDiaTra.txtObservacionDiagnostico.setText(null);
  }
  
    /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiarTratamiento(){
    vistaDiaTra.txtIdTrata.setText(null);
    vistaDiaTra.txNombreTratamiento.setText(null);
    vistaDiaTra.txtDosisTratamiento.setText(null);
    vistaDiaTra.txtTipoTratamiento.setText(null);
  }
  
}
