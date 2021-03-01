package _10_java_stackAndQueue.exercise.task4_optional;

import java.util.*;

public class BaseConverter {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = in.nextInt();

        System.out.print("Enter the base: ");
        int base = in.nextInt();

        System.out.println("result: " + convertBase(number, base));
    }

    private static String convertBase(int number, int toBase) {
        boolean flag = true;
        if (number < 0) {
            number = -number;
            flag = false;
        }

        Stack<String> remainderStack = new Stack<>();

        do {
            int remainder = number % toBase;
            number /= toBase;
            if (toBase == 16) {
                String temp;
                if (remainder == 10) remainderStack.push("A");
                else if (remainder == 11) remainderStack.push("B");
                else if (remainder == 12) remainderStack.push("C");
                else if (remainder == 13) remainderStack.push("D");
                else if (remainder == 14) remainderStack.push("E");
                else if (remainder == 15) remainderStack.push("F");
                else remainderStack.push(Integer.toString(remainder));
            } else {
                remainderStack.push(Integer.toString(remainder));
            }
        } while (number != 0);

        if (!flag) {
            remainderStack.push("-");
        }

        StringBuilder result = new StringBuilder();
        while (!remainderStack.isEmpty()) {
            result.append(remainderStack.pop());
        }

        return result.toString();
    }
}
