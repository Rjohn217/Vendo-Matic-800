package com.techelevator.model;

public class Chip implements Item {

    private String name;
    private Money cost;

    private String slot;

    public Chip(String name, Money cost, String slot) {
        this.name = name;
        this.cost = cost;
        this.slot = slot;
    }

    @Override
    public String getName() { return name; }

    @Override
    public Money getCost() { return cost; }

    @Override
    public String dispenseMessage() {
        return "Crunch Crunch, Yum!";
    }

    @Override
    public String getSlot() {
        return slot;
    }

    @Override
    public String getType() {
        return "Chip";
    }
}
