
package servidormonopoly;

import envio.Paquete_enviar;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import monopolio.Jugador;
import monopolio.Tablero;

public class Server extends javax.swing.JFrame implements Runnable{
    
    ArrayList<Jugador> jugadores = new ArrayList();
    int idJugador = 0;
    Jugador jugadorActual;
    Tablero tablero;

    public Server() {
        initComponents();
        Thread mi_hilo = new Thread(this);
        mi_hilo.start();
        tablero = new Tablero();
        tablero.generarCasillas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        areatexto = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        areatexto.setColumns(20);
        areatexto.setRows(5);
        jScrollPane1.setViewportView(areatexto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areatexto;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9999);
            int codigo, origen;
            Paquete_enviar mi_paquete;
            ArrayList<String> listaIP = new ArrayList();

            while(true){
                Socket mi_server = server.accept();
                ObjectInputStream paquete_datos = new ObjectInputStream(mi_server.getInputStream());
                mi_paquete = (Paquete_enviar) paquete_datos.readObject();
                codigo = mi_paquete.getCodigo();
                
              
                if(codigo == 1){
                    //Lanzamiento de dados
                    jugadorActual = mi_paquete.getJugador();
                    origen= jugadorActual.getId();
                    areatexto.append("\n"+"El usuario "+origen+" lanzo los dados");
                    
                    //Se crean los random para enviarlos a todos los clientes y que de como resultado la misma animacion
                    
                    Random rd=new Random();
                    Random rd2 = new Random();
                    Paquete_enviar seedDados = new Paquete_enviar();
                    seedDados.setJugador(jugadorActual);
                    seedDados.setSeed1(rd);
                    seedDados.setSeed2(rd2);
                    seedDados.setCodigo(codigo);
                    seedDados.setTablero(tablero);
                    
                    //Le envio los seeds a todos los clientes
                    for(String z:listaIP){
                        Socket enviar_destino = new Socket(z,9090);
                        ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                        envio.writeObject(seedDados);
                        enviar_destino.close();
                        envio.close();
                        mi_server.close();
                        paquete_datos.close();
                        }
                }
                else if(codigo == 0){
                    //Usuario nuevo se ha conectado
                    idJugador++;
                    InetAddress localizacion = mi_server.getInetAddress();
                    String ipremota = localizacion.getHostAddress();
                    listaIP.add(ipremota);
                    areatexto.append("\n"+"Se ha conectado "+ipremota+" Se le asigna el Jugador numero "+idJugador);
                    
                    //Creacion del nuevo jugador
                    Jugador jugador = new Jugador(1500);
                    jugador.setId(idJugador);
                    jugador.setIp(ipremota);
                    jugador.setPosicion(1);
                    if (idJugador == 1){
                        jugador.setTurno(true);
                    }
                    else{
                        jugador.setTurno(false);
                    }
                    
                    
                    //Añadimos el juador a la lista de jugadores
                    jugadores.add(jugador);
                    
                    //Le enviamos el jugador al cliente correspondiente
                    Paquete_enviar nuevoJugador = new Paquete_enviar();
                    nuevoJugador.setCodigo(codigo);
                    nuevoJugador.setJugador(jugador);
                    
                    Socket enviar_destino = new Socket(ipremota,9090);
                    ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                    envio.writeObject(nuevoJugador);
                    enviar_destino.close();
                    envio.close();
                     mi_server.close();
                     paquete_datos.close();
                    
                }
                else if(codigo == 2){
                    //Pasa el turno al siguiente jugador de forma dinamica
                    
                    jugadorActual = mi_paquete.getJugador();
                    areatexto.append("\nEl jugador "+jugadorActual.getId()+" ha finalizado su turno");
                    int cantidadDeJugadores = jugadores.size();
                    int idJugadorActual = jugadorActual.getId();
                    int nuevoTurno;
                    
                    
                    if(cantidadDeJugadores-idJugadorActual != 0){
                        nuevoTurno = idJugadorActual;
                        String ip = jugadores.get(nuevoTurno).getIp();
                        areatexto.append("\nEs el turno del jugador "+jugadores.get(nuevoTurno).getId());
                        Socket enviar_destino = new Socket(ip,9090);
                        Paquete_enviar turno = new Paquete_enviar();
                        turno.setCodigo(2);
                        ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                        envio.writeObject(turno);
                        enviar_destino.close();
                        envio.close();
                        
                    }
                    else{
                        nuevoTurno = 0;
                        String ip = jugadores.get(nuevoTurno).getIp();
                        areatexto.append("\nEs el turno del jugador "+jugadores.get(nuevoTurno).getId());
                        Socket enviar_destino = new Socket(ip,9090);
                        Paquete_enviar turno = new Paquete_enviar();
                        turno.setCodigo(2);
                        ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                        envio.writeObject(turno);
                        enviar_destino.close();
                        envio.close();
                        
                    }
                    
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
