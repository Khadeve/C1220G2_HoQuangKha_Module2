package _01_java_introduction.exercises;

import java.util.Scanner;
import java.lang.StringBuilder;

public class NumberToWords {

    static String readNumber(int number, int numberPosition) {
        switch (number) {
            case 1:
                return (numberPosition == 2) ? "" : "one";
            case 2:
                return (numberPosition == 2) ? "twenty" : "two";
            case 3:
                return (numberPosition == 2) ? "thirty" : "three";
            case 4:
                return (numberPosition == 2) ? "forty" : "four";
            case 5:
                return (numberPosition == 2) ? "fifty" : "five";
            case 6:
                return (numberPosition == 2) ? "sixty" : "six";
            case 7:
                return (numberPosition == 2) ? "seventy" : "seven";
            case 8:
                return (numberPosition == 2) ? "eighty" : "eight";
            case 9:
                return (numberPosition == 2) ? "ninety" : "nine";
        }
        return "";
    }

    static String readFullNumber(int number) {

        StringBuilder builder = new StringBuilder();

        //read the numbers
        int ones = number % 10;
        int tens = (number % 100) / 10;
        int hundreds = number / 100;

        String digitOfHundreds = readNumber(hundreds, 1);
        String digitOfTens = readNumber(tens, 2);
        String digitOfOnes = readNumber(ones, 3);

        //read the digit of hundreds.
        boolean hasHundreds = false;
        if (!digitOfHundreds.isEmpty()) {
            builder.append(digitOfHundreds).append(" hundred");
            hasHundreds = true;
        }

        //read the digit of tens.
        if (hasHundreds) {
            builder.append(" and ");
        }
        boolean hasTens = false;
        if (!digitOfTens.isEmpty()) {
            builder.append(digitOfTens);
            hasTens = true;
        }

        //read the digit of ones.
        if (hasTens) {
            builder.append(" ");
        }
        if (tens == 1) {
            switch (digitOfOnes) {
                case "one":
                    builder.append("eleven");
                    break;
                case "two":
                    builder.append("twelve");
                    break;
                case "three":
                    builder.append("thirteen");
                    break;
                case "four":
                    builder.append("fourteen");
                    break;
                case "five":
                    builder.append("fifteen");
                    break;
                case "six":
                    builder.append("sixteen");
                    break;
                case "seven":
                    builder.append("seventeen");
                    break;
                case "eight":
                    builder.append("eighteen");
                    break;
                case "nine":
                    builder.append("nineteen");
                    break;
                default:
                    builder.append("ten");
                    break;
            }
        } else {
            if (digitOfOnes.isEmpty() && !hasTens) {
                builder.append("zero");
            } else {
                builder.append(digitOfOnes);
            }
        }

        return builder.toString();
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a natural number: ");
        int number = in.nextInt();

        System.out.println(readFullNumber(number));
    }
}
