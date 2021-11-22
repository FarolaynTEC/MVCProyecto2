
package mvcproyecto2;

import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import Controlador.CtrlCentroAtencion;
import Controlador.CtrlFuncionario;
import Modelo.ConsultaFuncionario;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Vista.FuncionarioV;


/**
 *
 * @author farol
 */
public class MVCProyecto2 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    CentroAtencion modCA = new CentroAtencion();
    ConsultaCentroAtencion modCCA = new ConsultaCentroAtencion();
    CentroA frmCA = new CentroA();
    
    CtrlCentroAtencion ctrl1 = new CtrlCentroAtencion(modCA,modCCA,frmCA);
    ctrl1.iniciar();
    frmCA.setVisible(true);
    
    Funcionario modFun = new Funcionario();
    Doctor modDoc = new Doctor();
    Enfermero modEnf= new Enfermero();
    ConsultaFuncionario modCF = new ConsultaFuncionario();
    FuncionarioV frmF = new FuncionarioV();
    
    CtrlFuncionario ctrl2 = new CtrlFuncionario( modFun, modCF, modDoc, modEnf, frmF);
    ctrl2.iniciar();
    frmCA.setVisible(true);
  }
}
