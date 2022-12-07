package com.techelevator.model;

public class Beverage implements Item {

    private String name;
    private Money cost;

    private String slot;

    public Beverage(String name, Money cost, String slot) {
        this.name = name;
        this.cost = cost;
        this.slot = slot;
    }

    @Override
    public String getName() { return name; }

    @Override
    public Money getCost() { return cost; }

    @Override
    public String dispenseMessage() { return "Glug Glug, Yum!"; }

    @Override
    public String getSlot() {
        return slot;
    }
}
