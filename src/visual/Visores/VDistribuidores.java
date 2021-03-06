/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual.Visores;

import internal.BCliente;
import internal.BConnector;
import internal.BDistribuidor;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author joaquin
 */
public class VDistribuidores extends javax.swing.JFrame {

    /**
     * Creates new form VDistribuidores
     */
    public VDistribuidores() {
        initComponents();
        
        InitDistribuidores();
    }
    
    private void InitDistribuidores(){
        ArrayList<BDistribuidor> distribuidores = BDistribuidor.GetAllDistribuidores();
        
        DefaultListModel model = new DefaultListModel();

        if(distribuidores.size() > 0){
            for (int i = 0; i < distribuidores.size(); i++) {
                model.addElement(distribuidores.get(i).getFullName());
            }
        }
        distribuidoresList.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        distribuidoresList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        addDistribuidor = new javax.swing.JMenu();
        btnDelete = new javax.swing.JMenu();
        updateDistribuidor = new javax.swing.JMenu();
        btnUpdate = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Distribuidores");

        distribuidoresList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(distribuidoresList);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Distribuidores");

        addDistribuidor.setText("Nuevo");
        addDistribuidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addDistribuidorMouseClicked(evt);
            }
        });
        addDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDistribuidorActionPerformed(evt);
            }
        });
        jMenuBar1.add(addDistribuidor);

        btnDelete.setText("Eliminar");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnDelete);

        updateDistribuidor.setText("Actualizar Distribuidor");
        updateDistribuidor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateDistribuidorMouseClicked(evt);
            }
        });
        jMenuBar1.add(updateDistribuidor);

        btnUpdate.setText("Actualizar Lista");
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        jMenuBar1.add(btnUpdate);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addDistribuidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addDistribuidorMouseClicked
        VNewDistribuidores distribuidoresPage = new VNewDistribuidores();
        distribuidoresPage.pack();
        distribuidoresPage.setLocationRelativeTo(null);
        distribuidoresPage.setVisible(true);
        this.setEnabled(true);
    }//GEN-LAST:event_addDistribuidorMouseClicked

    private void addDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDistribuidorActionPerformed
        VNewDistribuidores distribuidoresPage = new VNewDistribuidores();
        distribuidoresPage.pack();
        distribuidoresPage.setLocationRelativeTo(null);
        distribuidoresPage.setVisible(true);
        this.setEnabled(true);
    }//GEN-LAST:event_addDistribuidorActionPerformed

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        String rut = JOptionPane.showInputDialog("Ingrese el Rut del distribuidor a eliminar");
        if(rut != null && !rut.equals("")){
            ResultSet distribuidorID = BConnector.ExecuteQueryResult("SELECT id FROM Distribuidor WHERE rut = '" + rut + "';");

            try{
                if(distribuidorID.next()){
                    ArrayList<String> deleteQueries = new ArrayList();

                    int id = distribuidorID.getInt("id");

                    if(BConnector.ExecuteQuery("DELETE FROM Distribuidor WHERE rut = '" + rut + "';")){
                        JOptionPane.showMessageDialog(null, "Distribuidor eliminado");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "No se ha encontrado un distribuidor con ese Rut");
                    btnDeleteMouseClicked(evt);
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void updateDistribuidorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateDistribuidorMouseClicked
        String rut = JOptionPane.showInputDialog("Ingrese el Rut para Actualizar");

        if(rut != null && !rut.equals("")){
            ResultSet result = BConnector.ExecuteQueryResult("SELECT id FROM Distribuidor WHERE rut = '"+rut+"'");

            try{
                if(result.next()){
                    VNewDistribuidores distribuidoresPage = new VNewDistribuidores(rut);
                    distribuidoresPage.pack();
                    distribuidoresPage.setLocationRelativeTo(null);
                    distribuidoresPage.setVisible(true);
                    this.setEnabled(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Rut no encontrado");
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error");
            }
        }
    }//GEN-LAST:event_updateDistribuidorMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        InitDistribuidores();
    }//GEN-LAST:event_btnUpdateMouseClicked

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
            java.util.logging.Logger.getLogger(VDistribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VDistribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VDistribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VDistribuidores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VDistribuidores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu addDistribuidor;
    private javax.swing.JMenu btnDelete;
    private javax.swing.JMenu btnUpdate;
    private javax.swing.JList<String> distribuidoresList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu updateDistribuidor;
    // End of variables declaration//GEN-END:variables
}
