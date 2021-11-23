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
  private int indicadorPersonasACargo;
  private int indicadorExpCapacitacion;

  @Override
  public String toString() {
    String msg;
    msg = "Ha tenido personas a su cargo: "+indicadorPersonasACargo + "\n";
    msg = "Tiene experiencia en capacitacion: "+indicadorExpCapacitacion + "\n";
    return msg;
  }

  public int isIndicadorPersonasACargo() {
    return indicadorPersonasACargo;
  }

  public int isIndicadorExpCapacitacion() {
    return indicadorExpCapacitacion;
  }

  public void setIndicadorPersonasACargo(int indicadorPersonasACargo) {
    this.indicadorPersonasACargo = indicadorPersonasACargo;
  }

  public void setIndicadorExpCapacitacion(int indicadorExpCapacitacion) {
    this.indicadorExpCapacitacion = indicadorExpCapacitacion;
  }
  
  
  
  
}
