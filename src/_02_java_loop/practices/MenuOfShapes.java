package _02_java_loop.practices;

import java.util.Scanner;

public class MenuOfShapes {

    static void drawTriangle(int edges) {
        int stars = 1;
        int spaces = edges - stars;

        while (stars < edges) {
            //draw stars.
            for (int i = 1; i <= stars; i++) {
                System.out.print("* ");
            }
            //draw spaces.
            for (int t = 1; t <= spaces; t++) {
                System.out.print(" ");
            }
            System.out.println();
            stars++;
            spaces--;
        }
    }

    static void drawRectangle(int width, int height) {
        for (int h = 1; h <= height; h++) {
            for (int w = 1; w <= width; w++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

    static void drawSquare(int edges) {
        for (int i = 1; i <= edges; i++) {
            for (int t = 1; t <= edges; t++) {
                System.out.print("*  ");
            }
            System.out.println();
        }
    }

//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

    public static void main(String[] args) {

        boolean isContinue = false;
        do {
            //create a menu.
            System.out.println("-----------Menu-----------");
            System.out.println("1. Draw triangle");
            System.out.println("2. Draw rectangle");
            System.out.println("3. Draw square");
            System.out.println("4. Exit");
            System.out.println("--------------------------");

            Scanner in = new Scanner(System.in);
            System.out.print("Please enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    drawTriangle(5);
                    break;
                case 2:
                    drawRectangle(10, 6);
                    break;
                case 3:
                    drawSquare(5);
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Your choice is invalid. Please try again.");
                    isContinue = true;
                    continue;
            }

            System.out.print("Do you want to continue? (y/n) ");
            //read the newline character in buffer.
            if (in.hasNextLine()) {
                in.nextLine();
            }
            String opt = in.nextLine();
            isContinue = opt.equalsIgnoreCase("y");
        } while (isContinue);
    }
}
