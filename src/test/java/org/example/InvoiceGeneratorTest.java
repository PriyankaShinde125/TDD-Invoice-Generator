package org.example;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateFare(2.5, 5);
        Assert.assertEquals(30,totalFare,0.0);
    }
}
