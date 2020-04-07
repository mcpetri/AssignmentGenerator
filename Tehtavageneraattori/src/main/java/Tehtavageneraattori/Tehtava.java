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
    Laskin laskin = new Laskin();
    Random rand = new Random();
    double vastaus;
    public double luoTehtava(final String merkki) { //Luo alkeellisen tehtavan annetulle merkkityypille +/-/*/:
        vastaus = 0;
        if (merkki.equals("+")) {                   //Yhteenlasku
            int luku1 = rand.nextInt(100) + 1;      //1-100
            int luku2 = rand.nextInt(100) + 1;
            System.out.println("Ratkaise x kun, \n"
                     + luku1 + " + " + luku2 + " = x");
            String tempLauseke = String.valueOf(luku1) + "+" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals("-")) {                       //Vähennyslasku, varmistutaan että luku1 > luku2 jotta vastaus > 0
            int luku2 = rand.nextInt(100) + 1;          //1-100
            int luku1 = rand.nextInt(100) + luku2;      //luku2 + 1-100
            System.out.println("Ratkaise x kun, \n"
                     + luku1 + " - " + luku2 + " = x");
            String tempLauseke = String.valueOf(luku1) + "-" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals("*")) {                       //Kertolasku
            int luku1 = rand.nextInt(100) + 1;          //1-100
            int luku2 = rand.nextInt(100) + 1;
            System.out.println("Ratkaise x kun, \n"
                     + luku1 + " * " + luku2 + " = x");
            String tempLauseke = String.valueOf(luku1) + "*" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals(":")) {                       //Jakolasku, varmistutaan taas että luku1 > luku2 jotta vastaus >= 1
            int luku2 = rand.nextInt(100) + 1;          //1-100
            int luku1 = rand.nextInt(100) + luku2;      //luku2 + 1-100
            System.out.println("Ratkaise x kun, \n"
                     + luku1 + " : " + luku2 + " = x");
            String tempLauseke = String.valueOf(luku1) + "/" + String.valueOf(luku2);
            vastaus = laskin.laske(tempLauseke);
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
