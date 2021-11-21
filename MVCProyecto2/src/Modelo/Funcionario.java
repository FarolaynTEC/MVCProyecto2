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
  protected String fechaIngreso;
  protected String tipoFuncionario;
  protected CentroAtencion trabajaEn;
  protected AreaTrabajo areaTrabajo;

  public Funcionario(int pCedulaFuncionario, String pNomFuncionario, String pFechaIngreso, AreaTrabajo pAreaTrabajo, String pTipoFuncionario, CentroAtencion pTrabajaEn) {
    this.cedulaFuncionario = pCedulaFuncionario;
    this.nomFuncionario = pNomFuncionario;
    this.fechaIngreso = pFechaIngreso;
    this.areaTrabajo = pAreaTrabajo;
    this.tipoFuncionario = pTipoFuncionario;
    this.trabajaEn = pTrabajaEn;
  }
  
  public void cancelarCitaPaciente () {}
  
  public void asignarCitaPaciente () {}

  @Override
  public String toString() {
    String msg;
    msg = "Datos del funcionario \n ";
    msg+= "Cedula: "+cedulaFuncionario + "\n"; 
    msg+= "Nombre: "+nomFuncionario +"\n";
    msg+= "Fecha de ingreso: "+fechaIngreso+"\n"; 
    msg+= "Tipo de funcionario: "+tipoFuncionario+"\n";
    msg+= "Area de trabajo: " + areaTrabajo.toString();
    return msg;
  }

  public int getCedulaFuncionario() {
    return cedulaFuncionario;
  }

  public String getNomFuncionario() {
    return nomFuncionario;
  }

  public String getFechaIngreso() {
    return fechaIngreso;
  }

  public String getTipoFuncionario() {
    return tipoFuncionario;
  }

  public AreaTrabajo getAreaTrabajo() {
    return areaTrabajo;
  }

  public CentroAtencion getTrabajaEn() {
    return trabajaEn;
  }
  
  
  
  public void setCedulaFuncionario(int cedulaFuncionario) {
    this.cedulaFuncionario = cedulaFuncionario;
  }

  public void setNomFuncionario(String nomFuncionario) {
    this.nomFuncionario = nomFuncionario;
  }

  public void setFechaIngreso(String fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  public void setTipoFuncionario(String tipoFuncionario) {
    this.tipoFuncionario = tipoFuncionario;
  }

  public void setAreaTrabajo(AreaTrabajo areaTrabajo) {
    this.areaTrabajo = areaTrabajo;
  }

  public void setTrabajaEn(CentroAtencion trabajaEn) {
    this.trabajaEn = trabajaEn;
  }
  
  
  
  
}
