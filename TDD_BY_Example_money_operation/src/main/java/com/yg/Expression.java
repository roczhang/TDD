package com.yg;

/**
 * Created by I076057 on 7/15/2017.
 */
public class Expression {
    private Expression rOperand;
    private Expression lOperand;
    private Operation operation;


    public Expression() {
    }

    public Expression(Expression loperand, Expression rOperand, Operation operation) {

        this.lOperand = loperand;
        this.rOperand = rOperand;
        this.operation = operation;
    }

    public Number reduce(Bank bank) throws Exception {

        if (this instanceof Number)
            return (Number) this;

        Number leftNumber = lOperand.reduce(bank);
        Number rightNumber = rOperand.reduce(bank);

        return this.operation.reduce( leftNumber, rightNumber, bank);

    }


    public Expression plus(Expression expression) {
        return new Expression(this, expression, Operation.ADD);
    }

    public Expression sub(Expression expression) {
        return new Expression(this, expression, Operation.SUB);
    }

    public Expression multiple(Expression times) {
        return new Expression(this, times, Operation.MULTIPLE);
    }



}
