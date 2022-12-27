package org.example;

import java.util.List;

public class InvoiceGenerator {

    public static final int COST_PER_DISTANCE = 10;
    public static final int COST_PER_MINUTE = 1;
    public static final double MINIMUM_FARE = 5;

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public double calculateFare(double distance, int time) {
        double totalFare = COST_PER_DISTANCE * distance + COST_PER_MINUTE * time;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateFare(List<Ride> rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}
