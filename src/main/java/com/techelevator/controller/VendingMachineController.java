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

    @Override
    public void exitProgram() {
        pw.close();
        System.exit(0);
    }
}
