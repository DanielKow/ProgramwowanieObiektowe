import org.example.Client;
import org.example.PremiumClient;
import org.example.Room;
import org.example.RoomReservation;

import java.sql.SQLOutput;
import java.time.LocalDate;

public class Test {
    @org.junit.jupiter.api.Test
    public void getFullNameShouldReturnNameAndLastNameIfSecondNameWasNotGiven() {
        Client client1 = new Client("1", "Jan", "Kowalski", LocalDate.of(1990, 1, 3), "jakowalski@gmail.com", "123123123", true, "XXX1234");
        Client client2 = new Client("2", "Adam", "Nowak", LocalDate.of(1990, 1, 3), "test1@gmail.com", "123123123", true, "XXX1234", "Janusz");
        Client client3 = new Client("3", "Alicja", "Kotowska", LocalDate.of(1990, 1, 3), "test2@gmail.com", "123123123", false, "XXX1234", "    ");

        System.out.println(client1.getFullName());
        System.out.println(client2.getFullName());
        System.out.println(client3.getFullName());
    }

    @org.junit.jupiter.api.Test
    public void getAge() {
        Client client1 = new Client("1", "Jan", "Kowalski", LocalDate.of(1990, 1, 3), "jakowalski@gmail.com", "123123123", true, "XXX1234");
        Client client2 = new Client("2", "Adam", "Nowak", LocalDate.of(2000, 4, 20), "test1@gmail.com", "123123123", true, "XXX1234", "Janusz");
        Client client3 = new Client("3", "Alicja", "Kotowska", LocalDate.of(2006, 3, 2), "test2@gmail.com", "123123123", false, "XXX1234", "    ");

        System.out.println(client1.getAge());
        System.out.println(client2.getAge());
        System.out.println(client3.getAge());
    }

    @org.junit.jupiter.api.Test
    public void roomConstructors() {
        Room room = new Room("1", 10.5, 2, false, "Standardowy", 7, 3, false, true);
    }

    @org.junit.jupiter.api.Test
    public void roomReservationConstructor() {
        Client client = new Client("2", "Adam", "Nowak", LocalDate.of(1990, 1, 3), "test1@gmail.com", "123123123", true, "XXX1234", "Janusz");
        Room room = new Room("1", 10.5, 2, false, "Standardowy", 7, 3, false, true);

        RoomReservation reservation = new RoomReservation(LocalDate.now(), client, room);
    }

    @org.junit.jupiter.api.Test
    public void premiumClientGetFullName(){
        PremiumClient premiumClient = new PremiumClient("2", "Adam", "Nowak", LocalDate.of(1990, 1, 3), "test1@gmail.com", "123123123", true, "XXX1234", "Janusz");
        PremiumClient premiumClient2 = new PremiumClient("2", "Adam", "Nowak", LocalDate.of(1990, 1, 3), "test1@gmail.com", "123123123", true, "XXX1234");

        System.out.println(premiumClient.getFullName());
        System.out.println(premiumClient2.getFullName());
    }
}

