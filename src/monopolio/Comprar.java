
package monopolio;

import MensajeUI.MensajeUI;
import java.util.ArrayList;
import envio.Paquete_enviar;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import envio.Paquete_enviar;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */
public class Comprar extends javax.swing.JDialog implements Runnable{
    
    private ArrayList<Propiedad> properties;
    private String server_ip_address;
    private Jugador player;
    private Thread thread;
    
    public Comprar(java.awt.Frame parent, boolean modal){
        super(parent, modal);
        initComponents();
    }
    
    public Comprar(java.awt.Frame parent, boolean modal,ArrayList<Propiedad> properties,String server_ip_address,Jugador player) {
        super(parent, modal);
        initComponents();
        this.properties = properties;
        this.server_ip_address = server_ip_address;
        this.player = player;
        this.thread = new Thread(this);
        this.thread.start();
        /*Fill combo box with the User's properties*/
        for(int i = 0; i < properties.size(); i++){
            my_properties.addItem(this.properties.get(i).getName());
        }
    }
    
    public void setProperties(ArrayList<Propiedad> properties){
        this.properties = properties;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroud = new javax.swing.JPanel();
        my_properties = new javax.swing.JComboBox<>();
        image_property = new javax.swing.JLabel();
        buy_home = new javax.swing.JButton();
        houses_backgroud = new javax.swing.JPanel();
        house1 = new javax.swing.JLabel();
        house3 = new javax.swing.JLabel();
        house2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        backgroud.setBackground(new java.awt.Color(255, 255, 255));
        backgroud.setLayout(null);

        my_properties.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mis propiedades" }));
        my_properties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                my_propertiesActionPerformed(evt);
            }
        });
        backgroud.add(my_properties);
        my_properties.setBounds(31, 47, 190, 29);
        backgroud.add(image_property);
        image_property.setBounds(31, 87, 250, 290);

        buy_home.setText("Comprar una casa");
        buy_home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy_homeMouseClicked(evt);
            }
        });
        backgroud.add(buy_home);
        buy_home.setBounds(105, 428, 119, 23);

        javax.swing.GroupLayout houses_backgroudLayout = new javax.swing.GroupLayout(houses_backgroud);
        houses_backgroud.setLayout(houses_backgroudLayout);
        houses_backgroudLayout.setHorizontalGroup(
            houses_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(houses_backgroudLayout.createSequentialGroup()
                .addComponent(house1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(house2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(house3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        houses_backgroudLayout.setVerticalGroup(
            houses_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(houses_backgroudLayout.createSequentialGroup()
                .addComponent(house3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, houses_backgroudLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(houses_backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(house1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(house2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        backgroud.add(houses_backgroud);
        houses_backgroud.setBounds(370, 130, 320, 100);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void my_propertiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_my_propertiesActionPerformed
        // TODO add your handling code here:
        int property_id = my_properties.getSelectedIndex();
        
        if(property_id != 0){
            String image = properties.get(property_id - 1).getImg();
            image_property.setIcon(new javax.swing.ImageIcon(getClass().getResource(image)));
        }else{
            image_property.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blanco.jpg")));
        }
    }//GEN-LAST:event_my_propertiesActionPerformed

    private void buy_homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy_homeMouseClicked
        // TODO add your handling code here:
        //Buy a home
        int property_id = my_properties.getSelectedIndex();
        if(property_id!=0){
            Paquete_enviar buy = new Paquete_enviar();
            buy.setJugador(player);
            buy.setPropertyPosition(property_id - 1);
            buy.setMensaje("home");
            buy.setCodigo(20);
            
            //Send Purchase
            try{
                Socket socket = new Socket(server_ip_address,9999);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(buy);
                
                socket.close();
                out.close();
            }catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            
        }else{
            //Error message: Select a property
        }
    }//GEN-LAST:event_buy_homeMouseClicked

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
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Comprar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Comprar dialog = new Comprar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JButton buy_home;
    private javax.swing.JLabel house1;
    private javax.swing.JLabel house2;
    private javax.swing.JLabel house3;
    private javax.swing.JPanel houses_backgroud;
    private javax.swing.JLabel image_property;
    private javax.swing.JComboBox<String> my_properties;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            ServerSocket server_buy_socket = new ServerSocket(9000);
            Socket connection;
            Paquete_enviar paquete;
            int code;
            
            while(true){
                connection = server_buy_socket.accept();
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                paquete = (Paquete_enviar) in.readObject();
                code = paquete.getCodigo();
                
                if(code == 20){//Compra satisfactoria
                    int property_position = paquete.getPropertyPosition();
                    int property_id = my_properties.getSelectedIndex();
                    Propiedad property = player.getPropiedades().get(property_position);
                    if(property_id != 0){
                        String image = properties.get(property_id - 1).getImg();
                        image_property.setIcon(new javax.swing.ImageIcon(getClass().getResource(image)));
                        if(property.getNumerocasas() == 1){
                            house1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                        }else if(property.getNumerocasas() == 2){
                            house1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                            house2.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                        }else if(property.getNumerocasas() == 3){
                            house1.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                            house2.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                            house3.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/monopoly_house_100")));
                        }
                    }else{
                        image_property.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blanco.jpg")));
                    }
                    
                }else if(code == 21){//Mensaje error
                    String message = paquete.getMensaje();
                    JOptionPane.showMessageDialog(this,message);
                }
                
                connection.close();
                in.close();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex){
            Logger.getLogger(Comprar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
