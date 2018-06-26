
package monopolio;

import java.io.Serializable;
import java.util.ArrayList;


public class Jugador implements Serializable{
    
    int id, dinero,posicion;
    boolean turno;
    String nombre;
    ArrayList<Propiedad> propiedades = new ArrayList(); 

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }   

    public int getPosicion() {
        return posicion;
    }

    public Jugador(int id, int dinero, int posicion, boolean turno, String nombre) {
        this.id = id;
        this.dinero = dinero;
        this.posicion = posicion;
        this.turno = turno;
        this.nombre = nombre;
        
    }

    public ArrayList<Propiedad> getPropiedades() {
        return propiedades;
    }

    public void setPropiedades(ArrayList<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }
    String ip;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    

    public Jugador(int dinero) {
        this.dinero = dinero;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
}
