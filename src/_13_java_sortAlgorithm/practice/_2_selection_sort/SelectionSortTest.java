package _13_java_sortAlgorithm.practice._2_selection_sort;

import java.util.Arrays;

public class SelectionSortTest {
    public static void main(String[] args) {
        int[] integerArray = {4, 3, 5, 6, 2, 1};
        System.out.println("Before sorting:");
        System.out.println(Arrays.toString(integerArray));

        System.out.println("---------------------------------");
        selectionSort(integerArray);
        System.out.println("After sorting:");
        System.out.println(Arrays.toString(integerArray));
    }

    public static void selectionSort(int[] list) {
        int n = list.length;
        int counter = 1;
        for (int i = 0; i < n - 1; i++) {
            int jmin = i;
            for (int j = i + 1; j < n; j++) {
                if (list[j] < list[jmin]) jmin = j;
            }
            if (jmin != i) {
                int temp = list[jmin];
                list[jmin] = list[i];
                list[i] = temp;
                System.out.print(counter++ + ". Swap list[" + i + "] and list[" + jmin + "]: " + Arrays.toString(list) + "\n");
            }
        }
    }
}
