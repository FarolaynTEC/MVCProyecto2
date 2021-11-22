/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
public class Tratamiento {
  private String nombreTratamiento;
  private String dosis;
  private String tipoTratamiento;

  public Tratamiento(String nombreTratamiento, String dosis, String tipoTratamiento) {
    this.nombreTratamiento = nombreTratamiento;
    this.dosis = dosis;
    this.tipoTratamiento = tipoTratamiento;
  }

  public String getNombreTratamiento() {
    return nombreTratamiento;
  }

  public String getDosis() {
    return dosis;
  }

  public String getTipoTratamiento() {
    return tipoTratamiento;
  }

  public void setNombreTratamiento(String nombreTratamiento) {
    this.nombreTratamiento = nombreTratamiento;
  }

  public void setDosis(String dosis) {
    this.dosis = dosis;
  }

  public void setTipoTratamiento(String tipoTratamiento) {
    this.tipoTratamiento = tipoTratamiento;
  }
  
  @Override
  public String toString() {
    String msg;
    msg= "Informacion del tratamiento \n";
    msg+= "Tratamiento: " + nombreTratamiento+ "\n";
    msg+= "Dosis: "+ dosis+ "\n";
    msg+= "Tipo de tratamiento: "+tipoTratamiento+ "\n";
    return msg;
  }
  
  
  
}
