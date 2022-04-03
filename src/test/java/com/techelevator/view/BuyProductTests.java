package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

public class BuyProductTests {
     /*
    Not testing invalid format because input checking with menu.
     */

    @Test
    public void shouldDeductPriceFromCustBalance(){
        //arrange
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.updateCustomerBalance(2.00);

        //act
        vendingMachine.purchaseSnack("C3");
        double balance = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(0.5, balance, .001);

    }

}
