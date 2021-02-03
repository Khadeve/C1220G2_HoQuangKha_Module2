package _03_java_method.exercises;

import java.util.Scanner;

public class SumOfColumn {

    public static void inputTwoDimensionalArray(double[][] ar, int rows, int cols) {
        Scanner in = new Scanner(System.in);
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.printf("Enter matrix[%d][%d]: ", r, c);
                ar[r][c] = in.nextDouble();
            }
        }
    }

    public static void outputTwoDimensionalArray(double[][] ar) {
        for (double[] r : ar) {
            for (double c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static double calSumOfCol(double[][] ar, int colIndex) {
        double sum = 0;
        int numberOfRows = ar.length;
        for (int row = 0; row < numberOfRows; row++) {
            sum += ar[row][colIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = in.nextInt();
        System.out.print("Enter the number of cols: ");
        int cols = in.nextInt();

        double[][] arr = new double[rows][cols];
        System.out.println("Enter content of the array:");
        inputTwoDimensionalArray(arr, rows, cols);
        System.out.println("The content of the array:");
        outputTwoDimensionalArray(arr);

        int colIndex = -1;
        do {
            System.out.print("Enter a column index: ");
            colIndex = in.nextInt();
            if (colIndex < 0 || colIndex >= cols) {
                System.out.println("Invalid input. Please try again.");
            }
        } while(colIndex < 0 || colIndex >= cols);

        System.out.println("The sum of elements in colummn " + colIndex + " is : " + calSumOfCol(arr, colIndex));
    }
}
