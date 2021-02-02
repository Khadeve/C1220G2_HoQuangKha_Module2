package _02_java_loop.exercises;

import _02_java_loop.practices.PrimeNumber;

public class PrimesLessThan100 {
    public static void main(String[] args) {
        System.out.println("Primes numbers that less than 100: ");
        int counter = 1;
        System.out.println(counter++ + ". 2");

        for (int number = 3; number < 100; number += 2) {
            if (PrimeNumber.isPrime(number)) {
                System.out.println(counter++ + ". " + number);
            }
        }
    }
}
