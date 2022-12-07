package com.techelevator;

import com.techelevator.view.Menu;

public class VendingMachineCLI {
	Menu menu = new Menu(System.in, System.out);

	public static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	public static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	public static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	public String getChoice() {
		return (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
	}
}
