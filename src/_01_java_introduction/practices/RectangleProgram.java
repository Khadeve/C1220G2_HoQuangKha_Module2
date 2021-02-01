package _01_java_introduction.practices;

import java.util.Scanner;

public class RectangleProgram {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //Enter measurements.
        System.out.print("Enter the width: ");
        double width = in.nextDouble();
        System.out.print("Enter the height: ");
        double height = in.nextDouble();

        //Calculate rectangle area
        double area = width * height;
        System.out.println("Rectangle area: " + area);
    }
}
