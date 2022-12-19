package com.techelevator.controller;

import com.techelevator.model.InvalidTransactionException;
import com.techelevator.model.Item;

import java.util.Map;

public interface VendingMachineEventListener {
    String doPurchase(Item item) throws InvalidTransactionException;
    void doFeed(int amount);
    void doGiveChange();
    String getBalance();
    void exitProgram();
    Map<Item,Integer> getInventory();
}
