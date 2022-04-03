package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.SnackItem;
import com.techelevator.view.VendingMachine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VendingMachineCLI {

    private Menu menu;
    private VendingMachine vendingMachine;


    //Main Menu
    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase"; //goes to Purchase Menu
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    //    private static final String MAIN_MENU_OPTION_SALES_REPORT = "Sales Report (Will Be
    //    Empty String)";//TODO code sales report
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS,
            MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};

    //Purchase Menu
    private static final String PURCHASE_MENU_OPTION_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_OPTION_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_OPTION_FINISH_TRANSACTION = "Finish Transaction";
    public static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_OPTION_FEED_MONEY,
            PURCHASE_MENU_OPTION_SELECT_PRODUCT, PURCHASE_MENU_OPTION_FINISH_TRANSACTION};


    public VendingMachineCLI(Menu menu, VendingMachine vendingMachine) {
        this.menu = menu;
        this.vendingMachine = vendingMachine;
    }

    public void run() {

        //Menu will run until program is exited
        while (true) {
            //Set to Main Menu
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            //Switch on choices from Main Menu
            switch (choice) {
                //Display all the snacks available.
                case MAIN_MENU_OPTION_DISPLAY_ITEMS:
                    menu.setStatusLine(""); //maybe refactor this?
                    vendingMachine.displaySnackItemsList();
                    break;

                //Go to Purchase Menu
                case MAIN_MENU_OPTION_PURCHASE:
                    while (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                        displayPurchaseMenu(choice);
                    }

                //Exit the program.
                case MAIN_MENU_OPTION_EXIT:
                    System.out.println("Thank you for buying your snacks with us!");
                    System.exit(0);

            }
        }
    }

    private void displayPurchaseMenu(String choice) {

        menu.setStatusLine("\nCurrent Money Provided: $" + vendingMachine.getCustomerBalance());

        //Get option from Purchase Menu.
        choice = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS);

        //Execute the choice the user entered.
        switch (choice) {
            case PURCHASE_MENU_OPTION_FEED_MONEY:
                menu.setStatusLine("");

                double moneyDeposited;
                moneyDeposited = menu.getDepositAmtFromUser();
                vendingMachine.feedMoney(moneyDeposited);
                break;

            case PURCHASE_MENU_OPTION_SELECT_PRODUCT:
                menu.setStatusLine("");
                vendingMachine.displaySnackItemsList();
                String id = menu.getIDFromCustomer();
                vendingMachine.purchaseSnack(id);
                break;

            case PURCHASE_MENU_OPTION_FINISH_TRANSACTION:
                vendingMachine.makeChange();
                menu.setStatusLine("");
                choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
                break;

            default:
                System.err.println("This line should never print. \n inside " +
                        "displayPurchaseMenu()");


        }
    }


    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        String fileName = "vendingmachine.csv";
        VendingMachine vendingmachine = new VendingMachine();
        VendingMachineCLI cli = new VendingMachineCLI(menu, vendingmachine);
        cli.run();
    }
}


