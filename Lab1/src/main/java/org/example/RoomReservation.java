package org.example;

import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private boolean isConfirmed;
    private Client client;
    private Room room;

    public RoomReservation(LocalDate date, Client client, Room room) {
        this.date = date;
        this.isConfirmed = false;
        this.client = client;
        this.room = room;
    }

    public void confirmReservation() {
        isConfirmed = true;
    }
}