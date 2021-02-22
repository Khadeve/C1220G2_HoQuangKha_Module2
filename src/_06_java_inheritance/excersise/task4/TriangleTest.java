package _06_java_inheritance.excersise.task4;

import java.util.*;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter color: ");
        String color = in.next();

        System.out.print("Fill or not? (y / n): ");
        boolean isFilled = in.next().equalsIgnoreCase("y");

        System.out.print("Enter side1: ");
        double side1 = in.nextDouble();

        System.out.print("Enter side2: ");
        double side2 = in.nextDouble();

        System.out.print("Enter side3: ");
        double side3 = in.nextDouble();

        Triangle myTriangle = new Triangle(color, isFilled, side1, side2, side3);
        System.out.println("The triangle: ");
        System.out.println(myTriangle);
    }
}
