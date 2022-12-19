package com.techelevator.view;

import com.techelevator.model.Item;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class Menu {

	private PrintWriter out;
	private Scanner in;

	public Menu(InputStream input, OutputStream output) {
		this.out = new PrintWriter(output);
		this.in = new Scanner(input);
	}

	public Object getChoiceFromOptions(Object[] options) {
		Object choice = null;
		while (choice == null) {
			displayMenuOptions(options);
			choice = getChoiceFromUserInput(options);
		}
		return choice;
	}

	private Object getChoiceFromUserInput(Object[] options) {
		Object choice = null;
		String userInput = in.nextLine();
		try {
			int selectedOption = Integer.valueOf(userInput);
			if (selectedOption > 0 && selectedOption <= options.length) {
				choice = options[selectedOption - 1];
			}
		} catch (NumberFormatException e) {
			// eat the exception, an error message will be displayed below since choice will be null
		}
		if (choice == null) {
			out.println(System.lineSeparator() + "*** " + userInput + " is not a valid option ***" + System.lineSeparator());
		}
		return choice;
	}

	private void displayMenuOptions(Object[] options) {
		out.println();
		for (int i = 0; i < options.length; i++) {
			int optionNum = i + 1;
			out.println(optionNum + ") " + options[i]);
		}
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public int getFeedAmount() {
		System.out.print("Choose an amount to deposit (whole dollar amount): ");
		while(true) {
			try {
				return Integer.parseInt(in.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Please input a valid amount");
			}
		}
	}

	public String getPurchaseItem(List<String> items) {
		System.out.println("Choose an item: ");
		for (int i = 1; i <= items.size(); i++) {
			System.out.println(i + ") " + items.get(i));
		}
		while(true) {
			try {
				int choice = Integer.parseInt(in.nextLine());
				if (choice > 0 && choice <= items.size()) {
					return items.get(choice);
				}
			} catch (NumberFormatException e) {
				System.out.println("Please input a valid choice");
			}
		}
	}
}
