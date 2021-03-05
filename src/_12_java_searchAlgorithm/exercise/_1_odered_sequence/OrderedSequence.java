package _12_java_searchAlgorithm.exercise._1_odered_sequence;

import java.util.*;

public class OrderedSequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = in.nextLine();
        System.out.println("Result: " + extractOrderedSequence(str));
    }

    public static String extractOrderedSequence(String source) {
        int temp = Byte.MIN_VALUE;
        int len = source.length();
        StringBuilder result = new StringBuilder(len);

        for (int i = 0; i < len; i++) {
            if (source.codePointAt(i) > temp) {
                temp = source.codePointAt(i);
                result.append(source.charAt(i));
            }
        }

        return result.toString();
    }
}
