
package monopolio;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import envio.Paquete_enviar;


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
    public String img;
    public Jugador propietario;
    
    private String name;
    private int type;//1,2,3,4,5,6,7 or 8
    private int cantidad_solares;
    
    public Propiedad(String nombre, int posicionTablero,int posicionx, int posiciony, boolean dueño, int costoSolar, int numerocasas, int numeroHotel, int hipoteca, int costoAlquiler, int costoUnacasa, int costoDoscasa, int costoTrescasa, int costoHotel, int compraCasa, int compraHotel, Jugador propietario, String img,int type,int cantidad_solares ) {
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
        this.img = img;
        this.type = type;
        this.cantidad_solares = cantidad_solares;
    }
    
    public int getType(){
        return this.type;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public int getCantidad(){
        return this.cantidad_solares;
    }
    
    public void setCantidad(int cantidad_solares){
        this.cantidad_solares = cantidad_solares;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    @Override
    public void alSalir() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alLlegar(Jugador jugador) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(!dueño){
           String mensaje ="Esta propiedad se puede comprar";
           Paquete_enviar notieneDueño = new Paquete_enviar();
           notieneDueño.setCodigo(9);
           notieneDueño.setMensaje(mensaje);
           notieneDueño.setJugador(jugador);
           socketEnviar(notieneDueño,jugador.getIp());       
       }
       else if(jugador.getId() != propietario.getId()){
           if(numerocasas == 0){
               String pagar = "Has pagado "+costoAlquiler+" del alquiler de "+nombre;
               String ganar = "Has ganado "+costoAlquiler+" del alquiler de "+nombre;
               
               
               jugador.setDinero(jugador.getDinero()-costoAlquiler);
               propietario.setDinero(propietario.getDinero()+costoAlquiler);
               System.out.println("Soy el dueño "+propietario.isTurno());
               System.out.println("Soy el jugador "+jugador.isTurno());
               Paquete_enviar pagado = new Paquete_enviar();
               pagado.setJugador(jugador);
               pagado.setMensaje(pagar);
               pagado.setCodigo(9);
               
               Paquete_enviar ganado = new Paquete_enviar();
               ganado.setJugador(propietario);
               ganado.setMensaje(ganar);
               ganado.setCodigo(9);
               
               socketEnviar(pagado,jugador.getIp());
               socketEnviar(ganado,propietario.getIp());
           }
       }
    }
    
}
