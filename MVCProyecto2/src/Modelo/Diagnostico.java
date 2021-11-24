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
  public int identificadorCita;
  public String nombreDiagnostico;
  public String observaciones;
  public ArrayList<Tratamiento> tratamientos;
  public String nivel;

  public Diagnostico(String nombreDiagnostico, String observaciones) {
    this.nombreDiagnostico = nombreDiagnostico;
    this.observaciones = observaciones;
  }

  public int getIdentificadorCita() {
    return identificadorCita;
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

  public void setIdentificadorCita(int identificadorCita) {
    this.identificadorCita = identificadorCita;
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
