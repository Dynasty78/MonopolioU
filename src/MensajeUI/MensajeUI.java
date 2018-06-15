package MensajeUI;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alexd
 * Descripcion: Hilo que muestra un mensaje en pantalla y luego lo oculta;
 */
public class MensajeUI implements Runnable{
    JPanel PanelMensaje;
    int duracion;
    String mensaje;
    JLabel texto;
    JLabel imagen;

    // Parametros: PanelMensaje: panel a mostrar
    //             mensajeL mensaje a mostrar
    //             duracionL segundos que se mostrara el mensaje
    public MensajeUI(JPanel Panelmensaje, String mensaje, int duracion) {
        this.PanelMensaje = Panelmensaje;
        this.duracion = duracion;
        texto = (JLabel)this.PanelMensaje.getComponent(0);
        
        imagen = (JLabel)this.PanelMensaje.getComponent(1);
        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/celeste.png")));
        texto.setText(mensaje);
        this.mensaje = mensaje; 
        
    }
    
    
    @Override
    public void run() {
        imagen.setVisible(true);
        texto.setText(mensaje);
        
        try{Thread.sleep( duracion*1000);
        }   catch (InterruptedException ex) {
            Logger.getLogger(MensajeUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        imagen.setVisible(false);
        texto.setText("");
       
        
    } 
}