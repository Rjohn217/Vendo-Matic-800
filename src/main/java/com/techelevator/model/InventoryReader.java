package com.techelevator.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class InventoryReader{
  public static List<Item> processFile()  {
    List<Item> inventoryReader=new ArrayList<Item>();
    StringTokenizer token=null;
    String name="";
    String type="";
    String location="";
   // int money=0;


    try {
      File inventryReaderFile=new File("vendingmachine.csv");
      Scanner sc=new Scanner(inventryReaderFile);
      while (sc.hasNext()){
         token=new StringTokenizer(sc.nextLine(),"|");
         location=token.nextToken();
         name=token.nextToken();
         Money money=new Money(Integer.parseInt(token.nextToken().replaceAll("\\.", "")));
         type=token.nextToken();
         //money=Integer.parseInt(token.nextToken());
         //money=(Money)token.nextToken();
          if(type.equals("Gum")){
              Gum newGum=new Gum(name,money,location);
              inventoryReader.add(newGum);
          }else if(type.equals("Candy")) {
              Candy newCandy= new Candy(name,money,location);
              inventoryReader.add(newCandy);
          }
          else if (type.equals("Chip")) {
              Chip newChip=new Chip(name,money,location);
              inventoryReader.add(newChip);
          }else if(type.equals("Drink")){
              Beverage newBeverages=new Beverage(name,money,location);
              inventoryReader.add(newBeverages);
          }


      }
    } catch (IOException e){
      System.out.println("The inventory can not been read in");
     }

    return inventoryReader;
  }
}
