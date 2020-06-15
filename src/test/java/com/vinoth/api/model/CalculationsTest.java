package com.vinoth.api.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculationsTest {

    @Test
    public void testAdd(){
        Calculation calculation = new Calculation(1,2);
        float result = calculation.performOperation(Calculation.Operation.ADD);
        assertEquals(result, 3.0, 0.001);
    }

    @Test
    public void testSubtract(){
        Calculation calculation = new Calculation(4,2);
        float result = calculation.performOperation(Calculation.Operation.SUBTRACT);
        assertEquals(result, 2.0, 0.001);
    }

    @Test
    public void testMultiply(){
        Calculation calculation = new Calculation(1,2);
        float result = calculation.performOperation(Calculation.Operation.MULTIPLY);
        assertEquals(result, 2.0, 0.001);
    }
}
