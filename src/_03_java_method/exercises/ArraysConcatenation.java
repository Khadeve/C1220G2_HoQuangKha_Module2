package _03_java_method.exercises;

import java.util.Scanner;

public class ArraysConcatenation {
    public static void inputArray(int[] ar) {
        Scanner in = new Scanner(System.in);

        int len = ar.length;
        for (int i = 0; i < len; i++) {
            System.out.print("Enter element " + i + ": ");
            ar[i] = in.nextInt();
        }
    }

    public static void printArray(int[] ar) {
        int len = ar.length;
        for (int v : ar) {
            System.out.print(v + " ");
        }
    }

    public static int[] concatArrays(int[] ar1, int[] ar2) {
        int len1 = ar1.length;
        int len2 = ar2.length;
        int[] ar3 = new int[len1 + len2];
        int i = 0;
        //copy values of ar1 to ar3.
        while (i < len1) {
            ar3[i] = ar1[i];
            i++;
        }
        //copy values of ar2 to ar3.
        int j = 0;
        while (j < len2) {
            ar3[i] = ar2[j];
            i++;
            j++;
        }
        return ar3;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number of elements of the first array: ");
        int n1 = in.nextInt();
        int[] ar1 = new int[n1];
        System.out.println("Enter content of array1: ");
        inputArray(ar1);
        System.out.println("The array1: ");
        printArray(ar1);


        System.out.print("\nPlease enter number of elements of the second array: ");
        int n2 = in.nextInt();
        int[] ar2 = new int[n2];
        System.out.println("Enter content of array2: ");
        inputArray(ar2);
        System.out.println("The array2: ");
        printArray(ar2);

        int[] res = concatArrays(ar1, ar2);
        System.out.println("\nThe result: ");
        printArray(res);
    }
}
