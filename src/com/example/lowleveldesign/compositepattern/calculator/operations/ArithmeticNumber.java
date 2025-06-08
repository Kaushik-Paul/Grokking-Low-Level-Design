package com.example.lowleveldesign.compositepattern.calculator.operations;

public class ArithmeticNumber implements ArithmeticExpression {
    private int value;

    public ArithmeticNumber(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        System.out.println("The value is: " + this.value);

        return this.value;
    }
}
