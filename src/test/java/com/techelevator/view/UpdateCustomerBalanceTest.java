package com.techelevator.view;

import com.techelevator.VendingMachineCLI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UpdateCustomerBalanceTest {
    VendingMachine vendingMachine;
    @Before
    private void setup(){
        vendingMachine = new VendingMachine();

    }

    @Test
    public void whenValidDeposit_ShouldUpdateCurrentCustBalanceCorrectly(){
        //act
        double depositValue = 15.25;
        //double withdrawlValue = 13.50;
        //double zeroValue = 0.0;

        //arrange
        vendingMachine.updateCustomerBalance(depositValue);
        double result = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(15.25, result, .0001);
    }


    @Test
    public void whenValidWithdrawl_ShouldUpdateCurrentCustBalanceCorrectly(){
        //act
        double depositValue = 15.50;
        double withdrawlValue = -13.50;
        //double zeroValue = 0.0;

        //arrange
        vendingMachine.updateCustomerBalance(depositValue);
        vendingMachine.updateCustomerBalance(withdrawlValue);
        double result = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(2.0, result, .0001);
    }

     @Test
    public void whenZeroIsWithdrawnOrDeposited_ShouldNOTUpdateCurrentCustBalance(){
        //act
        double depositValue = 0.0;
        double withdrawlValue = 0.0;

        //arrange
         vendingMachine.updateCustomerBalance(15.00);
        vendingMachine.updateCustomerBalance(depositValue);
        vendingMachine.updateCustomerBalance(withdrawlValue);
        double resultWithdrawl = vendingMachine.getCustomerBalance();
        double resultDeposit = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(15, resultWithdrawl, .0001);
        Assert.assertEquals(15, resultDeposit, .0001);
    }

    /*
    No tests for invalid input because there is error checking in the menu and a
    invalid amount can't get through.
     */


   /* @Test(expected=Exception.class)
    @Test(expected=NumberFormatException.class)
    public void givenFractionalDollarsDeposited_ReturnsFormatError() throws NumberFormatException{
        //arrange
        String fileName = "vendingmachine.csv";
        VendingMachine vendingmachine = new VendingMachine(fileName);
        double inputMoney = 10.13;

        //act
        vendingmachine.updateCustomerBalance(inputMoney);

        //assert
        //Will throw an acception in act

    }*/
}
