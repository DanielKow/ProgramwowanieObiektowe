import org.example.Hotel;
import org.example.HotelCapability;
import org.example.Room;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNumberOfRoomsWithKingSizeBedInHotelTests {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 20, 50})
    void getNumberOfRoomsWithKingSizeBed_should_return_zero_when_there_are_no_rooms(int floor) {
        // Given
        HotelCapability hotel = new Hotel("Franek");

        // When
        int numberOfRoomsWithKingSizeBed = hotel.getNumberOfRoomsWithKingSizeBed(floor);

        // Then
        assertEquals(0, numberOfRoomsWithKingSizeBed);
    }

    @Test
    void getNumberOfRoomsWithKingSizeBed_should_return_zero_when_there_are_no_rooms_with_king_size_bed_on_the_floor() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(21.37, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 2, false, "Daleko od baru", "2"));
        rooms.add(new Room(4.20, 2, true, "Czerwone ściany", "3"));
        rooms.add(new Room(10, 3, false, "Zielone ściany", "4"));

        Hotel hotel = new Hotel("Józio", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        int numberOfRoomsWithKingSizeBed = hotel.getNumberOfRoomsWithKingSizeBed(3);

        // Then
        assertEquals(0, numberOfRoomsWithKingSizeBed);
    }

    @Test
    void getNumberOfRoomsWithKingSizeBed_should_return_zero_when_there_are_no_rooms_on_the_floor() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(21.37, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 2, false, "Daleko od baru", "2"));
        rooms.add(new Room(4.20, 2, true, "Czerwone ściany", "3"));

        Hotel hotel = new Hotel("Jan", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        int numberOfRoomsWithKingSizeBed = hotel.getNumberOfRoomsWithKingSizeBed(3);

        // Then
        assertEquals(0, numberOfRoomsWithKingSizeBed);
    }

    @Test
    void getNumberOfRoomsWithKingSizeBed_should_return_number_of_rooms_with_king_size_bed_on_the_floor() {
        // Given
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room(21.37, 1, false, "Blisko baru", "0"));
        rooms.add(new Room(20, 1, true, "Luksus", "1"));
        rooms.add(new Room(10, 2, false, "Daleko od baru", "2"));
        rooms.add(new Room(4.20, 2, true, "Czerwone ściany", "3"));
        rooms.add(new Room(10, 2, true, "Zielone ściany", "4"));

        Hotel hotel = new Hotel("Józio", new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), rooms);

        // When
        int numberOfRoomsWithKingSizeBed = hotel.getNumberOfRoomsWithKingSizeBed(2);

        // Then
        assertEquals(2, numberOfRoomsWithKingSizeBed);
    }
}
