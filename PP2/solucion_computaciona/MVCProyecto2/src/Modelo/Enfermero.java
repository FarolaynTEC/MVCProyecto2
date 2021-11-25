/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 * Esta es una abstraccion de la clase Enfermero
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class Enfermero extends Funcionario{
  private int indicadorPersonasACargo;
  private int indicadorExpCapacitacion;

  /**
   * Metodo que imprime un String de la clase
   * @return 
   */
  @Override
  public String toString() {
    String msg;
    msg = "Ha tenido personas a su cargo: "+indicadorPersonasACargo + "\n";
    msg = "Tiene experiencia en capacitacion: "+indicadorExpCapacitacion + "\n";
    return msg;
  }

  //Metodos accesores
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
