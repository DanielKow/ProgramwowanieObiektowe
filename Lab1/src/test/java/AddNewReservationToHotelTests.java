import org.example.*;
import org.example.exceptions.ClientNotFoundException;
import org.example.exceptions.RoomNotFoundException;
import org.example.exceptions.RoomReservedException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AddNewReservationToHotelTests {
    @Test
    void addNewReservation_should_throw_ClientNotFoundException_when_client_with_given_id_does_not_exists() {
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertThrows(ClientNotFoundException.class, () -> hotel.addNewReservation("4", "1", LocalDate.now().plusDays(2)));

    }

    @Test
    void addNewReservation_should_not_throw_ClientNotFoundException_when_client_with_given_id_exists() {
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertDoesNotThrow(() -> hotel.addNewReservation("1", "1", LocalDate.now().plusDays(2)));
    }

    @Test
    void addNewReservation_should_throw_RoomNotFoundException_when_room_with_given_id_does_not_exists() {
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertThrows(RoomNotFoundException.class, () -> hotel.addNewReservation("1", "7", LocalDate.now().plusDays(2)));

    }

    @Test
    void addNewReservation_should_not_throw_RoomNotFoundException_when_room_with_given_id_exists() {
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

        // when
        // then
        assertDoesNotThrow(() -> hotel.addNewReservation("1", "1", LocalDate.now().plusDays(2)));
    }

    @Test
    void addNewReservation_should_throw_RoomReservedException_when_room_is_reserved_on_given_day() {
        // given
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

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // when
        // then
        assertThrows(RoomReservedException.class, () -> hotel.addNewReservation("3", "2", LocalDate.of(2024, 5, 13)));
    }

    @Test
    void addNewReservation_should_not_throw_RoomReservedException_when_room_is_not_reserved_on_given_day() {
        // given
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

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // when
        // then
        assertDoesNotThrow(() -> hotel.addNewReservation("3", "2", LocalDate.of(2024, 5, 14)));
    }

    @Test
    void addNewReservation_should_return_new_reservation_Id_when_it_was_added() throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        // given
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

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // when
        String reservationId = hotel.addNewReservation("1", "2", LocalDate.now().plusDays(1));

        // then
        assertEquals("1", reservationId);

    }

    @Test
    void addNewReservation_should_return_new_reservation_Id_when_it_was_added_and_there_was_no_reservation_yet() throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        // given
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

        // when
        String reservationId = hotel.addNewReservation("1", "2", LocalDate.now().plusDays(1));

        // then
        assertEquals("0", reservationId);

    }

    @Test
    void addNewReservation_should_return_new_reservation_Id_when_it_was_added_and_there_were_many_reservations_already() throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        // given
        ArrayList<Client> clients = new ArrayList<>();
        clients.add(new Client("Marek", "Nowak", LocalDate.of(2001, 3, 27), "1"));
        clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999, 2, 7), "2"));
        clients.add(new Client("Rek", "Rekin", LocalDate.of(1789, 11, 28), "3"));

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Ładny z widokiem na morze", "1"));
        rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
        rooms.add(new Room(17, 2, true, "Przyjemny z kominkiem", "3"));

        ArrayList<RoomReservation> reservations = new ArrayList<>();
        reservations.add(new RoomReservation(LocalDate.of(2025, 5, 13), clients.get(1), rooms.get(0), "0"));
        reservations.add(new RoomReservation(LocalDate.of(2024, 7, 13), clients.get(2), rooms.get(1), "1"));
        reservations.add(new RoomReservation(LocalDate.of(2022, 5, 15), clients.get(0), rooms.get(2), "2"));
        reservations.add(new RoomReservation(LocalDate.of(2021, 5, 10), clients.get(1), rooms.get(0), "3"));
        reservations.add(new RoomReservation(LocalDate.of(2019, 1, 7), clients.get(2), rooms.get(1), "4"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), clients, reservations, rooms);

        // when
        String reservationId = hotel.addNewReservation("1", "2", LocalDate.now().plusDays(1));

        // then
        assertEquals("5", reservationId);

    }


    /***
     @Test void addNewReservation_should_not_add_reservation_when_client_is_underage(){
     // given
     ArrayList<Client> clients = new ArrayList<>();
     clients.add(new Client("Marek", "Nowak", LocalDate.of(2001,3,27),"1"));
     clients.add(new Client("Arek", "Kwiatek", LocalDate.of(1999,2,7),"2"));
     clients.add(new Client("Rek", "Rekin", LocalDate.of(2017,11,28),"3"));


     ArrayList<Room> rooms = new ArrayList<>();
     rooms.add(new Room( 30, 2, true, "Ładny z widokiem na morze", "1"));
     rooms.add(new Room(25, 1, true, "Brzydki bez widoku na morze", "2"));
     rooms.add(new Room( 17, 2, true, "Przyjemny z kominkiem", "3"));

     HotelCapability hotel = new Hotel("Syrenka",new ArrayList<SpecialService>(), clients, new ArrayList<RoomReservation>(), rooms);

     String reservationId = null;

     // when
     try {
     reservationId = hotel.addNewReservation("3","3", LocalDate.now().plusDays(2));
     } catch (ClientNotFoundException e) {
     fail("Brak klienta");
     } catch (RoomNotFoundException e) {
     fail("Brak pokoju");
     }

     // then
     assertNull(reservationId);


     }
     ***/


}
