/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta es una abstraccion de la clase ventana CentroA
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class CentroA extends javax.swing.JFrame {

  /**
   * Creates new form CentroA
   */
  public CentroA() {
    initComponents();
    setLocationRelativeTo(null);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jLabel6 = new javax.swing.JLabel();
    txtCodigoCentro = new javax.swing.JTextField();
    txtNombreCentro = new javax.swing.JTextField();
    txtUbicacionCentro = new javax.swing.JTextField();
    txtCantidadCentro = new javax.swing.JTextField();
    cmbTipoCentro = new javax.swing.JComboBox<>();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaCentroA = new javax.swing.JTable();
    btnGuardarCentro = new javax.swing.JButton();
    btnEditarCentro = new javax.swing.JButton();
    btnEliminarCentro = new javax.swing.JButton();
    btnLimpiarCentro = new javax.swing.JButton();
    btnVolverCentro = new javax.swing.JButton();
    jLabel7 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(37, 182, 204));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setText("Centro de Atención");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Código");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Nombre");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Ubicación");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Capacidad Pacientes");

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("Tipo de Centro");

    tablaCentroA.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Código", "Nombre", "Ubicacion", "Pacientes", "Tipo Centro"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaCentroA);

    btnGuardarCentro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardarCentro.setText("Guardar");
    btnGuardarCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarCentroActionPerformed(evt);
      }
    });

    btnEditarCentro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEditarCentro.setText("Editar");
    btnEditarCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEditarCentroActionPerformed(evt);
      }
    });

    btnEliminarCentro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminarCentro.setText("Eliminar");
    btnEliminarCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarCentroActionPerformed(evt);
      }
    });

    btnLimpiarCentro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiarCentro.setText("Limpiar");
    btnLimpiarCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimpiarCentroActionPerformed(evt);
      }
    });

    btnVolverCentro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolverCentro.setText("Volver");
    btnVolverCentro.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverCentroActionPerformed(evt);
      }
    });

    jLabel7.setText("Para registrar NO llenar este campo");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(37, 37, 37)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(txtCantidadCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(txtUbicacionCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(32, 32, 32)
              .addComponent(cmbTipoCentro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(61, 61, 61)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel7)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(txtCodigoCentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txtNombreCentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(73, 73, 73))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(454, 454, 454)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(btnVolverCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(0, 0, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(69, 69, 69)
        .addComponent(btnGuardarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(38, 38, 38)
        .addComponent(btnEditarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(34, 34, 34)
        .addComponent(btnEliminarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 603, Short.MAX_VALUE)
        .addComponent(btnLimpiarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(276, 276, 276))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(34, 34, 34)
        .addComponent(jLabel1)
        .addGap(15, 15, 15)
        .addComponent(jLabel7)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(txtCodigoCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(41, 41, 41)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(txtNombreCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(37, 37, 37)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel4)
              .addComponent(txtUbicacionCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(37, 37, 37)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtCantidadCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(38, 38, 38)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbTipoCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEditarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEliminarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnLimpiarCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
        .addComponent(btnVolverCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Metodo del boton guardar CentroA
   * @param evt 
   */
  private void btnGuardarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCentroActionPerformed
    if(txtCantidadCentro.getText().length()==0
            || txtNombreCentro.getText().length()==0
                || txtUbicacionCentro.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO AGREGADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnGuardarCentroActionPerformed

  /**
   * Metodo del boton editar CentroA
   * @param evt 
   */
  private void btnEditarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCentroActionPerformed
    if(txtCantidadCentro.getText().length()==0
            || txtNombreCentro.getText().length()==0
                || txtUbicacionCentro.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnEditarCentroActionPerformed

  /**
   * Metodo del boton eliminar CentroA
   * @param evt 
   */
  private void btnEliminarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCentroActionPerformed
    if(txtCodigoCentro.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, el codigo del centro no puede estar vacio");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnEliminarCentroActionPerformed

  /**
   * Metodo del boton limpiar CentroA
   * @param evt 
   */
  private void btnLimpiarCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarCentroActionPerformed
    txtCantidadCentro.setText(null);
    txtCodigoCentro.setText(null);
    txtNombreCentro.setText(null);
    txtUbicacionCentro.setText(null);
  }//GEN-LAST:event_btnLimpiarCentroActionPerformed

  /**
   * Metodo del boton volver CentroA
   * @param evt 
   */
  private void btnVolverCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCentroActionPerformed
    Menu verM = new Menu();    
    verM.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverCentroActionPerformed

  /**
   * Metodo main de la vista CentroA
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(CentroA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(CentroA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(CentroA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(CentroA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new CentroA().setVisible(true);
      }
    });
  }
  
  /*
  Metodo para limpiar campos txt
  */
   public void limpiar(){
    txtCantidadCentro.setText(null);
    txtCodigoCentro.setText(null);
    txtNombreCentro.setText(null);
    txtUbicacionCentro.setText(null);
  }
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnEditarCentro;
  public javax.swing.JButton btnEliminarCentro;
  public javax.swing.JButton btnGuardarCentro;
  public javax.swing.JButton btnLimpiarCentro;
  public javax.swing.JButton btnVolverCentro;
  public javax.swing.JComboBox<String> cmbTipoCentro;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  public javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  public javax.swing.JTable tablaCentroA;
  public javax.swing.JTextField txtCantidadCentro;
  public javax.swing.JTextField txtCodigoCentro;
  public javax.swing.JTextField txtNombreCentro;
  public javax.swing.JTextField txtUbicacionCentro;
  // End of variables declaration//GEN-END:variables
}
