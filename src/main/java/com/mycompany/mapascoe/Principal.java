/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapascoe;

import java.util.HashMap;
import java.util.Scanner;
import javafx.util.converter.PercentageStringConverter;

/**
 *
 * @author Alejo02
 */
public class Principal {

    
    Scanner sc = new Scanner(System.in);

    public Principal() {
        llenarMapa();
    }

    public HashMap<Integer, Persona> llenarMapa() {
        
        HashMap<Integer, Persona> mapaPersonas = new HashMap<>();
        
        Persona hijo1 = new Persona(1111, "Diego", "Reyes");
        Persona hijo2 = new Persona(2222, "Sebastian", "Bustos");
        Persona hijo3 = new Persona(3333, "Santiago", "Bustos");
        Persona hijo4 = new Persona(4444, "Jose", "Luna");

        Persona padre2 = new Persona(5555, "Orlando", "Bustos");
        Persona padre3 = new Persona(6666, "Fernando", "Reyes");
        Persona padre1 = new Persona(7777, "Fernando", "Reyes");

        Persona abuelo1 = new Persona(8888, "Alejandro", "Reyes");
        Persona abuelo2 = new Persona(9999, "Ricardo", "Bustos");

        padre1.familia.put(hijo1.getCedula(), hijo1);
        padre2.familia.put(hijo2.getCedula(), hijo2);
        padre3.familia.put(hijo3.getCedula(), hijo3);
        padre3.familia.put(hijo4.getCedula(), hijo4);

        abuelo1.familia.put(padre1.getCedula(), padre1);
        abuelo2.familia.put(padre2.getCedula(), padre2);
        abuelo2.familia.put(padre3.getCedula(), padre3);

        mapaPersonas.put(abuelo1.getCedula(), abuelo1);
        mapaPersonas.put(abuelo2.getCedula(), abuelo2);

        return mapaPersonas;
    }

    public void ejecutar(){
        
        System.out.print("Ingrese el codigo de la persona que desea buscar : ");
        Integer codigo = sc.nextInt();
        
        HashMap<Integer, Persona> mapa = llenarMapa();
        
        System.err.println(buscar(codigo, mapa));
    }
    
    public String buscar(Integer codigo, HashMap<Integer, Persona> mapaFamilia) {
        System.out.println("Ingrese el documento : ");
        Integer cc = sc.nextInt();

        if (mapPersons.containsKey(cc)) {
            Persona person2 = mapPersons.get(cc);
            System.out.println(person2.getNombre());
            for (Integer i1 : person2.familia.keySet()) {
                Persona p = person2.familia.get(i1);
                System.out.println("    HIJOS");
                System.out.println("    " + p.getNombre());
                for (Integer i2 : p.familia.keySet()) {
                    Persona p2 = p.familia.get(i2);
                    System.out.println("        NIETO");
                    System.out.println("        " + p2.getNombre());

                }
            }

        } else {
            for (Integer iterador : mapPersons.keySet()) {
                Persona person3 = mapPersons.get(iterador);
                if (person3.familia.containsKey(cc)) {
                    Persona person4 = person3.familia.get(cc);
                    System.out.println("Persona");
                    System.out.println(person4.getNombre());
                    System.out.println("Padre de " + person4.getNombre());
                    System.out.println(person3.getNombre());
                    for (Integer i3 : person4.familia.keySet()) {
                        Persona p3 = person4.familia.get(i3);
                        System.out.println("        hijos de "+ person4.getNombre());
                        System.out.println("        " + p3.getNombre());

                    }
                } else {
                    for (Integer iterador2 : person3.familia.keySet()) {
                        Persona person5 = person3.familia.get(iterador2);
                        if (person5.familia.containsKey(cc)) {
                            Persona person6 = person5.familia.get(cc);
                            System.out.println("Persona");
                            System.out.println(person6.getNombre());
                            System.out.println("Padre de " + person6.getNombre());
                            System.out.println(person5.getNombre());
                            System.out.println("Abuelo de " + person6.getNombre());
                            System.out.println(person3.getNombre());
                        }
                    }
                }
            }
        }
    }

}
