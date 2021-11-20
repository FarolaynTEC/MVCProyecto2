
package mvcproyecto2;

import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import Controlador.CtrlCentroAtencion;


/**
 *
 * @author farol
 */
public class MVCProyecto2 {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    CentroAtencion mod = new CentroAtencion();
    ConsultaCentroAtencion modC = new ConsultaCentroAtencion();
    CentroA frm = new CentroA();
    
    CtrlCentroAtencion ctrl = new CtrlCentroAtencion(mod,modC,frm);
    ctrl.iniciar();
    frm.setVisible(true);
  }
}
