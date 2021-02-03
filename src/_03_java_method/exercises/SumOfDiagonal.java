package _03_java_method.exercises;

import _03_java_method.exercises.MaxValueInMatrix;

import java.util.Scanner;

public class SumOfDiagonal {

    private static double calSumOfDiagonal(double[][] matrix, int size) {
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of matrix: ");
        int size = in.nextInt();

        double[][] matrix = new double[size][size];
        System.out.println("Enter content of the matrix:");
        MaxValueInMatrix.inputMatrix(matrix, size);
        System.out.println("The content of the matrix:");
        MaxValueInMatrix.outputMatrix(matrix);

        System.out.println("The sum of elements on the diagonal: " + calSumOfDiagonal(matrix, size));
    }
}
