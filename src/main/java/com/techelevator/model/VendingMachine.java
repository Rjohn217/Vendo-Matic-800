package com.techelevator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    Money balance;
    Map<Item, Integer> inventory = new HashMap<>();

    private void feedMoney(int money) {

    }

    private void purchaseItem(Item item) {
        //throws InvalidTransactionException
    }

    private List<String> getItems(){

        return null;
    }

    private void finishTransaction() {
        //throws InvalidTransactionException
    }



}
