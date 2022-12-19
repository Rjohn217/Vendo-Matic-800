package com.techelevator.model;

import java.text.NumberFormat;
import java.util.Currency;

public class Money {

    private int amount;

    public int getAmount() {
        return amount;
    }

    public Money() {
        this.amount = 0;
    }

    public Money(int amount) {
        this.amount = amount;
    }

    public void add(Money m) { amount += m.amount; }

    public void subtract (Money m) { amount = amount - m.amount; }

    @Override
    public String toString() {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        return format.format(amount / 100.);
    }
}
