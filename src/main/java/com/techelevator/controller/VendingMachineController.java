package com.techelevator.controller;


import com.techelevator.VendingMachineCLI;

import static com.techelevator.VendingMachineCLI.*;


public class VendingMachineController {
    VendingMachineCLI vendingMachineCLI;

    public VendingMachineController(VendingMachineCLI vendingMachineCLI) {
        this.vendingMachineCLI = vendingMachineCLI;
    }

    public void run() {
        while (true) {
            String choice = vendingMachineCLI.getChoice();

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        VendingMachineCLI vendingMachineCLI = new VendingMachineCLI();
        VendingMachineController controller = new VendingMachineController(vendingMachineCLI);
        controller.run();
    }
}
