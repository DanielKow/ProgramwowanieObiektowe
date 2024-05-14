import org.example.Client;
import org.example.Hotel;
import org.example.SpecialService;
import org.example.exceptions.ClientNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetClientFromHotelTests {

    @Test
    void getClientById_should_return_client_with_given_id() throws ClientNotFoundException {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stasiław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        Hotel hotel = new Hotel("Rover", new ArrayList<>(), clients, new ArrayList<>(), new ArrayList<>());

        // When
        Client client = hotel.getClientById("2");

        // Then
        assertEquals("Adam", client.getFirstName());
        assertEquals("Nowak", client.getLastName());
        assertEquals(LocalDate.of(2012, 12, 23), client.getBirthDate());
        assertEquals("2", client.getId());
    }

    @Test
    void getClientById_should_throw_ClientNotFoundException_when_there_is_no_client_with_given_id() {
        // Given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Jan", "Kowalski", LocalDate.of(2002, 2, 3), "1"));
        clients.add(new Client("Adam", "Nowak", LocalDate.of(2012, 12, 23), "2"));
        clients.add(new Client("Stasiław", "Staszowki", LocalDate.of(2008, 12, 29), "3"));

        Hotel hotel = new Hotel("Rover", new ArrayList<>(), clients, new ArrayList<>(), new ArrayList<>());

        // When
        // Then
        assertThrows(ClientNotFoundException.class, () -> hotel.getClientById("5"));
    }
}
