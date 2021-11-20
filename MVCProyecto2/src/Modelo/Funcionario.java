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
public class Funcionario {
  protected int cedulaFuncionario;
  protected String nomFuncionario;
  protected Date fechaIngreso;
  protected AreaTrabajo areaTrabajo;

  public Funcionario(int pCedulaFuncionario, String pNomFuncionario, Date pFechaIngreso, AreaTrabajo pAreaTrabajo) {
    this.cedulaFuncionario = pCedulaFuncionario;
    this.nomFuncionario = pNomFuncionario;
    this.fechaIngreso = pFechaIngreso;
    this.areaTrabajo = pAreaTrabajo;
  }
  
  public void cancelarCitaPaciente () {}
  
  public void asignarCitaPaciente () {}

  @Override
  public String toString() {
    String msg;
    msg = "Datos del funcionario \n ";
    msg+= "Cedula: "+cedulaFuncionario; 
    msg+= "Nombre: "+nomFuncionario;
    msg+= "Fecha de ingreso: "+fechaIngreso; 
    areaTrabajo.toString();
    return msg;
  }
  
  
  
}
