package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class InvoiceService {

    RideRepository rideRepository;

    public InvoiceService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Invoice getInvoice(int userId) {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        User user = rideRepository.userRides.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().id == userId)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElseThrow();
        List<Ride> userRides = rideRepository.userRides.get(user);
        InvoiceSummary invoiceSummary = invoiceGenerator.calculateFare(userRides);
        Invoice invoice = new Invoice(user, invoiceSummary);
        return invoice;
    }
}
