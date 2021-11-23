/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Alejandra Merino
 */
class RegistroSeguimiento {
  private String fechaSeguimiento;
  private Funcionario funcionarioSegui;
  private String observacionEvolucion;
  private String tratamientoAsociado;

  public String getFechaSeguimiento() {
    return fechaSeguimiento;
  }

  public String getObservacionEvolucion() {
    return observacionEvolucion;
  }

  public String getTratamientoAsociado() {
    return tratamientoAsociado;
  }

  public void setFechaSeguimiento(String fechaSeguimiento) {
    this.fechaSeguimiento = fechaSeguimiento;
  }

  public void setObservacionEvolucion(String observacionEvolucion) {
    this.observacionEvolucion = observacionEvolucion;
  }

  public void setTratamientoAsociado(String tratamientoAsociado) {
    this.tratamientoAsociado = tratamientoAsociado;
  }
  
  
  
}
