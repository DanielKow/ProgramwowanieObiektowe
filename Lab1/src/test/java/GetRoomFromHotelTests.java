import org.example.Hotel;
import org.example.HotelCapability;
import org.example.Room;
import org.example.exceptions.RoomNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GetRoomFromHotelTests {
    @Test
    void getRoomById_should_throw_RoomNotFoundException_when_there_is_no_room_with_given_id() {
        // Given
        Hotel hotel = new Hotel("Spanko");

        // When
        // Then
        assertThrows(RoomNotFoundException.class, () -> hotel.getRoomById("1"));
    }

    @Test
    void getRoomById_should_return_room_when_room_with_given_id_exists() throws RoomNotFoundException {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(10, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 5, false, "Daleko od baru", "2"));
        rooms.add(new Room(10, 2, true, "Czerwone ściany", "3"));

        Hotel hotel = new Hotel("Przy drodze", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        Room room = hotel.getRoomById("2");

        // Then
        assertEquals(10, room.getArea());
        assertEquals(5, room.getFloor());
        assertFalse(room.isHasKingSizeBed());
        assertEquals("Daleko od baru", room.getDescription());
        assertEquals("2", room.getId());
    }


}
