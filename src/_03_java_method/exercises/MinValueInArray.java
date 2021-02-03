package _03_java_method.exercises;

import _03_java_method.exercises.ArraysConcatenation;

import java.util.Scanner;

public class MinValueInArray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        do {
            System.out.print("Enter the size of array: ");
            n = in.nextInt();
            if (n <= 0) {
                System.out.println("The size cannot be less than or equal to 0.");
            }
        } while (n <= 0);
        int[] ar = new int[n];
        System.out.println("Enter content of the array:");
        ArraysConcatenation.inputArray(ar);
        System.out.println("The array:");
        ArraysConcatenation.printArray(ar);

        int minValue = Integer.MAX_VALUE;
        for (int elmnt : ar) {
            if (elmnt < minValue) {
                minValue = elmnt;
            }
        }
        System.out.println("\nThe minimum value in the array is " + minValue);
    }
}
