package com.techelevator.logger;

import com.techelevator.model.Item;
import com.techelevator.model.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SalesReporter {
    public static Map<String, Money> costs(Set<Item> items) {
        Map<String, Money> costMap = new HashMap<>();
        for(Item item : items) {
            costMap.put(item.getName(), item.getCost());
        }
        return costMap;
    }

    public static Map<String, Integer> newSales(Map<Item, Integer> inventory) {
        Map<String, Integer> sales = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            sales.put(entry.getKey().getName(), 5 - entry.getValue());
        }
        return sales;
    }
    public static void updateSalesReport(Map<Item, Integer> inventory) {
        Map<String, Money> costList = costs(inventory.keySet());
        Map<String, Integer> sales = newSales(inventory);
        Money total = new Money();
        try (Scanner scanner = new Scanner(new File("SalesReport.csv"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    break;
                }
                String[] lineFields = line.split("\\|");
                sales.put(lineFields[0], Integer.parseInt(lineFields[1]) + sales.get(lineFields[0]));
                for (int i = 0; i < sales.get(lineFields[0]); i++) {
                    total.add(costList.get(lineFields[0]));
                }
            }
        } catch (FileNotFoundException e) {
            for (Map.Entry<String, Money> cost : costList.entrySet()) {
                for (int i = 0; i < sales.get(cost.getKey()); i++) {
                    total.add(cost.getValue());
                }
            }
        }
        try(PrintWriter printWriter = new PrintWriter("SalesReport.csv")) {
            for (Map.Entry<String, Integer> sale : sales.entrySet()) {
                printWriter.println(sale.getKey() + "|" + sale.getValue());
            }
            printWriter.println();
            printWriter.println("**TOTAL SALES** " + total.toString());
        } catch (IOException ignored) {
            //just don't generate the report
        }
    }
}
