package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FeedMoneyTests {
    VendingMachine vendingMachine;
    /*
    Tests for valid input are not included because the Menu class,
    doesn't pass on input to the VendingMachine class until it has validated it.
     */

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();

    }
    @Test
    public void whenWholeDollarsDeposited_updatesCurrentCustomerBalanceUpdatedCorrectly(){
        //arrange -setup()

        //act
        vendingMachine.feedMoney(15);
        double result = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(15, result, .0001);
    }

    @Test
    public void whenWholeDollarsDeposited_updatesPreviousCustomerBalanceUpdatesCorrectly(){
        //arrange - setup()
        //Balance starts at zero, feed $10, this amount will be the previous balance
        vendingMachine.feedMoney(10);
        double previousBalance = vendingMachine.getCustomerBalance();

                //act
        vendingMachine.feedMoney(22);
        double expectedResult = vendingMachine.getPreviousCustBalance();

        //assert
        Assert.assertEquals(expectedResult,previousBalance, .001);

    }

    @Test
    public void whenDollarsDepositedMultipleTimes_CurrentCustomerBalancesUpdatesCorrectly(){
        //arrange - setup()

        //act
        vendingMachine.feedMoney(22);
        vendingMachine.feedMoney(10);
        vendingMachine.feedMoney(2);
        double expectedResult = vendingMachine.getCustomerBalance();

        //assert
        Assert.assertEquals(expectedResult,34, .001);

    }

    @Test
    public void whenDollarsDepositedMultipleTimes_PreviousCustomerBalancesUpdatesCorrectly(){
        //arrange - setup()

        //act
        vendingMachine.feedMoney(22);
        vendingMachine.feedMoney(10);
        //previous balance is the sum of the above two method calls
        vendingMachine.feedMoney(2);
        double expectedResult = vendingMachine.getPreviousCustBalance();

        //assert
        Assert.assertEquals(expectedResult,32, .001);

    }
}
