/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.JFrame;

/**
 * Esta es una abstraccion de la clase ventana ConsultasDePacientes
 * @author Josue Brenes, Paola Lopez, Alejandra Merino
 */
public class ConsultasDePacientes extends javax.swing.JFrame {

  /**
   * Creates new form ConsultasDoctores
   */
  public ConsultasDePacientes() {
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
    tblCitas = new javax.swing.JTable();
    btnEspecialidad = new javax.swing.JButton();
    cmbEspecialidad = new javax.swing.JComboBox<>();
    cmbEstado = new javax.swing.JComboBox<>();
    btnEstado = new javax.swing.JButton();
    jLabel3 = new javax.swing.JLabel();
    cmbNivelDiagnostico = new javax.swing.JComboBox<>();
    cmbNombreDiagnostico = new javax.swing.JComboBox<>();
    btnNivel = new javax.swing.JButton();
    btnNombre = new javax.swing.JToggleButton();
    jLabel4 = new javax.swing.JLabel();
    jLabel5 = new javax.swing.JLabel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tblDiagnosticoConsulta = new javax.swing.JTable();
    jLabel6 = new javax.swing.JLabel();
    jLabel7 = new javax.swing.JLabel();
    cmbTipoTratamiento = new javax.swing.JComboBox<>();
    cmbNombreTratamiento = new javax.swing.JComboBox<>();
    btnTipoTratameinto = new javax.swing.JButton();
    btnNombreTratemineto = new javax.swing.JButton();
    jScrollPane3 = new javax.swing.JScrollPane();
    tblTratamiento = new javax.swing.JTable();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    cmbNombrePaciente = new javax.swing.JComboBox<>();
    jScrollPane4 = new javax.swing.JScrollPane();
    tblHospiPaciente2 = new javax.swing.JTable();
    jScrollPane5 = new javax.swing.JScrollPane();
    tblHospiPaciente1 = new javax.swing.JTable();
    btnConsultaPacienteHospitalizado = new javax.swing.JButton();
    jButton1 = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
    jLabel1.setText("Consultas de los Pacientes");

    jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel2.setText("Citas asociadas a un paciente:");

    tblCitas.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Paciente", "Cita", "Observaciones", "Fecha Cita", "Estado de Cita"
      }
    ));
    jScrollPane1.setViewportView(tblCitas);

    btnEspecialidad.setText("Especialidad");

    cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASIGNADA", "CANCELADA" }));
    cmbEstado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        cmbEstadoActionPerformed(evt);
      }
    });

    btnEstado.setText("Estado");

    jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel3.setText("Diagnosticos asociados a un paciente:");

    btnNivel.setText("Nivel");

    btnNombre.setText("Nombre");

    jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel4.setText("Consultar por:");

    jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel5.setText("Consultar por:");

    tblDiagnosticoConsulta.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "identificador", "Nombre Diagnostico", "Obcervaciones", "Nivel"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane2.setViewportView(tblDiagnosticoConsulta);

    jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel6.setText("Consultar por:");

    jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel7.setText("Tratamiento asociados a un paciente:");

    btnTipoTratameinto.setText("Tipo");

    btnNombreTratemineto.setText("Nombre");

    tblTratamiento.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "identificador", "Nombre Tratemianto", "Dosis", "Tipo Tratamiento"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, true, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane3.setViewportView(tblTratamiento);

    jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    jLabel8.setText("Consultar por:");

    jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
    jLabel9.setText("Hospitalizaciones por paciente");

    tblHospiPaciente2.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Nombre Paciente", "Fecha Ingreso", "Fecha Salida", "Especialidad"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane4.setViewportView(tblHospiPaciente2);

    tblHospiPaciente1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "CentroAtención", "Cedula paciente", "Nombre paciente", "Diagnostico", "Funcionario encargado"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, true
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane5.setViewportView(tblHospiPaciente1);
    if (tblHospiPaciente1.getColumnModel().getColumnCount() > 0) {
      tblHospiPaciente1.getColumnModel().getColumn(0).setHeaderValue("CentroAtención");
    }

    btnConsultaPacienteHospitalizado.setText("Paciente");
    btnConsultaPacienteHospitalizado.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnConsultaPacienteHospitalizadoActionPerformed(evt);
      }
    });

    jButton1.setText("Volver");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(btnEspecialidad)
                    .addGap(131, 131, 131)
                    .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(168, 168, 168))
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(118, 118, 118))
                  .addComponent(jScrollPane1)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel2)
                    .addGap(29, 29, 29)
                    .addComponent(jLabel4)
                    .addGap(216, 216, 216)))
                .addGap(80, 80, 80))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnNivel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(btnNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel3)
                  .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel8)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(cmbNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(btnConsultaPacienteHospitalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4)
                .addContainerGap())
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(cmbNivelDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel5)
                  .addComponent(cmbNombreDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(btnTipoTratameinto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(btnNombreTratemineto, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(cmbTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(jLabel6)
                  .addComponent(cmbNombreTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGap(80, 80, 80)
            .addComponent(jScrollPane5)
            .addContainerGap())
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel9)
            .addGap(403, 403, 403))))
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(462, 462, 462)
        .addComponent(jLabel1)
        .addGap(0, 0, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addComponent(jLabel1)
        .addGap(27, 27, 27)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnNivel)
                .addComponent(btnNombre))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4)
                .addComponent(jLabel2))
              .addGap(18, 18, 18)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cmbEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnEspecialidad)
                .addComponent(btnEstado))
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
              .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel5)
              .addComponent(jLabel3))
            .addGap(18, 18, 18)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbNivelDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbNombreDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(jLabel9)))
        .addGap(35, 35, 35)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jLabel8)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbNombrePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(btnConsultaPacienteHospitalizado))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(jLabel7)
              .addComponent(jLabel6))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(cmbTipoTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(cmbNombreTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
              .addComponent(btnTipoTratameinto)
              .addComponent(btnNombreTratemineto))
            .addGap(18, 18, 18)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(59, 59, 59)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addGap(0, 47, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addContainerGap(12, Short.MAX_VALUE)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(0, 18, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Metodo del boton combobox estado en ConsultasDePacientes
   * @param evt 
   */
  private void cmbEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_cmbEstadoActionPerformed

  private void btnConsultaPacienteHospitalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaPacienteHospitalizadoActionPerformed
    // TODO add your handling code here:
  }//GEN-LAST:event_btnConsultaPacienteHospitalizadoActionPerformed

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Menu verM = new Menu();    
    verM.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButton1ActionPerformed

  /**
   * Metodo main de la clase vista ConsultasDePacientes
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
      java.util.logging.Logger.getLogger(ConsultasDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(ConsultasDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(ConsultasDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(ConsultasDePacientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new ConsultasDePacientes().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JButton btnConsultaPacienteHospitalizado;
  public javax.swing.JButton btnEspecialidad;
  public javax.swing.JButton btnEstado;
  public javax.swing.JButton btnNivel;
  public javax.swing.JToggleButton btnNombre;
  public javax.swing.JButton btnNombreTratemineto;
  public javax.swing.JButton btnTipoTratameinto;
  public javax.swing.JComboBox<String> cmbEspecialidad;
  public javax.swing.JComboBox<String> cmbEstado;
  public javax.swing.JComboBox<String> cmbNivelDiagnostico;
  public javax.swing.JComboBox<String> cmbNombreDiagnostico;
  public javax.swing.JComboBox<String> cmbNombrePaciente;
  public javax.swing.JComboBox<String> cmbNombreTratamiento;
  public javax.swing.JComboBox<String> cmbTipoTratamiento;
  private javax.swing.JButton jButton1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JLabel jLabel5;
  private javax.swing.JLabel jLabel6;
  private javax.swing.JLabel jLabel7;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  public javax.swing.JTable tblCitas;
  public javax.swing.JTable tblDiagnosticoConsulta;
  public javax.swing.JTable tblHospiPaciente1;
  public javax.swing.JTable tblHospiPaciente2;
  public javax.swing.JTable tblTratamiento;
  // End of variables declaration//GEN-END:variables
}
