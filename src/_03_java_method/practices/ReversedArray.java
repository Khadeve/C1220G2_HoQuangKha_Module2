package _03_java_method.practices;

import java.util.Scanner;

public class ReversedArray {

    //swap two elements at index1 and index2 of arr array.
    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //Reversing array.
    public static void reverseArray(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < (int)(len / 2); i++) {
            swap(arr, i, len - 1 - i);
        }
    }

    //Enter value of array
    public static void enterArray(int[] arr, int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + i + ": ");
            arr[i] = in.nextInt();
        }
    }

    //print value of array.
    public static void printArray(int[] arr) {
        for (int elmnt : arr) {
            System.out.print(elmnt + " ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter number of elements: ");
        int n = in.nextInt();
        int[] arr = new int[n];

        enterArray(arr, n);
        System.out.println("The Array:");
        printArray(arr);

        reverseArray(arr);
        //swap(arr, 0, 1);
        System.out.println("\nThe reversed array: ");
        printArray(arr);
    }
}
