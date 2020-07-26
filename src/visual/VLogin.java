/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import internal.*;
import javax.swing.JOptionPane;
import java.sql.*;

/**
 *
 * @author RemoteUser
 */
public class VLogin extends javax.swing.JFrame {

    /**
     * Creates new form VLogin
     */
    public VLogin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        passLabel = new javax.swing.JPasswordField();
        rutLabel = new javax.swing.JTextField();
        btnAccept = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        btnAccept1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de sesion");

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Iniciar Sesión de Trabajador");

        passLabel.setToolTipText("Contraseña");

        rutLabel.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        rutLabel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        rutLabel.setToolTipText("Ingrese su Rut");
        rutLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rutLabelActionPerformed(evt);
            }
        });

        btnAccept.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        btnAccept.setText("Entrar");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Biblioteca");

        btnAccept1.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        btnAccept1.setText("FastLogin");
        btnAccept1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccept1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAccept1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(rutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccept, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAccept1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rutLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rutLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rutLabelActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO: Accept
        if(BUtilities.IsTextValid(rutLabel.getText()) && BUtilities.IsTextValid(passLabel.getText())){
            ResultSet result = BConnector.ExecuteQueryResult("SELECT * FROM Trabajador WHERE rut = '" + rutLabel.getText() + "'");
            
            try{
                if(result.next()){
                    String pass = result.getString("password");
                    
                    if(pass.equals(passLabel.getText())){
                        
                        BTrabajador trabajador = new BTrabajador(result.getInt("id"), 
                            result.getString("rut"), result.getString("nombre"),
                            result.getString("apellido_paterno"), result.getString("apellido_materno"),
                            result.getString("fecha_contratacion"));
                        BConnector.CloseConnection();
                        
                        BSession.SetCurrentTrabajador(trabajador);
                        
                        VHome homePage = new VHome();
                        
                        BUtilities.OpenFrame(homePage);
                        this.dispose();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Contraseña inválida");
                    }
                }
                else{
                    BConnector.CloseConnection();
                    JOptionPane.showMessageDialog(null, "Rut no encontrado");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error:\n" + e.getMessage());
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Rut o Contraseña Inválidos");
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnAccept1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccept1ActionPerformed
        ResultSet result = BConnector.ExecuteQueryResult("SELECT * FROM Trabajador WHERE rut = 'test'");
            
            try{
                if(result.next()){

                    BTrabajador trabajador = new BTrabajador(result.getInt("id"), 
                        result.getString("rut"), result.getString("nombre"),
                        result.getString("apellido_paterno"), result.getString("apellido_materno"),
                        result.getString("fecha_contratacion"));
                    BConnector.CloseConnection();

                    BSession.SetCurrentTrabajador(trabajador);

                    VHome homePage = new VHome();
                        
                    BUtilities.OpenFrame(homePage);
                    this.dispose();

                }
                else{
                    BConnector.CloseConnection();
                    JOptionPane.showMessageDialog(null, "Rut no encontrado");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error:\n" + e.getMessage());
            }
    }//GEN-LAST:event_btnAccept1ActionPerformed

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
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnAccept1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passLabel;
    private javax.swing.JTextField rutLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
