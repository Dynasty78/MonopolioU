package login;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import clientemonopoly.Client;
import envio.Paquete_enviar;
import java.io.ObjectOutputStream;
        
/**
 *
 * @author samuel
 */
public class Configuration extends javax.swing.JFrame {

    public Configuration() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        input_address = new javax.swing.JTextField();
        set_ip = new javax.swing.JButton();
        conf_image = new javax.swing.JLabel();
        ip_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroud.setBackground(new java.awt.Color(255, 255, 255));

        input_address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                input_addressActionPerformed(evt);
            }
        });

        set_ip.setText("Set IP");
        set_ip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                set_ipMouseClicked(evt);
            }
        });

        conf_image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/monopoly_guy.jpg"))); // NOI18N

        ip_label.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ip_label.setText("Server IP Address");

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(set_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroudLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conf_image, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroudLayout.createSequentialGroup()
                        .addComponent(ip_label)
                        .addGap(72, 72, 72))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroudLayout.createSequentialGroup()
                        .addComponent(input_address, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addComponent(conf_image, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(ip_label, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(input_address, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(set_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void input_addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_input_addressActionPerformed

    }//GEN-LAST:event_input_addressActionPerformed

    private void set_ipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_set_ipMouseClicked
        server_ip_address = input_address.getText();
        boolean success = true;
        try {
        //Compare if the monopoly server exist
            socket = new Socket(server_ip_address,9999);
            Paquete_enviar init_package = new Paquete_enviar();
            init_package.setCodigo(-1);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(init_package);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
            System.out.printf(ex.getMessage());//Print error Message
            success = false;
        }

        if(success){
            //Set to Login JFrame
            this.setVisible(false);
            //new Register(socket).setVisible(true);
            new Login(server_ip_address).setVisible(true);
            //new Client(server_ip_address).setVisible(true);
        }
    }//GEN-LAST:event_set_ipMouseClicked

    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Configuration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JLabel conf_image;
    private javax.swing.JTextField input_address;
    private javax.swing.JLabel ip_label;
    private javax.swing.JButton set_ip;
    // End of variables declaration//GEN-END:variables
    
    String server_ip_address; 
    Socket socket;
}
