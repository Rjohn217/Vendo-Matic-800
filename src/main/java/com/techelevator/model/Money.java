package com.techelevator.model;

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

    private void subtract(Money m) {
    }

    @Override
    public String toString() {
        //199 -> "$1.99"
        return null;
    }
}
