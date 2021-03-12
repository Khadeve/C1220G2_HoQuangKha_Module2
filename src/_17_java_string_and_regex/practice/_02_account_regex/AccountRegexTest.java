package _17_java_string_and_regex.practice._02_account_regex;

import java.util.*;
import java.util.regex.*;

public class AccountRegexTest {
    private static final String ACCOUNT_REGEX = "^[a-z0-9_]{6,}$";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern accountPattern = Pattern.compile(ACCOUNT_REGEX);

        boolean flag;
        do {
            System.out.println("***Enter your account:");
            String myAccount = in.nextLine();

            Matcher matcher = accountPattern.matcher(myAccount);
            flag = matcher.matches();
            if (flag) {
                System.out.println("Successfully entering account.");
            } else {
                System.out.println("!Invalid input. Please try again.");
            }
        } while(!flag);
    }
}
