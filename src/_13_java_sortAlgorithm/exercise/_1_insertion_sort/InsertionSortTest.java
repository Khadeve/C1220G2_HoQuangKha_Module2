package _13_java_sortAlgorithm.exercise._1_insertion_sort;

import java.util.Arrays;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] integerArray = {4, 3, 5, 6, 2, 1};

        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(integerArray));

        System.out.println("-------------------------------");
        InsertionSort(integerArray);
        System.out.println("After sorting:");
        System.out.println(Arrays.toString(integerArray));
    }

    public static void InsertionSort(int[] list) {
        int counter = 1;

        int n = list.length;

        for (int i = 1; i < n; i++) {
            int current = list[i];
            int j = i - 1;

            // find proper position in range [i-1, 0] for inserting the current.
            while(j >= 0 && current < list[j]) {
                list[j + 1] = list[j];  //make space for the current.
                j--;
            }
            if ((j + 1) != i) {
                list[j + 1] = current;
                System.out.println(counter++ + ". Insert list[" + i + "] at position " + (j + 1) + ": " + Arrays.toString(list));
            }
        }
    }
}
