package furamaResort.controllers;

import furamaResort.models.House;
import furamaResort.models.Room;
import furamaResort.models.Services;
import furamaResort.models.Villa;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.io.*;

public class MainController {
    private static final String MAIN_MENU = "\n---------------------Main Menu---------------------" +
            "\n1. Add New Services." +
            "\n2. Show Services." +
            "\n3. Add New Customer." +
            "\n4. Show Information of Customer." +
            "\n5. Add New Booking." +
            "\n6. Show Information of Employee." +
            "\n7. Exit." +
            "\n---------------------------------------------------";

    private static final String MENU_FOR_ADD_NEW_SERVICES = "\n---------------------Add New Services---------------------" +
            "\n1. Add New Villa." +
            "\n2. Add New House." +
            "\n3. Add New Room." +
            "\n4. Back to Main Menu." +
            "\n5. Exit." +
            "\n------------------------------------------------------";

    public static void displayMainMenu() {
        System.out.println(MAIN_MENU);
    }

    public static void addNewServices() throws IOException {
        Scanner in = new Scanner(System.in);
        int choice;

        // Show add new services menu.
        do {
            System.out.println(MENU_FOR_ADD_NEW_SERVICES);
            System.out.print("***Please enter your choice: ");
            choice = in.nextInt();

            String serviceName = null;
            String id = null;
            double area = 0;
            double price = 0;
            int largestNumberOfGuests = 0;
            String typeOfRental = null;

            String classificationOfRoom;
            String utilities;
            double areaOfPool;
            int numberOfFloors;
            String freeUtilities;

            if (choice == 1 || choice == 2 || choice == 3) {
                // Enter common information of all services.
                System.out.println("***Enter information of the new service***");

                System.out.print("1. Please enter the service name: ");
                in.nextLine();  // Consume newline.
                serviceName = in.nextLine();

                System.out.print("2. Please enter the id of service: ");
                //in.nextLine();  // Consume newline.
                id = in.nextLine();

                System.out.print("3. Please enter the area: ");
                area = in.nextDouble();

                System.out.print("4. Please enter the price: ");
                price = in.nextDouble();

                System.out.print("5. Please enter the largest number of guests: ");
                largestNumberOfGuests = in.nextInt();

                System.out.print("6. Please enter the type of rental: ");
                in.nextLine();  // Consume newline.
                typeOfRental = in.nextLine();
            }

            switch (choice) {
                case 1:
                    // Enter specialized information for villa.
                    System.out.print("7. Please enter the classification of room: ");
                    classificationOfRoom = in.nextLine();

                    System.out.print("8. Please enter the other utilities: ");
                    utilities = in.nextLine();

                    System.out.print("9. Please enter the area of swimming pool: ");
                    areaOfPool = in.nextDouble();

                    System.out.print("10. Please enter the number of floors: ");
                    numberOfFloors = in.nextInt();

                    Services newVilla = new Villa(serviceName, id, area, price, largestNumberOfGuests, typeOfRental,
                            classificationOfRoom, utilities, areaOfPool, numberOfFloors);

                    // Write villa information into the Villa.csv
                    try (PrintWriter out = new PrintWriter(
                            new FileOutputStream("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\furamaResort\\data\\Villa.csv", true)
                    )) {
                        newVilla.writeService(out);
                        System.out.println("Adding Villa Successfully!");
                    }
                    break;
                case 2:
                    // Enter specialized information for house.
                    System.out.print("7. Please enter the classification of room: ");
                    classificationOfRoom = in.nextLine();

                    System.out.print("8. Please enter the other utilities: ");
                    utilities = in.nextLine();

                    System.out.print("9. Please enter the number of floors: ");
                    numberOfFloors = in.nextInt();

                    Services newHouse = new House(serviceName, id, area, price, largestNumberOfGuests, typeOfRental, classificationOfRoom, utilities, numberOfFloors);

                    // Write house information into the House.csv
                    try (PrintWriter out = new PrintWriter(
                            new FileOutputStream("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\furamaResort\\data\\House.csv", true)
                    )) {
                        newHouse.writeService(out);
                        System.out.println("Adding New House Successfully!");
                    }
                    break;
                case 3:
                    // Enter specialized information for room.
                    System.out.print("7. Please enter the other free utilities: ");
                    freeUtilities = in.nextLine();

                    Services newRoom = new Room(serviceName, id, area, price, largestNumberOfGuests, typeOfRental, freeUtilities);

                    // Write room information into the Room.csv
                    try (PrintWriter out = new PrintWriter(
                            new FileOutputStream("D:\\23. Git Module2\\C1220G2_HoQuangKha_Module2\\src\\furamaResort\\data\\Room.csv", true)
                    )) {
                        newRoom.writeService(out);
                        System.out.println("Adding New Room Successfully!");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid. Please try again.");
            }
        } while (choice != 4);

    }
}
