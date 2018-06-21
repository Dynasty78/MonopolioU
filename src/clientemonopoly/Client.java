
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
import monopolio.*;
import envio.Paquete_enviar;
import java.util.ArrayList;

public class Client extends javax.swing.JFrame implements Runnable{
    
     private static int count = 0;
     public int dice1 = 0, dice2 = 0;
     public Jugador jugadorlocal;
     ArrayList<javax.swing.JLabel> fichas = new ArrayList();
     int nueva_posicion;
     String IPServidor = "192.168.0.105";
     boolean segundoDado;
    
     public Client() {
        initComponents();
        Thread mi_hilo = new Thread(this);
        mi_hilo.start();
        
        
        fichaUsuario1.setVisible(false);
        fichaUsuario2.setVisible(false);
        fichaUsuario3.setVisible(false);
        fichaUsuario4.setVisible(false);
        fichas.add(fichaUsuario1);
        fichas.add(fichaUsuario2);
        fichas.add(fichaUsuario3);
        segundoDado = false;
        fichas.add(fichaUsuario4);
        addWindowListener(new Online());
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fichaUsuario1 = new javax.swing.JLabel();
        fichaUsuario2 = new javax.swing.JLabel();
        fichaUsuario3 = new javax.swing.JLabel();
        fichaUsuario4 = new javax.swing.JLabel();
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
        propiedadPosicion = new javax.swing.JLabel();
        compra = new javax.swing.JButton();
        propiedad = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        fichaUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CarroP.png"))); // NOI18N
        jPanel1.add(fichaUsuario1);
        fichaUsuario1.setBounds(640, 640, 45, 40);

        fichaUsuario2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/SombreroP.png"))); // NOI18N
        jPanel1.add(fichaUsuario2);
        fichaUsuario2.setBounds(640, 640, 50, 40);

        fichaUsuario3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/PerroP.png"))); // NOI18N
        jPanel1.add(fichaUsuario3);
        fichaUsuario3.setBounds(640, 640, 50, 50);

        fichaUsuario4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/DedalP.png"))); // NOI18N
        jPanel1.add(fichaUsuario4);
        fichaUsuario4.setBounds(640, 640, 50, 40);

        imagenTablero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/tablero blanco.png"))); // NOI18N
        imagenTablero.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                imagenTableroMouseMoved(evt);
            }
        });
        jPanel1.add(imagenTablero);
        imagenTablero.setBounds(0, 0, 700, 700);

        dados.setText("Dados");
        dados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dadosActionPerformed(evt);
            }
        });
        jPanel1.add(dados);
        dados.setBounds(790, 670, 80, 23);
        jPanel1.add(dado2);
        dado2.setBounds(860, 590, 65, 73);
        jPanel1.add(dado1);
        dado1.setBounds(940, 590, 65, 73);

        PanelMensaje.setBackground(new java.awt.Color(255, 255, 255));
        PanelMensaje.setLayout(null);

        mensaje.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        PanelMensaje.add(mensaje);
        mensaje.setBounds(20, 70, 380, 40);
        PanelMensaje.add(imagen);
        imagen.setBounds(0, 0, 440, 170);

        jPanel1.add(PanelMensaje);
        PanelMensaje.setBounds(700, 40, 440, 170);

        usuario.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        usuario.setText("Username");
        jPanel1.add(usuario);
        usuario.setBounds(710, 0, 92, 23);

        turno.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jPanel1.add(turno);
        turno.setBounds(840, 0, 160, 20);

        dinero.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jPanel1.add(dinero);
        dinero.setBounds(1010, 0, 130, 20);

        finalizarTurno.setText("Finalizar");
        finalizarTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarTurnoActionPerformed(evt);
            }
        });
        jPanel1.add(finalizarTurno);
        finalizarTurno.setBounds(890, 670, 80, 23);

        jLabel1.setBackground(new java.awt.Color(0, 255, 102));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(770, 340, 50, 50);

        propiedadPosicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blanco.jpg"))); // NOI18N
        jPanel1.add(propiedadPosicion);
        propiedadPosicion.setBounds(800, 290, 250, 290);

        compra.setText("Comprar");
        compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compraActionPerformed(evt);
            }
        });
        jPanel1.add(compra);
        compra.setBounds(990, 670, 90, 23);

        propiedad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        propiedad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propiedadActionPerformed(evt);
            }
        });
        jPanel1.add(propiedad);
        propiedad.setBounds(800, 250, 250, 20);

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jLabel2.setText("Propiedades");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(800, 220, 90, 18);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dadosActionPerformed
     //if(!segundoDado){
        if(jugadorlocal.isTurno()){
            segundoDado = true;
            Paquete_enviar lanzarDados = new Paquete_enviar();
            lanzarDados.setJugador(jugadorlocal);
            lanzarDados.setCodigo(1);
            socketEnviar(lanzarDados);
       }
      else{
          new Thread(new MensajeUI(PanelMensaje,"Aun no es tu turno!",4)).start();
      }
      /*}else{
         new Thread(new MensajeUI(PanelMensaje,"Ya lanzaste los dados",4)).start();
     }*/
    }//GEN-LAST:event_dadosActionPerformed

    private void finalizarTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarTurnoActionPerformed
      if(jugadorlocal.isTurno()){
            segundoDado= false;  
            jugadorlocal.setTurno(false);
            turno.setText("Esperando turno");
            Paquete_enviar finalizarTurno = new Paquete_enviar();
            finalizarTurno.setJugador(jugadorlocal);
            finalizarTurno.setCodigo(2);
            socketEnviar(finalizarTurno);
            
            new Thread(new MensajeUI(PanelMensaje,"Has finalizado tu turno",4)).start();
       }
      else{
          new Thread(new MensajeUI(PanelMensaje,"Aun no es tu turno!",4)).start();
      }
    }//GEN-LAST:event_finalizarTurnoActionPerformed

    private void imagenTableroMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imagenTableroMouseMoved
        /*int x,y;
        x = evt.getX();
        y= evt.getY();
        System.out.println("posicion: "+x+" "+y);*/
    }//GEN-LAST:event_imagenTableroMouseMoved

    private void compraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compraActionPerformed
       if(jugadorlocal.isTurno()){ 
           Paquete_enviar comprar = new Paquete_enviar();
           comprar.setJugador(jugadorlocal);
           comprar.setCodigo(4);
           socketEnviar(comprar);
       }
      else{
          new Thread(new MensajeUI(PanelMensaje,"Aun no es tu turno!",4)).start();
      }
    }//GEN-LAST:event_compraActionPerformed

    private void propiedadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propiedadActionPerformed
      int idpropiedad = propiedad.getSelectedIndex() -1;
        System.out.println(idpropiedad);
      if(idpropiedad==-1){
       
          propiedadPosicion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/blanco.jpg")));
      }else{
          String imagen =jugadorlocal.getPropiedades().get(idpropiedad).getImg();
          propiedadPosicion.setIcon(new javax.swing.ImageIcon(getClass().getResource(imagen)));
      }
      
    }//GEN-LAST:event_propiedadActionPerformed

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
    private javax.swing.JPanel PanelMensaje;
    private javax.swing.JButton compra;
    private javax.swing.JLabel dado1;
    private javax.swing.JLabel dado2;
    private javax.swing.JButton dados;
    private javax.swing.JLabel dinero;
    private javax.swing.JLabel fichaUsuario1;
    private javax.swing.JLabel fichaUsuario2;
    private javax.swing.JLabel fichaUsuario3;
    private javax.swing.JLabel fichaUsuario4;
    private javax.swing.JButton finalizarTurno;
    private javax.swing.JLabel imagen;
    private javax.swing.JLabel imagenTablero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel mensaje;
    private javax.swing.JComboBox<String> propiedad;
    private javax.swing.JLabel propiedadPosicion;
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
                
                switch (codigo) {
                    case 0:
                        //Se le asigna al cliente el jugador enviado por el servidor
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
                    break;
                    case 1:
                        //Se toman las seeds para la animacion de los dados tambien se mueve la ficha del jugador
                            Random seed1, seed2;
                            seed1 = paquete_recibido.getSeed1();
                            seed2 =paquete_recibido.getSeed2();
                            animacionDados(seed1,seed2);
                            Jugador jugadorEnviado = paquete_recibido.getJugador();
                           
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                            }      
                           
                            nueva_posicion =jugadorEnviado.getPosicion()+dice1+dice2;
                            
                            if(nueva_posicion > 40){
                                nueva_posicion = nueva_posicion -40;
                            }  
                            
                            animacionFicha(jugadorEnviado.getPosicion(), nueva_posicion,paquete_recibido.getTablero(),jugadorEnviado.getId());
                            
                            if(jugadorEnviado.getId() == jugadorlocal.getId()){
                                jugadorlocal.setPosicion(nueva_posicion);
                                Paquete_enviar meMovi = new Paquete_enviar();
                                meMovi.setCodigo(5);
                                meMovi.setJugador(jugadorlocal);
                                socketEnviar(meMovi);
                            }  
                            
                            
                    break;
                        
                    case 2:
                        //Se le pasa el turno al jugador
                        jugadorlocal.setTurno(true);
                        new Thread(new MensajeUI(PanelMensaje,"Es tu turno! lanza los dados",4)).start();
                        turno.setText("Tu turno");
                    break;
                    case 3:
                        //Se ponen visibles las fichas dependiendo de la cantidad de jugadores
                        int cantidad = paquete_recibido.getCantidadJugadores();
                        for(int i = 0; i<cantidad; i++){
                            fichas.get(i).setVisible(true);
                        }  
                    break;
                    case 4:
                            //Se le envia un mensaje al jugador si la compra fue exitosa y se añade a sus propiedades
                            Jugador jugador_Enviado = paquete_recibido.getJugador();
                            Tablero tablero = paquete_recibido.getTablero();
                            if(jugador_Enviado.getId() == jugadorlocal.getId()){
                                jugadorlocal =jugador_Enviado;
                                int posicion = jugadorlocal.getPosicion();
                                
                                 Casilla casillaComprada =tablero.buscarCasilla(posicion);
                                 propiedad.addItem(casillaComprada.getNombre());
                                 new Thread(new MensajeUI(PanelMensaje,"Has comprado la propiedad "+casillaComprada.getNombre(),4)).start();
                                 dinero.setText("$: "+jugadorlocal.getDinero());
                                   
                            }
                            else{
                                
                                int posicion = jugador_Enviado.getPosicion();
                                Casilla casillaComprada =tablero.buscarCasilla(posicion);
                                new Thread(new MensajeUI(PanelMensaje,"Eljugador "+jugador_Enviado.getId()+" comprado la propiedad "+casillaComprada.getNombre(),4)).start();
                            }
                    break;
                    case 9: 
                            jugadorlocal = paquete_recibido.getJugador();
                            dinero.setText("$: "+jugadorlocal.getDinero());
                            String mensaje = paquete_recibido.getMensaje();
                            new Thread(new MensajeUI(PanelMensaje,mensaje,4)).start();
                            
                    break;
                    default:
                        break;
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
    
    public void animacionFicha(int posicion, int nueva_posicion,Tablero tablero,int id){
        int i;
        int x;
        int y;
        if(posicion>nueva_posicion){
            for(i = posicion +1; i<=40; i++){
            Casilla casilla = tablero.buscarCasilla(i);
                       x = casilla.getPosicionx();
                       y = casilla.getPosiciony();
                       fichas.get(id-1).setLocation(x, y);
                       fichas.get(id-1).setBounds(x, y,50,40);
                        try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            for(i = 1; i<=nueva_posicion; i++){
            Casilla casilla = tablero.buscarCasilla(i);
                       x = casilla.getPosicionx();
                       y = casilla.getPosiciony();
                       fichas.get(id-1).setLocation(x, y);
                       fichas.get(id-1).setBounds(x, y,50,40);
                        try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }
        for(i = posicion +1; i<=nueva_posicion; i++){
            Casilla casilla = tablero.buscarCasilla(i);
                       x = casilla.getPosicionx();
                       y = casilla.getPosiciony();
                       fichas.get(id-1).setLocation(x, y);
                       fichas.get(id-1).setBounds(x, y,50,40);
                        try {
                        Thread.sleep(400);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
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
    
    public void socketEnviar(Paquete_enviar paquete_enviar){
        try {
            Socket socket = new Socket(IPServidor,9999);
            ObjectOutputStream paquete_datos = new ObjectOutputStream(socket.getOutputStream());
            paquete_datos.writeObject(paquete_enviar);
            socket.close();
            paquete_datos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
