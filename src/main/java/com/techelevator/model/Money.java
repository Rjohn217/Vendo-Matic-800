package com.techelevator.model;

import java.text.NumberFormat;
import java.util.Currency;

public class Money {

    private int amount;

    public Money() {
        this.amount = 0;
    }

    public Money(int amount) {
        this.amount = amount;
    }

    private void add(Money m) {
        amount += m.amount;
    }

    private void subtract(Money m) { amount = amount - m.amount; }

    @Override
    public String toString() {
//        Currency cu = Currency.getInstance(String.valueOf(amount));
//        return cu.toString();
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(amount / 100.);
    }
}
