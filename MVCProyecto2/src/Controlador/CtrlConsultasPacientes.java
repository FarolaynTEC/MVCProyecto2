package Controlador;

import Modelo.Cita;
import Modelo.ConsultaCita;
import Modelo.ConsultaDiagnosticoTratamiento;
import Modelo.ConsultaHospitalizacion;
import Modelo.Diagnostico;
import Modelo.Hospitalizacion;
import Modelo.Tratamiento;
import Vista.CitaV;
import Vista.ConsultasDePacientes;
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
 * Controlador para las consultas de pacientes.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlConsultasPacientes implements ActionListener{
  
  private Cita modCita;
  private ConsultaCita modC;
  
  private Diagnostico modDia;
  private Tratamiento modTra;
  private ConsultaDiagnosticoTratamiento modDiaTra;
  
  private Hospitalizacion modHos;
  private ConsultaHospitalizacion modHosC;
  
  private ConsultasDePacientes frm;
  
  public CtrlConsultasPacientes(Cita modCita,ConsultaCita modC, 
      Diagnostico modDia, Tratamiento modTra, 
      ConsultaDiagnosticoTratamiento modDiaTra, ConsultasDePacientes frm , 
      Hospitalizacion modHos,ConsultaHospitalizacion modHosC ) {
    this.modCita = modCita;
    this.modC = modC;
    this.modDia = modDia;
    this.modTra = modTra;
    this.modDiaTra = modDiaTra;
    this.modHos = modHos;
    this.modHosC = modHosC;
    this.frm = frm;
    this.frm.btnEspecialidad.addActionListener(this);
    this.frm.btnEstado.addActionListener(this);
    this.frm.btnNivel.addActionListener(this);
    this.frm.btnNombre.addActionListener(this);
    this.frm.btnNombreTratemineto.addActionListener(this);
    this.frm.btnTipoTratameinto.addActionListener(this);
    this.frm.btnConsultaPacienteHospitalizado.addActionListener(this);

  }
  
  /**
   * Inicializador de la ventana consultasPacientes
   */
  public void iniciar(){
    frm.setTitle("Consultas Pacientes");
    frm.setLocationRelativeTo(null);
    obtenerEspecialidades();
    obtenerNombre();
    obtenerNivelDiagnostico();
    obtenerNombreTratamiento();
    obtenerTipoTratamiento();
    obtenerNombreHospitalizados();

  }

  @Override
  public void actionPerformed(ActionEvent e) {
//Boton consultar por especialidad
    if(e.getSource() == frm.btnEspecialidad){
      modCita.setEspecialidad(frm.cmbEspecialidad.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblCitas.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblCitas.getColumnCount(); i++){
          frm.tblCitas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modC.consultarCitasEspecialidad(modCita, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }  
    
    //Boton consultar por estado
    if(e.getSource() == frm.btnEstado){
      modCita.setEstadoDeCita(frm.cmbEstado.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblCitas.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblCitas.getColumnCount(); i++){
          frm.tblCitas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modC.consultarCitasEstado(modCita, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //***********Segunda consulta******************//
    
    //Boton consultar por nivel
    if(e.getSource() == frm.btnNivel){
      modDia.setNivel(frm.cmbNivelDiagnostico.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblDiagnosticoConsulta.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblDiagnosticoConsulta.getColumnCount(); i++){
          frm.tblDiagnosticoConsulta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modDiaTra.consultarCitasEstado(modDia, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
       //Boton consultar por nombre
    if(e.getSource() == frm.btnNombre){
      modDia.setNivel(frm.cmbNombreDiagnostico.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblDiagnosticoConsulta.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblDiagnosticoConsulta.getColumnCount(); i++){
          frm.tblDiagnosticoConsulta.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modDiaTra.consultarNombre(modDia, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
     //***********tercera consulta******************//
    //Boton consultar por tipo tratamiento
    if(e.getSource() == frm.btnTipoTratameinto){
      modTra.setTipoTratamiento(frm.cmbTipoTratamiento.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblTratamiento.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblTratamiento.getColumnCount(); i++){
          frm.tblTratamiento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modDiaTra.consultarTipoTrata(modTra, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
        //Boton consultar por nombre tratamiento
    if(e.getSource() == frm.btnNombreTratemineto){
      modTra.setNombreTratamiento(frm.cmbNombreTratamiento.getSelectedItem().toString());
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblTratamiento.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblTratamiento.getColumnCount(); i++){
          frm.tblTratamiento.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modDiaTra.consultarNombreTrata(modTra, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
     //***********cuarta consulta******************//
    //Boton consultar por nombre paciente internado
    if(e.getSource() == frm.btnConsultaPacienteHospitalizado){
      modHos.setCedulaPAcienteInternado(Integer.parseInt(frm.cmbNombrePaciente
          .getSelectedItem().toString()));
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblHospiPaciente1.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblHospiPaciente1.getColumnCount(); i++){
          frm.tblHospiPaciente1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modHosC.consultarCedulaPacInter(modHos, modeloTabla)){
   
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    //Boton consultar por nombre paciente internado
    if(e.getSource() == frm.btnConsultaPacienteHospitalizado){
      modHos.setCedulaPAcienteInternado(Integer.parseInt(frm.cmbNombrePaciente
          .getSelectedItem().toString()));
      try {
        DefaultTableModel modeloTabla = (DefaultTableModel) frm.tblHospiPaciente2.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frm.tblHospiPaciente2.getColumnCount(); i++){
          frm.tblHospiPaciente2.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modHosC.consultarCedulaPacInter2(modHos, modeloTabla)){
   
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
      PreparedStatement st = connect.prepareStatement("SELECT especialidad "
          + "from Citas order by cedulaPaciente");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("especialidad"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbEspecialidad.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
   /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbNivelDiagnostico
   */  
    public void obtenerNivelDiagnostico(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Nivel");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nivel from "
          + "Diagnostico order by identificador");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nivel"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbNivelDiagnostico.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
     /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbNombre
   */  
    public void obtenerNombre(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Nombre");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreDiagnostico from "
          + "Diagnostico order by identificador");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreDiagnostico"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbNombreDiagnostico.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
     /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbNombre
   */  
    public void obtenerTipoTratamiento(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Tipo");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT tipoTratamiento"
          + " from Tratamiento order by identificador");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("tipoTratamiento"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbTipoTratamiento.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
  /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbNombre
   */  
    public void obtenerNombreTratamiento(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Nombre");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT nombreTratameinto"
          + " from Tratamiento order by identificador");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("nombreTratameinto"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbNombreTratamiento.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
    
    /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbNombre
   */  
    public void obtenerNombreHospitalizados(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Nombre");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT "
          + "cedulaPacienteInternado from Hospitalizacion order by "
          + "cedulaPacienteInternado");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaPacienteInternado"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbNombrePaciente.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
}
