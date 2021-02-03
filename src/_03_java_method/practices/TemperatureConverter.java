package _03_java_method.practices;

import java.util.Scanner;

public class TemperatureConverter {
    public static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * (9.0 / 5.0) + 32;
    }

    public static double convertFahrenheitToCelsius(double fah) {
        return (fah - 32) * (5.0 / 9.0);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int choice;
        do {
            System.out.println("------------Menu-----------");
            System.out.println("1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");
            System.out.println("---------------------------");

            System.out.print("Please enter your choice: ");
            choice = in.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter celsius: ");
                    double c = in.nextDouble();
                    System.out.printf("\n%5.2f Celsius is %5.2f Fahrenheit", c, convertCelsiusToFahrenheit(c));
                    break;
                case 2:
                    System.out.print("Enter Fahrenheit: ");
                    double f = in.nextDouble();
                    System.out.printf("\n%5.2f Fahrenheit is %5.2f Celsius", f, convertFahrenheitToCelsius(f));
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid. Please try again.");
            }
        } while(choice < 1 || choice > 3);

    }
}
