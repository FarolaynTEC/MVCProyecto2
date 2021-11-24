/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.CtrlCentroAtencion;
import Controlador.CtrlAreaCentro;
import Modelo.CentroAtencion;
import Modelo.ConsultaCentroAtencion;
import Vista.CentroA;
import Controlador.CtrlCentroAtencion;
import Controlador.CtrlCitas;
import Controlador.CtrlFuncionario;
import Controlador.CtrlPaciente;
import Modelo.AreaTrabajo;
import Modelo.Cita;
import Modelo.ConsultaCita;
import Modelo.ConsultaFuncionario;
import Modelo.ConsultaPaciente;
import Modelo.ConsultaTipoCentro;
import Modelo.Doctor;
import Modelo.Enfermero;
import Modelo.Funcionario;
import Modelo.Paciente;
import Modelo.TipoCentroAtencion;
import Modelo.Vacuna;
import Vista.AreaCentro;
import Vista.FuncionarioV;
import Vista.Menu;
import Vista.PacienteV;
import javax.swing.JFrame;

/**
 *
 * @author farol
 */
public class Menu extends javax.swing.JFrame {

  /**
   * Creates new form Menu
   */
  public Menu() {
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
    jPanel2 = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jButton3 = new javax.swing.JButton();
    jButton4 = new javax.swing.JButton();
    jButton5 = new javax.swing.JButton();
    jButton6 = new javax.swing.JButton();
    jButton7 = new javax.swing.JButton();
    jButton8 = new javax.swing.JButton();
    jButton9 = new javax.swing.JButton();
    btnHospitalizar = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setBackground(new java.awt.Color(37, 182, 204));

    jPanel2.setBackground(new java.awt.Color(37, 182, 204));
    jPanel2.setEnabled(false);

    jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
    jLabel1.setText("Menú Principal");

    jButton1.setBackground(new java.awt.Color(255, 255, 255));
    jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton1.setText("Registrar Área o Centro");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton1ActionPerformed(evt);
      }
    });

    jButton2.setBackground(new java.awt.Color(255, 255, 255));
    jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton2.setText("Registrar Bitácora");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton2ActionPerformed(evt);
      }
    });

    jButton3.setBackground(new java.awt.Color(255, 255, 255));
    jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton3.setText("Registrar Centro Atención");
    jButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton3ActionPerformed(evt);
      }
    });

    jButton4.setBackground(new java.awt.Color(255, 255, 255));
    jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton4.setText("Solicitar Cita");
    jButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton4ActionPerformed(evt);
      }
    });

    jButton5.setBackground(new java.awt.Color(255, 255, 255));
    jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton5.setText("Diagnósticos y Tratamientos");
    jButton5.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton5ActionPerformed(evt);
      }
    });

    jButton6.setBackground(new java.awt.Color(255, 255, 255));
    jButton6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton6.setText("Registrar Funcionarios");
    jButton6.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton6ActionPerformed(evt);
      }
    });

    jButton7.setBackground(new java.awt.Color(255, 255, 255));
    jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton7.setText("Registrar Paciente");
    jButton7.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton7ActionPerformed(evt);
      }
    });

    jButton8.setBackground(new java.awt.Color(255, 255, 255));
    jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton8.setText("Seguimiento Paciente");
    jButton8.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton8ActionPerformed(evt);
      }
    });

    jButton9.setBackground(new java.awt.Color(255, 255, 255));
    jButton9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    jButton9.setText("Registrar Vacunas");
    jButton9.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jButton9ActionPerformed(evt);
      }
    });

    btnHospitalizar.setBackground(new java.awt.Color(255, 255, 255));
    btnHospitalizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
    btnHospitalizar.setText("Hospitalizar Paciente");
    btnHospitalizar.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnHospitalizarActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap(541, Short.MAX_VALUE)
        .addComponent(jLabel1)
        .addGap(539, 539, 539))
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addGap(131, 131, 131)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(btnHospitalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel1)
        .addGap(44, 44, 44)
        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(btnHospitalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(44, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

  private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    AreaTrabajo modAT = new AreaTrabajo();
    TipoCentroAtencion modTCA = new TipoCentroAtencion() ;
    ConsultaTipoCentro modC = new ConsultaTipoCentro();
    AreaCentro frmAC = new AreaCentro();
    
    CtrlAreaCentro ctrl4 = new CtrlAreaCentro(modAT, modTCA, modC, frmAC);
    ctrl4.iniciar();
    frmAC.setVisible(true);
  }//GEN-LAST:event_jButton1ActionPerformed

  private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    BitacoraV verV = new BitacoraV();    
    verV.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButton2ActionPerformed

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    CentroAtencion modCA = new CentroAtencion();
    ConsultaCentroAtencion modCCA = new ConsultaCentroAtencion();
    CentroA frmCA = new CentroA();
    
    CtrlCentroAtencion ctrl1 = new CtrlCentroAtencion(modCA,modCCA,frmCA);
    ctrl1.iniciar();
    frmCA.setVisible(true);
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    Cita modCita = new Cita();
    ConsultaCita modC = new ConsultaCita();
    CitaV verV = new CitaV(); 
    
    CtrlCitas ctrlCita = new CtrlCitas(modCita,modC,verV);
    ctrlCita.iniciar();
    verV.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButton4ActionPerformed

  private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    DiagnosticoTratamiento verDT = new DiagnosticoTratamiento();    
    verDT.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButton5ActionPerformed

  private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    Funcionario modFun = new Funcionario();
    Doctor modDoc = new Doctor();
    Enfermero modEnf= new Enfermero();
    ConsultaFuncionario modCF = new ConsultaFuncionario();
    FuncionarioV frmF = new FuncionarioV();
    
    CtrlFuncionario ctrl2 = new CtrlFuncionario( modFun, modCF, modDoc, modEnf, frmF);
    ctrl2.iniciar();
    frmF.setVisible(true);
  }//GEN-LAST:event_jButton6ActionPerformed

  private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    Paciente modPac = new Paciente();
    Vacuna modVac = new Vacuna();
    ConsultaPaciente modCP = new ConsultaPaciente();
    PacienteV frmP = new PacienteV();
    
    CtrlPaciente ctrl3 = new CtrlPaciente( modPac, modVac, modCP, frmP);
    ctrl3.iniciar();
    frmP.setVisible(true);
  }//GEN-LAST:event_jButton7ActionPerformed

  private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    Seguimiento verS = new Seguimiento();    
    verS.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_jButton8ActionPerformed

  private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    Paciente modPac = new Paciente();
    Vacuna modVac = new Vacuna();
    ConsultaPaciente modCP = new ConsultaPaciente();
    PacienteV frmP = new PacienteV();
    
    CtrlPaciente ctrl3 = new CtrlPaciente( modPac, modVac, modCP, frmP);
    ctrl3.iniciar();
    frmP.setVisible(true);
  }//GEN-LAST:event_jButton9ActionPerformed

  private void btnHospitalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHospitalizarActionPerformed
    Hospitalizar verH = new Hospitalizar();    
    verH.setVisible(true);
    this.setVisible(false);
  }//GEN-LAST:event_btnHospitalizarActionPerformed

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
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new Menu().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnHospitalizar;
  private javax.swing.JButton jButton1;
  private javax.swing.JButton jButton2;
  private javax.swing.JButton jButton3;
  private javax.swing.JButton jButton4;
  private javax.swing.JButton jButton5;
  private javax.swing.JButton jButton6;
  private javax.swing.JButton jButton7;
  private javax.swing.JButton jButton8;
  private javax.swing.JButton jButton9;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  // End of variables declaration//GEN-END:variables
}
