/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

import generaattoriapp.logic.Laskin;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petri
 */
public class LaskinTest {
    
    Laskin testiLaskin = new Laskin();
    //laske() palauttaa doublen
    
    @Test
    public void testi1() {
        String lauseke = "1-(1+1)+1";
        double vastaus = 0.0;
        assertEquals(vastaus, testiLaskin.laske(lauseke), 0);
    }
    
    @Test
    public void testi2() {
        String lauseke = "(3*6)-(3*2)";
        double vastaus = 12.0;
        assertEquals(vastaus, testiLaskin.laske(lauseke), 0);
    }
    
    @Test
    public void testi3() {
        String lauseke = "4*5-6";
        double vastaus = 14.0;
        assertEquals(vastaus, testiLaskin.laske(lauseke), 0);
    }
    
    @Test
    public void testi4() {
        String lauseke = "2*4-4*8";
        double vastaus = -24.0;
        assertEquals(vastaus, testiLaskin.laske(lauseke), 0);
    }
    
}
