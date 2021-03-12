package _17_java_string_and_regex.exercise._02_phone_number_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberRegexTest {
    private static final String PHONE_NUMBER_REGEX = "\\(\\d{2}\\)-\\(0\\d{9}\\)";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        boolean flag = false;
        do {
            System.out.println("***Enter the phone number:");
            String phoneNumber = in.nextLine();

            Matcher matcher = pattern.matcher(phoneNumber);
            flag = matcher.matches();
            if (flag) {
                System.out.println("Successfully entering phone number.");
                break;
            } else {
                System.out.println("!Invalid input. Please try again.");
            }
        } while(true);
    }
}
