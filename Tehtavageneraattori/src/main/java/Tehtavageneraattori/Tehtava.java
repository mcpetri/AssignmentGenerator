/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tehtavageneraattori;
import java.util.*;
/**
 *
 * @author petri
 */
public class Tehtava {
    
    Random rand = new Random();
    double vastaus;
    
    public double luoTehtava(String merkki) { //Luo alkeellisen tehtavan annetulle merkkityypille +/-/*/:
        vastaus = 0;
        int luku1 = rand.nextInt(21)+10;            // 10-30
        int luku2 = rand.nextInt(10)+1;             // 1-10
        
        if(merkki.equals("+")) {                    //Yhteenlasku
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " + "+luku2+ " = x");
            vastaus = luku1 + luku2;
        }
        if(merkki.equals("-")) {                    //Vähennyslasku
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " - "+luku2+ " = x");
            vastaus = luku1 - luku2;
        }
        if(merkki.equals("*")) {                    //Kertolasku
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " * "+luku2+ " = x");
            vastaus = luku1 * luku2;
        }
        if(merkki.equals(":")) {                    //Jakolasku
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " : "+luku2+ " = x");
            vastaus = 1.0 * luku1 / luku2;
        }
        
        return vastaus;
    }
    
    public double getVastaus() {
        return vastaus;
    }
    
    public boolean onOlemassa() {
        return true;
    }
    
}
