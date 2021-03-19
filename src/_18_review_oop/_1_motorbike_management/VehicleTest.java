package review_oop._1_motorbike_management;

import _11_java_javaCollectionsFramework.exercise.task1.ProductManagerTest;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class VehicleTest {
    public static final String mainMenu = "\n------------------------------------------" +
            "\n1. Add new vehicle." +
            "\n2. Show the vehicle management list." +
            "\n3. Exit." +
            "\n------------------------------------------";

    public static void main(String[] args) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();

        vehicleList.add(new Vehicle(1500, 150));

        Scanner in = new Scanner(System.in);


        do {
            System.out.println(mainMenu);
            System.out.print("Please enter your choice: ");
            int choice = in.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter the price: ");
                    double price = in.nextDouble();
                    System.out.print("Enter the cylinder volume: ");
                    int cylinderVolume = in.nextInt();

                    vehicleList.add(new Vehicle(price, cylinderVolume));
                    System.out.println("Adding successfully");
                    break;
                case 2:
                    AtomicInteger counter = new AtomicInteger(1);
                    System.out.println("----------------Vehicle List-----------------");
                    vehicleList.forEach((e) -> {
                        System.out.println(counter.getAndIncrement() + ". " + e);
                    });
                    System.out.println("-----------------------------------------");
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid. Please try again.");
            }
        } while(ProductManagerTest.isContinue());
    }
}
