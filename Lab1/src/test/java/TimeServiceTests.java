import org.example.TimeService;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TimeServiceTests {

    @Test
    void getPrice_should_return_9_99() {
        // Given
        TimeService timeService = new TimeService();

        // When
        double price = timeService.getPrice();

        // Then
        assertEquals(9.99, price);
    }

    @Test
    void isAccessible_should_always_return_true() {
        // Given
        Random random = new Random();
        TimeService timeService = new TimeService();
        int age = random.nextInt(120);
        System.out.println(age);

        // When
        boolean isAccessible = timeService.isAccessible(random.nextInt(120));

        // Then
        assertTrue(isAccessible);
    }

    @Test
    void getDescription_should_return_Dowiedz_sie_jaki_jest_teraz_czas() {
        // Given
        TimeService timeService = new TimeService();

        // When
        String description = timeService.getDescription();

        // Then
        assertEquals("Dowiedz sie jaki jest teraz czas", description);

    }

}
