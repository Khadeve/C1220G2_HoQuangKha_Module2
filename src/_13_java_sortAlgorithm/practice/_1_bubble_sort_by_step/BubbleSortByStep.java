package _13_java_sortAlgorithm.practice._1_bubble_sort_by_step;

import java.util.Arrays;

public class BubbleSortByStep {
    public static void main(String[] args) {
        int[] myList = {1, 3, 2, 6, 5, 4};
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(myList));

        System.out.println("-------------------------------------");
        BubbleSort(myList);
        System.out.println("After sorting:");
        System.out.println(Arrays.toString(myList));
    }

    public static void BubbleSort(int[] list) {
        int n = list.length;
        int counter = 1;
        for (int i = 1; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                if (list[j] < list[j - 1]) {
                    int temp = list[j];
                    list[j] = list[j - 1];
                    list[j - 1] = temp;
                    System.out.print(counter++ + ". Swap list[" + j + "] and list[" + (j - 1) + "]: " + Arrays.toString(list) + "\n");
                }
            }
        }
    }
}
