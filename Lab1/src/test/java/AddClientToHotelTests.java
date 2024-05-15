import org.example.*;
import org.example.exceptions.ClientNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddClientToHotelTests {

    @Test
    void addClient_should_return_zero_as_id_for_first_client() {
        // Given
        HotelCapability hotel = new Hotel("Złotoryjski");

        // When
        String clientId = hotel.addClient("Tomasz", "Radomski", LocalDate.of(1997, 11, 2));

        // Then
        assertEquals("0", clientId);
    }

    @Test
    void addClient_should_return_next_number_as_id_for_newly_created_client() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Piotr", "Szatkowski", LocalDate.of(1998, 2, 4), "0"));
        clients.add(new Client("Adam", "Kadłuczka", LocalDate.of(1995, 12, 30), "1"));
        clients.add(new Client("Balbina", "Bujak", LocalDate.of(1999, 2, 14), "2"));
        clients.add(new Client("Piotr", "Protasiewicz", LocalDate.of(1992, 7, 23), "3"));

        HotelCapability hotel = new Hotel("Nova", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), new ArrayList<Room>());

        // When
        String clientId = hotel.addClient("Piotr", "Pikuła", LocalDate.of(2000, 9, 2));

        // Then
        assertEquals("4", clientId);
    }

    @Test
    void addClient_should_return_next_number_as_id_for_newly_created_client_even_if_there_is_a_gap_in_ids() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Piotr", "Szatkowski", LocalDate.of(1998, 2, 4), "1"));
        clients.add(new Client("Adam", "Kadłuczka", LocalDate.of(1995, 12, 30), "0"));
        clients.add(new Client("Balbina", "Bujak", LocalDate.of(1999, 2, 14), "2"));
        clients.add(new Client("Piotr", "Protasiewicz", LocalDate.of(1992, 7, 23), "4"));

        HotelCapability hotel = new Hotel("Nova", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), new ArrayList<Room>());

        // When
        String clientId = hotel.addClient("Piotr", "Pikuła", LocalDate.of(2000, 9, 2));

        // Then
        assertEquals("5", clientId);
    }

    @Test
    void addClient_should_return_next_number_as_id_for_newly_created_client_even_if_there_is_a_text_in_id() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Piotr", "Szatkowski", LocalDate.of(1998, 2, 4), "a"));
        clients.add(new Client("Adam", "Kadłuczka", LocalDate.of(1995, 12, 30), "1"));
        clients.add(new Client("Balbina", "Bujak", LocalDate.of(1999, 2, 14), "b"));
        clients.add(new Client("Piotr", "Protasiewicz", LocalDate.of(1992, 7, 23), "c2"));

        HotelCapability hotel = new Hotel("Nova", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), new ArrayList<Room>());

        // When
        String clientId = hotel.addClient("Piotr", "Pikuła", LocalDate.of(2000, 9, 2));

        // Then
        assertEquals("2", clientId);
    }

    @Test
    void addClient_should_add_client_to_hotel() throws ClientNotFoundException {
        // Given
        Hotel hotel = new Hotel("Novy");

        // When
        hotel.addClient("Jan", "Kowalski", LocalDate.of(2000, 1, 18));

        // Then
        Client client = hotel.getClientById("0");
        assertEquals("Jan", client.getFirstName());
        assertEquals("Kowalski", client.getLastName());
        assertEquals(LocalDate.of(2000, 1, 18), client.getBirthDate());
    }

}
