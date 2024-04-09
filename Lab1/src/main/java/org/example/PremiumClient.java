package org.example;

import java.time.LocalDate;

public class PremiumClient extends Client {

    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber) {
        super(id, firstName, lastName, birthDate, email, phoneNumber, isMale, idNumber);
    }
    public PremiumClient(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber, String secondName) {
        super(id, firstName, lastName, birthDate, email, phoneNumber, isMale, idNumber, secondName);
    }
    @Override
    public String getFullName() {
        return "[premium] " + super.getFullName();
    }
}
