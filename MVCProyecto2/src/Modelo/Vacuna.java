/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
public class Vacuna {
  private int cedulaPaciente;
  private String fechaAplicacion;
  private String nombreVacuna;
  private String farmaceutica;
  private String numLote;

  public int getCedulaPaciente() {
    return cedulaPaciente;
  }

  public void setCedulaPaciente(int cedulaPaciente) {
    this.cedulaPaciente = cedulaPaciente;
  }
  
  public String getFechaAplicacion() {
    return fechaAplicacion;
  }

  public String getNombreVacuna() {
    return nombreVacuna;
  }

  public String getFarmaceutica() {
    return farmaceutica;
  }

  public String getNumLote() {
    return numLote;
  }

  public void setFechaAplicacion(String fechaAplicacion) {
    this.fechaAplicacion = fechaAplicacion;
  }

  public void setNombreVacuna(String nombreVacuna) {
    this.nombreVacuna = nombreVacuna;
  }

  public void setFarmaceutica(String farmaceutica) {
    this.farmaceutica = farmaceutica;
  }

  public void setNumLote(String numLote) {
    this.numLote = numLote;
  }
  
  
}
