package _14_java_exception_and_debug.exercise._1_illegal_triangle_exception;

import java.io.IOException;
import java.util.*;

public class IllegalTriangleExceptionTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(true) {
            try {
                System.out.print("Enter the first side: ");
                double side1 = in.nextDouble();

                System.out.print("Enter the second side: ");
                double side2 = in.nextDouble();

                System.out.print("Enter the third side: ");
                double side3 = in.nextDouble();

                if ((side1 < 0 || side2 < 0 || side3 < 0)) {
                    throw new IllegalTriangleException("Value cannot be negative.");
                } else if (!(side1 + side2 > side3) || !(side1 + side3 > side2) || !(side2 + side3 > side1)) {
                    throw new IllegalTriangleException("Invalid input value.");
                } else {
                    break;
                }
            } catch(IOException e) {
                System.out.println(e.getMessage() + "Please try again!");
            }
        }

    }
}
