package com.vinoth.api.model;

public class Calculation {
    private final float input1;
    private final float input2;

    public Calculation(float input1, float input2) {
        this.input1 = input1;
        this.input2 = input2;
    }

    public float getInput1() {
        return input1;
    }

    public float getInput2() {
        return input2;
    }


    public float performOperation(Operation operation) {
        switch (operation) {
            case ADD:
                return input1 + input2;
            case SUBTRACT:
                return input1 - input2;
            case MULTIPLY:
                return input1 * input2;
            default:
                throw new UnsupportedOperationException("UnsupportedOperation" + operation);
        }
    }


    public enum Operation {
        ADD, SUBTRACT, MULTIPLY;
    }
}
