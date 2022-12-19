package com.techelevator.model;

public interface Item {
    String getName();
    Money getCost();
    String dispenseMessage();
    String getSlot();
    String getType();
}
