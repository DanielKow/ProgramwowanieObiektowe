package org.example;

public class Room {
    private String id;
    private double area;
    private int floor;
    private boolean hasKingSizeBed;

    private String standard;
    private int number;
    private int maxNumberOfGuests;
    private boolean isForSmokers;
    private boolean hasAirConditioner;

    public Room(String id, double area, int floor, boolean hasKingSizeBed, String standard, int number, int maxNumberOfGuests, boolean isForSmokers, boolean hasAirConditioner) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.standard = standard;
        this.number = number;
        this.maxNumberOfGuests = maxNumberOfGuests;
        this.isForSmokers = isForSmokers;
        this.hasAirConditioner = hasAirConditioner;
    }
}