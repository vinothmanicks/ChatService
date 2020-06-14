package com.vinoth.api.model;

public class Calculation {
    private float input1;
    private float input2;

    public float add() {
        return input1 + input2;
    }

    public float subtract() {
        return  input1 - input2;
    }

    public float multiply() {
        return input1 * input2;
    }
}
