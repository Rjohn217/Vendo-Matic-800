package com.techelevator.model;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventoryReader{
  public static List<String> processFile()  {
    List<String> inventoryReader=new ArrayList<String>();

    try{ File inventryReaderFile=new File("vendingmachine.csv");
      Scanner sc=new Scanner(inventryReaderFile);
      while (sc.hasNext()){
        for (int i=0;i<=inventoryReader.size();i++){
          System.out.println(inventoryReader.get(i).split("|"));
        }

      }
    }
    catch (IOException e){
      System.out.println(e);
      e.printStackTrace();

    }

    return inventoryReader;
  }
}
