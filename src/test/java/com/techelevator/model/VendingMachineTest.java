package com.techelevator.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.TestCase;
import org.junit.Assert;

public class VendingMachineTest extends TestCase {
    public void testFeedMoney() {

        Money moneyToAdd = new Money(5);
        Money balance = new Money(0);
        Transaction result = new Transaction("FEED MONEY", moneyToAdd, balance, "");

        Assert.assertEquals(FEED MONEY 5 balance , result);
    }

    public void testFeedPurchaseItem() {
        @Test
        public void testPurchaseItem() throws InvalidTransactionException {

        }

            Item sampleItem = new Item();



    }

    public void testgetItems() {
    List<String> myItems = new ArrayList<>();
    Map <Item, Integer> sampleMap = new HashMap<>();
    sampleMap.put(Beverage, 1);
    sampleMap.put(Candy, 2);
    sampleMap.put(Chip, 3);
    sampleMap.put(Gum, 4);

        for(Map.Entry<Item, Integer> entry : inventory.entrySet()){
            myItems.add(entry.getKey().getName());
        }

        Assert.assertEquals("Beverage, Candy, Chip, Gum" , myItems);


    }


    public void testFinishTransaction() {
        Money balance = new Money();
        Transaction result = new Transaction();
        Assert.assertEquals("left over balance" , result.getCommand("left over balance"));
    }


}
