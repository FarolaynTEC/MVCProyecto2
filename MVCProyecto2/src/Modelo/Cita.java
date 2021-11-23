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
  private int identificador;
  private String fechaCita;
  private String observaciones;
  private AreaTrabajo servicio;
  private Diagnostico diagnostico;
  private Bitacora bitacora;

  @Override
  public String toString() {
    String msg;
    msg= "Cita: " +identificador+ "\n";
    msg+="Fecha de cita: "+fechaCita+ "\n";
    msg+= "Observaciones: "+ observaciones+ "\n"; 
    msg+= servicio.toString()+ "\n";
    msg+= diagnostico.toString() +"\n";
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

  
  
  public void setIdentificador(int identificador) {
    this.identificador = identificador;
  }

  public void setFechaCita(String fechaCita) {
    this.fechaCita = fechaCita;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }
  
  
  
}
