/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Alejandra Merino
 */
public class Hospitalizacion {
  private int centroAtencion;
  private int cedulaPAcienteInternado;
  private String nombrePacienteInternado;
  private Diagnostico diagnosticoInter;
  private String fechaInicio;
  private String fechaFin;
  private String especialidadHospi;
  private Funcionario funcionarioEncargado;
  private ArrayList<RegistroSeguimiento> registroDeSEguimiento;

  public int getCentroAtencion() {
    return centroAtencion;
  }

  public int getCedulaPAcienteInternado() {
    return cedulaPAcienteInternado;
  }

  public String getNombrePacienteInternado() {
    return nombrePacienteInternado;
  }

  public String getFechaInicio() {
    return fechaInicio;
  }

  public String getFechaFin() {
    return fechaFin;
  }

  public String getEspecialidadHospi() {
    return especialidadHospi;
  }

  public void setCentroAtencion(int centroAtencion) {
    this.centroAtencion = centroAtencion;
  }

  public void setCedulaPAcienteInternado(int cedulaPAcienteInternado) {
    this.cedulaPAcienteInternado = cedulaPAcienteInternado;
  }

  public void setNombrePacienteInternado(String nombrePacienteInternado) {
    this.nombrePacienteInternado = nombrePacienteInternado;
  }

  public void setDiagnosticoInter(Diagnostico diagnosticoInter) {
    this.diagnosticoInter = diagnosticoInter;
  }

  public void setFechaInicio(String fechaInicio) {
    this.fechaInicio = fechaInicio;
  }

  public void setFechaFin(String fechaFin) {
    this.fechaFin = fechaFin;
  }

  public void setEspecialidadHospi(String especialidadHospi) {
    this.especialidadHospi = especialidadHospi;
  }

  public void setFuncionarioEncargado(Funcionario funcionarioEncargado) {
    this.funcionarioEncargado = funcionarioEncargado;
  }

  public void setRegistroDeSEguimiento(RegistroSeguimiento pRegistroDeSEguimiento) {
    this.registroDeSEguimiento.add(pRegistroDeSEguimiento);
  }
  
  
}
