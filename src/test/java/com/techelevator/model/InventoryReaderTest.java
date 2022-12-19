package com.techelevator.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryReaderTest {

@Test
    void gumReader(){
    InventoryReader gumProduct=new InventoryReader();
    List<String> gumCalculation=new ArrayList<>();
    gumCalculation.add("Gum");
    gumCalculation.add("2.50");
    gumCalculation.add("Chiclets");
    assertEquals(gumCalculation,gumProduct.processFile());
}
@Test
    void chipReader(){
    InventoryReader chipProduct=new InventoryReader();
    List<String> chipCalculation=new ArrayList<>();
    chipCalculation.add("Chip");
    chipCalculation.add("3.25");
    chipCalculation.add("Grain Waves");
    assertEquals(chipCalculation,chipProduct.processFile());
}
    @Test
    void drinkReader(){
        InventoryReader drinkProduct=new InventoryReader();
        List<String> chipCalculation=new ArrayList<>();
        chipCalculation.add("Drink");
        chipCalculation.add("1.85");
        chipCalculation.add("Grain Waves");
        assertEquals(chipCalculation,drinkProduct.processFile());
    }
}