package _03_java_method.exercises;

import java.util.Scanner;

public class MaxValueInMatrix {

    public static void inputMatrix(double[][] matrix, int n) {
        Scanner in = new Scanner(System.in);
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.printf("Enter matrix[%d][%d]: ", r, c);
                matrix[r][c] = in.nextDouble();
            }
        }
    }

    public static void outputMatrix(double[][] matrix) {
        for (double[] r : matrix) {
            for (double c : r) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    private static void findMaxValueInMatrix(double[][] matrix) {
        double max = Double.NEGATIVE_INFINITY;
        int rowIndex = -1, colIndex = -1;
        int size = matrix.length;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (matrix[r][c] > max) {
                    max = matrix[r][c];
                    rowIndex = r;
                    colIndex = c;
                }
            }
        }
        System.out.printf("The greatest element is %5.2f which at position of %d, %d.", max, rowIndex, colIndex);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of matrix: ");
        int size = in.nextInt();

        double[][] matrix = new double[size][size];
        System.out.println("Enter content of the matrix:");
        inputMatrix(matrix, size);
        System.out.println("The content of the matrix:");
        outputMatrix(matrix);

        findMaxValueInMatrix(matrix);
    }
}
