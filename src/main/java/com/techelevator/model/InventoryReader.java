package com.techelevator.model;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InventoryReader{
  public static List<Item> processFile()  {
    List<Item> inventoryReader=new ArrayList<>();
    StringTokenizer token;
    String name;
    String type;
    String location;


    try {
      File inventryReaderFile=new File("vendingmachine.csv");
      Scanner sc=new Scanner(inventryReaderFile);
      while (sc.hasNext()){
          token=new StringTokenizer(sc.nextLine(),"|");
          location=token.nextToken();
          name=token.nextToken();
          Money money=new Money(Integer.parseInt(token.nextToken().replaceAll("\\.", "")));
          type=token.nextToken();
          switch (type) {
              case "Gum":
                  Gum newGum = new Gum(name, money, location);
                  inventoryReader.add(newGum);
                  break;
              case "Candy":
                  Candy newCandy = new Candy(name, money, location);
                  inventoryReader.add(newCandy);
                  break;
              case "Chip":
                  Chip newChip = new Chip(name, money, location);
                  inventoryReader.add(newChip);
                  break;
              case "Drink":
                  Beverage newBeverages = new Beverage(name, money, location);
                  inventoryReader.add(newBeverages);
                  break;
          }


      }
    } catch (IOException e){
      System.out.println("The inventory can not been read in");
     }

    return inventoryReader;
  }
}
