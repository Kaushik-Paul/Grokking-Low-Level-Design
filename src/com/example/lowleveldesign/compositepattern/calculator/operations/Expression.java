package com.example.lowleveldesign.compositepattern.calculator.operations;

public class Expression implements ArithmeticExpression {
    private ArithmeticExpression leftExpression;
    private Operator operator;
    private ArithmeticExpression rightExpression;

    public Expression(ArithmeticExpression leftExpression, Operator operator, ArithmeticExpression rightExpression) {
        this.leftExpression = leftExpression;
        this.operator = operator;
        this.rightExpression = rightExpression;
    }


    @Override
    public int evaluate() {
        int value = switch (this.operator) {
            case ADD -> this.leftExpression.evaluate() + this.rightExpression.evaluate();
            case SUBTRACT -> this.leftExpression.evaluate() - this.rightExpression.evaluate();
            case MULTIPLY -> this.leftExpression.evaluate() * this.rightExpression.evaluate();
            case DIVIDE -> this.leftExpression.evaluate() / this.rightExpression.evaluate();
        };

        System.out.println("Expression value is: " + value);

        return value;
    }
}
