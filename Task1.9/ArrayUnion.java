import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Maria on 21.01.2017.
 */
public class ArrayUnion {
    /**
     * entry point
     * @param args arguments from command line. if it's empty program asks user to enter data;
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] firstArray;
        String[] secondArray;
        int k = 0;
        System.out.println("first array:");
        firstArray = sc.nextLine().split(" ");
        System.out.println("second array:");
        secondArray = sc.nextLine().split(" ");
        System.out.println("enter k:");
        try {
            k = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid data");
            System.exit(0);
        }
        printArray(union(firstArray, secondArray, k));
    }

    /**
     * unites two arrays into one, placing second array between k and k+1 elements
     * @param firstArray is a first array;
     * @param secondArray is a second array
     * @param k is a position for placing second array
     * @return united array;
     */
    public static String[] union(String[] firstArray, String[] secondArray, int k) {

        String[] unitedArray = new String[firstArray.length + secondArray.length];
        for(int i = 0; i < k; i++) {
            unitedArray[i] = firstArray[i];
        }
        for(int i = k; i < (k + secondArray.length); i++) {
            unitedArray[i] = secondArray[i - k];
        }
        for(int i = (k + secondArray.length); i < (firstArray.length + secondArray.length); i++) {
            unitedArray[i] = firstArray[i - secondArray.length];
        }
        return unitedArray;
    }

    /**
     * prints array
     * @param unitedArray array for printing
     */
    public static void printArray(String[] unitedArray) {
        for(int i = 0; i < unitedArray.length; i++) {
            System.out.print(unitedArray[i] + "  ");
        }
    }
}
