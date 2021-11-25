/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta es una abstraccion de la clase ventana BitacoraV
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class BitacoraV extends javax.swing.JFrame {

  /**
   * Creates new form CentroA
   */
  public BitacoraV() {
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
    txtFechaBitacora = new javax.swing.JTextField();
    txtHoraBitacora = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaBitacora = new javax.swing.JTable();
    btnGuardarBitacora = new javax.swing.JButton();
    btnEditarBitacora = new javax.swing.JButton();
    btnEliminarBitacora = new javax.swing.JButton();
    btnLimpiarBitacora = new javax.swing.JButton();
    btnVolverBitacora = new javax.swing.JButton();
    jLabel6 = new javax.swing.JLabel();
    txtIDBitacora = new javax.swing.JTextField();
    cmbNombreBitacora = new javax.swing.JComboBox<>();
    cmbCitaBitacora = new javax.swing.JComboBox<>();
    jLabel7 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(37, 182, 204));
    jPanel1.setForeground(new java.awt.Color(37, 182, 204));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setText("Bitácora");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Nombre Autor");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("ID Cita");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Fecha");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Hora");

    txtFechaBitacora.setText("00 / 00 / 0000");

    tablaBitacora.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Num Bitacora", "Nombre", "ID CITA", "Fecha", "Hora"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaBitacora);

    btnGuardarBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnGuardarBitacora.setText("Guardar");
    btnGuardarBitacora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnGuardarBitacoraActionPerformed(evt);
      }
    });

    btnEditarBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEditarBitacora.setText("Editar");
    btnEditarBitacora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEditarBitacoraActionPerformed(evt);
      }
    });

    btnEliminarBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminarBitacora.setText("Eliminar");
    btnEliminarBitacora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarBitacoraActionPerformed(evt);
      }
    });

    btnLimpiarBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiarBitacora.setText("Limpiar");
    btnLimpiarBitacora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimpiarBitacoraActionPerformed(evt);
      }
    });

    btnVolverBitacora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolverBitacora.setText("Volver");
    btnVolverBitacora.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverBitacoraActionPerformed(evt);
      }
    });

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("ID Bitácora");

    jLabel7.setText("mes/dia/año");

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(511, 511, 511))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(btnVolverBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(55, 55, 55)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(0, 20, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                      .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(txtHoraBitacora)
                  .addComponent(txtIDBitacora)
                  .addComponent(txtFechaBitacora, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                  .addComponent(cmbNombreBitacora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(cmbCitaBitacora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(179, 179, 179)))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(btnGuardarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(32, 32, 32)
            .addComponent(btnEditarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(30, 30, 30)
            .addComponent(btnEliminarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLimpiarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(331, 331, 331))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addComponent(jLabel1)
        .addGap(47, 47, 47)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel6)
              .addComponent(txtIDBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(23, 23, 23)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(cmbNombreBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(25, 25, 25)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel3)
              .addComponent(cmbCitaBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(txtFechaBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel4))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jLabel7)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(txtHoraBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(100, 100, 100))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnGuardarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEditarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEliminarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnLimpiarBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(85, 85, 85)
        .addComponent(btnVolverBitacora, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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
   * Metodo del boton guardar bitacora
   * @param evt 
   */
  private void btnGuardarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarBitacoraActionPerformed
    if(txtFechaBitacora.getText().length()==0
        || txtHoraBitacora.getText().length()==0
            || txtIDBitacora.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO AÑADIDO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnGuardarBitacoraActionPerformed

  /**
   * Metodo del boton modificar bitacora
   * @param evt 
   */
  private void btnEditarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarBitacoraActionPerformed
    if(txtFechaBitacora.getText().length()==0
        || txtHoraBitacora.getText().length()==0
            || txtIDBitacora.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO MODIFICADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnEditarBitacoraActionPerformed

  /**
   * Metodo del boton eliminar bitacora
   * @param evt 
   */
  private void btnEliminarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarBitacoraActionPerformed
    if(txtIDBitacora.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, el campo ID no puede estar vacio");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnEliminarBitacoraActionPerformed

  /**
   * Metodo del boton limpiar bitacora
   * @param evt 
   */
  private void btnLimpiarBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarBitacoraActionPerformed
    txtFechaBitacora.setText(null);
    txtHoraBitacora.setText(null);
    txtIDBitacora.setText(null);
  }//GEN-LAST:event_btnLimpiarBitacoraActionPerformed

  /**
   * Metodo del boton volver bitacora
   * @param evt 
   */
  private void btnVolverBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverBitacoraActionPerformed
    Menu verM = new Menu();    
    verM.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverBitacoraActionPerformed

  /**
   * Metodo main de la vista BitacoraV
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
      java.util.logging.Logger.getLogger(BitacoraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(BitacoraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(BitacoraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(BitacoraV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new BitacoraV().setVisible(true);
      }
    });
  }
  
  /*
  Metodo para limpiar campos txt
  */
   public void limpiar(){
    txtFechaBitacora.setText(null);
    txtHoraBitacora.setText(null);
    txtIDBitacora.setText(null);
  }
   
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnEditarBitacora;
  public javax.swing.JButton btnEliminarBitacora;
  public javax.swing.JButton btnGuardarBitacora;
  public javax.swing.JButton btnLimpiarBitacora;
  public javax.swing.JButton btnVolverBitacora;
  public javax.swing.JComboBox<String> cmbCitaBitacora;
  public javax.swing.JComboBox<String> cmbNombreBitacora;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  public javax.swing.JTable tablaBitacora;
  public javax.swing.JTextField txtFechaBitacora;
  public javax.swing.JTextField txtHoraBitacora;
  public javax.swing.JTextField txtIDBitacora;
  // End of variables declaration//GEN-END:variables
}