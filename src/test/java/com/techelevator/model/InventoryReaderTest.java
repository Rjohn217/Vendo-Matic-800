package com.techelevator.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryReaderTest {
//inventryReader test
    public Boolean helperMethodForCompareObject(Item l, Item r ){
        //Boolean x;
        if(l.getName().equals(r.getName()) && l.getSlot().equals(r.getSlot())&& l.getCost().getAmount()==r.getCost().getAmount()){
            return true;
        }
        return false;

    }
@Test
    public void gumReader(){
    //D3|Chiclets|0.75|Gum
   // InventoryReader gumProduct=new InventoryReader();
    Money newMoney=new Money(75);
    Gum newGum=new Gum("Chiclets",newMoney,"D3");
    List<Item> gumHandler=InventoryReader.processFile();
    boolean x=false;
    for(int i=0;i<gumHandler.size();i++){
        if(helperMethodForCompareObject(newGum, gumHandler.get(i))){
            x=true;
        };
    }

    assertTrue(x);
}

}