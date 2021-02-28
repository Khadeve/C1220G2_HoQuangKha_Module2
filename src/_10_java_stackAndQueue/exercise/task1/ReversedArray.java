package _10_java_stackAndQueue.exercise.task1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Stack;

public class ReversedArray {

    //E is restricted to classes that implement the Serializable interface.
    private static <E extends Serializable> void reverseArray(E[] numbers) {
        Stack<E> numberStack = new Stack<>();

        int size = numbers.length;
        for(E e : numbers) {
            numberStack.push(e);
        }

        for (int i = 0; i < size; i++) {
            numbers[i] = numberStack.pop();
        }
    }

    /*private static void reverseIntArray(int[] original) {
        Stack<Integer> stack = new Stack<>();

        int size = original.length;
        for (int i = 0; i < size; i++) {
            stack.push(original[i]);
        }

        for (int i = 0; i < size; i++) {
            original[i] = stack.pop();
        }
    }*/

    private static String reverseString(String aString) {
        StringBuilder result = new StringBuilder();

        //split each word in aString string.
        String[] words = aString.split(" ");

        reverseArray(words);

        for (String word : words) {
            result.append(word).append(" ");
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};

        reverseArray(integers);
        System.out.println("The reversed integer array: " + Arrays.toString(integers));

        reverseArray(doubles);
        System.out.println("The reversed double array: " + Arrays.toString(doubles));

        String name = "Ho Quang Kha Codegym";
        System.out.println("The reversed string: " + reverseString(name));
    }
}
