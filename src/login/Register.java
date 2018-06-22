
package login;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author samuel
 */

public class Register extends javax.swing.JFrame {

    public Register() {
        initComponents();
    }
    
    public Register(String server_ip_address) {
        initComponents();
        this.server_ip_address = server_ip_address;
    }
    
    public Register(String server_ip_address,Login loginJFrame) {
        initComponents();
        this.server_ip_address = server_ip_address;
        this.loginJFrame = loginJFrame;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name1 = new javax.swing.JTextField();
        backgroud = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        prueba = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        password_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        lastname_label = new javax.swing.JLabel();
        username_label = new javax.swing.JLabel();
        buildings_label = new javax.swing.JLabel();

        name1.setText("name");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroud.setBackground(new java.awt.Color(30, 128, 74));
        backgroud.setPreferredSize(new java.awt.Dimension(300, 300));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo22.png"))); // NOI18N

        prueba.setText("Registrar");
        prueba.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pruebaMouseClicked(evt);
            }
        });

        username.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        lastname.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                lastnameKeyTyped(evt);
            }
        });

        name.setFont(new java.awt.Font("Cambria", 0, 13)); // NOI18N
        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        password_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        password_label.setText("Password");

        name_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        name_label.setText("Nombre");

        lastname_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        lastname_label.setText("Apellido");

        username_label.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        username_label.setText("Username");

        buildings_label.setIcon(new javax.swing.ImageIcon("C:\\Users\\hogar\\Documents\\Monopoly\\buildings1.png")); // NOI18N

        javax.swing.GroupLayout backgroudLayout = new javax.swing.GroupLayout(backgroud);
        backgroud.setLayout(backgroudLayout);
        backgroudLayout.setHorizontalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(logo))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lastname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(username_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(buildings_label, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(backgroudLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        backgroudLayout.setVerticalGroup(
            backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroudLayout.createSequentialGroup()
                .addComponent(logo)
                .addGap(10, 10, 10)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastname_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(backgroudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(prueba, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(username_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(buildings_label, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroudLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroud, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pruebaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pruebaMouseClicked
        
        if((name.getText().length()!=0)&&
            (lastname.getText().length()!=0)&&
            (username.getText().length()!=0)&&
            (password.getText().length()!=0)){ 
        
            try {
                //Create a new user 
                socket = new Socket(server_ip_address,9999);
                User user = new User(
                    name.getText(),
                    lastname.getText(),
                    username.getText(),
                    password.getText(),
                    "register");
                ObjectOutputStream register = new ObjectOutputStream(socket.getOutputStream());
                register.writeObject(user);
                socket.close();
            } catch (IOException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
                System.out.printf(ex.getMessage());//Print error Message
            }
            int accept = JOptionPane.showOptionDialog(this,"Cool.! te has registro satisfactoriamente","Registro",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, null, null, null);
            if(accept == JOptionPane.OK_OPTION){
                this.setVisible(false);
                loginJFrame.setVisible(true);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Dejo campos vacios");
        }
    }//GEN-LAST:event_pruebaMouseClicked

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        char c = evt.getKeyChar();
        int len = name.getText().length();
        int ascii = (int)evt.getKeyChar();
        if((Character.isDigit(c))||
                (len>=15)||
                (Character.isSpaceChar(c))||
                ((ascii>32)&&(ascii<=47))||
                ((ascii>=58)&&(ascii<=64))||
                ((ascii>=91)&&(ascii<=96))||
                ((ascii>=123)&&(ascii<=127))){
            evt.consume();
        }
    }//GEN-LAST:event_nameKeyTyped

    private void lastnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyTyped
        char c = evt.getKeyChar();
        int len = lastname.getText().length();
        int ascii = (int)evt.getKeyChar();
        if((Character.isDigit(c))||
                (len>=15)||
                (Character.isSpaceChar(c))||
                ((ascii>32)&&(ascii<=47))||
                ((ascii>=58)&&(ascii<=64))||
                ((ascii>=91)&&(ascii<=96))||
                ((ascii>=123)&&(ascii<=127))){
            evt.consume();
        }
    }//GEN-LAST:event_lastnameKeyTyped

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

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroud;
    private javax.swing.JLabel buildings_label;
    private javax.swing.JTextField lastname;
    private javax.swing.JLabel lastname_label;
    private javax.swing.JLabel logo;
    private javax.swing.JTextField name;
    private javax.swing.JTextField name1;
    private javax.swing.JLabel name_label;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password_label;
    private javax.swing.JButton prueba;
    private javax.swing.JTextField username;
    private javax.swing.JLabel username_label;
    // End of variables declaration//GEN-END:variables
    private Socket socket;
    private String server_ip_address;
    private Login loginJFrame;
    
}
