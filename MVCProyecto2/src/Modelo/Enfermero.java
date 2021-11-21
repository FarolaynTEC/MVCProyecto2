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

  public Enfermero(boolean indicadorPersonasACargo, boolean indicadorExpCapacitacion, int pCedulaFuncionario, String pNomFuncionario, Date pFechaIngreso, AreaTrabajo pAreaTrabajo) {
    super(pCedulaFuncionario, pNomFuncionario, pFechaIngreso, pAreaTrabajo);
    this.indicadorPersonasACargo = indicadorPersonasACargo;
    this.indicadorExpCapacitacion = indicadorExpCapacitacion;
  }

  @Override
  public String toString() {
    String msg;
    msg = "Ha tenido personas a su cargo: "+indicadorPersonasACargo + "\n";
    msg = "Tiene experiencia en capacitacion: "+indicadorExpCapacitacion + "\n";
    return msg;
  }
  
  
  
}
