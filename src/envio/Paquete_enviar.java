package envio;

import java.io.Serializable;
import java.util.Random;
import monopolio.Jugador;
import monopolio.Tablero;

public class Paquete_enviar implements Serializable {
   Jugador jugador;
   int codigo;
   Random seed1, seed2;
   int cantidadJugadores;
   boolean compraExitosa;

    public boolean isCompraExitosa() {
        return compraExitosa;
    }

    public void setCompraExitosa(boolean compraExitosa) {
        this.compraExitosa = compraExitosa;
    }

    public int getCantidadJugadores() {
        return cantidadJugadores;
    }

    public void setCantidadJugadores(int cantidadJugadores) {
        this.cantidadJugadores = cantidadJugadores;
    }
   
   Tablero tablero;

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

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
