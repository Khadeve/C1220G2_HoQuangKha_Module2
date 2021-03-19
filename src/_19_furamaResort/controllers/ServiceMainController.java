package furamaResort.controllers;

import furamaResort.commons.fileUtility.FileUtil;
import furamaResort.commons.validation.ServiceInputValidation;
import furamaResort.commons.fileUtility.ServiceFileUtil;
import furamaResort.models.House;
import furamaResort.models.Room;
import furamaResort.models.Service;
import furamaResort.models.Villa;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ServiceMainController {

    private static final String MENU_FOR_ADD_NEW_SERVICES = "\n---------------------Add New Services---------------------" +
            "\n1. Add New Villa." +
            "\n2. Add New House." +
            "\n3. Add New Room." +
            "\n4. Back to Main Menu." +
            "\n5. Exit." +
            "\n------------------------------------------------------";

    private static final String MENU_FOR_SHOW_SERVICES = "\n---------------------Show Services---------------------" +
            "\n1. Show All Villas." +
            "\n2. Show All Houses." +
            "\n3. Show All Rooms." +
            "\n4. Show All Names of Villas without Duplicate." +
            "\n5. Show All Names of Houses without Duplicate." +
            "\n6. Show All Names of Rooms without Duplicate." +
            "\n7. Back to Main Menu." +
            "\n8. Exit." +
            "\n------------------------------------------------------";


    /**
     * Add new services to files.
     *
     * @throws FileNotFoundException if this method cannot write data to file.
     */
    public static void addNewServices() throws FileNotFoundException {
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

            boolean flag = false;   // Flag used for validation of input data.

            if (choice == 1 || choice == 2 || choice == 3) {
                // Enter common information of all services.
                System.out.println("***Enter information of the new service***");

                in.nextLine();  // Consume newline.
                do {
                    System.out.print("1. Please enter the service name: ");
                    serviceName = in.nextLine();
                    flag = !ServiceInputValidation.isValidInputData(serviceName, ServiceInputValidation.NAME_PATTERN);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    }
                } while(flag);


                do {
                    System.out.print("2. Please enter the id of service: ");
                    id = in.nextLine();

                    String strPattern = null;
                    if (choice == 1) strPattern = ServiceInputValidation.VILLA_ID_PATTERN;
                    else if (choice == 2) strPattern = ServiceInputValidation.HOUSE_ID_PATTERN;
                    else strPattern = ServiceInputValidation.ROOM_ID_PATTERN;

                    flag = !ServiceInputValidation.isValidInputData(id, strPattern);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    }
                } while(flag);


                do {
                    System.out.print("3. Please enter the area (>30): ");
                    //area = in.nextDouble();
                    String strArea = in.nextLine();

                    flag = !ServiceInputValidation.isValidInputData(strArea, ServiceInputValidation.AREA_PATTERN);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    } else {
                        area = Double.parseDouble(strArea);
                    }
                } while(flag);


                do {
                    System.out.print("4. Please enter the price (>0): ");
                    String strPrice = in.nextLine();

                    flag = !ServiceInputValidation.isValidInputData(strPrice, ServiceInputValidation.PRICE_PATTERN);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    } else {
                        price = Double.parseDouble(strPrice);
                    }
                } while(flag);

                do {
                    System.out.print("5. Please enter the largest number of guests (>0 and <20): ");
                    String numberOfGuestsStr = in.nextLine();

                    flag = !ServiceInputValidation.isValidInputData(numberOfGuestsStr, ServiceInputValidation.LARGEST_GUEST_NUMBER_PATTERN);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    } else {
                        largestNumberOfGuests = Integer.parseInt(numberOfGuestsStr);
                    }
                } while(flag);


                do {
                    System.out.print("6. Please enter the type of rental: ");
                    typeOfRental = in.nextLine();
                    flag = !ServiceInputValidation.isValidInputData(typeOfRental, ServiceInputValidation.NAME_PATTERN);
                    if (flag) {
                        System.out.println("!Invalid Input Data. Please Try Again.");
                    }
                } while(flag);
            }

            switch (choice) {
                case 1: // Enter specialized information for villa.

                    do {
                        System.out.print("7. Please enter the classification of room: ");
                        classificationOfRoom = in.nextLine();
                        flag = !ServiceInputValidation.isValidInputData(classificationOfRoom, ServiceInputValidation.NAME_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please Try Again.");
                        }
                    } while(flag);

                    do {
                        System.out.print("8. Please enter the another utility: ");
                        utilities = in.nextLine();
                        flag = !ServiceInputValidation.isValidInputData(utilities, ServiceInputValidation.ANOTHER_UTILITY_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please try again.");
                        }
                    } while(flag);


                    do {
                        System.out.print("9. Please enter the area of swimming pool: ");
                        areaOfPool = 0;
                        String strAreaOfPool = in.nextLine();

                        flag = !ServiceInputValidation.isValidInputData(strAreaOfPool, ServiceInputValidation.AREA_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please Try Again.");
                        } else {
                            areaOfPool = Double.parseDouble(strAreaOfPool);
                        }
                    } while (flag);


                    do {
                        System.out.print("10. Please enter the number of floors: ");
                        numberOfFloors = 0;
                        String numberOfFloorsStr = in.nextLine();

                        flag = !ServiceInputValidation.isValidInputData(numberOfFloorsStr, ServiceInputValidation.NUMBER_OF_FLOORS_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please try again.");
                        } else {
                            numberOfFloors = Integer.parseInt(numberOfFloorsStr);
                        }
                    } while(flag);


                    Service newVilla = new Villa(serviceName, id, area, price, largestNumberOfGuests, typeOfRental,
                            classificationOfRoom, utilities, areaOfPool, numberOfFloors);

                    // Write villa information into the Villa.csv
                    FileUtil.writeObject("Villa.csv", newVilla);
                    System.out.println("Adding Villa Successfully!");
                    break;

                case 2: // Enter specialized information for house.
                    do {
                        System.out.print("7. Please enter the classification of room: ");
                        classificationOfRoom = in.nextLine();
                        flag = !ServiceInputValidation.isValidInputData(classificationOfRoom, ServiceInputValidation.NAME_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please Try Again.");
                        }
                    } while(flag);

                    do {
                        System.out.print("8. Please enter the another utility: ");
                        utilities = in.nextLine();
                        flag = !ServiceInputValidation.isValidInputData(utilities, ServiceInputValidation.ANOTHER_UTILITY_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please try again.");
                        }
                    } while(flag);

                    do {
                        System.out.print("9. Please enter the number of floors: ");
                        numberOfFloors = 0;
                        String numberOfFloorsStr = in.nextLine();

                        flag = !ServiceInputValidation.isValidInputData(numberOfFloorsStr, ServiceInputValidation.NUMBER_OF_FLOORS_PATTERN);
                        if (flag) {
                            System.out.println("!Invalid Input Data. Please try again.");
                        } else {
                            numberOfFloors = Integer.parseInt(numberOfFloorsStr);
                        }
                    } while(flag);

                    Service newHouse = new House(serviceName, id, area, price, largestNumberOfGuests, typeOfRental, classificationOfRoom, utilities, numberOfFloors);

                    // Write house information into the House.csv
                    FileUtil.writeObject("House.csv", newHouse);
                    System.out.println("Adding New House Successfully!");
                    break;

                case 3: // Enter specialized information for room.
                    System.out.print("7. Please enter the other free utilities: ");
                    freeUtilities = in.nextLine();

                    Service newRoom = new Room(serviceName, id, area, price, largestNumberOfGuests, typeOfRental, freeUtilities);

                    // Write room information into the Room.csv
                    FileUtil.writeObject("Room.csv", newRoom);
                    System.out.println("Adding New Room Successfully!");
                    break;
                case 4: // Back to main menu.
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid. Please try again.");
            }
        } while (choice != 4);
    }

    /**
     * Show all data in a file to the console screen.
     */
    public static void showServices() {

        Scanner in = new Scanner(System.in);
        int choice;

        do {
            System.out.println(MENU_FOR_SHOW_SERVICES);
            System.out.print("***Please enter your choice: ");
            choice = in.nextInt();

            switch (choice) {
                case 1: // Show all villas.
                    System.out.println("---------------------Villa List---------------------");
                    showServiceList("Villa.csv");
                    System.out.println("------------------------End-------------------------");
                    break;
                case 2: // Show all houses.
                    System.out.println("---------------------House List---------------------");
                    showServiceList("House.csv");
                    System.out.println("------------------------End-------------------------");
                    break;
                case 3: // Show all rooms.
                    System.out.println("---------------------Room List---------------------");
                    showServiceList("Room.csv");
                    System.out.println("------------------------End-------------------------");
                    break;
                case 4: // Show all names of villas without duplicate.
                    System.out.println("---------------------Distinct Villa Names---------------------");
                    showAllDistinctServiceNames("Villa.csv");
                    System.out.println("---------------------------End-----------------------------");
                    break;
                case 5: // Show all names of houses without duplicate.
                    System.out.println("---------------------Distinct House Names---------------------");
                    showAllDistinctServiceNames("House.csv");
                    System.out.println("---------------------------End-----------------------------");
                    break;
                case 6: // Show all names of rooms without duplicate.
                    System.out.println("---------------------Distinct Room Names---------------------");
                    showAllDistinctServiceNames("Room.csv");
                    System.out.println("---------------------------End-----------------------------");
                    break;
                case 7: // Back to main menu.
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("!Invalid input. Please try again.");
            }
        } while (choice != 7);
    }

    /**
     * Show all services in a file on console screen.
     *
     * @param fileName The name of the file.
     */
    public static void showServiceList(String fileName) {
        try {
            Path path = FileSystems.getDefault().getPath(FileUtil.DATA_FOLDER + fileName);

            Service[] services = ServiceFileUtil.readServiceData(path);
            for (int i = 0; i < services.length; i++) {
                System.out.print((i + 1) + "/ ");
                services[i].showInfor();
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Print out all names without duplicate of each type of service.
     *
     * @param fileName The file name.
     */
    public static void showAllDistinctServiceNames(String fileName) {
        File serviceFile = new File(FileUtil.DATA_FOLDER + fileName);
        TreeSet<String> distinctNames = new TreeSet<>();

        try {
            Service[] serviceList = ServiceFileUtil.readServiceData(serviceFile.toPath());
            for (Service s : serviceList) {
                distinctNames.add(s.getServiceName());
            }
        } catch(IOException e) {
            e.printStackTrace();
        }

        // Print out the tree set.
        AtomicInteger counter = new AtomicInteger(1);
        distinctNames.forEach(e ->
                System.out.println(counter.getAndIncrement() + ". " + e));
    }
}
