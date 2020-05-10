/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import generatorapp.logic.Statistics;
import java.io.IOException;

/**
 *
 * @author petri
 */
public class StatisticsTest {
    
    Statistics testStats = new Statistics();
    String testUser = "user";
    int status = testStats.generateStatisticsFile();
    
    @Test
    public void newUserTest() {
        try {
            testStats.createNewStatistics(testUser);
        } catch (IOException e) {
            fail();
        }
    }
    @Test
    public void newFileStatusTest() {
        if(status == -1) {
            fail();
        }
    }
    @Test
    public void checkStatisticsTest() {
        if(testStats.checkStatistics(testUser) == -1) {
            fail();
        }
    }
    @Test
    public void checkStatisticsFailTest() {
        if(testStats.checkStatistics("error") != -1) {
            fail();
        }
    }
    @Test
    public void parseGetStatistics() {
        try {
            testStats.createNewStatistics(testUser);
        } catch (IOException e) {
            fail();
        }
        String stats = testStats.getStatistics(testUser);
        String[] arrayStats = testStats.parseStatistics(stats);
        assertEquals(true, arrayStats[0].equals(testUser));
    }
    @Test
    public void updateTest() {
        try {
            testStats.createNewStatistics(testUser);
        } catch (IOException e) {
            fail();
        }
        testStats.setUser(testUser);
        testStats.increaseAssignmentNumber();
        testStats.increaseCorrectPercentage();
        testStats.increaseCorrectNumber();
        testStats.increaseIncorrectPercentage();
        testStats.increaseIncorrectNumber();
        testStats.increaseAdditionNumber();
        testStats.increaseSubtractionNumber();
        testStats.increaseMultiplicationNumber();
        testStats.increaseDivisionNumber();
        testStats.increaseRandomNumber();
        testStats.increaseCalculatorNumber();
        testStats.increaseErrorNumber();
        testStats.increaseDifficulty(1);
        testStats.increaseDifficulty(2);
        testStats.increaseDifficulty(3);
        testStats.increaseDifficulty(4);
        testStats.increaseVarition(10);
        testStats.increaseVarition(100);
        testStats.increaseVarition(1000);
        testStats.updateStatistics();
        String stats = testStats.getStatistics(testUser);
        String[] arrayStats = testStats.parseStatistics(stats);
        for (int i = 1; i<arrayStats.length; i++) {
            if (Integer.valueOf(arrayStats[i]) != 1) {
                fail();
            }
        }
                
    }
}
