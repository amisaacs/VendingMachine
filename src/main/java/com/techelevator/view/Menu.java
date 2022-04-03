package com.techelevator.view;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import com.techelevator.view.VendingMachine;
public class Menu {

	private PrintWriter out;
	private Scanner in;
	private String statusLine = "";

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

	/*
	Not sure if this should go here or in VendingMachine.
	Menu already has a Scanner for input, so maybe it's okay here. -ami
	Decided that it belongs here, because it is basically getting information
	from the user, so its function is UI, not processing logic.
	 */
	public double getDepositAmtFromUser(){
		//Loop until get valid deposit amount
		String depositAgain = "N";
		double depositAmt = 0.0;
		double moneyDeposited = 0.0;
		boolean isError;
		while(depositAmt == 0.0 || (depositAgain.equals("Y"))) {
			isError = false;
			try {
				System.out.println("Please enter money in whole dollars:");

				depositAmt = Double.parseDouble(in.nextLine());

				if (depositAmt % 1 != 0) {
					throw new NumberFormatException();
				}

			} catch (NumberFormatException e) {
				depositAmt = 0.0;
				System.err.println("Please enter a valid whole dollar amount.");
				isError = true;
			} catch (Exception e) {
				depositAmt = 0.0;
				System.err.println("Unknown error. Please enter a valid whole dollar amount.");
				isError = true;
			}

			if (!isError) {
				System.out.println("\nWould you like to deposit more money? (Enter \"y\" if yes or any other key to continue. )");
			depositAgain = in.nextLine().toUpperCase(Locale.ROOT).substring(0, 1);
			moneyDeposited += depositAmt;
		}

		}
		//System.out.printf("%s %2.2f", "You deposited: ", moneyDeposited); //TODO: uncomment
		// and make sure this works.
		return moneyDeposited;
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

		out.println(statusLine);
		out.print(System.lineSeparator() + "Please choose an option >>> ");
		out.flush();
	}

	public String getStatusLine() {
		return statusLine;
	}

	public void setStatusLine(String statusLine) {
		this.statusLine = statusLine;
	}

	public String getIDFromCustomer(){
		System.out.println("Please enter item ID:");
		String itemID = in.nextLine().toUpperCase(Locale.ROOT);
		return itemID;
	}



}

