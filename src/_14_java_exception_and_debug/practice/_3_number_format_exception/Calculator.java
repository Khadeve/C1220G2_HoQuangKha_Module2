package _14_java_exception_and_debug.practice._3_number_format_exception;

import java.util.*;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the first operand: ");
        int firstOperand = in.nextInt();
        System.out.print("Enter the second operand: ");
        int secondOperand = in.nextInt();

        calculate(firstOperand, secondOperand);
    }

    public static void calculate(int x, int y) {
        try {
            System.out.println("Summary: " + (x + y));
            System.out.println("Difference: " + (x - y));
            System.out.println("Product: " + (x * y));
            System.out.println("Quotient: " + (x / y));
        } catch(Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
}
