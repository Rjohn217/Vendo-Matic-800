package com.techelevator.model;

import java.util.Objects;

public class Gum implements Item {

    private String name;
    private Money cost;

    private String slot;

    public Gum(String name, Money cost, String slot) {
        this.name = name;
        this.cost = cost;
        this.slot = slot;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Money getCost() { return cost; }

    @Override
    public String dispenseMessage() { return "Chew Chew, Yum!"; }

    @Override
    public String getSlot() {
        return slot;
    }

    @Override
    public String getType() {
        return "Gum";
    }
}
