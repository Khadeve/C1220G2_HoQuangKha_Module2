package _01_java_introduction.practices;

import java.util.Scanner;

public class LinearEquationResolver {
    public static void main(String[] args) {

        System.out.println("Linear Equation Program!");
        System.out.println("Given a linear equation as 'a*x + b = 0', please enter constants:");

        Scanner in = new Scanner(System.in);

        //Enter equation's constants
        System.out.print("Enter the first constant: ");
        double a = in.nextDouble();
        System.out.print("Enter the second constant: ");
        double b = in.nextDouble();

        //print linear equation
        System.out.printf("The equation: %5.2f * x + %5.2f = 0\n", a, b);

        //solve the linear equation
        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinite solution.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double res = (-b / a);
            System.out.printf("The equation has one solution: %5.2f", res);
        }
    }
}
