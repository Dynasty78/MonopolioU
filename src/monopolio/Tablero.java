
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
        casilla = new Propiedad("Solarium Centro estudiantil",2,570,646,false,200,0,0,25,10,20,30,40,60,10,20,null,"/img/centroestudiantil.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Solarium Mesas",4,454,646,false,200,0,0,30,15,25,35,45,65,10,20,null,"/img/mesas.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Laboratorios fisica electrica",7,275,646,false,200,0,0,35,10,40,50,60,70,20,30,null,"/img/fisicaelectrica.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Laboratorio Arquitectura",9,154,646,false,200,0,0,40,15,45,55,65,75,20,30,null,"/img/arquitectura.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Laboratorio Redes",10,89,646,false,200,0,0,50,20,50,60,70,80,20,30,null,"/img/redes.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 1",12,20,580,false,200,0,0,60,15,55,65,75,85,30,40,null,"/img/modulo1.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 2",14,20,456,false,200,0,0,70,20,60,70,80,90,30,40,null,"/img/modulo2.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 3",15,20,396,false,200,0,0,80,25,75,85,95,105,30,40,null,"/img/modulo3.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 4",17,20,280,false,200,0,0,90,20,80,90,100,110,40,50,null,"/img/modulo4.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 5",19,20,160,false,200,0,0,100,25,85,95,105,115,40,50,null,"/img/modulo5.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Modulo 6",20,20,96,false,200,0,0,80,30,90,100,110,120,40,50,null,"/img/modulo6.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Feria Subway",22,99,20,false,200,0,0,90,35,105,115,125,135,50,60,null,"/img/subway.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Feria Wendy's",24,216,20,false,200,0,0,100,40,100,110,120,130,50,60,null,"/img/wendys.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Feria Presto",25,280,20,false,200,0,0,110,45,115,125,135,145,50,60,null,"/img/presto.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Cincuentenario plantabaja",27,395,20,false,200,0,0,120,40,110,120,130,140,60,70,null,"/img/plantabaja.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Cincuentenario Mezanina",28,454,20,false,200,0,0,130,45,125,135,145,155,60,70,null,"/img/mezanina.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Cincuentenario piso 1",30,570,20,false,200,0,0,140,40,130,140,150,160,60,70,null,"/img/piso1.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 1",32,648,98,false,200,0,0,150,45,135,145,155,165,80,90,null,"/img/biblioteca1.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 2",33,648,164,false,200,0,0,160,50,140,150,160,170,80,90,null,"/img/biblioteca2.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Biblioteca piso 3",35,648,277,false,200,0,0,170,55,145,155,165,175,80,90,null,"/img/biblioteca3.png");
        casillas.add(casilla);
        
        casilla = new Propiedad("Loyola",38,648,455,false,200,0,0,180,70,160,170,190,300,100,120,null,"/img/loyola.png");
        casillas.add(casilla);
        
         casilla = new Propiedad("Aula Magna",40,648,575,false,200,0,0,200,80,180,190,200,400,100,120,null,"/img/aula magna.png");
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Go",1,643,646);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Arca",3,517,646);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Vacio",5,398,646);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Ferrocaril",6,338,646);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",8,218,646);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Carcel",11,25,646);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Electricidad",13,20,520);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",16,20,341);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Arca",18,20,218);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Libre",21,20,35);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",23,160,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",26,338,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Agua",29,516,20);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ve al metro",31,646,20);
        casillas.add(casilla);
        
         casilla = new CasillaVacia("Arca",34,646,215);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Ferrocaril",36,646,342);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Suerte",37,646,398);
        casillas.add(casilla);
        
        casilla = new CasillaVacia("Vacio",39,646,516);
        casillas.add(casilla);
        
        
        
        
        
       
        
    }
    
    public void iterar(){
         for(Casilla casilla: casillas) {
             System.out.println(casilla.getNombre());   
        }
    }
    
}
