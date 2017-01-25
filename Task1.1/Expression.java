import java.util.Scanner;

/**
 * main class, contains entry point
 * Created by Maryia_Chuhunova on 1/19/2017.
 */
public class Expression {

    /**
     * entry point
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        String number = getData(args);
        if(dataValidation(number)) {
            System.out.println(checkExpression(toArray(number)));
        }
    }

    /**
     * checks entered number for complying given expression (sum of first two numbers is
     * equal to sum of second two numbers);
     * @param numbers array of numeric parts of number;
     * @return true if number complies expression, false if not;
     */
    public static boolean checkExpression(int[] numbers) {

        if((numbers[0] + numbers[1]) == ((numbers[2] + numbers[3]))) {
            return true;
        }
        return false;
    }

    /**
     * transforms number from string into array of numeric parts
     * @param sNumber is a number in string type
     * @return array of integer numeric parts of number
     */
    public static int[] toArray(String sNumber) {

        int number = Integer.parseInt(sNumber);
        int firstHalf = (number/100);
        int secondHalf = (number%100);
        int[] numbers = new int[4];
        numbers[0] = firstHalf/10;
        numbers[1] = (firstHalf%10);
        numbers[2] = (secondHalf/10);
        numbers[3] = (secondHalf%10);

        return numbers;
    }

    /**
     * checks if entered data numeric and has four numbers
     * @param number entered string data
     * @return true if entered data numeric and has four numbers
     */
    public static boolean dataValidation(String number) {

        if((number.length() == 4) && (number.matches(("^\\d+$")))) {
            return true;
        }
        System.out.println("Invalid data");
        return false;
    }

    /**
     * gets data depending on source
     * @param args data from comand line
     * @return data from comand line if it's not empty, otherwise asks user to enter data;
     */
    public static String getData(String[] args) {

        String number;

        if(args.length > 0) {
            number = args[0];
        } else {
            System.out.println("Enter data");
            Scanner sc = new Scanner(System.in);
            number = sc.nextLine();
        }
        return number;
    }
}
