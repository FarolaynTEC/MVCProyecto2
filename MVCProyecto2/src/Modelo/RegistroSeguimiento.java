/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Clase RegistroSeguimeinto.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class RegistroSeguimiento {
  private int cedilaPacienteInternado;
  private String fechaSeguimiento;
  private int funcionarioSegui;
  private String observacionEvolucion;
  private String tratamientoAsociado;

  //Metodos accesores
  public int getFuncionarioSegui() {
    return funcionarioSegui;
  }

  public void setFuncionarioSegui(int funcionarioSegui) {
    this.funcionarioSegui = funcionarioSegui;
  }
  
  public int getCedilaPacienteInternado() {
    return cedilaPacienteInternado;
  }
  
  public String getFechaSeguimiento() {
    return fechaSeguimiento;
  }

  public String getObservacionEvolucion() {
    return observacionEvolucion;
  }

  public String getTratamientoAsociado() {
    return tratamientoAsociado;
  }

  public void setCedilaPacienteInternado(int cedilaPacienteInternado) {
    this.cedilaPacienteInternado = cedilaPacienteInternado;
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
