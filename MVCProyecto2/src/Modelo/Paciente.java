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
public class Paciente {
  private int cedulaPaciente;
  private String nombrePaciente;
  private String fechaNacimiento;
  private String tipoSangre;
  private String nacionalidad;
  private String lugarResidencia;
  private String telefono;
  private String correoElectronico;
  private ArrayList<Cita> citas;
  private ArrayList<Vacuna> vacunas;
  
  private void solicitarCita(){}
  
  private void cancelarCita(){}

  public int getCedulaPaciente() {
    return cedulaPaciente;
  }

  public String getNombrePaciente() {
    return nombrePaciente;
  }

  public String getFechaNacimiento() {
    return fechaNacimiento;
  }

  public String getTipoSangre() {
    return tipoSangre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public String getLugarResidencia() {
    return lugarResidencia;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getCorreoElectronico() {
    return correoElectronico;
  }


  public void setCedulaPaciente(int cedulaPaciente) {
    this.cedulaPaciente = cedulaPaciente;
  }

  public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
  }

  public void setFechaNacimiento(String fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public void setTipoSangre(String tipoSangre) {
    this.tipoSangre = tipoSangre;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public void setLugarResidencia(String lugarResidencia) {
    this.lugarResidencia = lugarResidencia;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public void setCorreoElectronico(String correoElectronico) {
    this.correoElectronico = correoElectronico;
  }

  public void setCitas(Cita citaNueva) {
    citas.add(citaNueva);
  }
  
  public void setVacunas(Vacuna vacunaNueva) {
    vacunas.add(vacunaNueva);
  }
  
  
  
}
