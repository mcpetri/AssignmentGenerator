/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author petri
 */
public class Statistics {
    
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
            File myObj = new File("UsersAndStatistics.txt");
            if (myObj.createNewFile()) {
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
    
    public void createNewStatistics(String user) throws IOException {
        if (!checkStatistics(user)) {
            String statisticsLine = "";                     //Index number
            statisticsLine += user+"/";                     //0
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
            statisticsLine += difficultyNumber4 + "/";        //19    
            
            try {
                FileWriter writer = new FileWriter("UsersAndStatistics.txt");
                writer.write(statisticsLine);
                writer.close();
            } catch (IOException e) {
                //nothing
            }
        }
    }
    
    public void updateStatistics() {
        
    }
    
    public boolean checkStatistics(String user) {
        return true;
    }
    
    public String[] parseStatisctics(String user) {
        String[] tempStats = user.split("/");
        return tempStats;
    }
    
    public void increaseAssignmentNumber() {
        this.assignmentNumber++;
    }
    public void increaseCorrectPercentage() {
        this.correctPercentage++;
    }
    public void increaseCorrectNumber() {
        this.correctNumber++;
    }
    public void increaseIncorrectPercentage() {
        this.incorrectPercentage++;
    }
    public void increaseIncorrectNumber() {
        this.incorrectNumber++;
    }
    public void increaseAdditionNumber() {
        this.additionNumber++;
    }
    public void increaseSubtractionNumber() {
        this.subtractionNumber++;
    }
    public void increaseMultiplicationNumber() {
        this.multiplicationNumber++;
    }
    public void increaseDivisionNumber() {
        this.divisionNumber++;
    }
    public void increaseRandomNumber() {
        this.randomNumber++;
    }
    public void increaseCalculatorNumber() {
        this.calculatorNumber++;
    }
    public void increaseErrorNumber() {
        this.errorNumber++;
    }
    public void increaseVarition(int varition) {
        switch (varition) {
            case 1:
                this.variationNumber1++;
                break;
            case 2:
                this.variationNumber2++;
                break; 
            case 3:
                this.variationNumber3++;
                break;
            default:
                break;
        }
    }
    public void increaseDifficulty(int difficulty) {
        switch (difficulty) {
            case 1:
                this.difficultyNumber1++;
                break;
            case 2:
                this.difficultyNumber2++;
                break;
            case 3:
                this.difficultyNumber3++;
                break;
            case 4:
                this.difficultyNumber4++;
                break;
            default:
                break;
        }
    }
    
    

    
}
