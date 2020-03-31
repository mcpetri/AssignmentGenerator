/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Tehtavageneraattori.Tehtava;
import Tehtavageneraattori.Tehtavageneraattori;
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
public class TehtavaTest {
    
    Tehtava t = new Tehtava();
    //Tehtavageneraattori gene = new Tehtavageneraattori();
    
    @Test
    public void onOlemassa() {
        System.out.println(t.onOlemassa());
    }
}
