/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class InsertionSortPart1 {

    // https://www.hackerrank.com/challenges/insertionsort1
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = InsertionSortPart1.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Insert sort last value
        insertionSortLastValue(array);
    }

    /**
     * Insert sort last value of array in itself
     * 
     * @param array
     *      Array to have last value insert sorted in itself
     */
    private static void insertionSortLastValue(int[] array) {
        int size = array.length;
        StringBuilder output = new StringBuilder();
        
        // Loops through array to accommodate last value
        int lastIndex = size - 1;
        int lastValue = array[lastIndex];
        for (int i = lastIndex; i >= 0; i--) {
            int previousValue = i > 0 ? array[i - 1] : lastValue;
            if (previousValue > lastValue) {
                array[i] = previousValue;
                output.append(arrayToString(array) + "\n");
            } else {
                array[i] = lastValue;
                break;
            }
        }
        output.append(arrayToString(array) + "\n");
        
        System.out.println(output.toString());
    }



    /**
     * Returns array's string representation
     * 
     * @param array
     *      Array to be represented as string
     * @return String representation of array passed
     */
    private static Object arrayToString(int[] array) {
        // Build array string output
        StringBuilder arrayString = new StringBuilder(array.length * 2);
        for (int value : array) {
            arrayString.append(value + " ");
        }
        
        return arrayString.toString();
    }
}
