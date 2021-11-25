/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 * Esta es una abstraccion de la clase Bitacora
 * @author Alejandra Merino
 */
public class Bitacora {
  private int idBitacora;
  private String fecha;
  private String hora;
  private String nombreAutor;
  private int identificadorCita;

  //Metodos accesores
  public int getIdBitacora() {
    return idBitacora;
  }

  public String getFecha() {
    return fecha;
  }

  public String getHora() {
    return hora;
  }

  public String getNombreAutor() {
    return nombreAutor;
  }

  public int getIdentificadorCita() {
    return identificadorCita;
  }

  public void setIdBitacora(int idBitacora) {
    this.idBitacora = idBitacora;
  }

  public void setFecha(String fecha) {
    this.fecha = fecha;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public void setNombreAutor(String nombreAutor) {
    this.nombreAutor = nombreAutor;
  }

  public void setIdentificadorCita(int identificadorCita) {
    this.identificadorCita = identificadorCita;
  }
  
  
}
