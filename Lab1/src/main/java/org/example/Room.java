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
    private String description;

    public Room(double area, int floor, boolean hasKingSizeBed, String description, String id){
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.description = description;
        this.id = id;
    }

    public Room(String id, double area, int floor, boolean hasKingSizeBed, String standard, int number, int maxNumberOfGuests, boolean isForSmokers, boolean hasAirConditioner, String description) {
        this.id = id;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.standard = standard;
        this.number = number;
        this.maxNumberOfGuests = maxNumberOfGuests;
        this.isForSmokers = isForSmokers;
        this.hasAirConditioner = hasAirConditioner;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public boolean isHasKingSizeBed() {
        return hasKingSizeBed;
    }

    public String getStandard() {
        return standard;
    }

    public int getNumber() {
        return number;
    }

    public int getMaxNumberOfGuests() {
        return maxNumberOfGuests;
    }

    public boolean isForSmokers() {
        return isForSmokers;
    }

    public boolean isHasAirConditioner() {
        return hasAirConditioner;
    }

    public void setHasKingSizeBed(boolean hasKingSizeBed) {
        this.hasKingSizeBed = hasKingSizeBed;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public void setMaxNumberOfGuests(int maxNumberOfGuests) {
        this.maxNumberOfGuests = maxNumberOfGuests;
    }

    public void setForSmokers(boolean forSmokers) {
        isForSmokers = forSmokers;
    }

    public void setHasAirConditioner(boolean hasAirConditioner) {
        this.hasAirConditioner = hasAirConditioner;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}