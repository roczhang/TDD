package com.yg;

/**
 * Created by I076057 on 7/15/2017.
 */
public enum  Operation {

    ADD,
    SUB,
    MULTIPLE,
    DIVID,
    UnderDefined;

    public Number reduce(Number leftNumber, Number rightNumber, Bank bank) throws Exception {

        return  reduce(leftNumber, rightNumber,this.ordinal(), bank);
    }

    private Number reduce(Number leftNumber, Number rightNumber, int operation, Bank bank) throws Exception {


        Number rmenoyAfterExchange = bank.convert(rightNumber, leftNumber.getCurrency());
        if ( operation == Operation.ADD.ordinal()) {
            return new Number(leftNumber.getAmount() + rmenoyAfterExchange.getAmount(), leftNumber.getCurrency());
        } else if (operation == Operation.SUB.ordinal()) {
            return new Number(leftNumber.getAmount() - rmenoyAfterExchange.getAmount(), leftNumber.getCurrency());
        } else if (operation == Operation.MULTIPLE.ordinal()) {

            String currency = getCurrencyIfOneHasNoCurrency(leftNumber, rightNumber);
            return new Number(leftNumber.getAmount() * rightNumber.getAmount(), currency);
        }


        throw new Exception(" the operation doest not support");
    }

    private String getCurrencyIfOneHasNoCurrency(Number leftNumber, Number rightNumber) {

        return leftNumber.getCurrency() + rightNumber.getCurrency();
    }

    public void print() {
        System.out.println( this.name() );
        System.out.println( this.ordinal());
    }
}
