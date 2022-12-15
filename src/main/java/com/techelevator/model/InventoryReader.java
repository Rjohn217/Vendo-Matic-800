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
    double cost=0;


    try{ File inventryReaderFile=new File("vendingmachine.csv");
      Scanner sc=new Scanner(inventryReaderFile);
      while (sc.hasNext()){
         token=new StringTokenizer(sc.nextLine(),"|");
         name=token.nextToken();
         type=token.nextToken();
         location=token.nextToken();
         cost=Double.parseDouble(token.nextToken());
         Item newItem=new Item() {
           @Override
           public String getName() {
             return this.getName();
           }

           @Override
           public Money getCost() {
             return this.getCost();
           }

           @Override
           public String dispenseMessage() {
             return this.dispenseMessage();
           }

           @Override
           public String getSlot() {
             return this.getSlot();
           }

         };
     inventoryReader.add(newItem);

      }
    }
    catch (IOException e){
      System.out.println(e);
      e.printStackTrace();

    }

    return inventoryReader;
  }
}
