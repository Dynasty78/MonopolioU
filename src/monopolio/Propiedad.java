
package monopolio;

import java.io.Serializable;


public class Propiedad extends Casilla implements Serializable {
    
    public boolean dueño;
    public int costoSolar;
    public int numerocasas;
    public int numeroHotel;
    public int hipoteca;
    public int costoAlquiler;
    public int costoUnacasa;
    public int costoDoscasa;
    public int costoTrescasa;
    public int costoHotel;
    public int compraCasa;
    public int compraHotel;
    public Jugador propietario;

    public Propiedad(String nombre, int posicionTablero,int posicionx, int posiciony, boolean dueño, int costoSolar, int numerocasas, int numeroHotel, int hipoteca, int costoAlquiler, int costoUnacasa, int costoDoscasa, int costoTrescasa, int costoHotel, int compraCasa, int compraHotel, Jugador propietario ) {
        super(nombre, posicionTablero,posicionx,posiciony);
        this.dueño = dueño;
        this.costoSolar = costoSolar;
        this.numerocasas = numerocasas;
        this.numeroHotel = numeroHotel;
        this.hipoteca = hipoteca;
        this.costoAlquiler = costoAlquiler;
        this.costoUnacasa = costoUnacasa;
        this.costoDoscasa = costoDoscasa;
        this.costoTrescasa = costoTrescasa;
        this.costoHotel = costoHotel;
        this.compraCasa = compraCasa;
        this.compraHotel = compraHotel;
        this.propietario = propietario;
    }
    
    

    public int getCostoSolar() {
        return costoSolar;
    }

    public void setCostoSolar(int costoSolar) {
        this.costoSolar = costoSolar;
    }

    public int getCostoHotel() {
        return costoHotel;
    }

    public void setCostoHotel(int costoHotel) {
        this.costoHotel = costoHotel;
    }

    public int getCompraCasa() {
        return compraCasa;
    }

    public void setCompraCasa(int compraCasa) {
        this.compraCasa = compraCasa;
    }

    public int getCompraHotel() {
        return compraHotel;
    }

    public void setCompraHotel(int compraHotel) {
        this.compraHotel = compraHotel;
    }

     public int getCostoAlquiler() {
        return costoAlquiler;
    }

    public void setCostoAlquiler(int costoAlquiler) {
        this.costoAlquiler = costoAlquiler;
    }

    public int getHipoteca() {
        return hipoteca;
    }

    public void setHipoteca(int hipoteca) {
        this.hipoteca = hipoteca;
    }

    public int getNumerocasas() {
        return numerocasas;
    }

    public void setNumerocasas(int numerocasas) {
        this.numerocasas = numerocasas;
    }

    public int getNumeroHotel() {
        return numeroHotel;
    }

    public void setNumeroHotel(int numeroHotel) {
        this.numeroHotel = numeroHotel;
    }
    
    public boolean isDueño() {
        return dueño;
    }

    public void setDueño(boolean dueño) {
        this.dueño = dueño;
    }

   
    public int getCostoUnacasa() {
        return costoUnacasa;
    }

    public void setCostoUnacasa(int costoUnacasa) {
        this.costoUnacasa = costoUnacasa;
    }

    public int getCostoDoscasa() {
        return costoDoscasa;
    }

    public void setCostoDoscasa(int costoDoscasa) {
        this.costoDoscasa = costoDoscasa;
    }

    public int getCostoTrescasa() {
        return costoTrescasa;
    }

    public void setCostoTrescasa(int costoTrescasa) {
        this.costoTrescasa = costoTrescasa;
    }

    public Jugador getPropietario() {
        return propietario;
    }

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    @Override
    public void alSalir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alLlegar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
