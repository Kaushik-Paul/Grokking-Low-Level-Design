package com.example.lowleveldesign.compositepattern.calculator;

import com.example.lowleveldesign.compositepattern.calculator.operations.ArithmeticExpression;
import com.example.lowleveldesign.compositepattern.calculator.operations.ArithmeticNumber;
import com.example.lowleveldesign.compositepattern.calculator.operations.Expression;
import com.example.lowleveldesign.compositepattern.calculator.operations.Operator;

public class Main {

    public static void main(String[] args) {
        ArithmeticExpression two = new ArithmeticNumber(2);

        ArithmeticExpression one = new ArithmeticNumber(1);
        ArithmeticExpression seven = new ArithmeticNumber(7);

        ArithmeticExpression addExpression = new Expression(one, Operator.ADD, seven);

        ArithmeticExpression parentExpression = new Expression(two, Operator.MULTIPLY, addExpression);

        System.out.println("The final value is: " + parentExpression.evaluate());

    }
}
