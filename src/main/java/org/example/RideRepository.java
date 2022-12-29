package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    Map<User, List<Ride>> userRides;

    public RideRepository() {
        userRides = new HashMap<>();
    }

    public RideRepository(Map<User, List<Ride>> userRides) {
        this.userRides = userRides;
    }

    public Map<User, List<Ride>> getUserRides() {
        return userRides;
    }

    public void setUserRides(Map<User, List<Ride>> userRides) {
        this.userRides = userRides;
    }
}
