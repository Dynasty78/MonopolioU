package envio;

import java.io.Serializable;
import java.util.Random;
import monopolio.Jugador;

public class Paquete_enviar implements Serializable {
   Jugador jugador;
   int codigo;
   Random seed1, seed2;

    public Random getSeed1() {
        return seed1;
    }

    public void setSeed1(Random seed1) {
        this.seed1 = seed1;
    }

    public Random getSeed2() {
        return seed2;
    }

    public void setSeed2(Random seed2) {
        this.seed2 = seed2;
    }
  
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
   
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    } 
}
