package _17_java_string_and_regex.exercise._01_class_name_regex;

import java.util.*;
import java.util.regex.*;

public class ClassNameRegexTest {
    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIKLM]$";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Pattern pattern = Pattern.compile(CLASS_NAME_REGEX);
        boolean flag = false;
        do {
            System.out.println("***Enter the name of class:");
            String className = in.nextLine();

            Matcher matcher = pattern.matcher(className);
            flag = matcher.matches();
            if (flag) {
                System.out.println("Successfully entering class name.");
                break;
            } else {
                System.out.println("!Invalid input. Please try again.");
            }
        } while(true);
    }
}
