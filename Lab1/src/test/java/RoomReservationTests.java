import org.example.Client;
import org.example.Room;
import org.example.RoomReservation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoomReservationTests {
    @Test
    void roomReservation_should_not_be_confirmed_when_created() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", LocalDate.now().minusYears(20), "tomasz@radomski.pl", "123456789", true, "50052061199");
        Room room = new Room("2", 22.33, 2, true, "normal", 22, 4, false, false, "Bardzo wygodny");
        RoomReservation roomReservation = new RoomReservation(LocalDate.now().plusDays(4), client, room, "123");

        // When
        boolean isConfirmed = roomReservation.isConfirmed();

        // Then
        assertFalse(isConfirmed);
    }

    @Test
    void confirmReservation_should_confirm_reservation() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", LocalDate.now().minusYears(20), "tomasz@radomski.pl", "123456789", true, "50052061199");
        Room room = new Room("2", 22.33, 2, true, "normal", 22, 4, false, false, "Bardzo wygodny");
        RoomReservation roomReservation = new RoomReservation(LocalDate.now().plusDays(4), client, room, "123");

        // When
        roomReservation.confirmReservation();

        // Then
        assertTrue(roomReservation.isConfirmed());
    }
}
