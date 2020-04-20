package Tehtavageneraattori;
import java.util.Scanner;


public class tehtavaGeneraattori {
    
    int tila = 0;
    
    public tehtavaGeneraattori() {
        
        tehtava tehtava = new tehtava();
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
            int temp = 0;
            double tempDouble = 0.0;
            while (true) {
                try {
                    temp = Integer.valueOf(lukija.nextLine());
                    break;
                } catch (NumberFormatException e){
                    System.out.print("Virhe, yritä uudelleen: ");
                }
            }
            tila = temp;

            if(tila==1) { //Yhteenlasku
                System.out.println("Valitsit yhteenlaskun");
                int tulos = (int) tehtava.luoTehtava("+");
                System.out.print("Syötä vastaus: ");
                while (true) {
                    try {
                        temp = Integer.valueOf(lukija.nextLine());
                        break;
                    } catch (NumberFormatException e){
                        System.out.print("Virhe, yritä uudelleen: ");
                    }
                }   
                int vastaus = temp;
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                continue;
            }
            if(tila==2) { //Vähennyslasku
                System.out.println("Valitsit vähennylaskun");
                int tulos = (int) tehtava.luoTehtava("-");
                System.out.print("Syötä vastaus: ");
                while (true) {
                    try {
                        temp = Integer.valueOf(lukija.nextLine());
                        break;
                    } catch (NumberFormatException e){
                        System.out.print("Virhe, yritä uudelleen: ");
                    }
                }   
                int vastaus = temp;
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                continue;
            }
            if(tila==3) { //Kertolasku
                System.out.println("Valitsit kertolaskun");
                int tulos = (int) tehtava.luoTehtava("*");
                System.out.print("Syötä vastaus: ");
                while (true) {
                    try {
                        temp = Integer.valueOf(lukija.nextLine());
                        break;
                    } catch (NumberFormatException e){
                        System.out.print("Virhe, yritä uudelleen: ");
                    }
                }   
                int vastaus = temp;
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                continue; 
            }
            if(tila==4) { //Jakolasku
                System.out.println("Valitsit jakolaskun (Pyöristä sadasosiin)");
                double alustavaTulos = tehtava.luoTehtava(":");
                double tulos = Math.round(alustavaTulos * 100.0) / 100.0;
                System.out.print("Syötä vastaus: ");
                while (true) {
                    try {
                        tempDouble = Double.parseDouble(lukija.nextLine());
                        break;
                    } catch (NumberFormatException e){
                        System.out.print("Virhe, yritä uudelleen: ");
                    }
                }   
                double vastaus = tempDouble;
                if (tulos == vastaus) {
                    System.out.println("Vastasit oikein!");
                } else {
                    System.out.println("Vastasit väärin, oikea vastaus: "+tulos);
                }
                continue;
            }
            if(tila==5) { //Help
                System.out.println("Haha xd");
                continue;
            }
            if(tila==-1) { //Exit
                System.out.println("Hyvästi");
                break;
            }
            if(tila==0) {} //Estää allaolevan viestin kun halutaan palata aloitukseen muusta toiminnosta      
            else {
                System.out.println("Syöttämäsi numero ei vastannut vaihtoehtoja, ole hyvä ja yritä uudelleen");
            }
            
        }
    } 
}
