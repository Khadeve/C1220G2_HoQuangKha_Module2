package _01_java_introduction.practices;

import java.util.Scanner;

public class LeapYear {

    static boolean isLeapYear(int year) {
        //is leap year
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    public static void main(String[] args) {

        //Enter a year
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a year: ");
        int year = in.nextInt();

        //print result
        if (isLeapYear(year)) {
            System.out.printf("%d is a leap year.", year);
        } else {
            System.out.printf("%d is not a leap year.", year);
        }
    }
}
