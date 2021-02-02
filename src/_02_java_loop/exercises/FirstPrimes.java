package _02_java_loop.exercises;

import _02_java_loop.practices.PrimeNumber;
import java.util.Scanner;
import java.lang.StringBuilder;

public class FirstPrimes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the amount of primes: ");
        int amountOfPrimes = in.nextInt();

        StringBuilder strBuilder = new StringBuilder();
        int number = 2, count = 0;
        while (count < amountOfPrimes) {
            if ( PrimeNumber.isPrime(number)) {
                count++;
                strBuilder.append(count).append(". ").append(number).append("\n");
            }
            number++;
        }
        String res = strBuilder.toString();
        System.out.printf("The first %d prime numbers:\n", amountOfPrimes);
        System.out.println(res);
    }
}
