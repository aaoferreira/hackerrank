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
public class CountingSort2 {

    // https://www.hackerrank.com/challenges/countingsort2
    
    private static final int SIZE = 100;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CountingSort2.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Count sorts array
        countSort(array);
        
        // Prints array
        printArray(array);
    }

    /**
     * Count sorts array
     * 
     * @param array
     *      Array to be count sorted
     */
    private static void countSort(int[] array) {
        // Calculates occurrences
        int[] occurrences = new int[SIZE];
        for (int value : array) {
            occurrences[value]++;
        }
        
        // Sorts array with occurrences count
        int index = 0;
        for (int value = 0; value < SIZE; value++) {
            // Gets occurrences for value
            int valueOccurrences = occurrences[value];
            for (int j = 0; j < valueOccurrences; j++) {
                array[index++] = value;
            }
        }
    }
    
    /**
     * Prints array values in a space separated list
     * 
     * @param array
     *      Array to be printed
     */
    private static void printArray(int[] array) {
       StringBuilder output = new StringBuilder();
       for (int value : array) {
           output.append(value + " ");
       }
       System.out.println(output.toString());
    }
}
