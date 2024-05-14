import org.example.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetNumberOfUnderageClientsInHotelTests {
    @Test
    void getNumberOfUnderageClients_should_return_zero_when_there_are_no_underage_clients() {
        //  given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), new ArrayList<Room>());

        //  when
        int numberOfUnderageClients = hotel.getNumberOfUnderageClients();

        //  then
        assertEquals(0, numberOfUnderageClients);

    }

    @Test
    void getNumberOfUnderageClients_should_return_zero_when_there_are_no_clients() {
        //  given
        HotelCapability hotel = new Hotel("Syrenka");

        //  when
        int numberOfUnderageClients = hotel.getNumberOfUnderageClients();

        //  then
        assertEquals(0, numberOfUnderageClients);
    }

    @Test
    void getNumberOfUnderageClients_should_return_number_of_underage_clients() {
        //  given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.now().minusYears(7), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.now().minusYears(17), "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), new ArrayList<Room>());

        //  when
        int numberOfUnderageClients = hotel.getNumberOfUnderageClients();

        //  then
        assertEquals(2, numberOfUnderageClients);
    }

}
