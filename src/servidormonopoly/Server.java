
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
import monopolio.Casilla;
import monopolio.Jugador;
import monopolio.Propiedad;
import monopolio.Tablero;

public class Server extends javax.swing.JFrame implements Runnable{
    
    ArrayList<Jugador> jugadores = new ArrayList();
    ArrayList<String> listaIP = new ArrayList();
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
    public void enviarFichas(){
        //Enviar fichas a todos los jugadores cada vez que se conecte uno nuevo.
        Paquete_enviar fichas = new Paquete_enviar();
        fichas.setCodigo(3);
        fichas.setCantidadJugadores(jugadores.size());
        broadcast(fichas);
        /*for(String z:listaIP){
            try {
                Socket enviar_destino = new Socket(z,9090);
                ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                envio.writeObject(fichas);
                enviar_destino.close();
                envio.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
         }*/
    }
    @Override
    public void run() {
        try {
            ServerSocket server = new ServerSocket(9999);
            int codigo, origen;
            Paquete_enviar mi_paquete;
            

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
                    
                    broadcast(seedDados);
                    /*for(String z:listaIP){
                        Socket enviar_destino = new Socket(z,9090);
                        ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                        envio.writeObject(seedDados);
                        enviar_destino.close();
                        envio.close();
                        
                        }*/
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
                    
                    socketEnviar(nuevoJugador,ipremota);
                    
                    enviarFichas();
                    
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
                       
                        Paquete_enviar turno = new Paquete_enviar();
                        turno.setCodigo(2);
                       
                        socketEnviar(turno,ip);
                    }
                    else{
                        nuevoTurno = 0;
                        String ip = jugadores.get(nuevoTurno).getIp();
                        areatexto.append("\nEs el turno del jugador "+jugadores.get(nuevoTurno).getId());
                        
                        Paquete_enviar turno = new Paquete_enviar();
                        turno.setCodigo(2);
                        
                        socketEnviar(turno,ip);
                        
                    }
                    
                }else if(codigo == 4){
                    int posicionJugador;
                    jugadorActual = mi_paquete.getJugador();
                    posicionJugador = jugadorActual.getPosicion();
                    Casilla casillaJugador = tablero.buscarCasilla(posicionJugador);
                    
                    if(casillaJugador instanceof Propiedad){
                       
                        Propiedad propiedadAcomprar = (Propiedad) casillaJugador;
                        if(jugadorActual.getDinero()>propiedadAcomprar.getCostoSolar() && !propiedadAcomprar.isDueño()){
                            
                                propiedadAcomprar.setPropietario(jugadorActual);
                                propiedadAcomprar.setDueño(true);
                                jugadorActual.getPropiedades().add(propiedadAcomprar);
                                jugadorActual.setDinero(jugadorActual.getDinero()-propiedadAcomprar.getCostoSolar());

                                

                               Paquete_enviar compra = new Paquete_enviar();
                               compra.setCodigo(4);
                               compra.setJugador(jugadorActual);

                               compra.setTablero(tablero);

                               broadcast(compra);
                     }
                        else if(jugadorActual.getDinero()<propiedadAcomprar.getCostoSolar()){
                            String ip = jugadorActual.getIp();
                            String mensaje ="No tienes suficiente dinero";
                            Paquete_enviar compra = new Paquete_enviar();
                            compra.setCodigo(9);
                            compra.setMensaje(mensaje);
                            compra.setJugador(jugadorActual);
                            socketEnviar(compra,ip);
                        }
                        else if(propiedadAcomprar.isDueño()){
                            Jugador dueño = propiedadAcomprar.getPropietario();
                            String ip = jugadorActual.getIp();
                            if(dueño.getId() == jugadorActual.getId()){
                                String mensaje ="Ya eres dueño de esta propiedad";
                                Paquete_enviar compra = new Paquete_enviar();
                                compra.setCodigo(9);
                                compra.setMensaje(mensaje);
                                compra.setJugador(jugadorActual);
                                socketEnviar(compra,ip);
                            }else{
                                String mensaje ="Esta propiedad ya tiene dueño";
                                Paquete_enviar compra = new Paquete_enviar();
                                compra.setCodigo(9);
                                compra.setMensaje(mensaje);
                                compra.setJugador(jugadorActual);
                                socketEnviar(compra,ip);
                            }  
                        }
                    }
                    else{
                        String ip = jugadorActual.getIp();
                        String mensaje ="Esta casilla no es una propiedad";
                        Paquete_enviar compra = new Paquete_enviar();
                        compra.setCodigo(9);
                        compra.setMensaje(mensaje);
                        compra.setJugador(jugadorActual);
                        socketEnviar(compra,ip);
                    }
                }
                else if(codigo == 5){
                    
                   /* int posicionJugador;
                    jugadorActual = mi_paquete.getJugador();
                    posicionJugador = jugadorActual.getPosicion();
                    Casilla casillaJugador = tablero.buscarCasilla(posicionJugador);*/
                }
                mi_server.close();
                paquete_datos.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void socketEnviar(Paquete_enviar paquete_enviar, String IPServidor){
        try {
            Socket socket = new Socket(IPServidor,9090);
            ObjectOutputStream paquete_datos = new ObjectOutputStream(socket.getOutputStream());
            paquete_datos.writeObject(paquete_enviar);
            socket.close();
            paquete_datos.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void broadcast(Paquete_enviar paquete_enviar){
        for(String z:listaIP){
            try {
                Socket enviar_destino = new Socket(z,9090);
                ObjectOutputStream envio = new ObjectOutputStream(enviar_destino.getOutputStream());
                envio.writeObject(paquete_enviar);
                enviar_destino.close();
                envio.close();
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
    }
}
