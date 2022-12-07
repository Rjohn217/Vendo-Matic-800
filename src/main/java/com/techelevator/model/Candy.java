package com.techelevator.model;

public class Candy implements Item {
    private String name;
    private Money cost;

    public Candy(String name, Money cost) {
        this.name = name;
        this.cost = cost;
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
}
