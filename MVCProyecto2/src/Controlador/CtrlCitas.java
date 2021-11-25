package Controlador;

import Modelo.Bitacora;
import Modelo.Cita;
import Modelo.ConsultaCita;
import Modelo.Diagnostico;
import Modelo.Tratamiento;
import Vista.CitaV;
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
 * Controlados de la clase Cita.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlCitas implements ActionListener {
  private Cita modCita;
  private ConsultaCita modC;
  private CitaV frm;

  public CtrlCitas(Cita modCita,ConsultaCita modC, CitaV frm) {
    this.modCita = modCita;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnCancelar.addActionListener(this);
    this.frm.btnSolicitarCita.addActionListener(this);
    this.frm.btnVolver.addActionListener(this);
    this.frm.btnEliminarCita.addActionListener(this);
    this.frm.btnLimpiar.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana citas
   */
  public void iniciar(){
    frm.setTitle("Citas");
    frm.setLocationRelativeTo(null);
    cargarTablaCita();
    cargarTablaCita1();
    obtenerEspecialidades();
    obtenerCedulasPacientes();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton Solicitar Cita
    if(e.getSource() == frm.btnSolicitarCita){
      int cedulaP = Integer.parseInt(frm.cmbCedulaPaciente.getSelectedItem().toString());
      System.out.println(cedulaP);
      modCita.setCedulaPaciente(cedulaP);
      modCita.setEstadoDeCita("ASIGNADA");
      modCita.setFechaCita(frm.txtFechaCita.getText());
      modCita.setObservaciones(frm.txtObservacionesCita.getText());
      modCita.setEspecialidad(frm.cmbEspecialidad.getSelectedItem().toString());
      try {
        if(modC.registrarCita(modCita)){
          JOptionPane.showMessageDialog(null,"Registro de cita guardado");
          cargarTablaCita();
          cargarTablaCita1();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton cancelar Cita
    if(e.getSource() == frm.btnCancelar){
      int cedulaP = Integer.parseInt(frm.cmbCedulaPaciente.getSelectedItem().toString());
      modCita.setCedulaPaciente(cedulaP);
      modCita.setEstadoDeCita("CANCELADA");
      try {
        if(modC.modificarCita(modCita)){
          JOptionPane.showMessageDialog(null,"Registro de cita cancelado");
          cargarTablaCita();
          cargarTablaCita1();
          
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton eliminar Cita
    if(e.getSource() == frm.btnEliminarCita){
      int cedulaP = Integer.parseInt(frm.cmbCedulaPaciente.getSelectedItem().toString());
      modCita.setCedulaPaciente(cedulaP);
      try {
        if(modC.eliminarCita(modCita)){
          JOptionPane.showMessageDialog(null,"Registro de cita eliminado");
          cargarTablaCita();
          cargarTablaCita1();
          
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
  }
  
   /**
   * Método para insertar las cedulas de los pacientesen el
   * combobox llamado cmbCedulaPaciente
   */  
    public void obtenerCedulasPacientes(){
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
      } frm.cmbCedulaPaciente.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
  /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbEspecialidad
   */  
    public void obtenerEspecialidades(){
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
      } frm.cmbEspecialidad.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
  /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada TablaCita.
   */
  private void cargarTablaCita(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaCita.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaCita.getColumnCount(); i++){
      frm.tablaCita.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaCita.cargarTablaCita(modeloTabla);
  } 
   /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada TablaCita.
   */
  private void cargarTablaCita1(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaCita1.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaCita1.getColumnCount(); i++){
      frm.tablaCita1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaCita.cargarTablaCita1(modeloTabla);
  } 
}
