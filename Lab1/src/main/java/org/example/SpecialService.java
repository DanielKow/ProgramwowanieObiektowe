package org.example;

public abstract class SpecialService {

    private String name;

    public abstract void orderService();
    public abstract double getPrice();
    public abstract boolean isAccessible(int age);
    public abstract String getDescription();


}
