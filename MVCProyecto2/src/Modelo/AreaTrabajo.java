/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
class AreaTrabajo {
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
