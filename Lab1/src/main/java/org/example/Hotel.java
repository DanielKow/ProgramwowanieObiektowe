package org.example;

import org.example.exceptions.ClientNotFoundException;
import org.example.exceptions.ReservationNotFoundException;
import org.example.exceptions.RoomNotFoundException;
import org.example.exceptions.RoomReservedException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

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
        int maxClientId = getCurrentMaxClientId();
        String clientId = String.valueOf(maxClientId + 1);

        Client client = new Client(firstName, lastName, birthDate, clientId);

        clients.add(client);

        return clientId;
    }

    @Override
    public String getClientFullName(String clientId) {
        Optional<Client> client = clients.stream().filter(c -> c.getId().equals(clientId)).findFirst();
        if (client.isEmpty()) {
            return "";
        }

        return client.get().getFullName();
    }

    @Override
    public int getNumberOfUnderageClients() {
        int numberOfUnderageClients = 0;
        for (Client client : clients) {

            if (client.getAge() < 18) {
                numberOfUnderageClients++;
            }
        }

        return numberOfUnderageClients;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        int maxRoomId = getCurrentMaxRoomId();
        String roomId = String.valueOf(maxRoomId + 1);
        Room room = new Room(area, floor, hasKingSizeBed, description, roomId);

        rooms.add(room);
        return roomId;
    }

    @Override
    public double getRoomArea(String roomId) {
        for (Room room : rooms) {
            if (roomId.equals(room.getId())) {
                return room.getArea();
            }
        }
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {

        int count = 0;
        for (Room room : rooms) {
            if (floor == room.getFloor() && room.isHasKingSizeBed()) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        Client client = getClientById(clientId);
        Room room = getRoomById(roomId);

        for (RoomReservation tempReservation : reservations) {
            if (room.getId().equals(tempReservation.getRoom().getId()) && date.isEqual(tempReservation.getDate())) {
                throw new RoomReservedException(roomId, date);
            }
        }

        int maxReservationId = getCurrentMaxReservationId();
        String reservationId = String.valueOf(maxReservationId + 1);

        RoomReservation reservation = new RoomReservation(date, client, room, reservationId);
        reservations.add(reservation);
        return reservationId;
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {

        for (RoomReservation reservation : reservations) {
            if (reservationId.equals(reservation.getId())) {
                reservation.confirmReservation();
                return reservationId;
            }
        }
        throw new ReservationNotFoundException("Rezerwacja nie została znaleziona");

    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {

        Room room = getRoomById(roomId);

        for (RoomReservation reservation : reservations) {
            if (room.getId().equals(reservation.getRoom().getId()) && date.isEqual(reservation.getDate())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {

        int count = 0;
        for (RoomReservation reservation : reservations) {
            if (!reservation.isConfirmed() && date.isEqual(reservation.getDate())) {
                count++;
            }
        }
        return count;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {

        Client client = getClientById(clientId);

        ArrayList<String> roomIds = new ArrayList<>();

        for (RoomReservation reservation : reservations) {
            if (client.getId().equals(reservation.getClient().getId())) {
                roomIds.add(reservation.getRoom().getId());
            }
        }
        return roomIds;
    }

    public Client getClientById(String clientId) throws ClientNotFoundException {
        Client client = null;
        for (Client tempClient : clients) {
            if (clientId.equals(tempClient.getId())) {
                client = tempClient;
                break;
            }
        }
        if (client == null) {

            throw new ClientNotFoundException("Klient nie zostal znaleziony");
        }
        return client;
    }

    public Room getRoomById(String roomId) throws RoomNotFoundException {
        Room room = null;
        for (Room tempRoom : rooms) {
            if (roomId.equals(tempRoom.getId())) {
                room = tempRoom;
                break;
            }
        }
        if (room == null) {

            throw new RoomNotFoundException("Pokój nie zostal znaleziony");
        }

        return room;
    }

    public RoomReservation getRoomReservationById(String reservationId) throws ReservationNotFoundException {
        RoomReservation reservation = null;
        for (RoomReservation tempReservation : reservations) {
            if (reservationId.equals(tempReservation.getId())) {
                reservation = tempReservation;
                break;
            }
        }
        if (reservation == null) {

            throw new ReservationNotFoundException("Rezerwacja nie została znaleziona");
        }

        return reservation;
    }

    private int getCurrentMaxClientId() {
        int maxId = -1;
        for (Client client : clients) {
            try {
                int clientId = Integer.parseInt(client.getId());
                if (clientId > maxId) {
                    maxId = clientId;
                }
            } catch (NumberFormatException ignored) {}
        }

        return maxId;
    }

    private int getCurrentMaxReservationId() {
        int maxId = -1;

        for (RoomReservation reservation : reservations) {
            try {
                int reservationId = Integer.parseInt(reservation.getId());
                if (reservationId > maxId) {
                    maxId = reservationId;
                }
            } catch (NumberFormatException ignored) {}
        }

        return maxId;
    }

    private int getCurrentMaxRoomId() {
        int maxId = -1;

        for (Room room : rooms) {
            try {
                int roomId = Integer.parseInt(room.getId());
                if (roomId > maxId) {
                    maxId = roomId;
                }
            } catch (NumberFormatException ignored){}
        }

        return maxId;
    }
}
