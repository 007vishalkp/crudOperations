package support;

import java.util.Random;

public class Config {
    public static final int SIGNUP_EMAIL_LENGTH = 9;


    public static String randomEmail(int EmailLength) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder character = new StringBuilder();
        Random rnd = new Random();
        while (character.length() < EmailLength) { // length of the random string.
            int index = (int) (rnd.nextFloat() * chars.length());
            character.append(chars.charAt(index));
        }
        String email = character.toString();
        return "random_" + email + "@yopmail.com";
    }

}
