/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

import java.util.Random;

/**
 *
 * @author petri
 */
public class Tehtava {
    private static final int MAKSIMIVAIHTELU = 100;
    Laskin laskin = new Laskin();
    Random rand = new Random();
    String lauseke;
    double vastaus;
    public double luoTehtava(final String merkki) {
        vastaus = 0;
        if (merkki.equals("+")) { //Yhteenlasku
            int luku1 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            int luku2 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            lauseke = "Ratkaise x kun, \n" + luku1 + " + " + luku2 + " = x";
            String tempLauseke = String.valueOf(luku1) + "+" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals("-")) { //Vähennyslasku
            int luku2 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            int luku1 = rand.nextInt(MAKSIMIVAIHTELU) + luku2;
            lauseke = "Ratkaise x kun, \n" + luku1 + " - " + luku2 + " = x";
            String tempLauseke = String.valueOf(luku1) + "-" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals("*")) { //Kertolasku
            int luku1 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            int luku2 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            lauseke = "Ratkaise x kun, \n" + luku1 + " * " + luku2 + " = x";
            String tempLauseke = String.valueOf(luku1) + "*" + String.valueOf(luku2);
            vastaus = (int) laskin.laske(tempLauseke);
        }
        if (merkki.equals(":")) { //Jakolasku
            int luku2 = rand.nextInt(MAKSIMIVAIHTELU) + 1;
            int luku1 = rand.nextInt(MAKSIMIVAIHTELU) + luku2;
            lauseke = "Ratkaise x kun, \n" + luku1 + " : " + luku2 + " = x";
            String tempLauseke = String.valueOf(luku1) + "/" + String.valueOf(luku2);
            vastaus = laskin.laske(tempLauseke);
        }
        return vastaus;
    }
    public double getVastaus() {
        return vastaus;
    }
    public String getLauseke() {
        return lauseke;
    }
    public boolean tarkistus(String tarkistettava) {
        double parse = Double.parseDouble(tarkistettava);
        double tulos = Math.round(vastaus * 100.0) / 100.0;
        return parse == tulos;
    }
}
