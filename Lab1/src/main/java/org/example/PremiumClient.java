package org.example;

import java.time.LocalDate;

public class PremiumClient extends Client {


    private PremiumAccountType premiumAccountType;

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber) {
        super(id, firstName, lastName, birthDate, email, phoneNumber, isMale, idNumber);
        this.premiumAccountType = PremiumAccountType.PREMIUM;
    }
    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber, String secondName) {
        super(id, firstName, lastName, birthDate, email, phoneNumber, isMale, idNumber, secondName);
        this.premiumAccountType = PremiumAccountType.PREMIUM;
    }

    @Override
    public String getFullName() {
        return "[premium] " + super.getFullName();
    }
    public void upgradeToPremiumPlus() {
        premiumAccountType = PremiumAccountType.PREMIUM_PLUS;
    }
    public PremiumAccountType getPremiumAccountType() {
        return premiumAccountType;
    }
}
