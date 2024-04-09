package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TimeService extends SpecialService {

    @Override
    public void orderService() {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDate currentTime = LocalDate.now();
        String formattedTime = currentTime.format(pattern);
        System.out.println(formattedTime);
    }

    @Override
    public double getPrice() {
        return 9.99;
    }

    @Override
    public boolean isAccessible(int age) {
        return true;
    }

    @Override
    public String getDescription() {
        return "Dowiedz sie jaki jest teraz czas";
    }



}
