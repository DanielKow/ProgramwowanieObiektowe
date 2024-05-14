import org.example.*;
import org.example.exceptions.RoomNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsRoomReservedInHotelTests {
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "4", "6", "9", "11122"})
    void isRoomReserved_should_throw_RoomNotFoundException_when_there_are_no_rooms(String roomId) {
        // Given
        HotelCapability hotel = new Hotel("Fistaszki");

        // When
        // Then
        assertThrows(RoomNotFoundException.class, () -> hotel.isRoomReserved(roomId, LocalDate.now().plusDays(1)));
    }

    @Test
    void isRoomReserved_should_throw_RoomNotFoundException_when_there_is_no_room_with_given_id() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "2"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "3"));

        HotelCapability hotel = new Hotel("II", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        // Then
        assertThrows(RoomNotFoundException.class, () -> hotel.isRoomReserved("4", LocalDate.now().plusDays(2)));
    }

    @Test
    void isRoomReserved_should_return_false_when_there_are_no_reservations() throws RoomNotFoundException {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "2"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "3"));

        HotelCapability hotel = new Hotel("Motomoto", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        boolean isReserved = hotel.isRoomReserved("3", LocalDate.of(2024, 6, 6));

        // Then
        assertFalse(isReserved);
    }

    @Test
    void isRoomReserved_should_return_false_when_there_is_no_reservation_for_given_room_on_given_date() throws RoomNotFoundException {
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
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 1), clients.get(0), rooms.get(2), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 2), clients.get(1), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 3), clients.get(2), rooms.get(2), "2"));

        Hotel hotel = new Hotel("Brzydki", new ArrayList<>(), clients, reservations, rooms);

        // When
        boolean isReserved = hotel.isRoomReserved("3", LocalDate.of(2024, 1, 4));

        // Then
        assertFalse(isReserved);
    }

    @Test
    void isRoomReserved_should_return_false_when_there_is_reservation_for_given_room_on_given_date() throws RoomNotFoundException {
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
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 1), clients.get(0), rooms.get(2), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 2), clients.get(1), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 1, 3), clients.get(2), rooms.get(2), "2"));

        Hotel hotel = new Hotel("Brzydki", new ArrayList<>(), clients, reservations, rooms);

        // When
        boolean isReserved = hotel.isRoomReserved("3", LocalDate.of(2024, 1, 3));

        // Then
        assertFalse(isReserved);
    }
}
