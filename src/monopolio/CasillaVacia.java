/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolio;

/**
 *
 * @author Manuel
 */
public class CasillaVacia extends Casilla {
    
    public CasillaVacia(String nombre, int posicionTablero, int posicionx, int posiciony ) {
        super(nombre, posicionTablero,posicionx,posiciony);
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
