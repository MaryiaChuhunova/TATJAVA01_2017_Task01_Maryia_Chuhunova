import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Maria on 21.01.2017.
 */
public class Matrix {
    /**
     * entry point
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
        System.out.println("range of matrix:");
        try {
            n = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid data");
            System.exit(0);
        }
        printMatrix(matrixGeneration(n), n);
    }

    /**
     * unites two arrays into one, placing second array between k and k+1 elements
     * @param n range of matrix
     * @return matrix;
     */
    public static int[][] matrixGeneration(int n) {

        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i % 2 == 0) {
                    matrix[i][j] = j + 1;
                } else {
                    matrix[i][j] = n - j;
                }
            }
        }
        return matrix;
    }

    /**
     * prints array
     * @param matrix is a matrix
     * @param n is a range of matrix
     */
    public static void printMatrix(int[][] matrix, int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
