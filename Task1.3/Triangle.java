import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/20/2017.
 */
public class Triangle {

    /**
     * entry point
     *
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String[] sSides = getData(args);
        if (validateSides(sSides)) {
            System.out.println("Square = " + squareCalculation(getSides(sSides)));
            System.out.println("Perimeter = " + perimeterCalculation(getSides(sSides)));
        }
    }

    /**
     * calculates square of triangle
     *
     * @param sides integer array of numbers ;
     * @return result of calculation;
     */
    public static double squareCalculation(int[] sides) {

        return ((sides[0] * sides[1]) / 2);
    }

    /**
     * calculates perimeter of triangle
     *
     * @param sides integer array of numbers ;
     * @return result of calculation;
     */
    public static double perimeterCalculation(int[] sides) {

        return (sides[0] + sides[1] + Math.sqrt(sides[0] * sides[0] + sides[1] * sides[1]));
    }


    /**
     * string array of sides into integer array of sides
     *
     * @param sSides is a number in string type
     * @return array of integer numeric parts of number
     */
    public static int[] getSides(String[] sSides) {

        int[] sides = new int[2];
        try {
            sides[0] = Integer.parseInt(sSides[0]);
            sides[1] = Integer.parseInt(sSides[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
        }

        return sides;
    }

    /**
     * checks if entered data is numeric
     *
     * @param sSides entered string data
     * @return true if entered data numeric
     */
    public static boolean validateSides(String[] sSides) {

        int[] sides = new int[2];
        try {
            sides[0] = Integer.parseInt(sSides[0]);
            sides[1] = Integer.parseInt(sSides[1]);
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

        String[] sides = {"", ""};

        if (args.length > 1) {
            sides = args;
        } else {
            System.out.println("Enter data");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            sides = line.split(" ");
        }
        return sides;
    }


}
