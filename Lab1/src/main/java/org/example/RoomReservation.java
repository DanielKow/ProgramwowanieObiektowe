package org.example;

import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private boolean isConfirmed;
    private Client client;
    private Room room;
    private String id;



    public RoomReservation(LocalDate date, Client client, Room room, String id ) {
        this.date = date;
        this.isConfirmed = false;
        this.client = client;
        this.room = room;
        this.id = id;
    }

    public void confirmReservation() {
        isConfirmed = true;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public Client getClient() {
        return client;
    }

    public Room getRoom() {
        return room;
    }

    public String getId() {
        return id;
    }

}
