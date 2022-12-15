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


    try{ File inventryReaderFile=new File("vendingmachine.csv");
      Scanner sc=new Scanner(inventryReaderFile);
      while (sc.hasNext()){
         token=new StringTokenizer(sc.nextLine(),"|");
         name=token.nextToken();
         type=token.nextToken();
         location=token.nextToken();
         //money=Integer.parseInt(token.nextToken());
         Money money=new Money();
         //money=(Money)token.nextToken();
         Gum newGum=new Gum(name,money,location);
         Candy newCandy= new Candy(name,money,location);
         Chip newChip=new Chip(name,money,location);
         Beverage newBeverages=new Beverage(name,money,location);



     inventoryReader.add(newGum);
     inventoryReader.add(newCandy);
     inventoryReader.add(newChip);
     inventoryReader.add(newBeverages);

      }
    }
    catch (IOException e){
      System.out.println(e);
      e.printStackTrace();

    }

    return inventoryReader;
  }
}
