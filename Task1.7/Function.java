import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/20/2017.
 */
public class Function {
    /**
     * entry point
     *
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String[] sNumbers = getData(args);
        if (validateData(sNumbers)) {
            printArray(calculateValues(getNumbers(sNumbers)));
        }
    }

    /**
     * calculates values of first and second column
     *
     * @param numbers integer array of numbers ;
     * @return array with results of calculations;
     */
    public static double[][] calculateValues(double[] numbers) {

        int count = (int) ((numbers[1] - numbers[0]) / numbers[2]);
        double[][] table = new double[count][2];
        double firstValue = numbers[0];

        for (int i = 0; i < count; i++) {
            table[i][0] = firstValue;
            firstValue += numbers[2];
            table[i][1] = function(table[i][0]);
        }

        return table;
    }

    /**
     * calculates function with given values
     *
     * @param x is a value on segment
     * @return result of function
     */
    public static double function(double x) {
        return (Math.sin(x) * Math.sin(x)) - Math.cos(2 * x);
    }

    /**
     * prints array of values
     *
     * @param numbers array of numbers
     */
    public static void printArray(double[][] numbers) {
        for (int i = 0; i < 3; i++) {
            System.out.println(numbers[i][0] + " " + numbers[i][1]);
        }
    }

    /**
     * string array of numbers into integer array of numbers
     *
     * @param sNumbers is a number in string type
     * @return array of integer numbers
     */
    public static double[] getNumbers(String[] sNumbers) {

        double[] numbers = new double[3];
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
