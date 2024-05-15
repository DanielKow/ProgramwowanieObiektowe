import org.example.Client;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
}
