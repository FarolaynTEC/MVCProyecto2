package Controlador;

import Modelo.ConsultaFuncionario;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.AreaTrabajo;
import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.FuncionarioV;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlados de la clase Funcionario.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlFuncionario {
  
  private Funcionario modFun;
  private Doctor modDoc;
  private Enfermero modEnf;
  private ConsultaFuncionario modC;
  private FuncionarioV frm;

  public CtrlFuncionario(Funcionario modFun, ConsultaFuncionario modC,
        Doctor modDoc,Enfermero modEnf, FuncionarioV frm) {
    this.modFun = modFun;
    this.modDoc = modDoc;
    this.modEnf = modEnf;
    this.frm = frm;
    this.frm.btnAgregarEspecialidad.addActionListener(this);
    this.frm.btnEditarFuncionario.addActionListener(this);
    this.frm.btnEditarFuncionario1.addActionListener(this);
    this.frm.btnEliminarFuncionario.addActionListener(this);
    this.frm.btnEliminarFuncionario1.addActionListener(this);
    this.frm.btnGuardarFuncionario.addActionListener(this);
    this.frm.btnGuardarFuncionario2.addActionListener(this);
    this.frm.btnLimpiar.addActionListener(this);
    this.frm.btnVolver.addActionListener(this);
  }
    
  /**
   * Inicializador de la ventana Funcionarios
   */
  public void iniciar(){
    frm.setTitle("Funcionarios");
    frm.setLocationRelativeTo(null);
  }
  
  /**
   * 
   * @override
   * @param e 
   */
  public void actionPerformed(ActionEvent e){
    AreaTrabajo areaTrabajo = new AreaTrabajo(frm.cmbAreaFuncionario.getSelectedItem().toString());
    //Boton guardar Secritario
    if(e.getSource()==frm.btnGuardarFuncionario){
      modFun.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modFun.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modFun.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modFun.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modFun.setTrabajaEn(frm.cmbTrabajaEn.getSelectedItem().toString());
      modFun.setAreaTrabajo(areaTrabajo);
      try {
        if(modC.registrarFuncionario(modFun)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención guardado");
          limpiar();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton editar
    if(e.getSource()==frm.btnEditarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt(frm.txtCodigoCentro.getText()));
      mod.setNombre(frm.txtNombreCentro.getText());
      mod.setUbicacion(frm.txtUbicacionCentro.getText());
      mod.setCapacidadMaxPac(Integer.parseInt(frm.txtCantidadCentro.getText()));
      mod.setTipoDeCentro(frm.cmbTipoCentro.getSelectedItem().toString());
      
      try {
        if(modC.modificar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención modificado");
          limpiar();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar
    if(e.getSource()==frm.btnEliminarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt
        (frm.txtCodigoCentro.getText()));
      try {
        if(modC.eliminar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención eliminado");
          limpiar();
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==frm.btnLimpiar){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==frm.btnVolverCentro){
       
    }
    
  }
  
    /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    frm.txtCedulaFuncionario.setText(null);
    frm.txtCedulaDoctor.setText(null);
    frm.txtEspecialidad.setText(null);
    frm.txtFechaFuncionario.setText(null);
    frm.txtNombreFuncionario.setText(null);
  }
  
    /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaCentroA.
   */
  private void cargarTablaFuncionario(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaFuncionario.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaFuncionario.getColumnCount(); i++){
      frm.tablaFuncionario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaCentroAtencion.cargarTablaCentroAtencion(modeloTabla);
  }
  
}
