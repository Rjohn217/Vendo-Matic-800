package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Assert;

public class VendingMachineTest extends TestCase {
    public void testFeedMoney() {
        VendingMachine vendingMachine = new VendingMachine(new ArrayList<>());

        Money moneyToAdd = new Money(5);

        Transaction moneyFeed = null;
        try {
            moneyFeed = vendingMachine.feedMoney(moneyToAdd);
        } catch (InvalidTransactionException e) {
            throw new RuntimeException(e);
        }

        Assert.assertEquals(moneyFeed.getCommand(),"FEED MONEY:");

        Assert.assertEquals(moneyFeed.getAmount().getAmount() , 5 );

        Assert.assertEquals(moneyFeed.getFinalBalance().getAmount() , 5);
    }

    public void testFeedPurchaseItem() throws InvalidTransactionException {

        Item myItem = new Beverage("s",new Money(1000),"A1");
        List <Item> myList = new ArrayList<>();
        myList.add(myItem);
        VendingMachine vendingMachine = new VendingMachine(myList);
        vendingMachine.feedMoney(new Money(1500));
        Transaction myTransaction = vendingMachine.purchaseItem(myItem);

        Assert.assertEquals(myTransaction.getCommand(),"s A1");

        Assert.assertEquals(myTransaction.getAmount().getAmount() , 1000 );

        Assert.assertEquals(myTransaction.getFinalBalance().getAmount() , 500);

        Assert.assertEquals(myTransaction.getDispenseMessage() , "Glug Glug, Yum!");
    }

    // Edge case: The machine does  not have enough money
    public void testFeedPurchaseItemNotEnoughMoney()  {

        Item myItem = new Candy("hersey's",new Money(1500),"A2");
        List <Item> myList = new ArrayList<>();
        myList.add(myItem);
        VendingMachine vendingMachine = new VendingMachine(myList);
        try {
            vendingMachine.feedMoney(new Money(1000));
        } catch (InvalidTransactionException e) {
            throw new RuntimeException(e);
        }
        boolean caughtException = false;
        try{
            vendingMachine.purchaseItem(myItem);
        }catch (InvalidTransactionException e){
            caughtException = true;
        }
       assertTrue(caughtException);
    }

    // Edge case: The machine does not have enough item
    public void testFeedPurchaseItemNotEnoughItem() throws InvalidTransactionException {

        Item myItem = new Candy("hersey's",new Money(1),"A2");
        List <Item> myList = new ArrayList<>();
        myList.add(myItem);
        VendingMachine vendingMachine = new VendingMachine(myList);
        vendingMachine.feedMoney(new Money(1000));
        boolean caughtException = false;
        try{
            vendingMachine.purchaseItem(myItem);
            vendingMachine.purchaseItem(myItem);
            vendingMachine.purchaseItem(myItem);
            vendingMachine.purchaseItem(myItem);
            vendingMachine.purchaseItem(myItem);
            vendingMachine.purchaseItem(myItem);
        }catch (InvalidTransactionException e){
            caughtException = true;
        }
        assertTrue(caughtException);
    }

    public void testgetItems() {
        Item myItem = new Chip("C",new Money(2000),"A2");
        List <Item> myList = new ArrayList<>();
        myList.add(myItem);
        VendingMachine vendingMachine = new VendingMachine(myList);

        Assert.assertEquals(vendingMachine.getItems().get(myItem), Integer.valueOf(5));
    }


    public void testFinishTransaction() {

        VendingMachine vendingMachine = new VendingMachine(new ArrayList<>());

        try {
            vendingMachine.feedMoney(new Money(2500));
        } catch (InvalidTransactionException e) {
            throw new RuntimeException(e);
        }
        Transaction myTransaction = vendingMachine.finishTransaction();
       // "GIVE CHANGE:",balance,lastBalance,""
        Assert.assertEquals(myTransaction.getCommand(),"GIVE CHANGE:");

        Assert.assertEquals(myTransaction.getAmount().getAmount() , 2500 );

        Assert.assertEquals(myTransaction.getFinalBalance().getAmount() , 0);
    }


}
