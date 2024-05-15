import org.example.*;
import org.example.exceptions.ClientNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class GetRoomIdsReservedByClientInHotelTests {
    @Test
    void getRoomIdsReservedByClient_should_return_empty_list_when_there_are_no_reservations_for_client_with_given_id() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "3"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("0");

        // Then
        assertEquals(0, roomIds.size());
    }

    @Test
    void getRoomIdsReservedByClient_should_throw_ClientNotFoundException_when_there_is_no_client_with_given_id() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "3"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        // When
        // Then
        assertThrows(ClientNotFoundException.class, () -> hotel.getRoomIdsReservedByClient("5"));
    }

    @Test
    void getRoomIdsReservedByClient_should_return_list_of_room_ids_reserved_by_client_with_given_id() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "3"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("2");

        // Then
        assertEquals(2, roomIds.size());
        assertTrue(roomIds.contains("2"));
        assertTrue(roomIds.contains("3"));
    }

    @Test
    void getRoomIdsReservedByClient_should_return_empty_list_when_there_are_no_rooms() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        HotelCapability hotel = new Hotel("Bez Kosmonautów", new ArrayList<>(), clients, new ArrayList<>(), new ArrayList<>());

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("2");

        // Then
        assertEquals(0, roomIds.size());
    }

    @Test
    void getRoomIdsReservedByClient_should_return_list_of_room_ids_reserved_by_client_with_given_id_when_there_is_only_one_reservation() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "3"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("1");

        // Then
        assertEquals(1, roomIds.size());
        assertTrue(roomIds.contains("1"));
    }

    @Test
    void getRoomIdsReservedByClient_should_return_empty_list_when_there_are_no_reservations() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        HotelCapability hotel = new Hotel("Bez Kosmonautów", new ArrayList<>(), clients, new ArrayList<>(), rooms);

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("2");

        // Then
        assertEquals(0, roomIds.size());
    }

    @Test
    void getRoomIdsReservedByClient_should_return_distinct_list_of_room_ids_when_same_room_was_reserved_many_times() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 7), clients.get(1), rooms.get(1), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 8), clients.get(1), rooms.get(2), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 9), clients.get(1), rooms.get(1), "3"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "4"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 7), clients.get(2), rooms.get(2), "5"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "6"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "7"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("1");

        // Then
        assertEquals(2, roomIds.size());
        assertTrue(roomIds.contains("1"));
        assertTrue(roomIds.contains("2"));
    }

    @Test
    void getRoomIdsReservedByClient_should_return_list_of_room_ids_reserved_by_client_when_reservations_were_confirmed() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Mariola", "Kiepska", LocalDate.of(1983, 6, 6), "0"));
        clients.add(new Client("Marian", "Paździoch", LocalDate.of(1939, 10, 12), "1"));
        clients.add(new Client("Arnold", "Boczek", LocalDate.of(1964, 3, 8), "2"));
        clients.add(new Client("Ferdynand", "Kiepski", LocalDate.of(1950, 7, 9), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Ćwiartki 3/3", "0"));
        rooms.add(new Room(25, 4, false, "Ćwiartki 3/4", "1"));
        rooms.add(new Room(25, 5, false, "Ćwiartki 3/5", "2"));
        rooms.add(new Room(25, 6, false, "Ćwiartki 3/6", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 10), clients.get(2), rooms.get(3), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(3), rooms.get(0), "3"));

        HotelCapability hotel = new Hotel("Kosmonautów", new ArrayList<>(), clients, reservations, rooms);

        hotel.confirmReservation("2");

        // When
        Collection<String> roomIds = hotel.getRoomIdsReservedByClient("2");

        // Then
        assertEquals(2, roomIds.size());
        assertTrue(roomIds.contains("2"));
        assertTrue(roomIds.contains("3"));
    }
}
