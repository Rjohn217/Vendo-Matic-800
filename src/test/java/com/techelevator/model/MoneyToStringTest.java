package com.techelevator.model;

import junit.framework.TestCase;
import org.junit.Assert;

import java.text.NumberFormat;
import java.util.Currency;

public class MoneyToStringTest extends TestCase {

    public void testTestToString() {

        int amount = 399;
        String expected = "$3.99";

        NumberFormat format = NumberFormat.getCurrencyInstance();
        String result = format.format(amount/100.).toString();

        Assert.assertEquals(expected,result);
    }

}