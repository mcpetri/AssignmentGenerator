/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import generaattoriapp.logic.Tehtava;

/**
 *
 * @author petri
 */
public class TehtavaTest {
    
    Tehtava testiTehtava = new Tehtava();
    
    @Test
    public void testiYhteen() {
        testiTehtava.luoTehtava("+");
        assertEquals(true,testiTehtava.getLauseke().contains("+"));
    }
    
    @Test
    public void testiVahennys() {
        testiTehtava.luoTehtava("-");
        assertEquals(true,testiTehtava.getLauseke().contains("-"));
    }
    
    @Test
    public void testiKerto() {
        testiTehtava.luoTehtava("*");
        assertEquals(true,testiTehtava.getLauseke().contains("*"));
    }
    
    @Test
    public void testiJako() {
        testiTehtava.luoTehtava(":");
        assertEquals(true,testiTehtava.getLauseke().contains("/"));
    }
    
}
