import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/20/2017.
 */
public class PositiveNegative {
    /**
     * entry point
     *
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String[] sNumbers = getData(args);
        if (validateData(sNumbers)) {
            printArray(involution(getSides(sNumbers)));
        }
    }

    /**
     * prints array of numbers
     * @param numbers array of numbers
     */
    public static void printArray(int[] numbers) {
        for(int i = 0; i < 3; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    /**
     * involutes number into 2-nd degree if it's non-negative
     *              and into 4-th degree if it's negative
     *
     * @param numbers integer array of numbers ;
     * @return result of involution;
     */
    public static int[] involution(int[] numbers) {

        for(int i = 0; i < 3; i++) {
            if(numbers[i] >= 0) {
                numbers[i] = (int)(Math.pow(numbers[i], 2));
            } else {
                numbers[i] = (int)(Math.pow(numbers[i], 4));
            }
        }
        return numbers;
    }


    /**
     * string array of numbers into integer array of numbers
     *
     * @param sNumbers is a number in string type
     * @return array of integer numbers
     */
    public static int[] getSides(String[] sNumbers) {

        int[] numbers = new int[3];
        try {
            numbers[0] = Integer.parseInt(sNumbers[0]);
            numbers[1] = Integer.parseInt(sNumbers[1]);
            numbers[2] = Integer.parseInt(sNumbers[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
        }

        return numbers;
    }

    /**
     * checks if entered data is numeric
     *
     * @param sNumbers entered string data
     * @return true if entered data numeric
     */
    public static boolean validateData(String[] sNumbers) {

        int[] numbers = new int[3];
        try {
            numbers[0] = Integer.parseInt(sNumbers[0]);
            numbers[1] = Integer.parseInt(sNumbers[1]);
            numbers[2] = Integer.parseInt(sNumbers[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
            return false;
        }

        return true;
    }

    /**
     * gets data depending on source
     *
     * @param args data from comand line
     * @return data from comand line if it's not empty, otherwise asks user to enter data;
     */
    public static String[] getData(String[] args) {

        String[] numbers = {"", ""};

        if (args.length > 2) {
            numbers = args;
        } else {
            System.out.println("Enter data");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            numbers = line.split(" ");
        }
        return numbers;
    }

}
