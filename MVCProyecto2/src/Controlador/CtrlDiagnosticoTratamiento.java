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
 * Clase Controlador para las consultas de Diagnostico y Tratamiento.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlDiagnosticoTratamiento implements ActionListener{
  private Diagnostico modDia;
  private Tratamiento modTra;
  private ConsultaDiagnosticoTratamiento modDiaTra;
  private DiagnosticoTratamiento vistaDiaTra;

 /**
  * Esta es una clase de Controlador de Diagnostico y Tratamiento
  * @author Josue Brenes, Paola Lopez, Alejandra Merino
  * @param modDia
  * @param modTra
  * @param modDiaTra
  * @param vistaDiaTra 
  */
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
    obtenerIdCita();
    obtenerIdCita1();
  }
  
  /**
   * Metodo que carga la tabla de Dianostico de la BD
   */
  private void cargarTablaDiagnostico (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiaTra.tablaDiagnostico.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaDiaTra.tablaDiagnostico.getColumnCount(); i++){
        vistaDiaTra.tablaDiagnostico.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      }ConsultaDiagnosticoTratamiento.cargarTablaDiagnotico(modeloTabla);
    }
  
  /**
   * Metodo que carga la tabla de Tratamiento de la BD
   */
  private void cargarTablaTratamiento (){
      DefaultTableModel modeloTabla = (DefaultTableModel) vistaDiaTra.tablaTratamiento.getModel();
      modeloTabla.setRowCount(0);
      ResultSet rs;
      ResultSetMetaData rsmd;
      int columnas;

      int [] anchos = {10, 50, 100, 30, 100};
      for(int i = 0 ; i < vistaDiaTra.tablaDiagnostico.getColumnCount(); i++){
        vistaDiaTra.tablaTratamiento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
      } ConsultaDiagnosticoTratamiento.cargarTablaTratamiento(modeloTabla);
    }
  
  /**
   * Método encargado del control de las funcionalidades
   * del CRUD de los Diagnositcos y Tratamiento
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Diagnostico
    if(e.getSource() == vistaDiaTra.btnGuardarDiagnostico){
      modDia.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita.
          getSelectedItem().toString()));
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
      modTra.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita1.
          getSelectedItem().toString()));
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
    
    //Boton eliminar diagnostico
    if(e.getSource() == vistaDiaTra.btnEliminarDiagnostico){
      modDia.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita.
          getSelectedItem().toString()));
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
    
    //Boton eliminar Tratamineto
    if(e.getSource() == vistaDiaTra.btnEliminarTratamiento){
      modTra.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita1.
          getSelectedItem().toString()));
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
    
   //Boton modificar diagnostico
    if(e.getSource() == vistaDiaTra.btnEditarDiagnostico){
      modDia.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita.
          getSelectedItem().toString()));
      modDia.setNombreDiagnostico(vistaDiaTra.txtNombreDiagnostico.getText());
      modDia.setObservaciones(vistaDiaTra.txtObservacionDiagnostico.getText());
      modDia.setNivel(vistaDiaTra.cbxNiveles.getSelectedItem().toString());
      try {
        if(modDiaTra.modificarDiagnostico(modDia)){
          JOptionPane.showMessageDialog(null,"Registro de diagnostico"
              + " modificado");
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
    
    //Boton modificar Trataminto
    if(e.getSource() == vistaDiaTra.btnEditarTratamiento){
      modTra.setIdentificadorCita(Integer.parseInt(vistaDiaTra.cmbIdCita1.
          getSelectedItem().toString()));
      modTra.setNombreTratamiento(vistaDiaTra.txNombreTratamiento.getText());
      modTra.setDosis(vistaDiaTra.txtDosisTratamiento.getText());
      modTra.setTipoTratamiento(vistaDiaTra.txtTipoTratamiento.getText());
      try {
        if(modDiaTra.modificarTratamiento(modTra)){
          JOptionPane.showMessageDialog(null,"Registro de Tratamiento"
              + " modificado");
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
   * Metodo que establece las cajas de texto como nulas o vacias de Diagnostico
   */
  public void limpiarDiagnostico(){
    vistaDiaTra.txtNombreDiagnostico.setText(null);
    vistaDiaTra.txtObservacionDiagnostico.setText(null);
  }
  
    /**
   * Metodo que establece las cajas de texto como nulas o vacias de Tratamiento
   */
  public void limpiarTratamiento(){
    vistaDiaTra.txNombreTratamiento.setText(null);
    vistaDiaTra.txtDosisTratamiento.setText(null);
    vistaDiaTra.txtTipoTratamiento.setText(null);
  }
  
    /**
   * Método para insertar los id de las citas en el
   * combobox llamado cmbIdCita
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
      } vistaDiaTra.cmbIdCita.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
      /**
   * Método para insertar los id de las citas en el
   * combobox llamado cmbIdCita1
   */  
    public void obtenerIdCita1(){
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
      } vistaDiaTra.cmbIdCita1.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
}
