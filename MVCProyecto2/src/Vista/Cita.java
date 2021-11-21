/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author farol
 */
 public class Cita extends javax.swing.JFrame {

  /**
   * Creates new form CentroA
   */
  public Cita() {
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
    txtCedulaPaciente = new javax.swing.JTextField();
    jScrollPane1 = new javax.swing.JScrollPane();
    tablaCita = new javax.swing.JTable();
    btnVolver = new javax.swing.JButton();
    btnSolicitarCita = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    txtFechaCita = new javax.swing.JTextField();
    jLabel4 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    txtObservacionesCita = new javax.swing.JTextArea();
    jLabel7 = new javax.swing.JLabel();
    cmbEspecialidad = new javax.swing.JComboBox<>();
    txtLimpiar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(37, 182, 204));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Citas");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Cédula Paciente");

    tablaCita.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}
      },
      new String [] {
        "Cédula", "Cita ID", "Fecha Cita", "Observaciones", "Especialidad"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
    jScrollPane1.setViewportView(tablaCita);

    btnVolver.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnVolver.setText("Volver");
    btnVolver.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnVolverActionPerformed(evt);
      }
    });

    btnSolicitarCita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnSolicitarCita.setText("Solicitar Cita");
    btnSolicitarCita.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnSolicitarCitaActionPerformed(evt);
      }
    });

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel3.setText("Fecha Cita");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Observaciones");

    txtObservacionesCita.setColumns(20);
    txtObservacionesCita.setRows(5);
    jScrollPane2.setViewportView(txtObservacionesCita);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel7.setText("Especialidad");

    cmbEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    cmbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

    txtLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    txtLimpiar.setText("Limpiar");
    txtLimpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        txtLimpiarActionPerformed(evt);
      }
    });

    btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCancelar.setText("Cancelar Cita");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(52, 52, 52)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(cmbEspecialidad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
              .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGap(40, 40, 40)
              .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jScrollPane2))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(31, 31, 31))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(334, 334, 334))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(115, 115, 115)
        .addComponent(txtLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(btnSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32)
        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(177, 177, 177))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(jLabel1)
        .addGap(44, 44, 44)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(txtCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(41, 41, 41)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addComponent(jLabel4)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(54, 54, 54)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        .addGap(52, 52, 52)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(txtLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(btnSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
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

  private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnVolverActionPerformed

  private void btnSolicitarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarCitaActionPerformed
    if(txtCedulaPaciente.getText().length()==0
        || txtFechaCita.getText().length()==0
            || txtObservacionesCita.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO AÑADIDO CON EXITO");
    }
  }//GEN-LAST:event_btnSolicitarCitaActionPerformed

  private void txtLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLimpiarActionPerformed
    txtCedulaPaciente.setText(null);
    txtFechaCita.setText(null);
    txtObservacionesCita.setText(null);
  }//GEN-LAST:event_txtLimpiarActionPerformed

  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    if(txtCedulaPaciente.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, el campo de cedula no puede estar vacio");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO");
    }
  }//GEN-LAST:event_btnCancelarActionPerformed

  /**
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

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Cita().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnCancelar;
  public javax.swing.JButton btnSolicitarCita;
  public javax.swing.JButton btnVolver;
  public javax.swing.JComboBox<String> cmbEspecialidad;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  public javax.swing.JTable tablaCita;
  public javax.swing.JTextField txtCedulaPaciente;
  public javax.swing.JTextField txtFechaCita;
  public javax.swing.JButton txtLimpiar;
  public javax.swing.JTextArea txtObservacionesCita;
  // End of variables declaration//GEN-END:variables
}
