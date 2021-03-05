package _12_java_searchAlgorithm.practice._1_binary_search;

import java.util.Arrays;

public class BinarySearch<E extends Number> {
    private E[] list;

    public BinarySearch(E[] source) {
        list = Arrays.copyOf(source, source.length);
    }

    public int doBinarySearch(E key) {
        int left = 0;
        int right = list.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            // get strings from key and list[mid].
            String keyInString = key.toString();
            String midInString = list[mid].toString();

            if (keyInString.compareTo(midInString) > 0) {
                left = mid + 1;
            }
            else if (keyInString.compareTo(midInString) < 0) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Integer[] user = {1, 2, 3, 4, 5, 6};

        BinarySearch<Integer> integerList = new BinarySearch<>(user);
        System.out.println("----------------------------------");
        System.out.println("In integer array");
        int pos = integerList.doBinarySearch(7);
        if (pos == -1) {
            System.out.println("7 is not in the list of integers.");
        } else {
            System.out.println("7 is at index of " + pos);
        }


        Double[] user2 = {1.1, 2.1, 3.2, 4.2, 5.4, 6.5};

        BinarySearch<Double> doubleList = new BinarySearch<>(user2);
        System.out.println("----------------------------------");
        System.out.println("In double array");
        int pos2 = doubleList.doBinarySearch(5.45);
        if (pos2 == -1) {
            System.out.println("5.45 is not in the list of integers.");
        } else {
            System.out.println("First occurrence of 5.45 " + pos2);
        }
    }

}
