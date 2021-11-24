/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
public class Cita {
  private int cedulaPaciente;
  private int identificador;
  private String especialidad;
  private String fechaCita;
  private String observaciones;
  private AreaTrabajo servicio;
  private String estadoDeCita;

  @Override
  public String toString() {
    String msg;
    msg= "Cita: " +identificador+ "\n";
    msg+="Fecha de cita: "+fechaCita+ "\n";
    msg+= "Observaciones: "+ observaciones+ "\n"; 
    msg+= servicio.toString()+ "\n";
    return msg;
  }

  public int getIdentificador() {
    return identificador;
  }

  public String getFechaCita() {
    return fechaCita;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public String getEstadoDeCita() {
    return estadoDeCita;
  }

  public int getCedulaPaciente() {
    return cedulaPaciente;
  }

  public String getEspecialidad() {
    return especialidad;
  }

  public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
  }

  
  
  public void setCedulaPaciente(int cedulaPaciente) {
    this.cedulaPaciente = cedulaPaciente;
  }
  
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public void setFechaCita(String fechaCita) {
    this.fechaCita = fechaCita;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public void setEstadoDeCita(String estadoDeCita) {
    this.estadoDeCita = estadoDeCita;
  }
  
  
  
}
