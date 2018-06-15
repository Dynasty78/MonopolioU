
package clientemonopoly;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectOutputStream;
import java.net.Socket;
import envio.Paquete_enviar;

public class Online extends WindowAdapter{
    @Override
    public void windowOpened(WindowEvent e){
        try{
            Socket socket =new Socket("192.168.0.105",9999);
            Paquete_enviar paquete = new Paquete_enviar();
            paquete.setCodigo(0);
            ObjectOutputStream paquete_datos= new ObjectOutputStream(socket.getOutputStream());
            paquete_datos.writeObject(paquete);
            socket.close();  
        }catch(Exception ex){
            
        }
        
    }
    
}
