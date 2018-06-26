
package servidormonopoly;

import envio.Paquete_enviar;
import java.io.DataOutputStream;
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
import login.Handler;
import login.User;
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
    
    private Handler handler;

    public Server() {
        initComponents();
        Thread mi_hilo = new Thread(this);
        mi_hilo.start();
        tablero = new Tablero();
        tablero.generarCasillas();
        this.handler = new Handler();
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
                
                Object object = paquete_datos.readObject();
                
                if(object instanceof Paquete_enviar){
                    
                    mi_paquete = (Paquete_enviar) object;
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

                    }
                    else if(codigo == 0){
                        //Usuario nuevo se ha conectado
                        idJugador++;
                        InetAddress localizacion = mi_server.getInetAddress();
                        String ipremota = localizacion.getHostAddress();
                        listaIP.add(ipremota);
                        areatexto.append("\n"+"Se ha conectado "+ipremota+" Se le asigna el Jugador numero "+idJugador);

                        //Creacion del nuevo jugador
                        Jugador jugador = new Jugador(100000);
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

                        socketEnviar(nuevoJugador,ipremota,9090);

                        enviarFichas();

                    }
                    else if(codigo == 2){
                        //Pasa el turno al siguiente jugador de forma dinamica
                        int id;
                        jugadorActual = mi_paquete.getJugador();

                        for(Propiedad propiedad: jugadorActual.getPropiedades()){
                            propiedad.setPropietario(jugadorActual);
                        }

                        for(Propiedad propiedad: jugadorActual.getPropiedades()){
                            id = propiedad.getPosicionTablero();
                            Casilla casillaPropiedad = tablero.buscarCasilla(id);

                          if(casillaPropiedad instanceof Propiedad){
                              ((Propiedad) casillaPropiedad).setPropietario(jugadorActual);
                          }
                        }


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

                            socketEnviar(turno,ip,9090);
                        }
                        else{
                            nuevoTurno = 0;
                            String ip = jugadores.get(nuevoTurno).getIp();
                            areatexto.append("\nEs el turno del jugador "+jugadores.get(nuevoTurno).getId());

                            Paquete_enviar turno = new Paquete_enviar();
                            turno.setCodigo(2);

                            socketEnviar(turno,ip,9090);

                        }

                    }else if(codigo == 4){//Comprar propiedad
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
                                   
                                   Casilla casillaComprada = tablero.buscarCasilla(jugadorActual.getPosicion());
                                   propiedadAcomprar.setName(casillaComprada.getNombre()); 
                                   
                                   Paquete_enviar compra = new Paquete_enviar();
                                   compra.setCodigo(4);
                                   compra.setJugador(jugadorActual);

                                   compra.setTablero(tablero);

                                   broadcast(compra);
                            }else if(jugadorActual.getDinero()<propiedadAcomprar.getCostoSolar()){
                                String ip = jugadorActual.getIp();
                                String mensaje ="No tienes suficiente dinero";
                                Paquete_enviar compra = new Paquete_enviar();
                                compra.setCodigo(9);
                                compra.setMensaje(mensaje);
                                compra.setJugador(jugadorActual);
                                socketEnviar(compra,ip,9090);
                            }else if(propiedadAcomprar.isDueño()){
                                Jugador dueño = propiedadAcomprar.getPropietario();
                                String ip = jugadorActual.getIp();
                                if(dueño.getId() == jugadorActual.getId()){
                                    String mensaje ="Ya eres dueño de esta propiedad";
                                    Paquete_enviar compra = new Paquete_enviar();
                                    compra.setCodigo(9);
                                    compra.setMensaje(mensaje);
                                    compra.setJugador(jugadorActual);
                                    socketEnviar(compra,ip,9090);
                                }else{
                                    String mensaje ="Esta propiedad ya tiene dueño";
                                    Paquete_enviar compra = new Paquete_enviar();
                                    compra.setCodigo(9);
                                    compra.setMensaje(mensaje);
                                    compra.setJugador(jugadorActual);
                                    socketEnviar(compra,ip,9090);
                                }  
                            }
                            
                        }else{
                            String ip = jugadorActual.getIp();
                            String mensaje ="Esta casilla no es una propiedad";
                            Paquete_enviar compra = new Paquete_enviar();
                            compra.setCodigo(9);
                            compra.setMensaje(mensaje);
                            compra.setJugador(jugadorActual);
                            socketEnviar(compra,ip,9090);
                        }
                    }else if(codigo == 5){
                     
                       int posicionJugador;
                        jugadorActual = mi_paquete.getJugador();
                        System.out.println(jugadorActual.getDinero());
                        System.out.println(jugadorActual.getId());
                        posicionJugador = jugadorActual.getPosicion();
                        Casilla casillaJugador = tablero.buscarCasilla(posicionJugador);
                        casillaJugador.alLlegar(jugadorActual);
                        
                    }else if(codigo == 20){//Comprar una casa
                        /*Validar que tengo todas las propiedades del mismo tipo*/
                        Jugador player = mi_paquete.getJugador();//Jugador que hace la solicitud de compra
                        int property_position = mi_paquete.getPropertyPosition();//Correspondiente a la propiedad x (Posicion)
                        Propiedad property = player.getPropiedades().get(property_position);
                        int type_of_property = property.getType();
                        int cantidad_solares = property.getCantidad();
                        String message = mi_paquete.getMensaje();
                        
                        //Busqueda para saber si tengo los demas solares
                        int cont = 0;
                        for(int i = 0; i < player.getPropiedades().size(); i++){//Recorrer todas las propiedades del jugador
                            if(player.getPropiedades().get(i).getType() == type_of_property){
                                cont++;
                            }
                        }
                        if(cantidad_solares == cont){//El judor tiene todas las propiedades
                            if(message.equals("home")){
                                int home_n = property.getNumerocasas();//Numero de casas
                                //Validar que tiene dinero
                                if(player.getDinero() > property.getCompraCasa()){
                                    if(home_n < 3){
                                        //El jugador puede comprarla
                                        property.setNumerocasas(property.getNumerocasas()+1);
                                        int numero_casas = player.getPropiedades().get(property_position).getNumerocasas();
                                        player.getPropiedades().get(property_position).setNumerocasas(numero_casas + 1);
                                        switch (home_n) {
                                            case 0:
                                                player.setDinero(player.getDinero() - property.getCostoUnacasa());
                                                break;
                                            case 1:
                                                player.setDinero(player.getDinero() - property.getCostoDoscasa());
                                                break;
                                            case 2:
                                                player.setDinero(player.getDinero() - property.getCostoTrescasa());
                                                break;
                                            default:
                                                break;
                                        }
                                        String player_ip = player.getIp();
                                        String mensaje = "La casa se ha comprado satisfactoriamente";
                                        Paquete_enviar cool_package = new Paquete_enviar();
                                        cool_package.setPropertyPosition(property_position);
                                        cool_package.setCodigo(20);
                                        cool_package.setMensaje(mensaje);
                                        cool_package.setJugador(player);
                                        socketEnviar(cool_package,player_ip,9000);
                                    }
                                }else{//Error: No tienes suficiente dinero
                                    String player_ip = player.getIp();
                                    String mensaje = "No tienes suficiente dinero";
                                    Paquete_enviar error_package = new Paquete_enviar();
                                    error_package.setCodigo(21);
                                    error_package.setMensaje(mensaje);
                                    error_package.setJugador(player);
                                    socketEnviar(error_package,player_ip,9000);                         
                                }
                            }
                        }else{//Error: Aun no tienes todos los solares
                            String player_ip = player.getIp();
                            String mensaje = "Aun no eres dueño de todos los solares del mismo tipo";
                            Paquete_enviar error_package = new Paquete_enviar();
                            error_package.setCodigo(21);
                            error_package.setMensaje(mensaje);
                            error_package.setJugador(player);
                            socketEnviar(error_package,player_ip,9000);
                        }
                        
                        
                    }
                    
                    mi_server.close();
                    paquete_datos.close();
                    
                }else if(object instanceof User){
                    User user = (User) object;//username and password
                    //Handler handler = new Handler();
                    if(user.getAction().equals("login")){
                        /*Login*/
                        Boolean u = handler.verifignUser(object);
                        InetAddress localizacion = mi_server.getInetAddress();
                        String user_ip = localizacion.getHostAddress();
                        Socket send_client = new Socket(user_ip,9888);
                        DataOutputStream out = new DataOutputStream(send_client.getOutputStream());
                        if(u){
                        /*Send name and lastname to the user*/    
                            out.writeUTF("cool");  
                            ObjectOutputStream object_out = new ObjectOutputStream(send_client.getOutputStream());
                            User user_client = new User(
                                handler.getData("name",object),
                                handler.getData("lastname",object),
                                "","","");
                            object_out.writeObject(user_client);
                        }else{
                            out.writeUTF("login error");
                        }
                    }else if(user.getAction().equals("register")){
                        handler.saveUser(object);
                    }
                }
 
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void socketEnviar(Paquete_enviar paquete_enviar, String IPServidor,int puerto){
        try {
            Socket socket = new Socket(IPServidor,puerto);
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
