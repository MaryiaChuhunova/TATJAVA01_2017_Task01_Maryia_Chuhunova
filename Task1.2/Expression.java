import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/19/2017.
 */
public class Expression {

    /**
     * entry point
     *
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String[] numbers = getData(args);
        if (dataValidation(numbers)) {
            System.out.println(calculateExpression(getNumbers(numbers)));
        }
    }

    /**
     * calculates expression with entered numbers
     *
     * @param numbers integer array of numbers ;
     * @return result of calculation;
     */
    public static double calculateExpression(int[] numbers) {

        return (((numbers[1] + Math.sqrt(numbers[1] * numbers[1] + 4 * numbers[0] * numbers[2])) / (2 * numbers[0]))
                - (numbers[0] * numbers[0] * numbers[0] * numbers[2]) + (Math.pow(numbers[1], -2)));

    }

    /**
     * string array of numbers into integer array of numbers
     *
     * @param sNumbers is a number in string type
     * @return array of integer numeric parts of number
     */
    public static int[] getNumbers(String[] sNumbers) {

        int[] numbers = new int[3];
        numbers[0] = Integer.parseInt(sNumbers[0]);
        numbers[1] = Integer.parseInt(sNumbers[1]);
        numbers[2] = Integer.parseInt(sNumbers[2]);

        return numbers;
    }

    /**
     * checks if entered data is numeric
     *
     * @param numbers entered string data
     * @return true if entered data numeric
     */
    public static boolean dataValidation(String[] numbers) {
        //TODO include negative numbers

        if ((numbers[0].matches(("^\\d+$"))) && (numbers[1].matches(("^\\d+$"))) && (numbers[2].matches(("^\\d+$")))) {
            return true;
        }
        System.out.println("Invalid data");
        return false;
    }

    /**
     * gets data depending on source
     *
     * @param args data from comand line
     * @return data from comand line if it's not empty, otherwise asks user to enter data;
     */
    public static String[] getData(String[] args) {

        String[] numbers = {"", "", ""};

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
