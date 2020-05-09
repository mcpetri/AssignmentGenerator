/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatorapp.logic;

import generatorapp.logic.Calculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author petri
 */
public class CalculatorTest {
    
    Calculator testCalculator = new Calculator();
    
    @Test
    public void test1() {
        String expression = "1-(1+1)+1";
        double answer = 0.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
    @Test
    public void test2() {
        String expression = "(3*6)-(3*2)";
        double answer = 12.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
    @Test
    public void test3() {
        String expression = "4*5-6";
        double answer = 14.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
    @Test
    public void test4() {
        String expression = "2*4-4*8";
        double answer = -24.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
    @Test
    public void test5() {
        String expression = "2*(-2)";
        double answer = -4.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
    @Test
    public void test6() {
        String expression = "2*(+2)";
        double answer = 4.0;
        assertEquals(answer, testCalculator.count(expression), 0);
    }
    
}
