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

}
