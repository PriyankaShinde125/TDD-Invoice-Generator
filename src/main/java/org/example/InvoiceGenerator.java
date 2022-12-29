package org.example;

import java.util.List;

public class InvoiceGenerator {

    public static final int COST_PER_DISTANCE = 10;
    public static final int COST_PER_MINUTE = 1;
    public static final double MINIMUM_FARE = 5;
    public static final int PREMIUM_COST_PER_DISTANCE = 15;
    public static final int PREMIUM_COST_PER_MINUTE = 2;
    public static final double PREMIUM_MINIMUM_FARE = 20;

    public double calculateFare(double distance, int time) {
        double totalFare = COST_PER_DISTANCE * distance + COST_PER_MINUTE * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(double distance, int time, String type) {
        if (type.equalsIgnoreCase("premium")){
            double totalFare = PREMIUM_COST_PER_DISTANCE * distance + PREMIUM_COST_PER_MINUTE * time;
            return Math.max(totalFare, PREMIUM_MINIMUM_FARE);
        }
        else  return calculateFare(distance, time);
    }

    public InvoiceSummary calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.category);
        }
        return new InvoiceSummary(rides.size(), totalFare);
    }
}
