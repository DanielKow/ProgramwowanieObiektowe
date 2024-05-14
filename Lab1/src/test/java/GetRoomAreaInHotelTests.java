import org.example.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class GetRoomAreaInHotelTests {

    @Test
    void getRoomArea_should_return_zero_when_room_with_given_id_does_not_exist() {
        //  given

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Czysto", "0"));
        rooms.add(new Room(25.45, 1, false, "Czysto", "1"));
        rooms.add(new Room(17.99, 2, true, "Czysto", "2"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), new ArrayList<Client>(), new ArrayList<RoomReservation>(), rooms);
        //  when
        double roomArea = hotel.getRoomArea("5");

        //  then
        assertEquals(0, roomArea);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "20", "100"})
    void getRoomArea_should_return_zero_when_there_are_no_rooms(String roomId) {
        //  given

        ArrayList<Room> rooms = new ArrayList<>();

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), new ArrayList<Client>(), new ArrayList<RoomReservation>(), rooms);
        //  when
        double roomArea = hotel.getRoomArea(roomId);

        //  then
        assertEquals(0, roomArea);
    }


    @Test
    void getRoomArea_should_return_area_when_there_is_room_with_given_id() {
        //  given

        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(30, 2, true, "Czysto", "0"));
        rooms.add(new Room(25.45, 1, false, "Czysto", "1"));
        rooms.add(new Room(17.99, 2, true, "Czysto", "2"));

        HotelCapability hotel = new Hotel("Syrenka", new ArrayList<SpecialService>(), new ArrayList<Client>(), new ArrayList<RoomReservation>(), rooms);
        //  when
        double roomArea = hotel.getRoomArea("1");

        //  then
        assertEquals(25.45, roomArea);
    }

}
