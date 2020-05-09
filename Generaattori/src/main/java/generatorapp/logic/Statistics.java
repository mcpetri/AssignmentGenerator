/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author petri
 */
public class Statistics {
    
    File mainFile;
    private String user;
    private int assignmentNumber = 0;
    private int correctPercentage = 0;
    private int correctNumber = 0;
    private int incorrectPercentage = 0;
    private int incorrectNumber = 0;
    private int additionNumber = 0;
    private int subtractionNumber = 0;
    private int multiplicationNumber = 0;
    private int divisionNumber = 0;
    private int randomNumber = 0;
    private int calculatorNumber = 0;
    private int errorNumber = 0;
    private int variationNumber1 = 0;
    private int variationNumber2 = 0;
    private int variationNumber3 = 0;
    private int difficultyNumber1 = 0;
    private int difficultyNumber2 = 0;
    private int difficultyNumber3 = 0;
    private int difficultyNumber4 = 0;
    
    /**
     * Luo tiedoston "UsersAndStatistics" jos sitä ei ollut valmiiksi olemassa
     * Palauttaa 1 = tiedosto luotu, 2 = tiedosto oli jo luotu, -1 = virhe
     * @return -1, 1, 2
     */
    public int generateStatisticsFile() {
        try {
            mainFile = new File("UsersAndStatistics.txt");
            if (mainFile.createNewFile()) {
                //Luotu
                return 1;
            } else {
                //On jo
                return 2;
            }
        } catch (IOException e) {
            //Virhe
            return -1;
        }    
    }
    /**
     * Luo käyttäjälle user uudet tiedot, jos niitä ei ole olemassa
     * tiedostossa UsersAndStatistics.txt
     * @param user
     * @throws IOException 
     */
    public void createNewStatistics(String user) throws IOException {
        if (checkStatistics(user) == -1) {
            String statisticsLine = "";                     //Index number
            statisticsLine += user + "/";                     //0
            statisticsLine += assignmentNumber + "/";         //1
            statisticsLine += correctPercentage + "/";        //2
            statisticsLine += correctNumber + "/";            //3
            statisticsLine += incorrectPercentage + "/";      //4
            statisticsLine += incorrectNumber + "/";          //5
            statisticsLine += additionNumber + "/";           //6
            statisticsLine += subtractionNumber + "/";        //7
            statisticsLine += multiplicationNumber + "/";     //8
            statisticsLine += divisionNumber + "/";           //9
            statisticsLine += randomNumber + "/";             //10
            statisticsLine += calculatorNumber + "/";         //11
            statisticsLine += errorNumber + "/";              //12
            statisticsLine += variationNumber1 + "/";         //13
            statisticsLine += variationNumber2 + "/";         //14
            statisticsLine += variationNumber3 + "/";         //15
            statisticsLine += difficultyNumber1 + "/";        //16
            statisticsLine += difficultyNumber2 + "/";        //17
            statisticsLine += difficultyNumber3 + "/";        //18
            statisticsLine += difficultyNumber4 + "/\n";        //19    
            try {
                FileWriter writer = new FileWriter("UsersAndStatistics.txt", true);
                writer.write(statisticsLine);
                writer.close();
            } catch (IOException e) {
            }
            
        }
    }
    /**
     * Päivittää nykyisen käyttäjän tiedot tiedostossa
     * UsersAndStatistics.txt
     */
    public void updateStatistics() {
        String newStatistics = "";                     //Index number
        newStatistics += user + "/";                     //0
        newStatistics += assignmentNumber + "/";         //1
        newStatistics += correctPercentage + "/";        //2
        newStatistics += correctNumber + "/";            //3
        newStatistics += incorrectPercentage + "/";      //4
        newStatistics += incorrectNumber + "/";          //5
        newStatistics += additionNumber + "/";           //6
        newStatistics += subtractionNumber + "/";        //7
        newStatistics += multiplicationNumber + "/";     //8
        newStatistics += divisionNumber + "/";           //9
        newStatistics += randomNumber + "/";             //10
        newStatistics += calculatorNumber + "/";         //11
        newStatistics += errorNumber + "/";              //12
        newStatistics += variationNumber1 + "/";         //13
        newStatistics += variationNumber2 + "/";         //14
        newStatistics += variationNumber3 + "/";         //15
        newStatistics += difficultyNumber1 + "/";        //16
        newStatistics += difficultyNumber2 + "/";        //17
        newStatistics += difficultyNumber3 + "/";        //18
        newStatistics += difficultyNumber4 + "/";       //19
        File tempStatistics = new File("tempStatistics.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader("UsersAndStatistics.txt"));
            PrintWriter pw = new PrintWriter(new FileWriter("tempStatistics.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] userStats = parseStatistics(line);
                if (userStats[0].equalsIgnoreCase(user)) {
                    line = newStatistics;
                }
                pw.println(line);
                pw.flush();
            }
            pw.close();
            br.close();
            mainFile.delete();
            tempStatistics.renameTo(mainFile);
        } catch (IOException e) {
        }
    }
    /**
     * Tarkistaa tiedoston UsersAndStatistics.txt ja palauttaa rivi-indeksin,
     * jolta käyttäjän user tiedot löytyvät.
     * Jos tietoja ei ole olemassa, palauta -1
     * @param user
     * @return 
     */
    public int checkStatistics(String user) {
        try (BufferedReader br = new BufferedReader(new FileReader("UsersAndStatistics.txt"))) {
            String line;
            int index = 0;
            while ((line = br.readLine()) != null) {
                String[] userStats = parseStatistics(line);
                if (userStats[0].equalsIgnoreCase(user)) {
                    return index;
                } 
                index++;
            }
        } catch (Exception e) {  
        }
        return -1;
    }
    /**
     * Purkaa annetun tiedostorivin arrayksi 0-19
     * josta löytyy kyseisen rivin tiedot
     * @param userLine
     * @return 
     */
    public String[] parseStatistics(String userLine) {
        String[] tempStats = userLine.split("/");
        return tempStats;
    }
    /**
     * Palauttaa
     * @param user
     * @return 
     */
    public String getStatistics(String user) {
        int index = checkStatistics(user);
        try (BufferedReader br = new BufferedReader(new FileReader("UsersAndStatistics.txt"))) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                if (counter == index) {
                    return line;
                } 
                counter++;
            }
        } catch (Exception e) {  
        }
        return "";
    }
    /**
     * Asettaa nykyisen käyttäjän
     * @param user 
     */
    public void setUser(String user) {
        this.user = user;
    }
    /**
     * Lisää tehtyjen tehtävien määrää
     */
    public void increaseAssignmentNumber() {
        this.assignmentNumber++;
        updateStatistics();
    }
    /**
     * Lisää oikeinvastausprosenttia
     */
    public void increaseCorrectPercentage() {
        this.correctPercentage++;
        updateStatistics();
    }
    /**
     * Lisää oikeiden vastausten määrää
     */
    public void increaseCorrectNumber() {
        this.correctNumber++;
        updateStatistics();
    }
    /**
     * Lisää väärinvastausprosenttia
     */
    public void increaseIncorrectPercentage() {
        this.incorrectPercentage++;
        updateStatistics();
    }
    /**
     * Lisää väärien vastausten määrää
     */
    public void increaseIncorrectNumber() {
        this.incorrectNumber++;
        updateStatistics();
    }
    /**
     * Lisää yhteenlaskujen määrää
     */
    public void increaseAdditionNumber() {
        this.additionNumber++;
        updateStatistics();
    }
    /**
     * Lisää vähennyslaskujen määrä
     */
    public void increaseSubtractionNumber() {
        this.subtractionNumber++;
        updateStatistics();
    }
    /**
     * Lisää kertolaskujen määrää
     */
    public void increaseMultiplicationNumber() {
        this.multiplicationNumber++;
        updateStatistics();
    }
    /**
     * Lisää jakolaskujen määrää
     */
    public void increaseDivisionNumber() {
        this.divisionNumber++;
        updateStatistics();
    }
    /**
     * Lisää satunnaistehtävien määrää
     */
    public void increaseRandomNumber() {
        this.randomNumber++;
        updateStatistics();
    }
    /**
     * Lisää laskimen käytön määrää
     */
    public void increaseCalculatorNumber() {
        this.calculatorNumber++;
        updateStatistics();
    }
    /**
     * Lisää virheiden määrää
     */
    public void increaseErrorNumber() {
        this.errorNumber++;
        updateStatistics();
    }
    /**
     * Lisää annetulla vaihtelulla tehtyjen tehtävien määrää
     * @param varition 
     */
    public void increaseVarition(int varition) {
        switch (varition) {
            case 10:
                this.variationNumber1++;
                updateStatistics();
                break;
            case 100:
                this.variationNumber2++;
                updateStatistics();
                break; 
            case 1000:
                this.variationNumber3++;
                updateStatistics();
                break;
            default:
                break;
        }
    }
    /**
     * Lisää annetulla vaikeudella tehtyjen tehtävien määrä
     * @param difficulty 
     */
    public void increaseDifficulty(int difficulty) {
        if (difficulty == 1) {
            this.difficultyNumber1++;
            updateStatistics();
        } else if (difficulty == 2) {
            this.difficultyNumber2++;
            updateStatistics();
        } else if (difficulty == 3) {
            this.difficultyNumber3++;
            updateStatistics();
        } else if (difficulty == 4) {
            this.difficultyNumber4++;
            updateStatistics();
        }
    }
    
    

    
}
