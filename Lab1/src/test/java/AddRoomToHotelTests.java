import org.example.Hotel;
import org.example.HotelCapability;
import org.example.Room;
import org.example.exceptions.RoomNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddRoomToHotelTests {
    @Test
    void addRoom_should_return_zero_when_first_room_was_added() {
        // Given
        HotelCapability hotel = new Hotel("***");

        // When
        String roomId = hotel.addRoom(8.5, 1, false, "Klasyczny wystrój");

        // Then
        assertEquals("0", roomId);
    }

    @Test
    void addRoom_should_return_next_number_as_id_when_new_room_was_added() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "1"));
        rooms.add(new Room(20, 1, true, "Luksus", "2"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "3"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "4"));

        HotelCapability hotel = new Hotel("Splendor", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        String roomId = hotel.addRoom(20, 2, false, "Dla palących");

        // Then
        assertEquals("5", roomId);
    }

    @Test
    void addRoom_should_return_next_number_as_id_when_there_is_a_gap_in_ids() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "1"));
        rooms.add(new Room(20, 1, true, "Luksus", "3"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "4"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "8"));

        HotelCapability hotel = new Hotel("Splendor", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        String roomId = hotel.addRoom(20, 2, false, "Dla palących");

        // Then
        assertEquals("9", roomId);
    }

    @Test
    void addRoom_should_return_next_number_as_id_when_there_is_text_in_id() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "a"));
        rooms.add(new Room(20, 1, true, "Luksus", "b"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "c"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "d"));

        HotelCapability hotel = new Hotel("Splendor", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        String roomId = hotel.addRoom(20, 2, false, "Dla palących");

        // Then
        assertEquals("0", roomId);
    }


    @Test
    void addRoom_should_add_room_to_hotel() throws RoomNotFoundException {
        // Given
        Hotel hotel = new Hotel("Splendor");

        // When
        String roomId = hotel.addRoom(15, 3, true, "Duże okna");

        // Then
        Room room = hotel.getRoomById(roomId);
        assertEquals(15, room.getArea());
        assertEquals(3, room.getFloor());
        assertTrue(room.isHasKingSizeBed());
        assertEquals("Duże okna", room.getDescription());
    }
}
