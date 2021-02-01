package _01_java_introduction.exercises;

import java.util.Scanner;
import java.math.BigInteger;

public class CurrencyConversion {
    static final int RATE = 23_000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter amount of dollar: ");
        int dollar = in.nextInt();

        BigInteger vnd = BigInteger.valueOf(dollar).multiply(BigInteger.valueOf(RATE));

        System.out.printf("%d - " + vnd, dollar);
//        System.out.println(vnd);
    }
}
