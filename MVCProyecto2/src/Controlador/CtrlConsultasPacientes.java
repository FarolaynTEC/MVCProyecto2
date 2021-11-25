package Controlador;

import Modelo.Cita;
import Modelo.ConsultaCita;
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
  private ConsultasDePacientes frm;
  
  public CtrlConsultasPacientes(Cita modCita,ConsultaCita modC, ConsultasDePacientes frm) {
    this.modCita = modCita;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnEspecialidad.addActionListener(this);
    this.frm.btnEstado.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana consultasPacientes
   */
  public void iniciar(){
    frm.setTitle("Consultas Pacientes");
    frm.setLocationRelativeTo(null);
    obtenerEspecialidades();
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
    
}
