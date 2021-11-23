package Controlador;

import Modelo.AreaTrabajo;
import Modelo.ConsultaTipoCentro;
import Modelo.TipoCentroAtencion;
import Vista.AreaCentro;
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
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Controlados de la clase AreaCentro.
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CtrlAreaCentro implements ActionListener{
  private AreaTrabajo modPac;
  private TipoCentroAtencion modTCA;
  private ConsultaTipoCentro modC;
  private AreaCentro frm;

  public CtrlAreaCentro(AreaTrabajo modPac, TipoCentroAtencion modTCA, ConsultaTipoCentro modC, AreaCentro frm) {
    this.modPac = modPac;
    this.modTCA = modTCA;
    this.modC = modC;
    this.frm = frm;
    this.frm.btnEliminarArea.addActionListener(this);
    this.frm.btnEliminarCentro.addActionListener(this);
    this.frm.btnGuardarArea.addActionListener(this);
    this.frm.btnEditarArea.addActionListener(this);
    this.frm.btnEditarArea.addActionListener(this);
    this.frm.btnEditarArea.addActionListener(this);
    this.frm.btnEditarArea.addActionListener(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  
  
  
}

