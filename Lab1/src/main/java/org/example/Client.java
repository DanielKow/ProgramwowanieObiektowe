package org.example;

import java.time.LocalDate;
import java.time.Period;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    private String email;
    private String phoneNumber;
    private boolean isMale;
    private String idNumber;
    private String secondName;

    public Client(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isMale = isMale;
        this.idNumber = idNumber;
        this.secondName = "";
    }

    public Client(String id, String firstName, String lastName, LocalDate birthDate, String email, String phoneNumber, boolean isMale, String idNumber, String secondName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isMale = isMale;
        this.idNumber = idNumber;
        this.secondName = secondName;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getFullName() {
        if (secondName == null || secondName.isBlank()) {
            return firstName + " " + lastName;
        }

        return firstName + " " + secondName + " " + lastName;
    }
}