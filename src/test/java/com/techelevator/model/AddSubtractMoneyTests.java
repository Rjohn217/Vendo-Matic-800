package com.techelevator.model;
import junit.framework.TestCase;
import org.junit.Assert;

public class AddSubtractMoneyTests extends TestCase {

    public void testAdd() {

        Money m1 = new Money(5);
        Money m2 = new Money(10);

        m1.add(m2);

        Assert.assertEquals(15, m1.getAmount());
    }

    public void testSubtract() {

        Money m1 = new Money(15);
        Money m2 = new Money(7);

        m1.subtract(m2);

        Assert.assertEquals(8,m1.getAmount());

    }
}
