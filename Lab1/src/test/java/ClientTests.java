import org.example.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTests {
    @Test
    void getFullName_should_return_only_firstName_when_there_is_no_lastName_nor_secondName() {
        // Given
        Client client = new Client("1", "Tomasz", null, null, null, null, true, null, null);

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz", fullName);
    }

    @Test
    void getFullName_should_return_firstName_and_lastName_when_there_is_no_secondName() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", null, null, null, true, null, null);

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz Radomski", fullName);
    }

    @Test
    void getFullName_should_return_firstName_and_secondName_when_there_is_no_lastName() {
        // Given
        Client client = new Client("1", "Tomasz", null, null, null, null, true, null, "Adam");

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz Adam", fullName);
    }

    @Test
    void getFullName_should_return_firstName_and_secondName_and_lastName() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", null, null, null, true, null, "Jan");

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz Jan Radomski", fullName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\r\n"})
    void getFullName_should_return_only_firstName_when_lastName_and_secondName_are_blank(String blank) {
        // Given
        Client client = new Client("1", "Tomasz", blank, null, null, null, true, null, blank);

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz", fullName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\r\n"})
    void getFullName_should_return_firstName_and_lastName_when_secondName_is_blank(String blank) {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", null, null, null, true, null, blank);

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz Radomski", fullName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  ", "\t", "\r\n"})
    void getFullName_should_return_firstName_and_secondName_when_lastName_is_blank(String blank) {
        // Given
        Client client = new Client("1", "Tomasz", blank, null, null, null, true, null, "Adam");

        // When
        String fullName = client.getFullName();

        // Then
        assertEquals("Tomasz Adam", fullName);
    }

    @Test
    void getAge_should_return_client_age_when_birthday_is_today() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", LocalDate.now().minusYears(17), null, null, true, null, null);

        // When
        int age = client.getAge();

        // Then
        assertEquals(17, age);
    }

    @Test
    void getAge_should_return_client_age_when_birthday_was_yesterday() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", LocalDate.now().minusYears(17).minusDays(1), null, null, true, null, null);

        // When
        int age = client.getAge();

        // Then
        assertEquals(17, age);
    }

    @Test
    void getAge_should_return_client_age_when_birthday_will_be_tomorrow() {
        // Given
        Client client = new Client("1", "Tomasz", "Radomski", LocalDate.now().minusYears(17).plusDays(1), null, null, true, null, null);

        // When
        int age = client.getAge();

        // Then
        assertEquals(16, age);
    }
}
