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
public class CountingSort1 {

    // https://www.hackerrank.com/challenges/countingsort1
    
    private static final int SIZE = 100;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CountingSort1.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Prints occurrences
        printOccurrences(array);
    }

    /**
     * Calculates occurrences in array and prints it
     * 
     * @param array
     *      Array to have occurrences counted and printed
     */
    private static void printOccurrences(int[] array) {
        // Calculates occurrences
        int[] occurrences = new int[SIZE];
        for (int value : array) {
            occurrences[value]++;
        }
        printArray(occurrences);
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
