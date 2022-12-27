package org.example;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_shouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateFare(2.5, 5);
        Assert.assertEquals(30, totalFare, 0.0);
    }

    @Test
    public void givenMinimumDistanceAndTime_shouldReturnMinimumFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateFare(0.1, 1);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_shouldReturnTotalFare() {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride(2.5,5));
        rides.add(new Ride(0.1,1));
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double totalFare = invoiceGenerator.calculateFare(rides);
        Assert.assertEquals(35,totalFare,0.0);
    }
}
