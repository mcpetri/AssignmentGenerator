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
import generatorapp.logic.Assignment;

/**
 *
 * @author petri
 */
public class AssignmentTest {
    
    Assignment testAssignment = new Assignment();
    
    @Test
    public void additionTest() {
        testAssignment.createAssignment("+");
        assertEquals(true,testAssignment.getExpression().contains("+"));
    }
    
    @Test
    public void subtractionTest() {
        testAssignment.createAssignment("-");
        assertEquals(true,testAssignment.getExpression().contains("-"));
    }
    
    @Test
    public void multiplicationTest() {
        testAssignment.createAssignment("*");
        assertEquals(true,testAssignment.getExpression().contains("*"));
    }
    
    @Test
    public void divisionTest() {
        testAssignment.createAssignment("/");
        assertEquals(true,testAssignment.getExpression().contains("/"));
    }
    
    @Test
    public void randomTest() {
        for (int i = 0; i < 100; i++) {
            testAssignment.createAssignment("random");
            assertEquals(true,testAssignment.getExpression().contains("+") 
                    || testAssignment.getExpression().contains("-") 
                    || testAssignment.getExpression().contains("*")
                    || testAssignment.getExpression().contains("/")
                    );
        }
    }
    
    @Test
    public void varitionChangeTest() {
        int variation = 100;
        testAssignment.setVariation(variation);
        assertEquals(true, testAssignment.getVariation() == 100);
    }
    
    @Test
    public void difficultyChangeTest() {
        int difficulty = 3;
        testAssignment.setDifficulty(difficulty);
        assertEquals(true, testAssignment.getDifficulty() == 3);
    }
    
    @Test
    public void amountOfCharacterTest() {
        testAssignment.setDifficulty(4); //5 tekijää 1-1000, 4 symbolia
        testAssignment.setVariation(1000);
        for (int i=0; i<100; i++) {
            testAssignment.createAssignment("random");
            String tempTest = testAssignment.getExpression();
            String testable = tempTest.replaceAll("Ratkaise x, kun \nx = ","");
            if (testable.length() < 9) {
                System.out.println(testable);
                fail("too few chars");     //Minimissään 5 tekijää 1-9, 4 symbolia = 9 chars
            } else if (testable.length() > 24) {
                System.out.println(testable);
                fail("too many chars");     //Maksimissaan 5 tekijää 1000, 4 symbolia = (5*4)+4 = 24 chars
            }
        }
    }
    
}
