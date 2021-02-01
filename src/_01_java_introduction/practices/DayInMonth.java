package _01_java_introduction.practices;

import java.util.Scanner;

public class DayInMonth {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the month you want to count days: ");
        int month = in.nextInt();

        //find number of days in month
        String daysInMonth;
        switch(month) {
            case 2:
                daysInMonth = "has 28 or 29 days.";
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = "has 31 days.";
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = "has 30 days.";
                break;
            default:
                daysInMonth = "";
        }

        //print result
        if (daysInMonth.equals("")) {
            System.out.println("Invalid input");
        } else {
            System.out.printf("The %d-th month " + daysInMonth, month);
        }
    }
}
