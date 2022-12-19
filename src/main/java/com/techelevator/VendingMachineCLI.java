package com.techelevator;

import com.techelevator.model.Item;
import com.techelevator.view.Menu;

import java.util.List;

public class VendingMachineCLI {
	Menu menu = new Menu(System.in, System.out);

	public static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	public static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	public static final String MAIN_MENU_OPTION_EXIT = "Exit";
	public static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
	public static final String PURCHASE_MENU_OPTION_PURCHASE_ITEM = "Purchase Item";
	public static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };
	private static final String[] PURCHASE_MENU_OPTIONS = { PURCHASE_MENU_OPTION_FEED_MONEY, PURCHASE_MENU_OPTION_PURCHASE_ITEM, PURCHASE_MENU_OPTION_FINISH_TRANSACTION };

	public String getChoice() {
		return (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
	}

	public String getPurchaseChoice() { return (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);}

	public int getFeedAmount() { return menu.getFeedAmount();}

	public String getPurchaseItem(List<String> items) {
		return menu.getPurchaseItem(items);
	}
}
