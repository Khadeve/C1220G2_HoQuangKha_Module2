package _02_java_loop.practices;

import java.util.Scanner;
import java.lang.Math;

public class GreatestDivisor {
    public static int findGreatestDivisor(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the first number: ");
        int a = in.nextInt();
        System.out.print("Please enter the second number: ");
        int b = in.nextInt();

        int res = findGreatestDivisor(a, b);
        if (res != 0)
            System.out.printf("The greatest divisor of %d and %d is %d", a, b, res);
        else
            System.out.println("There is no any result.");
    }
}
