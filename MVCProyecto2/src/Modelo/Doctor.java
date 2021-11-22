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

  public Doctor (int codigoMedico, String especialidad, int pCedulaFuncionario, 
      String pNomFuncionario, String pFechaIngreso, 
      AreaTrabajo pAreaTrabajo, String pTipoFuncionario, 
      String pTrabajaEn) {
    super(pCedulaFuncionario, pNomFuncionario, pFechaIngreso, pAreaTrabajo, 
        pTipoFuncionario, pTrabajaEn);
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

  public int getCodigoMedico() {
    return codigoMedico;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setCodigoMedico(int codigoMedico) {
    this.codigoMedico = codigoMedico;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }
  
  
  
}
