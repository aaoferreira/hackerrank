/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TheFullCountingSort {

    // https://www.hackerrank.com/challenges/countingsort4
    
    private static final int MAX_SIZE = 100;
    private static final String REPLACE_VALUE = " -";

    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheFullCountingSort.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets size
        int size = scanner.nextInt();
        int half = size / 2;
        
        // Gets key and values and calculates occurrences
        int[] keys = new int[size];
        String[] values = new String[size];
        int[] occurrences = new int[MAX_SIZE];
        
        for (int i = 0; i < size; i++) {
            // Gets key and value
            int key = scanner.nextInt();
            String value = scanner.nextLine();
            if (i < half) {
                value = REPLACE_VALUE;
            }
            
            // Sets key, value and occurrence
            keys[i] = key;
            values[i] = value;
            occurrences[key]++;
        }
        scanner.close();
        
        // Calculates prefix sum of occurrences
        int[] prefixSum = new int[MAX_SIZE];
        int sum = 0;
        for (int i = 0; i < MAX_SIZE; i++) {
            sum += occurrences[i];
            prefixSum[i] = sum;
        }
        
        // Creates new value sorted array
        String[] sortedValues = new String[size];
        for (int i = 0; i < size; i++) {
            int key = keys[i];
            int index = prefixSum[key] - occurrences[key]--;
            sortedValues[index] = values[i];
        }
        
        // Prints array
        printArray(sortedValues);
    }

    
    
    /**
     * Prints array values
     * 
     * @param array
     *      Array to be printed
     */
    private static void printArray(String[] array) {
        try (PrintWriter printWriter = new PrintWriter(System.out)) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                builder.append(array[i]);
            }
            builder.deleteCharAt(0);
            printWriter.print(builder.toString());
            printWriter.flush();
        }
    }
}
