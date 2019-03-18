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

    public void inicio() {

        System.out.print("Ingrese el codigo de la persona que desea buscar : ");
        Integer codigo = sc.nextInt();

        HashMap<Integer, Persona> mapa = llenarMapa();

        System.err.println(buscar(codigo, mapa));
    }

    public String buscar(int codigo, HashMap<Integer, Persona> mapaFamilia) {
        
        String returnRta = "";
        boolean existe=false;

        for (Integer iterador_abuelo : mapaFamilia.keySet()) {
            Persona abuelo = mapaFamilia.get(iterador_abuelo);
            if (abuelo.getCedula()==codigo) {
                returnRta = returnRta + "Persona : " + abuelo.getNombre();
                existe = true;
            }
            for (Integer iterador_padre : abuelo.familia.keySet()) {
                Persona padre = abuelo.familia.get(iterador_padre);
                if (abuelo.getCedula() == codigo) {
                    returnRta = returnRta + "\n     Hijo : " + padre.getNombre();
                }
                if (padre.getCedula() == codigo) {
                    returnRta = returnRta + "\nPersona : " + padre.getNombre();
                    returnRta = returnRta + "\n     Padre : " + abuelo.getNombre();
                    existe=true;
                }
                for (Integer iterador_hijo : padre.familia.keySet()) {
                    Persona hijo = padre.familia.get(iterador_hijo);
                    if (abuelo.getCedula() == codigo) {
                        returnRta = returnRta + "\n         Nieto : " + hijo.getNombre();
                    }
                    if (padre.getCedula() == codigo) {
                        returnRta = returnRta + "\n     Hijo : " + hijo.getNombre();
                    }
                    if (hijo.getCedula() == codigo) {
                        returnRta = returnRta + "Persona : " + hijo.getNombre();
                        returnRta = returnRta + "\n     Padre : " + padre.getNombre();
                        returnRta = returnRta + "\n         Abuelo : " + abuelo.getNombre();
                        existe=true;
                    }

                }

            }

        }
        if(existe == false){
            returnRta = "no existe la persona";
        }
        return returnRta;
    }

}
