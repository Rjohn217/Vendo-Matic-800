package com.techelevator.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VendingMachine {

    int balance;
    Map<Item, Integer> inventory = new HashMap<>();

    private void feedMoney(int money) {
        if(money > 0) {
            balance += money;
        } else {
            System.out.println("Please add cash");
        }
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
