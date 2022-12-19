package com.techelevator.controller;


import com.techelevator.VendingMachineCLI;
import com.techelevator.logger.Logger;
import com.techelevator.model.*;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.techelevator.VendingMachineCLI.*;


public class VendingMachineController {
    private VendingMachineCLI vendingMachineCLI;
    private VendingMachine vendingMachine;
    private Logger logger;

    public VendingMachineController(VendingMachineCLI vendingMachineCLI, VendingMachine vendingMachine, Logger logger) {
        this.vendingMachineCLI = vendingMachineCLI;
        this.vendingMachine = vendingMachine;
        this.logger = logger;
    }

    public void run() {

        while (true) {
            String choice = vendingMachineCLI.getChoice();

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
                for (String itemString : vendingMachine.getItems()) {
                    System.out.println(itemString);
                }
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
                String purchaseChoice = vendingMachineCLI.getPurchaseChoice();
                if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FEED_MONEY)) {
                    Money money = new Money(vendingMachineCLI.getFeedAmount() * 100);
                    Transaction feed = vendingMachine.feedMoney(money);
                    logger.logMessage(feed);
                } else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_PURCHASE_ITEM)) {
                    String purchaseItem = vendingMachineCLI.getPurchaseItem(vendingMachine.getItems());
                    try {
                        Transaction purchase = vendingMachine.purchaseItem(new Candy("", new Money(), ""));
                        logger.logMessage(purchase);
                    } catch (InvalidTransactionException e) {
                        throw new RuntimeException();
                    }
                } else if (purchaseChoice.equals(PURCHASE_MENU_OPTION_FINISH_TRANSACTION)) {
                    Transaction finish = vendingMachine.finishTransaction();
                    logger.logMessage(finish);
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        VendingMachineCLI vendingMachineCLI = new VendingMachineCLI();
        PrintWriter logFile = new PrintWriter(new File("Log.txt"));
        Logger logger = new Logger(logFile);
        List<Item> inventory = InventoryReader.processFile();
        VendingMachine  vendingMachine = new VendingMachine(inventory);
        VendingMachineController controller =
                new VendingMachineController(vendingMachineCLI, vendingMachine, logger);
        controller.run();
        logFile.close();
    }
}
