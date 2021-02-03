package _03_java_method.practices;

import java.util.Scanner;
import java.lang.Integer;

public class GreatestAsset {

    private static int index;

    private static double findGreatestProperty(double[] properties) {
        double greatestProperty = 0;
        int resIndex = -1;
        int numberOfProperties = properties.length;

        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] > greatestProperty) {
                resIndex = i;
                greatestProperty = properties[i];
            }
        }
        index = resIndex;
        return greatestProperty;
    }

    private static void enterPropertyList(double[] propertyList, int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter property " + i + ": ");
            propertyList[i] = in.nextDouble();
        }
    }

    private static void printPropertyList(double[] propertyList) {
        for (double v : propertyList) {
            System.out.println(v);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //enter number of items.
        int size;
        do {
            System.out.print("Please enter a size: ");
            size = in.nextInt();
            if (size <= 0 || size > 20) {
                System.out.println("The size must be in range of 0 to 20. Please try again.");
            } else {
                break;
            }
        } while (true);

        double[] propertyList = new double[size];

        enterPropertyList(propertyList, size);
        System.out.println("The property list:");
        printPropertyList(propertyList);


        double greatestProperty = findGreatestProperty(propertyList);
        System.out.println("The greatest property is " + greatestProperty + " billion dollars, at " + index + " position");
    }
}
