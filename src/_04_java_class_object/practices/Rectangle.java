package _04_java_class_object.practices;

import java.util.Scanner;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double wValue, double hValue) {
        this.width = wValue;
        this.height = hValue;
    }

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String display() {
        return "Rectangle = { width : " + this.width + ", height : " + this.height + " }";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the width of rectangle: ");
        double width = in.nextDouble();

        System.out.print("Enter the height of rectangle: ");
        double height = in.nextDouble();

        Rectangle myRectangle = new Rectangle(width, height);
        System.out.printf("The area of my rectangle: %5.2f\n", myRectangle.getArea());
        System.out.printf("The perimeter of my rectangle: %5.2f\n", myRectangle.getPerimeter());
        System.out.println("Display my rectangle: " + myRectangle.display());
    }
}
