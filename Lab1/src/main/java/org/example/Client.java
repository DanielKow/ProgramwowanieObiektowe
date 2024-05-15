package org.example;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

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

    public Client(String firstName, String lastName, LocalDate birthDate, String id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = "";
        this.phoneNumber = "";
        this.isMale = true;
        this.idNumber = "";
        this.secondName = "";
        this.id = id;

    }

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
        ArrayList<String> fullNameParts = new ArrayList<>();

        if (firstName != null && !firstName.isBlank()) {
            fullNameParts.add(firstName);
        }

        if (secondName != null && !secondName.isBlank()) {
            fullNameParts.add(secondName);
        }

        if (lastName != null && !lastName.isBlank()) {
            fullNameParts.add(lastName);
        }

        return String.join(" ", fullNameParts);
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isMale() {
        return isMale;
    }


    public String getIdNumber() {
        return idNumber;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
