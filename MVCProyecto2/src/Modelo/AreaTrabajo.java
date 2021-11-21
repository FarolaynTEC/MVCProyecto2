
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
public class AreaTrabajo {
  private String nomAreaTrabajo;

  public AreaTrabajo(String pNomAreaTrabajo) {
    this.nomAreaTrabajo = pNomAreaTrabajo;
  }

  @Override
  public String toString() {
    return "El nombre del area de trabajo es: "+nomAreaTrabajo;
  }

  public String getNomAreaTrabajo() {
    return nomAreaTrabajo;
  }

  public void setNomAreaTrabajo(String nomAreaTrabajo) {
    this.nomAreaTrabajo = nomAreaTrabajo;
  }
  
  
  
  
}
