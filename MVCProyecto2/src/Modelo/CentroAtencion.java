package Modelo;

/**
 * Clase que abarca los centros de atención del sistema
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CentroAtencion {
  private int codigoCentroAtencion;
  private String nombre;
  private String ubicacion; 
  private int capacidadMaxPac; 
  private String tipoDeCentro;

  /**
   * Constrictor para la clase CentroAtención
   * @param codigoCentroAtencion
   * @param nombre
   * @param ubicacion
   * @param capacidadMaxPac
   * @param tipoDeCentro 
   */
  public CentroAtencion(int codigoCentroAtencion, String nombre, String ubicacion, int capacidadMaxPac, String tipoDeCentro) {
    this.codigoCentroAtencion = codigoCentroAtencion;
    this.nombre = nombre;
    this.ubicacion = ubicacion;
    this.capacidadMaxPac = capacidadMaxPac;
    this.tipoDeCentro = tipoDeCentro;
  }

  public int getCodigoCentroAtencion() {
    return codigoCentroAtencion;
  }

  public void setCodigoCentroAtencion(int codigoCentroAtencion) {
    this.codigoCentroAtencion = codigoCentroAtencion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String ubicacion) {
    this.ubicacion = ubicacion;
  }

  public int getCapacidadMaxPac() {
    return capacidadMaxPac;
  }

  public void setCapacidadMaxPac(int capacidadMaxPac) {
    this.capacidadMaxPac = capacidadMaxPac;
  }

  public String getTipoDeCentro() {
    return tipoDeCentro;
  }

  public void setTipoDeCentro(String tipoDeCentro) {
    this.tipoDeCentro = tipoDeCentro;
  }
  
  
}
