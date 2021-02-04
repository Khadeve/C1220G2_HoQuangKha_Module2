package _04_java_class_object.exercises;

import java.lang.Math;
import java.util.Scanner;

public class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double factor1, double factor2, double factor3) {
        this.a = factor1;
        this.b = factor2;
        this.c = factor3;
    }

    public double getFirstFactor() {
        return this.a;
    }

    public double getSecondFactor() {
        return this.b;
    }

    public double getThirdFactor() {
        return this.c;
    }

    public double getDiscriminant() {
        return (this.b * this.b) - (4 * this.a * this.c);
    }

    public double getRoot1() {
        double delta = this.getDiscriminant();
        if (delta < 0) {
            return 0;
        }
        return (-this.b + Math.sqrt(delta)) / (2 * this.a);
    }

    public double getRoot2() {
        double delta = this.getDiscriminant();
        if (delta < 0) {
            return 0;
        }
        return (-this.b - Math.sqrt(delta)) / (2 * this.a);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a: ");
        double a = in.nextDouble();

        System.out.print("Please enter b: ");
        double b = in.nextDouble();

        System.out.print("Please enter c: ");
        double c = in.nextDouble();

        QuadraticEquation myEquation = new QuadraticEquation(a, b, c);

        double delta = myEquation.getDiscriminant();
        if (delta == 0) {
            System.out.println("The equation has one root: " + myEquation.getRoot1());
        } else if (delta < 0) {
            System.out.println("The equation has no root.");
        } else {
            System.out.printf("The equation has two roots: %5.2f and %5.2f", myEquation.getRoot1(), myEquation.getRoot2());
        }
    }
}
