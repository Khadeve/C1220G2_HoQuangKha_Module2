package _17_java_string_and_regex.practice._01_email_regex;

import java.util.*;
import java.util.regex.*;

public class EmailRegexTest {
    private static final String EMAIL_PATTERN = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        do {
            System.out.println("Please enter an email:");
            String myEmail = in.nextLine();

            Matcher matcher = pattern.matcher(myEmail);
            boolean flag = matcher.matches();
            if (!flag) {
                System.out.println("!Invalid email. Please try again.");
            } else {
                System.out.println("Successfully entering email.");
                break;
            }
        } while(true);
    }
}
