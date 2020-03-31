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
    
    public double luoTehtava(String merkki) { //Luo alkeellisen tehtavan annetulle merkkityypille +/-/*/:
        double vastaus = 0;
        int luku1 = rand.nextInt(21)+10;
        int luku2 = rand.nextInt(10)+1;
        if(merkki.equals("+")) {
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " + "+luku2+ " = x");
            vastaus = luku1 + luku2;
        }
        if(merkki.equals("-")) {
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " - "+luku2+ " = x");
            vastaus = luku1 - luku2;
        }
        if(merkki.equals("*")) {
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " * "+luku2+ " = x");
            vastaus = luku1 * luku2;
        }
        if(merkki.equals(":")) {
            System.out.println("Ratkaise x kun, \n"
                    + luku1+ " : "+luku2+ " = x");
            vastaus = 1.0 * luku1 / luku2;
        }
        
        return vastaus;
    }
    
}
