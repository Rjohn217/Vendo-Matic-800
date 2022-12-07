package com.techelevator.model;

public class Beverage implements Item {

    private String name;
    private Money cost;

    public Beverage(String name, Money cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public String getName() { return name; }

    @Override
    public Money getCost() { return cost; }

    @Override
    public String dispenseMessage() { return "Glug Glug, Yum!"; }
}
