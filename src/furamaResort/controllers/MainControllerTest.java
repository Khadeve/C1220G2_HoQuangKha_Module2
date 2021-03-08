package furamaResort.controllers;

import java.io.IOException;
import java.util.*;

public class MainControllerTest {
    public static void main(String[] args) {
        int c;

        // Show main menu.
        do {
            MainController.displayMainMenu();

            Scanner in = new Scanner(System.in);
            System.out.print("***Please enter your choice: ");
            c = in.nextInt();

            switch (c) {
                case 1:
                    try {
                        MainController.addNewServices();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    break;
                default:
                    System.out.println("***Your choice is invalid. Please try again!");
            }
        } while (c != 7);
    }
}
