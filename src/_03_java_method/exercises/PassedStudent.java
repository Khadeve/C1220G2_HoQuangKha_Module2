package _03_java_method.exercises;

import java.util.Scanner;

public class PassedStudent {
    public static void inputArray(double[] ar, int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark for student " + (i + 1) + ": ");
            ar[i] = in.nextDouble();
        }
    }

    private static int calPassedStudents(double[] scores) {
        int counter = 0;
        for (double score : scores) {
            if (score >= 5) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        do {
            System.out.print("Enter number of students: ");
            n = in.nextInt();
            if (n < 0 || n > 30) {
                System.out.println("Invalid input.");
            }
        } while (n < 0 || n > 30);

        double[] scoreList = new double[n];
        System.out.println("Enter list of scores: ");
        inputArray(scoreList, n);

        System.out.println("The number of passed student(s): " + calPassedStudents(scoreList));
    }
}
