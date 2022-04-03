package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class MakeChangeTests {
    @Test
    public void setsBalanceToZero(){
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.updateCustomerBalance(4.00);
        vendingMachine.purchaseSnack("A4");

        //act
        vendingMachine.makeChange();
        double result = vendingMachine.getCustomerBalance();


        //assert
        Assert.assertEquals(0.0, result, .001);
    }
}
