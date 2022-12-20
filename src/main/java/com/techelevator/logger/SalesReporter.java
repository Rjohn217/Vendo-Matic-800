package com.techelevator.logger;

import com.techelevator.model.Item;
import com.techelevator.model.Money;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SalesReporter {
    private static Map<String, Money> costs(Set<Item> items) {
        Map<String, Money> costMap = new HashMap<>();
        for(Item item : items) {
            costMap.put(item.getName(), item.getCost());
        }
        return costMap;
    }

    private static Map<String, Integer> newSales(Map<Item, Integer> inventory) {
        Map<String, Integer> sales = new HashMap<>();
        for (Map.Entry<Item, Integer> entry : inventory.entrySet()) {
            sales.put(entry.getKey().getName(), 5 - entry.getValue());
        }
        return sales;
    }

    private static void output(Map<String, Integer> sales, Money total) {
        try(PrintWriter printWriter = new PrintWriter("SalesReport.csv")) {
            for (Map.Entry<String, Integer> sale : sales.entrySet()) {
                printWriter.println(sale.getKey() + "|" + sale.getValue());
            }
            printWriter.println();
            printWriter.println("**TOTAL SALES** " + total);
        } catch (IOException ignored) {
            //just don't generate the report
        }
    }

    private static Money parseFile(Map<String, Money> costs, Map<String, Integer> sales) {
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
                    total.add(costs.get(lineFields[0]));
                }
            }
        } catch (FileNotFoundException e) {
            for (Map.Entry<String, Money> cost : costs.entrySet()) {
                for (int i = 0; i < sales.get(cost.getKey()); i++) {
                    total.add(cost.getValue());
                }
            }
        }
        return total;
    }

    public static void updateSalesReport(Map<Item, Integer> inventory) {
        Map<String, Money> costList = costs(inventory.keySet());
        Map<String, Integer> sales = newSales(inventory);
        Money total = parseFile(costList, sales);
        output(sales, total);
    }
}
