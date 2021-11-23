
package mvcproyecto2;

import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import Controlador.CtrlCentroAtencion;
import Controlador.CtrlFuncionario;
import Controlador.CtrlPaciente;
import Modelo.ConsultaFuncionario;
import Modelo.ConsultaPaciente;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.Paciente;
import Modelo.Vacuna;
import Vista.FuncionarioV;
import Vista.PacienteV;


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
    /*
  //Crud funcionario
    Funcionario modFun = new Funcionario();
    Doctor modDoc = new Doctor();
    Enfermero modEnf= new Enfermero();
    ConsultaFuncionario modCF = new ConsultaFuncionario();
    FuncionarioV frmF = new FuncionarioV();
    
    CtrlFuncionario ctrl2 = new CtrlFuncionario( modFun, modCF, modDoc, modEnf, frmF);
    ctrl2.iniciar();
    frmF.setVisible(true);
      */     
  /* 
  
  //Crud Paciente
    Paciente modPac = new Paciente();
    Vacuna modVac = new Vacuna();
    ConsultaPaciente modCP = new ConsultaPaciente();
    PacienteV frmP = new PacienteV();
    
    CtrlPaciente ctrl3 = new CtrlPaciente( modPac, modVac, modCP, frmP);
    ctrl3.iniciar();
    frmP.setVisible(true);
   */
  }
}
