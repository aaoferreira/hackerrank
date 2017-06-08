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
public class CountingSort3 {

    // https://www.hackerrank.com/challenges/countingsort3
    
    private static final int SIZE = 100;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CountingSort3.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
            
            // Ignores text
            scanner.nextLine();
        }
        scanner.close();
        
        // Count sorts array
        int[] occurrences = countOccurrences(array);
        
        // Calculates prefix sum
        int[] prefixSum = new int[occurrences.length + 1];
        for (int i = 0; i < occurrences.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + occurrences[i];
        }
        
        // Prints array
        printArray(prefixSum, 1);
    }

    /**
     * Count occurrences of array
     * 
     * @param array
     *      Array to have occurrences counted
     * @return Occurrences array
     */
    private static int[] countOccurrences(int[] array) {
        // Calculates occurrences
        int[] occurrences = new int[SIZE];
        for (int value : array) {
            occurrences[value]++;
        }
        
        return occurrences;
    }
    
    /**
     * Prints array values in a space separated list from index passed
     * 
     * @param array
     *      Array to be printed
     * @param startIndex
     *      Start index to start printing
     */
    private static void printArray(int[] array, int startIndex) {
       printArray(array, startIndex, array.length - 1);
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
    private static void printArray(int[] array, int startIndex, int endIndex) {
        StringBuilder output = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            output.append(array[i] + " ");
        }
        System.out.println(output.toString());
    }
}
