/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopolio;

import java.util.ArrayList;

/**
 *
 * @author Manuel
 */
public class PruebaLista {
    public static void main(String[] args) {
        ArrayList<Persona> listaPersona = new ArrayList<>();
        Persona persona = new Persona ("Manuel",22);
        listaPersona.add(persona);
         persona = new Persona ("Isabel",17);
        listaPersona.add(persona);
         persona = new Persona ("Laura",50);
        listaPersona.add(persona);
          persona = new Persona ("Frency",71);
        listaPersona.add(persona);
         persona = new Persona ("Evelyn",42);
        listaPersona.add(persona);
        
        for(Persona person: listaPersona){
            System.out.println("Nombre: "+person.getNombre()+" Edad: "+person.getEdad());
        }
        
        
        Persona per = listaPersona.get(0);
        per = listaPersona.get(2);
        
       
        for(Persona person: listaPersona){
            System.out.println("Nombre: "+person.getNombre()+" Edad: "+person.getEdad());
        }
    }
}
