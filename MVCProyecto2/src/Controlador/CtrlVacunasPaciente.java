
package Controlador;

import Modelo.ConsultaVacuna;
import Modelo.Vacuna;
import Vista.Vacunas;
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
 * Controlador de la clase Vacuna.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlVacunasPaciente implements ActionListener{
  private Vacuna modVac;
  private ConsultaVacuna modCVac;
  private Vacunas frmVac;

  /**
   * Construtor de la clase CtrlVacunasPaciente
   * @param modVac
   * @param modCVac
   * @param frmVac 
   */
  public CtrlVacunasPaciente(Vacuna modVac, ConsultaVacuna modCVac, Vacunas frmVac) {
    this.modVac = modVac;
    this.modCVac = modCVac;
    this.frmVac = frmVac;
    this.frmVac.btnConsultaVacunas.addActionListener(this);
    this.frmVac.btnVolver.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana Vacuna
   */
  public void iniciar(){
    frmVac.setTitle("ConsultaVacunas");
    frmVac.setLocationRelativeTo(null); 
    obtenerCedulaPaciente();
  }
  
  /**
   * Método encargado del control de las funcionalidades
   * del CRUD de las Vacunas
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton consultar Vacunas
    if(e.getSource() == frmVac.btnConsultaVacunas){
      modVac.setCedulaPaciente(Integer.parseInt
          (frmVac.cmbCedulaPaciente.getSelectedItem().toString()));
      try {
        
        DefaultTableModel modeloTabla = (DefaultTableModel) frmVac.tablaVacuna.getModel();
        modeloTabla.setRowCount(0);
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        int [] anchos = {10, 50, 100, 30, 100};
        for(int i = 0 ; i < frmVac.tablaVacuna.getColumnCount(); i++){
          frmVac.tablaVacuna.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        if(modCVac.consultarvacunas(modVac, modeloTabla)){
          
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
   * Método para insertar las areas de los funcionarios en el
   * combobox llamado cmbAreaFuncionario
   */  
  public void obtenerCedulaPaciente(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Paciente");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT cedulaPaciente "
          + "FROM Paciente ORDER BY cedulaPaciente");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("cedulaPaciente"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frmVac.cmbCedulaPaciente.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
}
