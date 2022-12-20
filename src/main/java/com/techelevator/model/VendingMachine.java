package com.techelevator.model;

import java.util.*;

public class VendingMachine {

   private Money balance;
    private final Map<Item, Integer> inventory;

    public Money getBalance() {
        return balance;
    }

    public VendingMachine(List<Item> items){
        inventory = new HashMap<>();
        for(Item i : items){
            inventory.put(i, 5);
        }
        balance = new Money();
    }

    public Transaction feedMoney(Money amountTOAdd) throws InvalidTransactionException {
        if (amountTOAdd.getAmount() <= 0) {
            throw new InvalidTransactionException("Please add a positive amount of money");
        }
        balance.add(amountTOAdd);
        return new Transaction("FEED MONEY:",amountTOAdd , balance,"");
    }

    public Transaction purchaseItem(Item item) throws InvalidTransactionException {
        int clientBalance = balance.getAmount();
        int itemCost = item.getCost().getAmount();
       // int inventoryValue = 0;
        if(clientBalance >= itemCost && inventory.get(item) > 0){
            balance.subtract(item.getCost());
            // reduce the value in the inventory by 1


            inventory.put(item, inventory.get(item) - 1); // updating the value
            return new Transaction(item.getName() + " " + item.getSlot(), item.getCost(), balance, item.dispenseMessage());
        } else{
            if (inventory.get(item) <= 0) {
                throw new InvalidTransactionException("Item out of stock, please select another");
            } else {
                throw new InvalidTransactionException("Balance required to complete this transaction is: " + item.getCost() + " please insert " + new Money(itemCost - clientBalance));
            }
        }
    }

    public Map<Item, Integer> getItems(){

        return inventory;
    }

    public Transaction finishTransaction(){
        // String command, Money amount, Money finalBalance, String dispenseMessage
       Money lastBalance = new Money();// the default constructor will set the balance value to zero
        Transaction lastTransaction = new Transaction("GIVE CHANGE:",balance,lastBalance,"");
        balance = lastBalance;

        return lastTransaction;

    }




}
