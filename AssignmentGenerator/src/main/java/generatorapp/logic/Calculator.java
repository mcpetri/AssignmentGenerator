/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

/**
 * Laskin -luokka laskee sille annetun lausekkeen,
 * joka ei sisällä välilyöntejä tai muita ylimäärisiä
 * merkkejä kuin +,-,*,/,(,)
 * @author petri
 */
public class Calculator {
    /**
     *
     * @param expression annettu lauseke laskimelle
     * 
     * @return vastaus annettuun lausekkeeseen doublena
     */
    public double count(final String expression) {
        return new Object() {
            private int index = -1;
            private int character = -1;
            /**
             * Asetetaan seuraava merkki
             */
            void next() {
                if (++index < expression.length()) {
                    character = expression.charAt(index);
                } else {
                    character = -1;
                }
            }
            /**
             * Liikutaan seuraavaan merkkiin lausekkeessa
             */
            boolean eat(final int eatable) { 
                if (character == eatable) {
                    next();
                    return true;
                }
                return false;
            }
            /**
             * laske metodi aloittaa tästä omalla parse()
             * kutsullaan ja lähtee liikkumaan lausekkeessa
             * merkki kerrallaan lauseke->termi->tekija
             */
            double parse() {
                next();
                double x = parseSymbol();
                if (index < expression.length()) {
                    throw new RuntimeException("Virhe merkillä: " + (char) character);
                }
                return x;
            }
            /**
             * Käsittelee plussat ja miinukset
             */
            double parseSymbol() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) { //Yhteenlasku
                        x += parseTerm();
                    } else if (eat('-')) { //Vähennyslasku
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }
            /**
             * Käsittelee kerrot ja jaot
             */
            double parseTerm() {
                double x = parseVariable();
                for (;;) {
                    if (eat('*')) { //Kertolasku
                        x *= parseVariable();
                    } else if (eat('/')) { //Jakolasku
                        x /= parseVariable();
                    }  else {
                        return x;
                    }
                }
            }
            /**
             * Käsittelee etumerkit, sulkeet ja numerot
             */
            double parseVariable() {
                if (eat('+')) {
                    return parseVariable(); //Etumerkki plus
                }
                if (eat('-')) {
                    return -parseVariable(); //Etumerkki miinus
                }
                double x;
                int beginningIndex = this.index;
                if (eat('(')) { //Sulkeet
                    x = parseSymbol();
                    eat(')');
                } else if ((character >= '0' && character <= '9') || character == '.') {
                    while ((character >= '0' && character <= '9') || character == '.') {
                        next();
                    }
                    x = Double.parseDouble(expression.substring(beginningIndex, this.index));
                } else {
                    throw new RuntimeException("Virhe merkillä: " + (char) character);
                }
                return x;
            }
        }.parse();
    }
}
