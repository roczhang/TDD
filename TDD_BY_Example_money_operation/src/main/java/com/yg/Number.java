package com.yg;

/**
 * Created by I076057 on 7/15/2017.
 */
public class Number extends Expression {


    protected float amount;
    protected String currency;

    public Number(float amount) {
        this(amount, "");
    }

    public Number(float amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    public float getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public static Number getDollar(int amount) {

        return new Number(amount, "US");
    }

    public static Number getNumber(float amount){
        return  new Number(amount);
    }

    public static Number getFrance(int amount) {
        return new Number(amount, "FR");
    }


    public boolean equals(Object object) {

        if (object instanceof Number) {
            Number number = (Number) object;

            if( this.currency.equals( number.currency)) {
                return Math.abs(this.getAmount() - number.getAmount()) < 0.001;
            }
            else
                if( Math.abs(this.amount) < 0.001 && Math.abs( number.amount) < 0.001)
                    return  true;
                else
                    return  false;
        }
        return false;
    }
}
