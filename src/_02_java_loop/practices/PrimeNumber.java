package _02_java_loop.practices;

import java.util.Scanner;
import java.lang.Math;

public class PrimeNumber {

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        else if (number == 2) {
            return true;
        }
        else if (number % 2 == 0) {
            return false;
        }
        else {
            int limit = (int)Math.sqrt(number);
            for (int i = 3; i <= limit; i += 2) {
                if (number % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number: ");
        int number = in.nextInt();

        boolean check = isPrime(number);
        if (check) {
            System.out.printf("%d is a prime number.", number);
        } else {
            System.out.printf("%d is not a prime number.", number);
        }
    }
}
