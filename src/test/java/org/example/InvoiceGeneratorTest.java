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
    public void givenMultipleRides_shouldReturnInvoiceForGivenUserId() {
        List<Ride> user1Rides = new ArrayList<>();
        user1Rides.add(new Ride(2.5, 5));
        user1Rides.add(new Ride(0.1, 1));
        User user1 = new User(1, "Priyanka", Long.parseLong("9518905320"), "pkshinde125@gmail.com");

        List<Ride> user2Rides = new ArrayList<>();
        user2Rides.add(new Ride(3.5, 5));
        user2Rides.add(new Ride(0.1, 1));
        user2Rides.add(new Ride(2.1, 3));
        User user2 = new User(2, "xyz", Long.parseLong("7515645320"), "xyz@gmail.com");

        RideRepository rideRepository = new RideRepository();
        rideRepository.userRides.put(user1, user1Rides);
        rideRepository.userRides.put(user2, user2Rides);

        InvoiceService invoiceService = new InvoiceService(rideRepository);
        Invoice invoice = invoiceService.getInvoice(2);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 69);
        Invoice expectedInvoice = new Invoice(user2, expectedInvoiceSummary);

        Assert.assertEquals(expectedInvoice, invoice);
    }

    @Test
    public void givenMultipleRides_whenRidesOfDifferentType_shouldReturnInvoiceForGivenUser() {
        List<Ride> user1Rides = new ArrayList<>();
        user1Rides.add(new Ride(2.5, 5,"normal"));
        user1Rides.add(new Ride(0.1, 1,"premium"));
        User user1 = new User(1, "Priyanka", Long.parseLong("9518905320"), "pkshinde125@gmail.com");

        List<Ride> user2Rides = new ArrayList<>();
        user2Rides.add(new Ride(3.5, 5,"normal"));
        user2Rides.add(new Ride(0.1, 1,"premium"));
        user2Rides.add(new Ride(2.1, 3,"premium"));
        User user2 = new User(2, "xyz", Long.parseLong("7515645320"), "xyz@gmail.com");
        RideRepository rideRepository = new RideRepository();
        rideRepository.userRides.put(user1, user1Rides);
        rideRepository.userRides.put(user2, user2Rides);

        InvoiceService invoiceService = new InvoiceService(rideRepository);
        Invoice invoice = invoiceService.getInvoice(2);

        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(3, 97.5);
        Invoice expectedInvoice = new Invoice(user2, expectedInvoiceSummary);

        Assert.assertEquals(expectedInvoice, invoice);
    }
}
