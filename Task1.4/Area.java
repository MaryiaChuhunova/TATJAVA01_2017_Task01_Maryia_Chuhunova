import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/20/2017.
 */
public class Area {

    /**
     * entry point
     *
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String[] sCoordinates = getData(args);
        if (validateCoordinates(sCoordinates)) {
            System.out.println(areaChecker(getCoordinates(sCoordinates)));
        }
    }

    /**
     * checks if point belongs to area
     *
     * @param coordinates integer array of numbers ;
     * @return result of calculation;
     */
    public static boolean areaChecker(int[] coordinates) {

        return ((coordinates[0] >= -1 && coordinates[0] <= 1 && coordinates[1] >= 0 && coordinates[1] <= 2)
                || (coordinates[0] >= -1 && coordinates[0] <= 1 && coordinates[1] >= 0 && coordinates[1] <= 2));
    }

    /**
     * string array of coordinates into integer array of coordinates
     *
     * @param sCoordinates is a number in string type
     * @return array of integer numeric parts of number
     */
    public static int[] getCoordinates(String[] sCoordinates) {

        int[] coordinates = new int[2];
        try {
            coordinates[0] = Integer.parseInt(sCoordinates[0]);
            coordinates[1] = Integer.parseInt(sCoordinates[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid data");
        }

        return coordinates;
    }

    /**
     * checks if entered data is numeric
     *
     * @param sCoordinates entered string data
     * @return true if entered data numeric
     */
    public static boolean validateCoordinates(String[] sCoordinates) {

        int[] coordinates = new int[2];
        try {
            coordinates[0] = Integer.parseInt(sCoordinates[0]);
            coordinates[1] = Integer.parseInt(sCoordinates[1]);
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

        String[] coordinates = {"", ""};

        if (args.length > 1) {
            coordinates = args;
        } else {
            System.out.println("Enter data");
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            coordinates = line.split(" ");
        }
        return coordinates;
    }


}
