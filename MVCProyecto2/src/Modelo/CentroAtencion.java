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
   * @param pCodigoCentroAtencion
   * @param pNombre
   * @param pUbicacion
   * @param pCapacidadMaxPac
   * @param pTipoDeCentro 
   */
  public CentroAtencion(int pCodigoCentroAtencion, String pNombre,
          String pUbicacion, int pCapacidadMaxPac, String pTipoDeCentro) {
    this.codigoCentroAtencion = pCodigoCentroAtencion;
    this.nombre = pNombre;
    this.ubicacion = pUbicacion;
    this.capacidadMaxPac = pCapacidadMaxPac;
    this.tipoDeCentro = pTipoDeCentro;
  }

  public int getCodigoCentroAtencion() {
    return codigoCentroAtencion;
  }

  public void setCodigoCentroAtencion(int pCodigoCentroAtencion) {
    this.codigoCentroAtencion = pCodigoCentroAtencion;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String pNombre) {
    this.nombre = pNombre;
  }

  public String getUbicacion() {
    return ubicacion;
  }

  public void setUbicacion(String pUbicacion) {
    this.ubicacion = pUbicacion;
  }

  public int getCapacidadMaxPac() {
    return capacidadMaxPac;
  }

  public void setCapacidadMaxPac(int pCapacidadMaxPac) {
    this.capacidadMaxPac = pCapacidadMaxPac;
  }

  public String getTipoDeCentro() {
    return tipoDeCentro;
  }

  public void setTipoDeCentro(String pTipoDeCentro) {
    this.tipoDeCentro = pTipoDeCentro;
  } 
}
