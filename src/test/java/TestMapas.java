/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.mapascoe.Persona;
import com.mycompany.mapascoe.Principal;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Alejo02
 */
public class TestMapas {

    public TestMapas() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("iniciando testing");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("finalizando testing");
    }

    /*@Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }*/

    @Test
    public void pruebaPersona() {
        Principal p = new Principal();
        HashMap<Integer, Persona> mapa = p.llenarMapa();

        String resultado = p.buscar(8888, mapa);

        assertEquals(resultado,"Persona : Alejandro"
                + "\n     Hijo : Fernando"
                + "\n         Nieto : Diego");
    }

    @Test
    public void buscarCodigoInexistente() {

        Principal p = new Principal();
        HashMap<Integer, Persona> mapa = p.llenarMapa();

        String resultado = p.buscar(1234, mapa);

        assertEquals(resultado, "no existe la persona");
    }
}
