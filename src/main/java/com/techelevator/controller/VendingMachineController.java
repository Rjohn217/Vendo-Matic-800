package com.techelevator.controller;


import SwingGUI.MainFrame;
import com.techelevator.logger.Logger;
import com.techelevator.model.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;


public class VendingMachineController implements VendingMachineEventListener {
    private final VendingMachine vendingMachine;
    PrintWriter pw;
    private final Logger logger;

    public VendingMachineController(VendingMachine vendingMachine, PrintWriter pw) {
        this.vendingMachine = vendingMachine;
        this.pw = pw;
        logger = new Logger(pw);
    }


    public static void main(String[] args) throws IOException {
        PrintWriter logFile = new PrintWriter("Log.txt");
        List<Item> inventory = InventoryReader.processFile();
        VendingMachine  vendingMachine = new VendingMachine(inventory);
        VendingMachineController controller =
                new VendingMachineController(vendingMachine, logFile);
        MainFrame myFrame = new MainFrame(controller);
    }

    @Override
    public void doPurchase(Item item) throws InvalidTransactionException {
        Transaction purchase = vendingMachine.purchaseItem(item);
        logger.logMessage(purchase);
    }

    @Override
    public void doFeed(int amount) {
        Transaction feed = vendingMachine.feedMoney(new Money(amount));
        logger.logMessage(feed);
    }

    @Override
    public void doGiveChange() {
        Transaction giveChange = vendingMachine.finishTransaction();
        logger.logMessage(giveChange);
    }

    @Override
    public String getBalance() {
        return vendingMachine.getBalance().toString();
    }

    @Override
    public void exitProgram() {
        pw.close();
        System.exit(0);
    }

    @Override
    public Map<Item, Integer> getInventory() {
        return vendingMachine.getItems();
    }
}
