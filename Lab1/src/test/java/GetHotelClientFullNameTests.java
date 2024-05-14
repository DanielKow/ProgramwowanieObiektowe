import org.example.Client;
import org.example.Hotel;
import org.example.HotelCapability;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetHotelClientFullNameTests {

    @Test
    void getClientFullName_should_return_empty_string_when_there_is_no_client_with_given_id() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stasiław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        HotelCapability hotel = new Hotel("Rover", new ArrayList<>(), clients, new ArrayList<>(), new ArrayList<>());

        // When
        String fullName = hotel.getClientFullName("55");

        // Then
        assertEquals("", fullName);
    }

    @Test
    void getClientFullName_should_return_empty_string_when_there_is_no_clients() {
        // Given
        HotelCapability hotel = new Hotel("Sójka");

        // When
        String fullName = hotel.getClientFullName("0");

        // Then
        assertEquals("", fullName);
    }

    @Test
    void getClientFullName_should_return_client_name_and_lastname_as_full_name_when_client_with_given_id_exists() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stasiław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        HotelCapability hotel = new Hotel("Rover", new ArrayList<>(), clients, new ArrayList<>(), new ArrayList<>());

        // When
        String fullName = hotel.getClientFullName("1");

        // Then
        assertEquals("Jan Kowalski", fullName);
    }
}
