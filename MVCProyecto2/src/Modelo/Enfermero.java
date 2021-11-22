/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Alejandra Merino
 */
public class Enfermero extends Funcionario{
  private boolean indicadorPersonasACargo;
  private boolean indicadorExpCapacitacion;

  @Override
  public String toString() {
    String msg;
    msg = "Ha tenido personas a su cargo: "+indicadorPersonasACargo + "\n";
    msg = "Tiene experiencia en capacitacion: "+indicadorExpCapacitacion + "\n";
    return msg;
  }

  public boolean isIndicadorPersonasACargo() {
    return indicadorPersonasACargo;
  }

  public boolean isIndicadorExpCapacitacion() {
    return indicadorExpCapacitacion;
  }

  public void setIndicadorPersonasACargo(boolean indicadorPersonasACargo) {
    this.indicadorPersonasACargo = indicadorPersonasACargo;
  }

  public void setIndicadorExpCapacitacion(boolean indicadorExpCapacitacion) {
    this.indicadorExpCapacitacion = indicadorExpCapacitacion;
  }
  
  
  
  
}
