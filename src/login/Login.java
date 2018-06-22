/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import clientemonopoly.Client;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author samuel
 */
public class Login extends javax.swing.JFrame implements Runnable {

    public Login() {
        initComponents();
    }
    
    public Login(String server_ip_address){
        initComponents();
        this.server_ip_address = server_ip_address;
        thread = new Thread(this);
        thread.start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        backgroud = new javax.swing.JPanel();
        password = new javax.swing.JPasswordField();
        username = new javax.swing.JTextField();
        username_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        prueba = new javax.swing.JButton();
        login_message = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        register = new javax.swing.JLabel();
        logoimage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroud.setBackground(new java.awt.Color(30, 128, 74));

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        username_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        username_label.setText("Username");

        password_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        password_label.setText("Password");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo22.png"))); // NOI18N

        prueba.setText("Entrar");
        prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pruebaMouseClicked(evt);
            }
        });
        prueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pruebaActionPerformed(evt);
            }
        });

        login_message.setFont(new java.awt.Font("Cambria", 1, 13)); // NOI18N
        login_message.setForeground(new java.awt.Color(153, 0, 0));

        register.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        register.setText("Registro");
        register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerMouseExited(evt);
            }
        });

        logoimage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/loginbuildings2.png"))); // NOI18N

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(logo))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(username_label, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(60, 60, 60)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(login_message, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(logoimage)
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(30, 30, 30)
                .addComponent(username_label, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(register, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addComponent(password_label)
                        .addGap(12, 12, 12)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(login_message, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(logoimage))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        char c = evt.getKeyChar();
        int len = username.getText().length();
        int ascii = (int)evt.getKeyChar();
        if((len>=10)||
                (Character.isSpaceChar(c))||
                ((ascii>32)&&(ascii<=47))||
                ((ascii>=58)&&(ascii<=64))||
                ((ascii>=91)&&(ascii<=96))||
                ((ascii>=123)&&(ascii<=127))){
            evt.consume();
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        char c = evt.getKeyChar();
        int len = password.getText().length();
        if((len>=10)||
            (Character.isSpaceChar(c))){
            evt.consume();
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void pruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pruebaMouseClicked
        //Send Username and Password to server
        User user = new User(
            username.getText(),
            password.getText(),
            "login"
            );     
        usern = username.getText();  
        try {
            socket = new Socket(server_ip_address,9999);
            ObjectOutputStream login = new ObjectOutputStream(socket.getOutputStream());
            login.writeObject(user);
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_pruebaMouseClicked

    private void registerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseEntered

        Font labelFont = register.getFont();
        register.setFont(new Font(labelFont.getName(),Font.BOLD,13));
    }//GEN-LAST:event_registerMouseEntered

    private void registerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseExited

        Font labelFont = register.getFont();
        register.setFont(new Font(labelFont.getName(),Font.PLAIN,13));
    }//GEN-LAST:event_registerMouseExited

    private void registerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new Register(server_ip_address,this).setVisible(true);
    }//GEN-LAST:event_registerMouseClicked

    private void pruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pruebaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pruebaActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
    
    @Override
    public void run() {
        try{
            ServerSocket client_server = new ServerSocket(9888);
            Socket client;
            
            while(true){
                client = client_server.accept();
                DataInputStream in = new DataInputStream(client.getInputStream());
                String message = in.readUTF();
                if(message.equals("login error")){
                    //Print Error on the scream
                    login_message.setText("El usuario o la clave no coinciden");
                }else if(message.equals("cool")){
                    //Get back the name and lastname of the user
                    ObjectInputStream object_in = new ObjectInputStream(client.getInputStream());
                    User user_client = (User) object_in.readObject();
                    user_client.setUsername(usern);
                    client.close();
                    client_server.close();
                    this.setVisible(false);
                    new Client(server_ip_address,user_client).setVisible(true);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel login_message;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logoimage;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton prueba;
    private javax.swing.JLabel register;
    private javax.swing.JTextField username;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
    private Socket socket;
    private Thread thread;
    private String usern;
    private String server_ip_address;
}
