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
public class Doctor extends Funcionario{
  private int codigoMedico;
  private String especialidad;

  public Doctor (int codigoMedico, String especialidad, int pCedulaFuncionario, String pNomFuncionario, Date pFechaIngreso, AreaTrabajo pAreaTrabajo) {
    super(pCedulaFuncionario, pNomFuncionario, pFechaIngreso, pAreaTrabajo);
    this.codigoMedico = codigoMedico;
    this.especialidad = especialidad;
  }
  
  public void atenderCita () {}
  
  public void registrarVacuna () {}

  @Override
  public String toString() {
    String msg;
    msg = "Doctor: "+codigoMedico+ "\n";
    msg+= "Especialidad: "+especialidad+ "\n";
    return msg;
  }
  
  
  
}
