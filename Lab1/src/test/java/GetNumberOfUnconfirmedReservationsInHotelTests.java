import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNumberOfUnconfirmedReservationsInHotelTests {
    @Test
    void getNumberOfUnconfirmedReservations_should_return_zero_when_there_are_no_reservations() {
        // Given
        HotelCapability hotel = new Hotel("Transylwania");

        // When
        int count = hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2024, 2, 3));

        // Then
        assertEquals(0, count);
    }
    
    @Test
    void getNumberOfUnconfirmedReservations_should_return_zero_when_there_are_no_reservations_on_given_date() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Krzysztof", "Bosak", LocalDate.of(1982, 6, 13), "0"));
        clients.add(new Client("Janusz", "Korwin-Mikke", LocalDate.of(1942, 10, 27), "1"));
        clients.add(new Client("Grzegorz", "Braun", LocalDate.of(1967, 3, 11), "2"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(20, 1, false, "Standardowy", "0"));
        rooms.add(new Room(20, 1, false, "Standardowy", "1"));
        rooms.add(new Room(20, 1, false, "Standardowy", "2"));
        rooms.add(new Room(20, 1, false, "Standardowy", "3"));

        ArrayList<RoomReservation> roomReservations = new ArrayList<>();
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(0), rooms.get(0), "0"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(1), rooms.get(1), "1"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 6, 6), clients.get(2), rooms.get(2), "2"));

        HotelCapability hotel = new Hotel("Konfa", new ArrayList<>(), clients, roomReservations, rooms);

        // When
        int count = hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2024, 6, 7));
        
        // Then
        assertEquals(0, count);
    }

    @Test
    void getNumberOfUnconfirmedReservations_should_return_number_of_unconfirmed_reservations_on_given_date() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Zbigniew", "Ziobro", LocalDate.of(1970, 8, 18), "0"));
        clients.add(new Client("Jarosław", "Kaczyński", LocalDate.of(1949, 6, 18), "1"));
        clients.add(new Client("Andrzej", "Duda", LocalDate.of(1972, 5, 16), "2"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(35.38, 2, true, "Premium", "0"));
        rooms.add(new Room(35.38, 2, true, "Premium", "1"));
        rooms.add(new Room(35.38, 2, true, "Premium", "2"));
        rooms.add(new Room(35.38, 2, true, "Premium", "3"));

        ArrayList<RoomReservation> roomReservations = new ArrayList<>();
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(0), rooms.get(0), "0"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(1), rooms.get(1), "1"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(2), rooms.get(2), "2"));

        HotelCapability hotel = new Hotel("Piękny i Spokojny", new ArrayList<>(), clients, roomReservations, rooms);

        // When
        int count = hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2024, 8, 7));

        // Then
        assertEquals(3, count);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getNumberOfUnconfirmedReservations_should_return_number_of_unconfirmed_reservations_on_given_date_when_some_reservations_are_confirmed(int confirmed) {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Donald", "Tusk", LocalDate.of(1957, 4, 22), "0"));
        clients.add(new Client("Szymon", "Hołowna", LocalDate.of(1976, 9, 3), "1"));
        clients.add(new Client("Anna Maria", "Żukowaska", LocalDate.of(1983, 6, 11), "2"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(25, 3, false, "Z widokiem na morze", "0"));
        rooms.add(new Room(25, 3, true, "Z widokiem na morze", "1"));
        rooms.add(new Room(25, 3, false, "Z widokiem na morze", "2"));
        rooms.add(new Room(25, 3, true, "Z widokiem na morze", "3"));

        ArrayList<RoomReservation> roomReservations = new ArrayList<>();
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(0), rooms.get(0), "0"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(1), rooms.get(1), "1"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(2), rooms.get(2), "2"));

        HotelCapability hotel = new Hotel("Gdynia", new ArrayList<>(), clients, roomReservations, rooms);

        for (int i = 0; i < confirmed; i++) {
            hotel.confirmReservation(String.valueOf(i));
        }

        // When
        int count = hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2024, 8, 7));

        // Then
        assertEquals(3 - confirmed, count);
    }

    @Test
    void getNumberOfUnconfirmedReservations_should_return_number_of_unconfirmed_reservations_only_on_given_date() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Maciej", "Wąsick", LocalDate.of(1969, 10, 16), "0"));
        clients.add(new Client("Michał", "Wójcik", LocalDate.of(1971, 4, 17), "1"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(5, 3, false, "Przytulny", "0"));
        rooms.add(new Room(5, 3, false, "Przytulny", "1"));

        ArrayList<RoomReservation> roomReservations = new ArrayList<>();
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(0), rooms.get(0), "0"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 7), clients.get(1), rooms.get(0), "1"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 10), clients.get(0), rooms.get(1), "2"));
        roomReservations.add(new RoomReservation(LocalDate.of(2024, 8, 10), clients.get(1), rooms.get(1), "3"));

        HotelCapability hotel = new Hotel("Piękny i Spokojny", new ArrayList<>(), clients, roomReservations, rooms);

        // When
        int count = hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2024, 8, 7));

        // Then
        assertEquals(2, count);

    }
}
