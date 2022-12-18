package com.techelevator.controller;


import SwingGUI.MainFrame;
import com.techelevator.VendingMachineCLI;
import com.techelevator.logger.Logger;
import com.techelevator.model.*;
import com.techelevator.view.Menu;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static com.techelevator.VendingMachineCLI.*;


public class VendingMachineController implements VendingMachineEventListener {
    private VendingMachine vendingMachine;
    private Logger logger;

    public VendingMachineController(VendingMachine vendingMachine, Logger logger) {
        this.vendingMachine = vendingMachine;
        this.logger = logger;
    }

    public static void main(String[] args) throws IOException {
        PrintWriter logFile = new PrintWriter(new File("Log.txt"));
        Logger logger = new Logger(logFile);
        List<Item> inventory = InventoryReader.processFile();
        VendingMachine  vendingMachine = new VendingMachine(inventory);
        VendingMachineController controller =
                new VendingMachineController(vendingMachine, logger);
        MainFrame myFrame = new MainFrame(controller);
        logFile.close();
    }

    @Override
    public String doPurchase(Item item) {
        return null;
    }

    @Override
    public void doFeed(int amount) {
        Transaction feed = vendingMachine.feedMoney(new Money(amount));
        logger.logMessage(feed);
    }

    @Override
    public String getBalance() {
        return vendingMachine.getBalance().toString();
    }
}
