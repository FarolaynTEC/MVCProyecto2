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
import javax.swing.DefaultComboBoxModel;
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
    cargarTablaCentroAtencion();
    obtenerTipoCentro();
  }
  
  /**
   * Método encargado del control de las funcionalidades
   * del CRUD de los centros de atención
   * @param e 
   */
  @Override
  public void actionPerformed(ActionEvent e){

    //Boton guardar
    if(e.getSource()==frm.btnGuardarCentro){ 
      mod.setNombre(frm.txtNombreCentro.getText());
      mod.setUbicacion(frm.txtUbicacionCentro.getText());
      mod.setCapacidadMaxPac(Integer.parseInt(frm.txtCantidadCentro.getText()));
      mod.setTipoDeCentro(frm.cmbTipoCentro.getSelectedItem().toString());
      
      try {
        
        if(frm.txtCantidadCentro.getText().length()==0
            || frm.txtNombreCentro.getText().length()==0
                || frm.txtUbicacionCentro.getText().length()==0){ 
          JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
        }
        else{
          if(modC.registrar(mod)){
            JOptionPane.showMessageDialog(null,"Registro de Centro de "
                    + "Atención guardado");
            cargarTablaCentroAtencion();
          }else{
            JOptionPane.showMessageDialog(null,"ERROR");
          }
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(null,"HA OCURRIDO UN ERROR");
      }
    }
    
    //Boton editar
    if(e.getSource()==frm.btnEditarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt(frm.txtCodigoCentro.getText()));
      mod.setNombre(frm.txtNombreCentro.getText());
      mod.setUbicacion(frm.txtUbicacionCentro.getText());
      mod.setCapacidadMaxPac(Integer.parseInt(frm.txtCantidadCentro.getText()));
      mod.setTipoDeCentro(frm.cmbTipoCentro.getSelectedItem().toString());
      
      try {
        if(modC.modificar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención modificado");
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton eliminar
    if(e.getSource()==frm.btnEliminarCentro){
      mod.setCodigoCentroAtencion(Integer.parseInt
        (frm.txtCodigoCentro.getText()));
      try {
        if(modC.eliminar(mod)){
          JOptionPane.showMessageDialog(null,"Registro de Centro de "
                  + "Atención eliminado");
          cargarTablaCentroAtencion();
        }else{
          JOptionPane.showMessageDialog(null,"ERROR");
        }
      } catch (SQLException ex) {
        Logger.getLogger(CtrlCentroAtencion.class.getName())
                .log(Level.SEVERE, null, ex);
      }
    }
    
    //Boton limpiar
    if(e.getSource()==frm.btnLimpiarCentro){
      limpiar();
    }
    
    
    //boton Volver
    if(e.getSource()==frm.btnVolverCentro){
       //Agregar la ventana principal
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
  
  /**
   * Método para cargar los datos de la base de datos
   * en la tabla llamada tablaCentroA.
   */
  private void cargarTablaCentroAtencion(){
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
  
  /**
   * Método para insertar las areas de trabajo el
   * combobox llamado cmbEspecialidad
   */  
    public void obtenerTipoCentro(){
    ResultSet rs;
    try {
      DefaultComboBoxModel listaModelo = new DefaultComboBoxModel();
      listaModelo.addElement("Tipo");
    
      Connection connect = DriverManager.getConnection("jdbc:sqlserver://"
          + ";databaseName=Proyecto_POO2;user=usuariosql;password=root1");
      PreparedStatement st = connect.prepareStatement("SELECT tipoDeCentro from "
          + "TiposCentrosAtencion order by tipoDeCentro SELECT AreaTrabajo from "
          + "AreaTrabajo order by AreaTrabajo");
      rs = st.executeQuery();
    
      try {
        while (rs.next()){
          listaModelo.addElement(rs.getString("tipoDeCentro"));
      } rs.close();
      
      } catch(SQLException ex ){
        System.err.println(ex.getMessage());
      } frm.cmbTipoCentro.setModel(listaModelo);
    } catch(SQLException e){
      JOptionPane.showMessageDialog(null,e);
    }
  }
  
}
