package _14_java_exception_and_debug.practice._2_array_index_out_of_bound_exception;

import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOutOfBoundsExceptionTest {
    public static void main(String[] args) {
        Integer[] arr = createRandomArray();

        Scanner in = new Scanner(System.in);
        System.out.print("Enter an index: ");
        int index = in.nextInt();

        try {
            System.out.println("The element at index " + index + " is " + arr[index]);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("The index is out of bounds.");
        }

    }

    public static Integer[] createRandomArray() {
        Random rd = new Random();
        Integer[] arr = new Integer[100];
        System.out.println("List of elements in array:");
        for (int i = 0; i < 100; i++) {
            arr[i] = rd.nextInt(100);
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return arr;
    }
}
