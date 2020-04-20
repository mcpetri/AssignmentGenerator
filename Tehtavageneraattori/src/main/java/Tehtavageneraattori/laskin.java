/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tehtavageneraattori;

/**
 *
 * @author petri
 */
public class laskin {
    /**
     *
     * @param lauseke
     * @return
     */
    public double laske(final String lauseke) {
        return new Object() {
            //Luodaan kokonaisuudessaan uusi objekti tänne
            //joka kutsuu omaa metodiaan (mark for replacement)
            private int indeksi = -1;
            private int merkki = -1;
            void seuraava() { //Asetetaan seuraava merkki
                if (++indeksi < lauseke.length()) {
                    merkki = lauseke.charAt(indeksi);
                } else {
                    merkki = -1;
                }
            }

            boolean poista(final int poistettava) { //Liikutaan seuraavaan merkkiin (char)
                if (merkki == poistettava) {
                    seuraava();
                    return true;
                }
                return false;
            }
            //laske metodi aloittaa tästä omalla parse()
            //kutsullaan ja lähtee liikkumaan lausekkeessa
            //merkki kerrallaan lauseke->termi->tekija
            double parse() {
                seuraava();
                double x = parseLauseke();
                if (indeksi < lauseke.length()) {
                    throw new RuntimeException("Virhe merkillä: " + (char) merkki);
                }
                return x;
            }

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
                } else if ((merkki >= '0' && merkki <= '9') || merkki == '.') {             //Numerot ja desimaalit
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