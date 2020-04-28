/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

/**
 * Laskin -luokka laskee sille annetun lausekkeen,
 * joka ei sisällä välilyöntejä tai muita ylimäärisiä
 * merkkejä kuin +,-,*,/,(,)
 * @author petri
 */
public class Laskin {
    /**
     *
     * @param lauseke annettu lauseke laskimelle
     * 
     * @return vastaus annettuun lausekkeeseen doublena
     */
    public double laske(final String lauseke) {
        return new Object() {
            private int indeksi = -1;
            private int merkki = -1;
            /**
             * Asetetaan seuraava merkki
             */
            void seuraava() {
                if (++indeksi < lauseke.length()) {
                    merkki = lauseke.charAt(indeksi);
                } else {
                    merkki = -1;
                }
            }
            /**
             * Liikutaan seuraavaan merkkiin lausekkeessa
             */
            boolean poista(final int poistettava) { 
                if (merkki == poistettava) {
                    seuraava();
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
                seuraava();
                double x = parseLauseke();
                if (indeksi < lauseke.length()) {
                    throw new RuntimeException("Virhe merkillä: " + (char) merkki);
                }
                return x;
            }
            /**
             * Käsittelee plussat ja miinukset
             */
            double parseLauseke() {
                double x = parseTermi();
                for (;;) {
                    if      (poista('+')) { //Yhteenlasku
                        x += parseTermi();
                    } else if (poista('-')) { //Vähennyslasku
                        x -= parseTermi();
                    } else {
                        return x;
                    }
                }
            }
            /**
             * Käsittelee kerrot ja jaot
             */
            double parseTermi() {
                double x = parseTekija();
                for (;;) {
                    if (poista('*')) { //Kertolasku
                        x *= parseTekija();
                    } else if (poista('/')) { //Jakolasku
                        x /= parseTekija();
                    }  else {
                        return x;
                    }
                }
            }
            /**
             * Käsittelee etumerkit, sulkeet ja numerot
             */
            double parseTekija() {
                if (poista('+')) {
                    return parseTekija(); //Etumerkki plus
                }
                if (poista('-')) {
                    return -parseTekija(); //Etumerkki miinus
                }
                double x;
                int alkuIndeksi = this.indeksi;
                if (poista('(')) { //Sulkeet
                    x = parseLauseke();
                    poista(')');
                } else if ((merkki >= '0' && merkki <= '9') || merkki == '.') {
                    while ((merkki >= '0' && merkki <= '9') || merkki == '.') {
                        seuraava();
                    }
                    x = Double.parseDouble(lauseke.substring(alkuIndeksi, this.indeksi));
                } else {
                    throw new RuntimeException("Virhe merkillä: " + (char) merkki);
                }
                return x;
            }
        }.parse();
    }
}
