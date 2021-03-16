package furamaResort.controllers;

import furamaResort.models.Cinema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class MainController {

    private static final String MAIN_MENU = "\n---------------------Main Menu---------------------" +
            "\n1. Add New Services." +
            "\n2. Show Services." +
            "\n3. Add New Customer." +
            "\n4. Show All Customers." +
            "\n5. Add New Booking." +
            "\n6. Show Information of Employee." +
            "\n7. Show Cinema Customer List." +
            "\n8. Search Employee documentation." +
            "\n9. Exit." +
            "\n---------------------------------------------------";

    public static void main(String[] args) {
        int c;

        do {
            System.out.println(MAIN_MENU);  // Show main menu.

            Scanner in = new Scanner(System.in);
            System.out.print("***Please enter your choice: ");
            c = in.nextInt();

            switch (c) {
                case 1:
                    try {
                        ServiceMainController.addNewServices();
                    } catch (FileNotFoundException e) {
                        System.out.println("!ERROR WRITING NEW SERVICE INTO FILE.");
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    ServiceMainController.showServices();
                    break;

                case 3:
                    try {
                        System.out.println("--------------------Fill In Customer Information--------------------");
                        CustomerMainController.addNewCustomer();
                    } catch(FileNotFoundException e) {
                        System.out.println("!ERROR WRITING NEW CUSTOMER INTO FILE.");
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("---------------------Customer List---------------------");
                    CustomerMainController.showAllCustomers(true);
                    System.out.println("------------------------End----------------------------");
                    break;

                case 5:
                    try {
                        CustomerMainController.addNewBooking();
                        System.out.println("Successfully Adding New Booking.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("---------------------Employee List---------------------");
                    EmployeeMainController.showAllEmployees();
                    System.out.println("------------------------End----------------------------");
                    break;

                case 7:
                    System.out.print("***Enter number of tickets: ");
                    int numberOfTickets = in.nextInt();
                    Cinema furamaCinema = new Cinema(numberOfTickets);

                    furamaCinema.sellTicket();
                    furamaCinema.showCinemaCustomers();
                    break;
                case 8:
                    break;
                case 9:
                    break;
                default:
                    System.out.println("***Your choice is invalid. Please try again!");
            }
        } while (c != 9);
    }
}
