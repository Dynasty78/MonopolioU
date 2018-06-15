
package clientemonopoly;

import MensajeUI.MensajeUI;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopolio.Jugador;
import envio.Paquete_enviar;

public class Client extends javax.swing.JFrame implements Runnable{
    
     private static int count = 0;
     public int dice1 = 0, dice2 = 0;
     public Jugador jugadorlocal;

    public Client() {
        initComponents();
        Thread mi_hilo = new Thread(this);
        mi_hilo.start();
        addWindowListener(new Online());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ficha = new javax.swing.JLabel();
        imagenTablero = new javax.swing.JLabel();
        dados = new javax.swing.JButton();
        dado2 = new javax.swing.JLabel();
        dado1 = new javax.swing.JLabel();
        PanelMensaje = new javax.swing.JPanel();
        mensaje = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        turno = new javax.swing.JLabel();
        dinero = new javax.swing.JLabel();
        finalizarTurno = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Movimiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ficha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_dot.png"))); // NOI18N
        jPanel1.add(ficha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 630, 60, 60));

        imagenTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tablero.png"))); // NOI18N
        imagenTablero.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imagenTableroMouseMoved(evt);
            }
        });
        jPanel1.add(imagenTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 704));

        dados.setText("Dados");
        dados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadosActionPerformed(evt);
            }
        });
        jPanel1.add(dados, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 670, -1, -1));
        jPanel1.add(dado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 570, 65, 73));
        jPanel1.add(dado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 570, 65, 73));

        PanelMensaje.setBackground(new java.awt.Color(255, 255, 255));
        PanelMensaje.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mensaje.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        PanelMensaje.add(mensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 340, 40));
        PanelMensaje.add(imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 120));

        jPanel1.add(PanelMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 370, 120));

        usuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usuario.setText("Username");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, -1, -1));

        turno.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jPanel1.add(turno, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 40, 160, 20));

        dinero.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jPanel1.add(dinero, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 130, 20));

        finalizarTurno.setText("finalizar");
        finalizarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(finalizarTurno, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 670, -1, -1));

        jLabel1.setBackground(new java.awt.Color(0, 255, 102));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 340, 50, 50));

        Movimiento.setText("Movimiento");
        Movimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MovimientoActionPerformed(evt);
            }
        });
        jPanel1.add(Movimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 670, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadosActionPerformed
      if(jugadorlocal.isTurno()){
        try {
            Socket mi_socket = new Socket("192.168.0.105",9999);
            Paquete_enviar datos = new Paquete_enviar();
            datos.setJugador(jugadorlocal);
            datos.setCodigo(1);
            ObjectOutputStream paquete_datos = new ObjectOutputStream(mi_socket.getOutputStream());
            paquete_datos.writeObject(datos);
            mi_socket.close();
            paquete_datos.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       }
      else{
          new Thread(new MensajeUI(PanelMensaje,"Aun no es tu turno!",4)).start();
      }
    }//GEN-LAST:event_dadosActionPerformed

    private void finalizarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarTurnoActionPerformed
      if(jugadorlocal.isTurno()){
        try {
            Socket mi_socket = new Socket("192.168.0.105",9999);
            Paquete_enviar datos = new Paquete_enviar();
            datos.setJugador(jugadorlocal);
            datos.setCodigo(2);
            ObjectOutputStream paquete_datos = new ObjectOutputStream(mi_socket.getOutputStream());
            paquete_datos.writeObject(datos);
            mi_socket.close();
            paquete_datos.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        jugadorlocal.setTurno(false);
        turno.setText("Esperando turno");
       }
      else{
          new Thread(new MensajeUI(PanelMensaje,"Aun no es tu turno!",4)).start();
      }
    }//GEN-LAST:event_finalizarTurnoActionPerformed

    private void imagenTableroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenTableroMouseMoved
        int x,y;
        x =evt.getX();
        y=evt.getY();
        System.out.println("posicion: "+x+" "+y);
    }//GEN-LAST:event_imagenTableroMouseMoved

    private void MovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MovimientoActionPerformed
 
    }//GEN-LAST:event_MovimientoActionPerformed

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
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Movimiento;
    private javax.swing.JPanel PanelMensaje;
    private javax.swing.JLabel dado1;
    private javax.swing.JLabel dado2;
    private javax.swing.JButton dados;
    private javax.swing.JLabel dinero;
    private javax.swing.JLabel ficha;
    private javax.swing.JButton finalizarTurno;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagenTablero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JLabel turno;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
   
    @Override
    public void run() {
        try {
            ServerSocket servidor_cliente = new ServerSocket(9090);
            Socket cliente;
            Paquete_enviar paquete_recibido;
            int codigo;

            while(true){
                cliente = servidor_cliente.accept();
                ObjectInputStream paquete_datos = new ObjectInputStream(cliente.getInputStream());
                paquete_recibido = (Paquete_enviar) paquete_datos.readObject();
                codigo = paquete_recibido.getCodigo();
                if(codigo == 0){
                    jugadorlocal = paquete_recibido.getJugador();
                    dinero.setText("$: "+jugadorlocal.getDinero());
                    if(jugadorlocal.isTurno()){
                        new Thread(new MensajeUI(PanelMensaje,"Ha empezado el juego, es tu turno!",4)).start();
                        turno.setText("Tu turno");
                    }
                    else{
                         new Thread(new MensajeUI(PanelMensaje,"Ha empezado el juego, esperando turno",4)).start();
                        turno.setText("Esperando turno");
                    }
                }
                else if(codigo ==1){
                    Random seed1, seed2;
                    seed1 = paquete_recibido.getSeed1();
                    seed2 =paquete_recibido.getSeed2();
                    animacionDados(seed1,seed2);
                } else if(codigo ==2){
                    jugadorlocal.setTurno(true);
                    new Thread(new MensajeUI(PanelMensaje,"Es tu turno! lanza los dados",4)).start();
                    turno.setText("Tu turno");
                }
                cliente.close();
                paquete_datos.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void animacionDados(Random seed1, Random seed2){
        Timer timer = new Timer();
        count = 0;
        
       TimerTask tarea = new TimerTask() {
       @Override
       public void run() {
           
        count++;
     if (count >= 20) {
         timer.cancel();
         timer.purge();
         return ;
     }
           
        int random=0, random2 = 0;
        random=seed1.nextInt(6)+1;
        random2=seed2.nextInt(6)+1;
        dice1 = random;
        dice2 = random2;
        switch(random){
            case 1:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_dot.png")));
                break;
            case 2:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_dots.png")));
                break;
            case 3:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3_dots.png")));
                break;
            case 4:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4_dots.png")));
                break;
            case 5:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5_dots.png")));
                break;
            case 6:
                dado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6_dots.png")));
                break;
        }
        switch(random2){
            case 1:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/1_dot.png")));
                break;
            case 2:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/2_dots.png")));
                break;
            case 3:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/3_dots.png")));
                break;
            case 4:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/4_dots.png")));
                break;
            case 5:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5_dots.png")));
                break;
            case 6:
                dado2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/6_dots.png")));
                break;
        }
       }
         };
        timer.schedule(tarea, 0, 100);
    }
}
