import org.example.*;
import org.example.exceptions.ClientNotFoundException;
import org.example.exceptions.RoomNotFoundException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class HotelTests {
    @Test
    void addNewReservation_should_throw_ClientNotFoundException_when_client_with_given_id_does_not_exists(){
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001,3,27),"1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999,2,7),"2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789,11,28),"3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room( 30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room( 17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka",new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertThrows(ClientNotFoundException.class,()->hotel.addNewReservation("4", "1", LocalDate.now().plusDays(2)));

    }

    @Test
    void addNewReservation_should_not_throw_ClientNotFoundException_when_client_with_given_id_exists(){
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001,3,27),"1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999,2,7),"2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789,11,28),"3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room( 30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room( 17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka",new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertDoesNotThrow(()->hotel.addNewReservation("1", "1", LocalDate.now().plusDays(2)));
    }

    @Test
    void addNewReservation_should_throw_RoomNotFoundException_when_room_with_given_id_does_not_exists(){
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001,3,27),"1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999,2,7),"2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789,11,28),"3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room( 30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room( 17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka",new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertThrows(RoomNotFoundException.class,()->hotel.addNewReservation("1", "7", LocalDate.now().plusDays(2)));

    }

    @Test
    void addNewReservation_should_not_throw_RoomNotFoundException_when_room_with_given_id_exists(){
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001,3,27),"1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999,2,7),"2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789,11,28),"3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room( 30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room( 17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka",new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertDoesNotThrow(()->hotel.addNewReservation("1", "1", LocalDate.now().plusDays(2)));
    }

}

