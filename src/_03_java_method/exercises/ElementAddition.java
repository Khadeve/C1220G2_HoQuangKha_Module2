package _03_java_method.exercises;

import java.util.Arrays;

public class ElementAddition {

    public static int[] insertElement(int[] ar, int value, int pos) {
        //create a copy of arr with the length increased by 1.
        ar = Arrays.copyOf(ar, ar.length + 1);

        for (int i = ar.length - 1; i > pos; i--) {
            ar[i] = ar[i - 1];
        }
        ar[pos] = value;
        return ar;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6};
        arr = insertElement(arr, 5, arr.length + 1);

        System.out.println("The inserted array: ");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
