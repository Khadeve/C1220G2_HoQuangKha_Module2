package _02_java_loop.exercises;

import java.util.Scanner;

public class MenuOfShapes_02 {

    static void drawSquareTriangle(int edges, int squareAnglePos) {
        int stars = edges + 1;

        //Square angle position: top left and top right.
        if (squareAnglePos == 2 || squareAnglePos == 3) {
            stars = edges;
        }
        //square angle position: bottom left and bottom right.
        else if (squareAnglePos == 1 || squareAnglePos == 4) {
            stars = 1;
        }

        int spaces = edges - stars;
        //print stars first, then spaces.
        if (squareAnglePos == 1 || squareAnglePos == 2) {
            while (stars <= edges && spaces <= edges) {
                //draw stars.
                for (int i = 1; i <= stars; i++) {
                    System.out.print("* ");
                }
                //draw spaces.
                for (int t = 1; t <= spaces; t++) {
                    System.out.print(" ");
                }
                System.out.println();
                if (squareAnglePos == 1) {
                    stars++;
                    spaces--;
                } else {
                    stars--;
                    spaces++;
                }
            }
        }
        //print spaces first, then stars.
        else if (squareAnglePos == 3 || squareAnglePos == 4) {
            while (stars <= edges && spaces <= edges) {
                //draw spaces.
                for (int t = 1; t <= spaces; t++) {
                    System.out.print("  ");
                }
                //draw stars.
                for (int i = 1; i <= stars; i++) {
                    System.out.print("* ");
                }
                System.out.println();
                if (squareAnglePos == 3) {
                    stars--;
                    spaces++;
                } else {
                    stars++;
                    spaces--;
                }
            }
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

    static void drawIsoscelesTriangle(int height) {
        int cols = height * 2 - 1;

        for (int i = 0; i < height; i++) {
            int startIndex = (int) (cols / 2) - i;
            int endIndex = (int) (cols / 2) + i;
            //print spaces at the beginning of each row.
            for (int spaces = 0; spaces < startIndex; spaces++) {
                System.out.print(" ");
            }
            //print stars.
            for (int stars = startIndex; stars <= endIndex; stars++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        boolean isContinue = false;
        do {
            //create a menu.
            System.out.println("-----------Menu-----------");
            System.out.println("1. Print the square triangle");
            System.out.println("2. Print the rectangle");
            System.out.println("3. Print the isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("--------------------------");

            Scanner in = new Scanner(System.in);
            System.out.print("Please enter your choice: ");
            int choice = in.nextInt();

            switch (choice) {
                case 1:
                    //create a menu for square triangles.
                    System.out.println("-----------Square Triangle Menu-----------");
                    System.out.println("1. Bottom-left square angle");
                    System.out.println("2. Top-left square angle");
                    System.out.println("3. Top-right square angle");
                    System.out.println("4. Bottom-right square angle");
                    System.out.println("-------------------------------------------");

                    System.out.print("Please enter a square triangle: ");
                    int c = in.nextInt();
                    drawSquareTriangle(5, c);
                    break;
                case 2:
                    drawRectangle(10, 6);
                    break;
                case 3:
                    drawIsoscelesTriangle(4);
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
