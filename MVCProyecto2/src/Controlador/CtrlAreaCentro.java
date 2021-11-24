package Controlador;

import Modelo.AreaTrabajo;
import Modelo.ConsultaTipoCentro;
import Modelo.TipoCentroAtencion;
import Vista.AreaCentro;
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
 * Controlados de la clase Area y tipo Centro.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlAreaCentro implements ActionListener{
  private AreaTrabajo modAT;
  private TipoCentroAtencion modTCA;
  private ConsultaTipoCentro modC;
  private AreaCentro frm;

  public CtrlAreaCentro(AreaTrabajo modAT, TipoCentroAtencion modTCA, ConsultaTipoCentro modC, AreaCentro frm) {
    this.modAT = modAT;
    this.modTCA = modTCA;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnEliminarArea.addActionListener(this);
    this.frm.btnEliminarCentro.addActionListener(this);
    this.frm.btnGuardarArea.addActionListener(this);
    this.frm.btnGuardarCentro.addActionListener(this);
    this.frm.btnLimpiarArea.addActionListener(this);
    this.frm.btnLimpiarCentro.addActionListener(this);
    this.frm.btnVolver.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana
   */
  public void iniciar(){
    frm.setTitle("Areas y Centros de Trabajo");
    frm.setLocationRelativeTo(null);
    cargarTablaAreaTrabajo();
    cargarTablaCentroAtencion();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Area
    if(e.getSource() == frm.btnGuardarArea){
      modAT.setNomAreaTrabajo(frm.txtNombreArea.getText());
      try {
        if(modC.registrarAreaTrabajo(modAT)){
          JOptionPane.showMessageDialog(null,"Registro de Area de Trabajo"
              + " guardado");
          cargarTablaAreaTrabajo();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton guardar Tipo Centro
    if(e.getSource() == frm.btnGuardarCentro){
      modTCA.setTipoCentro(frm.txtNombreCentro.getText());
      try {
        if(modC.registrarTipoCentroAtencion(modTCA)){
          JOptionPane.showMessageDialog(null,"Registro de Tipo de centro "
              + "de atención guardado");
          cargarTablaAreaTrabajo();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton eliminar Area
    if(e.getSource() == frm.btnEliminarArea){
      modAT.setNomAreaTrabajo(frm.txtNombreArea.getText());
      try {
        if(modC.EliminarAreaTrabajo(modAT)){
          JOptionPane.showMessageDialog(null,"Registro de Area de Trabajo"
              + " eliminado");
          cargarTablaAreaTrabajo();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
    
    //Boton eliminar Tipo Centro
    if(e.getSource() == frm.btnEliminarCentro){
      modTCA.setTipoCentro(frm.txtNombreCentro.getText());
      try {
        if(modC.EliminarTipoCentroAtencion(modTCA)){
          JOptionPane.showMessageDialog(null,"Registro de Tipo de centro "
              + "de atención eliminado");
          cargarTablaAreaTrabajo();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    } 
  }
  
      private void cargarTablaAreaTrabajo(){
      DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaArea.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < frm.tablaArea.getColumnCount(); i++){
        frm.tablaArea.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaTipoCentro.cargarTablaAreaTrabajo(modeloTabla);
    }
    
    private void cargarTablaCentroAtencion(){
      DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaTipoCentro.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < frm.tablaTipoCentro.getColumnCount(); i++){
        frm.tablaTipoCentro.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }
      ConsultaTipoCentro.cargarTablaTipoDeCentro(modeloTabla);
    }
}

