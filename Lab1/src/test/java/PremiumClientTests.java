import org.example.PremiumAccountType;
import org.example.PremiumClient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PremiumClientTests {

    @Test
    void getFullName_should_add_premium_prefix() {
        // Given
        PremiumClient premiumClient = new PremiumClient("1", "Tomasz", "Radomski", null, null, null, true, null, "Adam");

        // When
        String fullName = premiumClient.getFullName();

        // Then
        assertEquals("[premium] Tomasz Adam Radomski", fullName);
    }

    @Test
    void getFullName_should_add_premium_prefix_when_there_is_no_secondName() {
        // Given
        PremiumClient premiumClient = new PremiumClient("1", "Tomasz", "Radomski", null, null, null, true, null);

        // When
        String fullName = premiumClient.getFullName();

        // Then
        assertEquals("[premium] Tomasz Radomski", fullName);
    }

    @Test
    void premium_client_should_premium_client_when_created() {
        // Given
        PremiumClient premiumClient = new PremiumClient("1", "Tomasz", "Radomski", null, null, null, true, null, "Adam");

        // When
        PremiumAccountType premiumAccountType = premiumClient.getPremiumAccountType();

        // Then
        assertEquals(PremiumAccountType.PREMIUM, premiumAccountType);
    }

    @Test
    void upgradeToPremiumPlus_should_change_account_type_to_premium_plus() {
        // Given
        PremiumClient premiumClient = new PremiumClient("1", "Tomasz", "Radomski", null, null, null, true, null, "Adam");

        // When
        premiumClient.upgradeToPremiumPlus();

        // Then
        assertEquals(PremiumAccountType.PREMIUM_PLUS, premiumClient.getPremiumAccountType());
    }
}
