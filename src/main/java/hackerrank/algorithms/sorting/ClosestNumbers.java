/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ClosestNumbers {

    // https://www.hackerrank.com/challenges/closest-numbers
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ClosestNumbers.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sorts array
        Arrays.sort(array);
        
        // Finds smallest difference and stores pairs
        List<Integer> valuesList = new ArrayList<>(size);
        long minDiff = Long.MAX_VALUE;
        for (int i = size - 1; i > 0; i--) {
            int a = array[i];
            int b = array[i - 1];
            long currDiff = a - b;
            
            // If current difference is less, clears list and updates
            //  difference
            if (currDiff < minDiff) {
                minDiff = currDiff;
                valuesList.clear();
            }
            
            // Adds values
            if (currDiff == minDiff) {
                valuesList.add(a);
                valuesList.add(b);
            }
        }
        
        // Prints sorted array
        Integer[] valuesArray = valuesList.toArray(new Integer[0]);
        Arrays.sort(valuesArray);
        printArray(valuesArray);
    }

    /**
     * Prints array values in a space separated list
     * 
     * @param array
     *      Array to be printed
     */
    private static void printArray(Integer[] array) {
       printArray(array, 0, array.length - 1);
    }
    
    /**
     * Prints array values in a space separated list from index to index passed
     * 
     * @param array
     *      Array to be printed
     * @param startIndex
     *      Start index to start printing
     * @param endIndex
     *      End index to finish printing
     */
    private static void printArray(Integer[] array, int startIndex, int endIndex) {
        StringBuilder output = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            output.append(array[i] + " ");
        }
        System.out.println(output.toString());
    }
}
