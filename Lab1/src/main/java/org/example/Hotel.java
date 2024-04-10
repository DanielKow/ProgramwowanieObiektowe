package org.example;

import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<SpecialService> specialServices;
    private ArrayList<Client> clients;
    private ArrayList<RoomReservation> reservations;
    private ArrayList<Room> rooms;

    // Ustawiamy wartości pól na puste listy, żeby nie zwracało nulla
    public Hotel(String name) {
        this.name = name;
        this.specialServices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    public Hotel(String name, ArrayList<SpecialService> specialServices, ArrayList<Client> clients, ArrayList<RoomReservation> reservations, ArrayList<Room> rooms) {
        this.name = name;
        this.specialServices = specialServices;
        this.clients = clients;
        this.reservations = reservations;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public ArrayList<SpecialService> getSpecialServices() {
        return specialServices;
    }
}
