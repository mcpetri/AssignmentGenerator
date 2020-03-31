/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tehtavageneraattori;
import java.util.*;


public class Tehtavageneraattori {
    
    
    
    public static void main(String[] args) {
        int tila = 0;
        
        Tehtava tehtava = new Tehtava();
        Scanner lukija = new Scanner(System.in);
        
        
        while(true) {
            if(tila==0) {
                System.out.println("Tervetuloa tehtavageneraattoriin, \n"
                    + "0 = Palaa aloitukseen \n"
                    + "1 = Yhteenlasku \n"
                    + "2 = Vähennyslasku \n"
                    + "3 = Kertolasku \n"
                    + "4 = Jakolasku \n"
                    + "5 = Help \n"
                    + "-1 = Exit");
            }
            System.out.print("Valitse toiminto: ");
            tila = Integer.valueOf(lukija.nextLine());
            
            if(tila==1) { //Yhteenlasku
                System.out.println("Valitsit yhteenlaskun");
                int tulos = (int) tehtava.luoTehtava("+");
                System.out.print("Syötä vastaus: ");
                int vastaus = Integer.parseInt(lukija.nextLine());
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
            }
            if(tila==2) { //Vähennyslasku
                System.out.println("Valitsit vähennylaskun");
                int tulos = (int) tehtava.luoTehtava("-");
                System.out.print("Syötä vastaus: ");
                int vastaus = Integer.parseInt(lukija.nextLine());
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                
            }
            if(tila==3) { //Kertolasku
                System.out.println("Valitsit kertolaskun");
                int tulos = (int) tehtava.luoTehtava("*");
                System.out.print("Syötä vastaus: ");
                int vastaus = Integer.parseInt(lukija.nextLine());
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                
            }
            if(tila==4) { //Jakolasku
                System.out.println("Valitsit jakolaskun (Pyöristä sadasosiin)");
                double alustavaTulos = tehtava.luoTehtava(":");
                double tulos = Math.round(alustavaTulos * 100.0) / 100.0;
                System.out.print("Syötä vastaus: ");
                double vastaus = Double.parseDouble(lukija.nextLine());
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
            }
            if(tila==5) { //Help
                //Lisää tänne informaatiota toiminnoista
            }
            if(tila==-1) { //Exit
                System.out.println("Hyvästi");
                break;
            }
        }
    }
    
    
    
    
    
    
    
    
    
}

