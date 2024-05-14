import org.example.Client;
import org.example.Hotel;
import org.example.Room;
import org.example.RoomReservation;
import org.example.exceptions.ReservationNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetRoomReservationFromHotelTests {

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "2", "3", "1112", "42"})
    void getRoomReservationById_should_throw_ReservationNotFoundException_when_there_are_no_reservations(String reservationId) {
        // Given
        Hotel hotel = new Hotel("Piękny");

        // When
        // Then
        assertThrows(ReservationNotFoundException.class, () -> hotel.getRoomReservationById(reservationId));
    }

    @Test
    void getRoomReservationById_should_throw_ReservationNotFoundException_when_there_is_no_reservation_with_given_id() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "2"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "3"));

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stanisław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 1), clients.get(0), rooms.get(0), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 2), clients.get(1), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 3), clients.get(2), rooms.get(2), "2"));

        Hotel hotel = new Hotel("Zły", new ArrayList<>(), clients, reservations, rooms);

        // When
        // Then
        assertThrows(ReservationNotFoundException.class, () -> hotel.getRoomReservationById("69"));
    }

    @Test
    void getRoomReservationById_should_return_room_reservation_when_room_with_given_id_exists() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "2"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "3"));

        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stanisław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 1), clients.get(0), rooms.get(0), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 2), clients.get(1), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 3), clients.get(2), rooms.get(2), "2"));

        Hotel hotel = new Hotel("Zły", new ArrayList<>(), clients, reservations, rooms);

        // When
        RoomReservation reservation = hotel.getRoomReservationById("1");

        // Then
        assertEquals("2", reservation.getClient().getId());
        assertEquals("2", reservation.getRoom().getId());
        assertEquals(LocalDate.of(2024, 1, 2), reservation.getDate());
        assertEquals("1", reservation.getId());
    }
}
