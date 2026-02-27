package faker;

import com.github.javafaker.Faker;

public class TestData {
    public static String fakeNumber (){
        return new Faker().number().digits(8);
    }
    public static String fakeWord (){
        return new Faker().regexify("[a-zA-Z]{5}");
    }

    public static String emailGenerator(){
        return "test"+System.currentTimeMillis()+"@yopmail.com";
    }
    public static String phoneNumberGenerator(){
        return "000" + fakeNumber();
    }

    private static final Faker fake = new Faker();

    public static String canadaPhoneNumber() {
        int firstDigit = fake.number().numberBetween(2, 10);
        int remainingAreaDigits = fake.number().numberBetween(0, 100);
        String areaCode = String.format("%d%02d", firstDigit, remainingAreaDigits);
        String exchange = "555";
        int lineNumber = fake.number().numberBetween(1000, 10000);
        return areaCode + exchange + lineNumber;
    }
}