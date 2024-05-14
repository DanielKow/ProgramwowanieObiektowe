import org.example.*;
import org.example.exceptions.ReservationNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ConfirmReservationInHotelTests {
    @Test
    void confirmReservation_should_throw_ReservationNotFoundException_when_reservation_with_given_id_does_not_exist() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 13), clients.get(0), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 14), clients.get(1), rooms.get(2), "1"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // When
        // Then
        assertThrows(ReservationNotFoundException.class, () -> hotel.confirmReservation("3"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "0", "1", "2", "11", "404"})
    void confirmReservation_should_throw_ReservationNotFoundException_when_there_are_not_reservations(String reservationId) {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // When
        // Then
        assertThrows(ReservationNotFoundException.class, () -> hotel.confirmReservation(reservationId));
    }

    @Test
    void confirmReservation_should_confirm_reservation_with_given_id() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 13), clients.get(0), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 14), clients.get(1), rooms.get(2), "1"));

        Hotel hotel = new Hotel("Paweł", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // When
        String reservationId = hotel.confirmReservation("0");

        // Then
        RoomReservation reservation = hotel.getRoomReservationById(reservationId);
        assertTrue(reservation.isConfirmed());
    }

    @Test
    void confirmReservation_should_not_confirm_other_reservation() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 13), clients.get(0), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 14), clients.get(1), rooms.get(2), "1"));

        Hotel hotel = new Hotel("Paweł", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // When
        String reservationId = hotel.confirmReservation("0");

        // Then
        RoomReservation reservation = hotel.getRoomReservationById("1");
        assertFalse(reservation.isConfirmed());
    }

    @Test
    void confirmReservation_should_return_id_of_confirmed_reservation() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 13), clients.get(0), rooms.get(1), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 5, 14), clients.get(1), rooms.get(2), "1"));

        Hotel hotel = new Hotel("Paweł", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // When
        String reservationId = hotel.confirmReservation("0");

        // Then
        assertEquals("0", reservationId);
    }
}
