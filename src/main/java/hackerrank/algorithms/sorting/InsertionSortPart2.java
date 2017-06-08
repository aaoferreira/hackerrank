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
public class InsertionSortPart2 {

    // https://www.hackerrank.com/challenges/insertionsort2
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = InsertionSortPart2.class;
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
        insertionSort(array);
    }

    /**
     * Insert sorts array
     * 
     * @param array
     *      Array to be insertion sorted
     */
    private static void insertionSort(int[] array) {
        int size = array.length;
        StringBuilder output = new StringBuilder();
        
        // Loops through array sorting elements
        for (int i = 1; i < size; i++) {
            for (int currIndex = i; currIndex > 0; currIndex--)  {
                int prevIndex = currIndex - 1;
                if (array[currIndex] < array[prevIndex]) {
                    int temp = array[currIndex];
                    array[currIndex] = array[prevIndex];
                    array[prevIndex] = temp;
                }
            }
            output.append(arrayToString(array) + "\n");
        }
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
