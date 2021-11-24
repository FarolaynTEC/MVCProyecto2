
package mvcproyecto2;

import Controlador.CtrlAreaCentro;
import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import Controlador.CtrlCentroAtencion;
import Controlador.CtrlFuncionario;
import Controlador.CtrlPaciente;
import Modelo.AreaTrabajo;
import Modelo.ConsultaFuncionario;
import Modelo.ConsultaPaciente;
import Modelo.ConsultaTipoCentro;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.Paciente;
import Modelo.TipoCentroAtencion;
import Modelo.Vacuna;
import Vista.AreaCentro;
import Vista.FuncionarioV;
import Vista.Menu;
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
    /*
    //Crus centroAtención
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
/*  
    //Crus centroAtención
    AreaTrabajo modAT = new AreaTrabajo();
    TipoCentroAtencion modTCA = new TipoCentroAtencion() ;
    ConsultaTipoCentro modC = new ConsultaTipoCentro();
    AreaCentro frmAC = new AreaCentro();
    
    CtrlAreaCentro ctrl4 = new CtrlAreaCentro(modAT, modTCA, modC, frmAC);
    ctrl4.iniciar();
    frmAC.setVisible(true);
*/

    Menu menuPrincipal = new Menu();
    menuPrincipal.setVisible(true);

  }
}
