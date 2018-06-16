
package monopolio;

import java.io.Serializable;
import java.util.ArrayList;


public class Tablero implements Serializable{
    ArrayList<Casilla> casillas;

    public ArrayList<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(ArrayList<Casilla> casillas) {
        this.casillas = casillas;
    }

    public Tablero() {
        casillas = new ArrayList<>();
    }
    
    public Casilla buscarCasilla(int posicion){
        int posicionTablero;
        Casilla casill= null;
        for(Casilla casilla: casillas) {
            posicionTablero = casilla.getPosicionTablero();
            if(posicion == posicionTablero) {
                casill = casilla;
            }            
        }
        return casill;
    }
    
   
    public void generarCasillas(){
        
        //Genera las casillas del tablero
        
        Casilla casilla;
        casilla = new Propiedad("Solarium Centro estudiantil",2,655,740,false,200,0,0,25,10,20,30,40,60,10,20,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Solarium Mesas",4,520,740,false,200,0,0,30,15,25,35,45,65,10,20,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Laboratorios fisica electrica",7,320,740,false,200,0,0,35,10,40,50,60,70,20,30,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Laboratorio Arquitectura",9,177,740,false,200,0,0,40,15,45,55,65,75,20,30,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Laboratorio Redes",10,120,740,false,200,0,0,50,20,50,60,70,80,20,30,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 1",12,20,650,false,200,0,0,60,15,55,65,75,85,30,40,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 2",14,20,520,false,200,0,0,70,20,60,70,80,90,30,40,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 3",15,20,455,false,200,0,0,80,25,75,85,95,105,30,40,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 4",17,20,320,false,200,0,0,90,20,80,90,100,110,40,50,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 5",19,20,180,false,200,0,0,100,25,85,95,105,115,40,50,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 6",20,20,114,false,200,0,0,80,30,90,100,110,120,40,50,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Feria Subway",22,110,20,false,200,0,0,90,35,105,115,125,135,50,60,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Feria Wendy's",24,240,20,false,200,0,0,100,40,100,110,120,130,50,60,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Feria Presto",25,320,20,false,200,0,0,110,45,115,125,135,145,50,60,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Cincuentenario plantabaja",27,450,20,false,200,0,0,120,40,110,120,130,140,60,70,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Cincuentenario Mezanina",28,520,20,false,200,0,0,130,45,125,135,145,155,60,70,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Cincuentenario piso 1",30,650,20,false,200,0,0,140,40,130,140,150,160,60,70,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 1",32,740,114,false,200,0,0,150,45,135,145,155,165,80,90,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 2",33,740,183,false,200,0,0,160,50,140,150,160,170,80,90,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 3",35,740,320,false,200,0,0,170,55,145,155,165,175,80,90,null);
        casillas.add(casilla);
        
        casilla = new Propiedad("Loyola",38,740,520,false,200,0,0,180,70,160,170,190,300,100,120,null);
        casillas.add(casilla);
        
         casilla = new Propiedad("Aula Magna",40,740,660,false,200,0,0,200,80,180,190,200,400,100,120,null);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Go",1,740,740);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Arca",3,588,740);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Vacio",5,450,740);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Ferrocaril",6,386,740);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",8,255,740);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Carcel",11,25,740);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Electricidad",13,20,584);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",16,20,387);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Arca",18,20,243);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Libre",21,20,30);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",23,180,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",26,388,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Agua",29,588,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ve al metro",31,736,20);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Arca",34,738,251);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",36,738,386);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",37,738,451);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Vacio",39,738,592);
        casillas.add(casilla);
        
        
        
        
        
       
        
    }
    
}
