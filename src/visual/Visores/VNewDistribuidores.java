
package visual.Visores;

import internal.BCliente;
import internal.BConnector;
import internal.BDistribuidor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author RemoteUser
 */
public class VNewDistribuidores extends javax.swing.JFrame {

    public VNewDistribuidores(){
        initComponents();
    }
    
    BDistribuidor distribuidor = null;
    
    public VNewDistribuidores(String rut){
        initComponents();
        
        distribuidor = BDistribuidor.GetDistribuidorByRut(rut);
        
        rutLabel.setText(distribuidor.getRut());
        rutLabel.setEnabled(false);
        nombreEmpresa.setText(distribuidor.getNombre_empresa());
        
        añoInicio.setText(distribuidor.getAño_inicio());
        
        Direccion.setText(distribuidor.getDireccionString());
        TelefonoD.setText(distribuidor.getTelefonoString());
        CorreoD.setText(distribuidor.getCorreoString());
        
        titleLabel.setText("Actualizar Distribuidor");
        btnDistribuidor.setText("Actualizar");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        rutLabel = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        nombreEmpresa = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        añoInicio = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        Direccion = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        btnDistribuidor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TelefonoD = new java.awt.TextField();
        CorreoD = new java.awt.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Cliente");

        titleLabel.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Añadir Distribuidor");

        rutLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rutLabel.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        rutLabel.setToolTipText("Ingrese Rut sin puntos ni guión");

        jLabel16.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Rut");

        nombreEmpresa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nombreEmpresa.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        nombreEmpresa.setToolTipText("Ingrese Nombre");

        jLabel17.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Nombre Empresa");

        jLabel18.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Año inicio");

        añoInicio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        añoInicio.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        añoInicio.setToolTipText("Ingrese Apellido Paterno");

        jLabel19.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Direccion");

        Direccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Direccion.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        Direccion.setToolTipText("Ingrese Apellido Materno");

        jLabel21.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Correo");

        btnDistribuidor.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        btnDistribuidor.setText("Añadir Distribuidor");
        btnDistribuidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDistribuidorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Telefono");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 269, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(rutLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(nombreEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(añoInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(Direccion, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(TelefonoD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CorreoD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnDistribuidor)
                        .addGap(259, 259, 259))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rutLabel)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombreEmpresa)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(añoInicio)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Direccion)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TelefonoD, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CorreoD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addGap(36, 36, 36)
                .addComponent(btnDistribuidor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDistribuidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDistribuidorActionPerformed
        boolean fail = false;
        if(rutLabel.getText().equals("")){
            fail = true;
        }
        if(nombreEmpresa.getText().equals("")){
            fail = true;
        }
        if(añoInicio.getText().equals("")){
            fail = true;
        }
        if(Direccion.getText().equals("")){
            fail = true;
        }
        if(TelefonoD.getText().equals("")){
            fail = true;
        }
        if(CorreoD.getText().equals("")){
            fail = true;
        }
        
        if(fail){
            JOptionPane.showMessageDialog(null, "Datos incompletos");
            return;
        }
        
        if(distribuidor != null){
            if(BDistribuidor.AddDistribuidor(rutLabel.getText(),
                    nombreEmpresa.getText(), añoInicio.getText(), Direccion.getText(),
                    TelefonoD.getText(), CorreoD.getText(), distribuidor.getDireccion(), distribuidor.getTelefono_id(), distribuidor.getCorreo_id())){
                JOptionPane.showMessageDialog(null, "Distribuidor actualizado exitósamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        }
        else{
            if(BDistribuidor.AddDistribuidor(rutLabel.getText(),
                    nombreEmpresa.getText(), añoInicio.getText(), Direccion.getText(),
                    TelefonoD.getText(), CorreoD.getText(), null, null, null)){
                JOptionPane.showMessageDialog(null, "Distribuidor añadido exitósamente");
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha producido un error");
            }
        }
        
    }//GEN-LAST:event_btnDistribuidorActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VNewDistribuidores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextField CorreoD;
    private javax.swing.JTextField Direccion;
    private java.awt.TextField TelefonoD;
    private javax.swing.JTextField añoInicio;
    private javax.swing.JButton btnDistribuidor;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JTextField nombreEmpresa;
    private javax.swing.JTextField rutLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
