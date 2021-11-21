package Controlador;

import Modelo.ConsultaFuncionario;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.AreaTrabajo;
import Vista.FuncionarioV;
import java.awt.event.ActionEvent;

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
    AreaTrabajo areaTrabajo = new AreaTrabajo() ;
    //Boton guardar Secritario
    if(e.getSource()==frm.btnGuardarFuncionario){
      modFun.setCedulaFuncionario(Integer.parseInt(frm.txtCedulaFuncionario.getText()));
      modFun.setNomFuncionario(frm.txtNombreFuncionario.getText());
      modFun.setFechaIngreso(frm.txtFechaFuncionario.getText());
      modFun.setTipoFuncionario(frm.cmbTipoFuncionario.getSelectedItem().toString());
      modFun.setTrabajaEn(frm.cm.getSelectedItem().toString());
      
      modFun.setAreaTrabajo(frm.cmbAreaFuncionario.getSelectedItem().toString());
      try {
        if(modC.registrar(mod)){
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
    if(e.getSource()==frm.btnLimpiarCentro){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==frm.btnVolverCentro){
       
    }
    
  }
  
}
