package _03_java_method.exercises;

import java.util.Arrays;

public class ElementDeletion {

    public static int[] removeElement(int[] ar, int v) {
        int index = -1;
        int len = ar.length;

        //find v in the arr
        for (int i = 0; i < len; i++) {
            if (ar[i] == v) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            //remove element at index position.
            for (int i = index; i < len - 1; i++) {
                ar[i] = ar[i + 1];
            }
            //create a copy of ar with the length reduced by 1.
            ar = Arrays.copyOf(ar, ar.length - 1);
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 6};
        arr = removeElement(arr, 6);

        System.out.println("The changed array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
