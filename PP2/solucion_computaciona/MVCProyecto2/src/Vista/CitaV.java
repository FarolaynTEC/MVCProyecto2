/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Esta es una abstraccion de la clase ventana CitaV
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
 public class CitaV extends javax.swing.JFrame {

  /**
   * Creates new form CentroA
   */
  public CitaV() {
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
    btnLimpiar = new javax.swing.JButton();
    btnCancelar = new javax.swing.JButton();
    cmbCedulaPaciente = new javax.swing.JComboBox<>();
    jScrollPane3 = new javax.swing.JScrollPane();
    tablaCita1 = new javax.swing.JTable();
    btnEliminarCita = new javax.swing.JButton();
    jLabel5 = new javax.swing.JLabel();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jPanel1.setBackground(new java.awt.Color(37, 182, 204));

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setText("Citas");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel2.setText("Cédula Paciente");

    tablaCita.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Cédula", "Cita ID", "Observaciones"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Integer.class, java.lang.Object.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tablaCita);
    if (tablaCita.getColumnModel().getColumnCount() > 0) {
      tablaCita.getColumnModel().getColumn(0).setHeaderValue("Cédula");
      tablaCita.getColumnModel().getColumn(2).setHeaderValue("Observaciones");
    }

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

    txtFechaCita.setText("00 / 00 / 0000");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Observaciones");

    txtObservacionesCita.setColumns(20);
    txtObservacionesCita.setRows(5);
    jScrollPane2.setViewportView(txtObservacionesCita);

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel7.setText("Especialidad");

    cmbEspecialidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

    btnLimpiar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnLimpiar.setText("Limpiar");
    btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLimpiarActionPerformed(evt);
      }
    });

    btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnCancelar.setText("Cancelar Cita");
    btnCancelar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnCancelarActionPerformed(evt);
      }
    });

    cmbCedulaPaciente.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbCedulaPacienteActionPerformed(evt);
      }
    });

    tablaCita1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Cita ID", "Fecha Cita", "Especialidad", "Estado"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
      };
      boolean[] canEdit = new boolean [] {
        false, false, false, true
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane3.setViewportView(tablaCita1);

    btnEliminarCita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    btnEliminarCita.setText("Eliminar Cita del Registro");
    btnEliminarCita.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnEliminarCitaActionPerformed(evt);
      }
    });

    jLabel5.setText("mes/día/año");

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
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(40, 40, 40)
            .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(jScrollPane2)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel5)
              .addComponent(cmbCedulaPaciente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(24, 24, 24))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(23, 23, 23)
        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addGap(115, 115, 115)
        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(43, 43, 43)
        .addComponent(btnEliminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
        .addComponent(btnSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(32, 32, 32)
        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(177, 177, 177))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(442, 442, 442))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(30, 30, 30)
        .addComponent(jLabel1)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel2)
              .addComponent(cmbCedulaPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(27, 27, 27)
            .addComponent(jLabel5)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel3)
              .addComponent(txtFechaCita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(40, 40, 40)
            .addComponent(jLabel4))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGap(54, 54, 54)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(18, 18, 18)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(54, 54, 54)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(52, 52, 52)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnSolicitarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnEliminarCita, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
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

  /**
   * Metodo del boton volver CitaV
   * @param evt 
   */
  private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
    Menu verM = new Menu();    
    verM.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnVolverActionPerformed

  /**
   * Metodo del boton solicitar CitaV
   * @param evt 
   */
  private void btnSolicitarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarCitaActionPerformed
    if(cmbCedulaPaciente.getSelectedItem().toString().length()==0
        || txtFechaCita.getText().length()==0
            || txtObservacionesCita.getText().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, los campos solicitados no pueden estar vacios");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO AÑADIDO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnSolicitarCitaActionPerformed

  /**
   * Metodo del boton limpiar CitaV
   * @param evt 
   */
  private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

    txtFechaCita.setText(null);
    txtObservacionesCita.setText(null);
  }//GEN-LAST:event_btnLimpiarActionPerformed

  /**
   * Metodo del boton cancelar CitaV
   * @param evt 
   */
  private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    if(cmbCedulaPaciente.getSelectedItem().toString().length()==0)
   {
     JOptionPane.showMessageDialog(null, "ERROR, el campo de cedula no puede estar vacio");
    } else{
     //verificacion de repetido
     JOptionPane.showMessageDialog(null, "REGISTRO ELIMINADO CON EXITO");
     limpiar();
    }
  }//GEN-LAST:event_btnCancelarActionPerformed

  /**
   * Metodo del boton combobox cedula paciente en CitaV
   * @param evt 
   */
  private void cmbCedulaPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCedulaPacienteActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_cmbCedulaPacienteActionPerformed

  /**
   * Metodo del boton eliminar CitaV
   * @param evt 
   */
  private void btnEliminarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarCitaActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnEliminarCitaActionPerformed

  /**
   * Metodo main de la clase vista CitaV
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
        new CitaV().setVisible(true);
      }
    });
  }
  
  /*
  Metodo para limpiar campos txt
  */
   public void limpiar(){
    txtFechaCita.setText(null);
    txtObservacionesCita.setText(null);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnCancelar;
  public javax.swing.JButton btnEliminarCita;
  public javax.swing.JButton btnLimpiar;
  public javax.swing.JButton btnSolicitarCita;
  public javax.swing.JButton btnVolver;
  public javax.swing.JComboBox<String> cmbCedulaPaciente;
  public javax.swing.JComboBox<String> cmbEspecialidad;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  public javax.swing.JTable tablaCita;
  public javax.swing.JTable tablaCita1;
  public javax.swing.JTextField txtFechaCita;
  public javax.swing.JTextArea txtObservacionesCita;
  // End of variables declaration//GEN-END:variables
}