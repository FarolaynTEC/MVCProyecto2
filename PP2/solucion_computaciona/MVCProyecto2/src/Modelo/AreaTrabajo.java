
package Modelo;

/**
 * Esta es una abstraccion de la clase Area Trabajo
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class AreaTrabajo {
  private String nomAreaTrabajo;
 
  /**
   * Metodo que retorna un String de la clase
   * @return 
   */
  @Override
  public String toString() {
    return "El nombre del area de trabajo es: "+nomAreaTrabajo;
  }

  //Metodos accesores
  public String getNomAreaTrabajo() {
    return nomAreaTrabajo;
  }

  public void setNomAreaTrabajo(String nomAreaTrabajo) {
    this.nomAreaTrabajo = nomAreaTrabajo;
  }
  
  
  
  
}
