package org.example;

public class Ride {
    public int time;
    public double distance;
    public String category;

    public Ride(double distance, int time, String category) {
        this.time = time;
        this.distance = distance;
        this.category = category;
    }

    public Ride(double distance, int time) {
        this.distance = distance;
        this.time = time;
        this.category = "normal";
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

}
