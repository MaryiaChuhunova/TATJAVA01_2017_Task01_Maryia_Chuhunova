import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/20/2017.
 */
public class SumAliquot {
    /**
     * entry point
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = 0;
        int k = 0;

        try {
            System.out.println("Enter size of array");
            n = sc.nextInt();
            System.out.println("Enter k");
            k = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid data");
            System.exit(0);
        }
        String[] array = getArray(n);
        if(validateArray(array)) {
            System.out.println(sum(getNumbers(array), k));
        }
    }

    /**
     * calculates sum of numbers aliquot to k
     * @param numbers integer array of numbers ;
     * @return result of calculation;
     */
    public static int sum(int[] numbers, int k) {

        int sum = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] % k == 0) {
                sum += numbers[i];
            }
        }
        return sum;
    }

    /**
     * string array of numbers into integer array of numbers
     *
     * @param sNumbers is a number in string type
     * @return array of integer numbers
     */
    public static int[] getNumbers(String[] sNumbers) {

        int[] numbers = new int[sNumbers.length];
        for (int i = 0; i < sNumbers.length; i++) {
            numbers[i] = Integer.parseInt(sNumbers[i]);
        }

        return numbers;
    }

    /**
     * checks if entered data is numeric
     *
     * @param sNumbers entered string data
     * @return true if entered data numeric
     */
    public static boolean validateArray(String[] sNumbers) {

        for (int i = 0; i < sNumbers.length; i++) {
            if (!(sNumbers[i].matches("^\\d+$"))) {
                return false;
            }
        }

        return true;
    }

    /**
     * gets array
     *
     * @param n size of array
     * @return string array with numbers;
     */
    public static String[] getArray(int n) {

        String[] numbers = new String[n];
        System.out.println("Enter array:");
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++) {
            numbers[i] = sc.nextLine();
        }
        return numbers;
    }
}
