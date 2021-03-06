
package Controlador;

import Modelo.ConsultaPaciente;
import Modelo.Hospitalizacion;
import Modelo.Paciente;
import Modelo.RegistroSeguimiento;
import Modelo.Vacuna;
import Vista.PacienteV;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlador de la clase Paciente.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlPaciente implements ActionListener {
  private Paciente modPac;
  private Vacuna modVac;
  private Hospitalizacion modHos;
  private RegistroSeguimiento modReSe;
  private ConsultaPaciente modC;
  private PacienteV frm;

  /**
   * Constructor de la clase CtrlPaciente
   * @param modPac
   * @param modVac
   * @param modC
   * @param frm 
   */
  public CtrlPaciente(Paciente modPac, Vacuna modVac, /*Hospitalizacion modHos, RegistroSeguimiento modReSe,*/ ConsultaPaciente modC, PacienteV frm) {
    this.modPac = modPac;
    this.modVac = modVac;
    this.modHos = modHos;
    this.modReSe = modReSe;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnGuardarPaciente.addActionListener(this);
    this.frm.btnEditarPaciente.addActionListener(this);
    this.frm.btnEliminarPaciente.addActionListener(this);
    this.frm.btnAgregarVacuna.addActionListener(this);
    this.frm.btnConsultaVacunas.addActionListener(this);
    this.frm.btnLimpiarPaciente.addActionListener(this);
    this.frm.btnVolverPaciente.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana Funcionarios
   */
  public void iniciar(){
    frm.setTitle("Pacientes");
    frm.setLocationRelativeTo(null);
    cargarTablaPaciente1();
    cargarTablaPaciente2();
  }

  /**
   * Método encargado del control de las funcionalidades
   * del CRUD de los Pacientes
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    //Boton guardar Paciente
    if(e.getSource() == frm.btnGuardarPaciente){
      modPac.setCedulaPaciente(Integer.parseInt(frm.txtCedulaPaciente.getText()));
      modPac.setNombrePaciente(frm.txtNombrePaciente.getText());
      modPac.setFechaNacimiento(frm.txtFechaPaciente.getText());
      modPac.setTipoSangre(frm.cmbTipoSangre.getSelectedItem().toString());
      modPac.setNacionalidad(frm.txtNacionalidadPaciente.getText());
      modPac.setLugarResidencia(frm.txtResidenciaPaciente.getText());
      modPac.setTelefono(frm.txtTelefonoPaciente.getText());
      modPac.setCorreoElectronico(frm.txtCorreoPciente.getText());
      try {
        if(modC.registrarPaciente(modPac)){
          JOptionPane.showMessageDialog(null,"Registro de Paciente guardado");
          cargarTablaPaciente1();
          cargarTablaPaciente2();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    //Boton editar Paciente
    if(e.getSource() == frm.btnEditarPaciente){
      modPac.setCedulaPaciente(Integer.parseInt(frm.txtCedulaPaciente.getText()));
      modPac.setNombrePaciente(frm.txtNombrePaciente.getText());
      modPac.setFechaNacimiento(frm.txtFechaPaciente.getText());
      modPac.setTipoSangre(frm.cmbTipoSangre.getSelectedItem().toString());
      modPac.setNacionalidad(frm.txtNacionalidadPaciente.getText());
      modPac.setLugarResidencia(frm.txtResidenciaPaciente.getText());
      modPac.setTelefono(frm.txtTelefonoPaciente.getText());
      modPac.setCorreoElectronico(frm.txtCorreoPciente.getText());
      try {
        if(modC.modificarPaciente(modPac)){
          JOptionPane.showMessageDialog(null,"Registro de Paciente editado");
          cargarTablaPaciente1();
          cargarTablaPaciente2();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton Eliminar Paciente
    if(e.getSource() == frm.btnEliminarPaciente){
      modPac.setCedulaPaciente(Integer.parseInt(frm.txtCedulaPaciente.getText()));
      try {
        if(modC.eliminarPaciente(modPac)){
          JOptionPane.showMessageDialog(null,"Registro de Paciente eliminado");
          cargarTablaPaciente1();
          cargarTablaPaciente2();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch(SQLException ex){
        Logger.getLogger(CtrlFuncionario.class.getName())
                .log(Level.SEVERE,null,ex);
      }
    }
    
    //Boton Agregar vacuna
    if(e.getSource() == frm.btnAgregarVacuna){
      modVac.setCedulaPaciente(Integer.parseInt(frm.txtCedulaPaciente.getText()));
      modVac.setNombreVacuna(frm.txtNombreVacuna.getText());
      modVac.setFechaAplicacion(frm.txtFechaVacuna.getText());
      modVac.setFarmaceutica(frm.txtNombreFarmaceutica.getText());
      modVac.setNumLote(frm.txtNumLote.getText());
      try {
        if(modC.registrarVacunas(modVac)){
          JOptionPane.showMessageDialog(null,"Registro de vacuna guardado");
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
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    frm.txtCedulaPaciente.setText(null);
    frm.txtCorreoPciente.setText(null);
    frm.txtFechaPaciente.setText(null);
    frm.txtFechaVacuna.setText(null);
    frm.txtNacionalidadPaciente.setText(null);
    frm.txtNombreFarmaceutica.setText(null);
    frm.txtNombrePaciente.setText(null);
    frm.txtNombreVacuna.setText(null);
    frm.txtNumLote.setText(null);
    frm.txtResidenciaPaciente.setText(null);
    frm.txtTelefonoPaciente.setText(null);
  }
  
  /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaPaciente.
   */
  private void cargarTablaPaciente1(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaPaciente1.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaPaciente1.getColumnCount(); i++){
      frm.tablaPaciente1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    } ConsultaPaciente.cargarTablaPaciente1(modeloTabla);
  }
  
  /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaPaciente.
   */
  private void cargarTablaPaciente2(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaPaciente2.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaPaciente2.getColumnCount(); i++){
      frm.tablaPaciente2.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }ConsultaPaciente.cargarTablaPaciente2(modeloTabla);
  }
}
