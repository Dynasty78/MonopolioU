
package monopolio;

import java.io.Serializable;


public abstract class Casilla implements Serializable{
    
    public String nombre;
    public int posicionTablero;
    public int posicionx;
    public int posiciony;
    //Casilla generica todos heredan de aqui

    public Casilla(String nombre, int posicionTablero, int posicionx, int posiciony) {
        this.nombre = nombre;
        this.posicionTablero = posicionTablero;
        this.posicionx = posicionx;
        this.posiciony = posiciony;
    }

    public int getPosicionx() {
        return posicionx;
    }

    public void setPosicionx(int posicionx) {
        this.posicionx = posicionx;
    }

    public int getPosiciony() {
        return posiciony;
    }

    public void setPosiciony(int posiciony) {
        this.posiciony = posiciony;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getPosicionTablero() {
        return posicionTablero;
    }

    public void setPosicionTablero(int posicionTablero) {
        this.posicionTablero = posicionTablero;
    }

    
    public abstract void alSalir();
    public abstract void alLlegar();
}