package com.techelevator.model;

public class Candy implements Item {
    private final String name;
    private final Money cost;

    private final String slot;


    public Candy(String name, Money cost, String slot) {
        this.name = name;
        this.cost = cost;
        this.slot = slot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getCost() {
        return cost;
    }

    @Override
    public String dispenseMessage() {
        return "Munch Munch, Yum!";
    }

    @Override
    public String getSlot() {
        return slot;
    }

    @Override
    public String getType() {
        return "Candy";
    }
}
