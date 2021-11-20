package Controlador;

import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlados de la clase CentroAtencion.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlCentroAtencion implements ActionListener{
  
  private CentroAtencion mod;
  private ConsultaCentroAtencion modC;
  private CentroA frm;

  /**
   * Constructor del controlador de la clase CentroAtencion
   * @param mod
   * @param modC
   * @param frm 
   */
  public CtrlCentroAtencion(CentroAtencion mod, ConsultaCentroAtencion modC,
          CentroA frm) {
    this.mod = mod;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnGuardarCentro.addActionListener(this);
    this.frm.btnEditarCentro.addActionListener(this);
    this.frm.btnEliminarCentro.addActionListener(this);
    this.frm.btnLimpiarCentro.addActionListener(this);
    this.frm.btnVolverCentro.addActionListener(this);
  }
  
  /**
   * Inicializador de la ventana
   */
  public void iniciar(){
    frm.setTitle("Centros de Atención");
    frm.setLocationRelativeTo(null);
    cargarTablaPlanEstudio();
  }
  
  /**
   * 
   * @override
   * @param e 
   */
  public void actionPerformed(ActionEvent e){
    
    if(e.getSource()==frm.btnGuardarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt(frm.txtCodigoCentro.getText()));
      mod.setNombre(frm.txtNombreCentro.getText());
      mod.setUbicacion(frm.txtUbicacionCentro.getText());
      mod.setCapacidadMaxPac(Integer.parseInt(frm.txtCantidadCentro.getText()));
      mod.setTipoDeCentro(frm.cmbTipoCentro.getSelectedItem().toString());
      
      try {
        if(modC.registrar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención guardado");
          limpiar();
          cargarTablaPlanEstudio();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
          limpiar();
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
  }
  
  /**
   * Establece las cajas de texto como nulas o vacias
   */
  public void limpiar(){
    
    frm.txtCodigoCentro.setText(null);
    frm.txtCantidadCentro.setText(null);
    frm.txtNombreCentro.setText(null);
    frm.txtUbicacionCentro.setText(null);
  }
  
  private void cargarTablaPlanEstudio(){
    DefaultTableModel modeloTabla = (DefaultTableModel) frm.tablaCentroA.getModel();
    modeloTabla.setRowCount(0);
    ResultSet rs;
    ResultSetMetaData rsmd;
    int columnas;
    
    int [] anchos = {10, 50, 100, 30, 100};
    for(int i = 0 ; i < frm.tablaCentroA.getColumnCount(); i++){
      frm.tablaCentroA.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
    }
    ConsultaCentroAtencion.cargarTablaCentroAtencion(modeloTabla);
  }
}
