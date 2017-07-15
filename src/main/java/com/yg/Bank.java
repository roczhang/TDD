package com.yg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by I076057 on 7/15/2017.
 */
public class Bank {

    private Map<String, Float> exchangeRate;

    public Bank() {
        this(null);
    }


    public Bank(Map<String, Float> exchangeRate) {
        if (exchangeRate != null) {
            this.exchangeRate = exchangeRate;
        } else {
            this.exchangeRate = getDefaultRatio();
        }

    }

    public Number reduce(Expression expression) throws Exception {
        return expression.reduce(this);
    }

    public Number convert(Number number, String currency) {

        float ratio = GetRatio(number.getCurrency(), currency);
        return new Number(number.getAmount() * ratio, currency);
    }

    public float GetRatio(String source, String target) {
        return this.exchangeRate.get(this.jion(source, target));
    }


    private String jion(String source, String target) {
        return source + "-" + target;
    }

    private Map<String, Float> getDefaultRatio() {

        Map<String, Float> exchangeRatio = new HashMap<>();
        exchangeRatio.put("US-FR", 2f);
        exchangeRatio.put("FR-US", 0.5f);
        exchangeRatio.put("FR-FR", 1f);
        exchangeRatio.put("US-US", 1f);
        exchangeRatio.put("-US", 1f);
        exchangeRatio.put("-FR", 1f);
        exchangeRatio.put("FR-", 1f);
        exchangeRatio.put("US-", 1f);
        exchangeRatio.put("-", 1f);

        return exchangeRatio;
    }
}
