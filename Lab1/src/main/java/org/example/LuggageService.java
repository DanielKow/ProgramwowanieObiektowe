package org.example;

public class LuggageService extends SpecialService {


    @Override
    public void orderService() {
        System.out.println("Twoj bagaz jest przechowywany");
    }

    @Override
    public double getPrice() {
        return 21.37;
    }

    @Override
    public boolean isAccessible(int age) {
        return age > 5;
    }

    @Override
    public String getDescription() {
        return "Przechowaj swoj bagaz";
    }
}
