package org.example;

import org.example.exceptions.ClientNotFoundException;
import org.example.exceptions.ReservationNotFoundException;
import org.example.exceptions.RoomNotFoundException;
import org.example.exceptions.RoomReservedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Hotel implements HotelCapability {

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

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        String clientId = String.valueOf(clients.size());
        Client client = new Client(firstName, lastName, birthDate, clientId);

        clients.add(client);

        return clientId;
    }

    @Override
    public String getClientFullName(String clientId) {
        return "";
    }

    @Override
    public int getNumberOfUnderageClients() {
        return 0;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        return "";
    }

    @Override
    public double getRoomArea(String roomId) {
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        return 0;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        return "";
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        return "";
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        return false;
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        return 0;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        return List.of();
    }
}
