/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual.Visores;


import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import internal.*;
import java.util.ArrayList;

/**
 *
 * @author RemoteUser
 */
public class VnewTrabajador extends javax.swing.JFrame {

    /**
     * Creates new form VNewClient
     */
    public VnewTrabajador() {
        initComponents();
        
        InitLists();
    }
    BTrabajador Tref = null;
    
    public VnewTrabajador(String rut){
        initComponents();
        
        Tref = BTrabajador.GetTrabajadorByRut(rut);
        jLabel1.setText("Trabajador: " + Tref.getFullNameCode());
        
        rutL.setText(Tref.getRut());
        rutL.setEnabled(false);
        
        nombre.setText(Tref.getNombre());
        apellidoPaterno.setText(Tref.getApellidoPaterno());
        apellidoMaterno.setText(Tref.getApellidoMaterno());
        password.setText(Tref.getPassword());
        fechaContratacion.setText(Tref.getFechaContratacion());
        
        AñadirT.setText("Actualizar");
        
        InitLists();
    }
    
    DefaultListModel correoModel = new DefaultListModel();
    DefaultListModel telefonoModel = new DefaultListModel();
    DefaultListModel direccionModel = new DefaultListModel();
    
    ArrayList<String> newCorreos = new ArrayList();
    ArrayList<String> newTelefonos = new ArrayList();
    ArrayList<String> newDirecciones = new ArrayList();
    
    private void InitLists(){
        if(Tref != null){
            for (int i = 0; i < Tref.getCorreos().size(); i++) {
                correoModel.addElement(Tref.getCorreos().get(i));
            }
            for (int i = 0; i < Tref.getTelefonos().size(); i++) {
                telefonoModel.addElement(Tref.getTelefonos().get(i));
            }
            for (int i = 0; i < Tref.getDirecciones().size(); i++) {
                direccionModel.addElement(Tref.getDirecciones().get(i));
            }
        }
        UpdateModels();
    }
    
    private void UpdateModels(){
        correosList.setModel(correoModel);
        telefonosList.setModel(telefonoModel);
        direccionesList.setModel(direccionModel);
    }
    
    private void AddElementToModel(DefaultListModel modelRef, String value){
        modelRef.addElement(value);
        
        UpdateModels();
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
        rutL = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        apellidoPaterno = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        apellidoMaterno = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        telefonosList = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        correosList = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        direccionesList = new javax.swing.JList<>();
        AñadirT = new javax.swing.JButton();
        newCorreo = new javax.swing.JButton();
        newDireccion = new javax.swing.JButton();
        newTelefono = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        fechaContratacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Cliente");

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Añadir Trabajador");

        rutL.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rutL.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rutL.setText("529.159.159-9");
        rutL.setToolTipText("Ingrese Rut sin puntos ni guión");

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Rut");

        nombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nombre.setToolTipText("Ingrese Nombre");

        jLabel17.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nombre");

        jLabel18.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Apellido Paterno");

        apellidoPaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellidoPaterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        apellidoPaterno.setToolTipText("Ingrese Apellido Paterno");

        jLabel19.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Apellido Materno");

        apellidoMaterno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        apellidoMaterno.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        apellidoMaterno.setToolTipText("Ingrese Apellido Materno");

        jLabel20.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel20.setText("Correos");

        jLabel21.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Fecha de Contratacion");

        jLabel22.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Teléfonos");

        jLabel23.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Direcciones");

        telefonosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(telefonosList);

        correosList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        correosList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                correosListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(correosList);

        direccionesList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(direccionesList);

        AñadirT.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        AñadirT.setText("Añadir Trabajador");
        AñadirT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AñadirTActionPerformed(evt);
            }
        });

        newCorreo.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        newCorreo.setText("Nuevo Correo");
        newCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCorreoActionPerformed(evt);
            }
        });

        newDireccion.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        newDireccion.setText("Nueva Direccion");
        newDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newDireccionActionPerformed(evt);
            }
        });

        newTelefono.setFont(new java.awt.Font("Lucida Sans", 0, 12)); // NOI18N
        newTelefono.setText("Nuevo Telefono");
        newTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTelefonoActionPerformed(evt);
            }
        });

        jLabel2.setText("C o n t r a s e ñ a");

        password.setText("jPasswordField1");

        fechaContratacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaContratacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(AñadirT)
                        .addGap(264, 264, 264))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newDireccion)))
                                    .addComponent(newCorreo))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(newTelefono)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(fechaContratacion))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(rutL, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(apellidoPaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(apellidoMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                    .addComponent(password))))
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rutL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nombre)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoPaterno)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(apellidoMaterno)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fechaContratacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(AñadirT, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AñadirTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AñadirTActionPerformed
         boolean incomplete = false;
        if(rutL.getText().equals("")){
            incomplete = true;
        }
        if(nombre.getText().equals("")){
            incomplete = true;
        }
        if(apellidoPaterno.getText().equals("")){
            incomplete = true;
        }
        if(apellidoMaterno.getText().equals("")){
            incomplete = true;
        }
        if(password.getText().equals("")){
            incomplete = true;
        }
        
        if(fechaContratacion.getText().equals("")){
            incomplete = true;
        }
        
        if(correoModel.getSize() <= 0 || telefonoModel.getSize() <= 0 || direccionModel.getSize() <= 0){
            incomplete = true;
        }
        if(incomplete){
            JOptionPane.showMessageDialog(null, "Datos incompletos");
            return;
        }//validacion  
        
        if(Tref != null){
            if(BTrabajador.AddTrabajador(rutL.getText(), nombre.getText(), apellidoPaterno.getText(), apellidoMaterno.getText(), 
                    password.getText(), fechaContratacion.getText(), newCorreos, newTelefonos, newDirecciones, false, Integer.toString(Tref.getId()))){
                JOptionPane.showMessageDialog(null, "Trabajador actualizado");
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
                return; 
            }
        }else{
             if(BTrabajador.AddTrabajador(rutL.getText(), nombre.getText(), apellidoPaterno.getText(), apellidoMaterno.getText(), 
                    password.getText(), fechaContratacion.getText(), BUtilities.ModelOfStringsToArrayList(correoModel), BUtilities.ModelOfStringsToArrayList(telefonoModel), BUtilities.ModelOfStringsToArrayList(direccionModel), true, null)){
                JOptionPane.showMessageDialog(null, "Trabajador añadido");
                rutL.setText("");
                nombre.setText("");
                apellidoPaterno.setText("");
                apellidoMaterno.setText("");
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
                return; 
            }//aqui
        }
        
                       
    }//GEN-LAST:event_AñadirTActionPerformed

    private void correosListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_correosListValueChanged

    }//GEN-LAST:event_correosListValueChanged

    private void newCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCorreoActionPerformed
        String correo = JOptionPane.showInputDialog("Ingrese un Correo");
        
        if(correo != null && !correo.equals("")){
             if(Tref != null){
                newCorreos.add(correo);
            }
            AddElementToModel(correoModel, correo);
        }
    }//GEN-LAST:event_newCorreoActionPerformed

    private void newDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDireccionActionPerformed
        String direccion = JOptionPane.showInputDialog("Ingrese una Dirección");
        
        if(direccion != null && !direccion.equals("")){
            if(Tref != null){
                newDirecciones.add(direccion);
            }
            AddElementToModel(direccionModel, direccion);
        }
    }//GEN-LAST:event_newDireccionActionPerformed

    private void newTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTelefonoActionPerformed
        String telefono = JOptionPane.showInputDialog("Ingrese un Telefono");
        
        if(telefono != null && !telefono.equals("")){
            if(Tref != null){
                newTelefonos.add(telefono);
            }
            AddElementToModel(telefonoModel, telefono);
        }
    }//GEN-LAST:event_newTelefonoActionPerformed

    private void fechaContratacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaContratacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaContratacionActionPerformed

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
            java.util.logging.Logger.getLogger(VnewTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VnewTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VnewTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VnewTrabajador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VnewTrabajador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AñadirT;
    private javax.swing.JTextField apellidoMaterno;
    private javax.swing.JTextField apellidoPaterno;
    private javax.swing.JList<String> correosList;
    private javax.swing.JList<String> direccionesList;
    private javax.swing.JTextField fechaContratacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton newCorreo;
    private javax.swing.JButton newDireccion;
    private javax.swing.JButton newTelefono;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField rutL;
    private javax.swing.JList<String> telefonosList;
    // End of variables declaration//GEN-END:variables
}
