package org.example;

//
import org.example.exceptions.ClientNotFoundException;
import org.example.exceptions.ReservationNotFoundException;
import org.example.exceptions.RoomNotFoundException;
import org.example.exceptions.RoomReservedException;

import java.time.LocalDate;
import java.util.Collection;

public interface HotelCapability {

    // clients //
    String addClient(String firstName, String lastName, LocalDate birthDate);
    String getClientFullName(String clientId);
    int getNumberOfUnderageClients();

    // rooms //
    String addRoom(double area, int floor, boolean hasKingSizeBed, String description);
    double getRoomArea(String roomId);
    int getNumberOfRoomsWithKingSizeBed(int floor);

    // reservations //
    String addNewReservation(String clientId, String roomId, LocalDate date)
        throws ClientNotFoundException, RoomNotFoundException, RoomReservedException;

    String confirmReservation(String reservationId)
        throws ReservationNotFoundException;

    boolean isRoomReserved(String roomId, LocalDate date)
        throws RoomNotFoundException;

    int getNumberOfUnconfirmedReservation(LocalDate date);

    Collection<String> getRoomIdsReservedByClient(String clientId)
        throws ClientNotFoundException;
}

