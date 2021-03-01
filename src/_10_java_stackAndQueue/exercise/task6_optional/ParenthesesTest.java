package _10_java_stackAndQueue.exercise.task6_optional;

import java.io.IOException;
import java.util.*;

public class ParenthesesTest {
    public static void main(String[] args) {
        String expression;
        Scanner in = new Scanner(System.in);

        System.out.print("Enter a math expression: ");
        String exp = in.nextLine();

        try {
            System.out.println("Is " + exp + " in a good form: " + testParentheses(exp));
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean testParentheses(String expression) throws IOException {
        if (expression == null) {
            throw new IOException();
        }
        Stack<String> stack = new Stack<>();

        String[] tokens = expression.split("");

        int len = tokens.length;
        //push all '(' character in the expression into the stack.
        for (int i = 0; i < len; i++) {
            if (tokens[i].equals(")")) {
                stack.push(tokens[i]);
            }
        }

        for (int i = 0; i < len; i++) {
            if(tokens[i].equals("(")) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
