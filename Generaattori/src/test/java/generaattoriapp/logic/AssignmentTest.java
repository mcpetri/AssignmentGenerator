/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generaattoriapp.logic;

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
    public void testAddition() {
        testAssignment.createAssignment("+");
        assertEquals(true,testAssignment.getExpression().contains("+"));
    }
    
    @Test
    public void testSubtraction() {
        testAssignment.createAssignment("-");
        assertEquals(true,testAssignment.getExpression().contains("-"));
    }
    
    @Test
    public void testMultiplication() {
        testAssignment.createAssignment("*");
        assertEquals(true,testAssignment.getExpression().contains("*"));
    }
    
    @Test
    public void testDivision() {
        testAssignment.createAssignment(":");
        assertEquals(true,testAssignment.getExpression().contains("/"));
    }
    
}
