package _10_java_stackAndQueue.exercise.task5_optional;

import java.util.*;

public class PalindromeTest {

    public static void main(String[] args) {
        String str1 = "Quang Kha";
        String str2 = "Able was I ere I saw Elba";
        System.out.println("is " + str1 + " palindrome: " + testPalindrome(str1));
        System.out.println("is " + str2 + " palindrome: " + testPalindrome(str2));
    }

    private static boolean testPalindrome(String aString) {
        Stack<String> stack = new Stack<>();
        Queue<String> queue = new ArrayDeque<>();
        aString = aString.toLowerCase();

        String[] tokens = aString.split("");

        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            stack.push(tokens[i]);
            queue.add(tokens[i]);
        }

        for (int i = 0; i < len; i++) {
            if (!Objects.equals(stack.pop(), queue.poll())) return false;
        }

        return true;
    }
}
