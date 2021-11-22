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
public class Diagnostico {
  private String nombreDiagnostico;
  private String observaciones;
  private ArrayList<Tratamiento> tratamientos;
  private String nivel;

  public Diagnostico(String nombreDiagnostico, String observaciones) {
    this.nombreDiagnostico = nombreDiagnostico;
    this.observaciones = observaciones;
  }

  public String getNombreDiagnostico() {
    return nombreDiagnostico;
  }

  public String getObservaciones() {
    return observaciones;
  }

  public ArrayList<Tratamiento> getTratamientos() {
    return tratamientos;
  }

  public String getNivel() {
    return nivel;
  }
  

  public void setNombreDiagnostico(String nombreDiagnostico) {
    this.nombreDiagnostico = nombreDiagnostico;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public void setTratamientos(Tratamiento tratamiento) {
    tratamientos.add(tratamiento);
  }

  public void setNivel(String nivel) {
    this.nivel = nivel;
  }
  
  @Override
  public String toString() {
    String msg;
    msg = "Diagnostico: "+nombreDiagnostico+ "\n";
    msg+= "Observaciones: "+observaciones+"\n";
    for(Tratamiento corre: tratamientos ) {
        msg+=corre.toString();
    }
    return msg;
  }
  
  
  
}
