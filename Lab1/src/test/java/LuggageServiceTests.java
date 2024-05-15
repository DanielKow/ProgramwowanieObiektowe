import org.example.LuggageService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class LuggageServiceTests {

    @Test
    void getPrice_should_return_21_37() {
        // Given
        LuggageService luggageService = new LuggageService();

        // When
        double price = luggageService.getPrice();

        // Then
        assertEquals(21.37, price);
    }

    @Test
    void isAccessible_should_return_true_for_age_6() {
        // Given
        LuggageService luggageService = new LuggageService();

        // When
        boolean isAccessible = luggageService.isAccessible(6);

        // Then
        assertTrue(isAccessible);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 12, 24, 48, 77, 112})
    void isAccessible_should_return_true_for_older_than_six(int age) {
        // Given
        LuggageService luggageService = new LuggageService();

        // When
        boolean isAccessible = luggageService.isAccessible(age);

        // Then
        assertTrue(isAccessible);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void isAccessible_should_return_false_for_younger_than_six(int age) {
        // Given
        LuggageService luggageService = new LuggageService();

        // When
        boolean isAccessible = luggageService.isAccessible(age);

        // Then
        assertFalse(isAccessible);
    }

    @Test
    void getDescription_should_return_Przechowaj_swoj_bagaz() {
        // Given
        LuggageService luggageService = new LuggageService();

        // When
        String description = luggageService.getDescription();

        // Then
        assertEquals("Przechowaj swoj bagaz", description);
    }
}
