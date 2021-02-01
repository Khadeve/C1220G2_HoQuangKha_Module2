package _01_java_introduction.practices;

import java.util.Scanner;
import java.math.*;

public class BodyMassIndex {
    public static void main(String[] args) {

        //enter weight and height
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter your weight: ");
        double weight = in.nextDouble();
        System.out.print("Please enter your height: ");
        double height = in.nextDouble();

        //calculate IBM
        double bmi = (weight / Math.pow(height, 2.0));

        //print result
        if (bmi < 18) {
            System.out.printf("%-20.2f - %s", bmi, "Underweight");
        } else if (bmi < 25) {
            System.out.printf("%-20.2f - %s", bmi, "Normal");
        } else if (bmi < 30) {
            System.out.printf("%-20.2f - %s", bmi, "Overweight");
        } else {
            System.out.printf("%-20.2f - %s", bmi, "Obese");
        }
    }
}
