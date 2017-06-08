/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 12 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LarrysArray {

    // https://www.hackerrank.com/challenges/larrys-array
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LarrysArray.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        // Run through test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            
            // Fills array
            int[] array = new int[size];
            for (int j = 0; j < size; j++) {
                array[j] = scanner.nextInt();
            }
            
            // Robot sorts array
            robotSort(array);
            
            // Checks if array is fully sorted
            boolean sorted = true;
            for (int j = 0; j < size - 1; j++) {
                if (array[j] > array[j + 1]) {
                    sorted = false;
                    break;
                }
            }
            
            output.append(sorted ? "YES" : "NO");
            output.append("\n");
        }

        scanner.close();
        System.out.println(output.toString());
    }
    
    /**
     * Sorts as much as possible using robot sorting algorithm
     * 
     * @param array
     *      Array to be robot sorted
     */
    private static void robotSort(int[] array) {
        boolean sorted = false;
        do {
            sorted = robotSortFirstOccurrence(array);
        } while (sorted);
    }
    
    /**
     * Sorts first occurrence that is robot sortable
     * 
     * @param array
     *      Array to have first robot sortable occurrence sorted
     * @return Flag indicating if any occurrence was sorted
     */
    private static boolean robotSortFirstOccurrence(int[] array) {
        // Occurrence sorted flag
        boolean occurrenceSorted = false;
        
        // Loops through array looking for robot occurrence to be sorted
        for (int i = 0; i < array.length - 2; i ++) {
            int first = array[i];
            int second = array[i + 1];
            int third = array[i + 2];
            
            // Skips if first is already the lowest
            if (first < second && first < third) {
                continue;
            }
            
            // Sets lowest value to first
            if (second < third) {
                array[i] = second;
                array[i + 1] = third;
                array[i + 2] = first;
                occurrenceSorted = true;
            } else {
                array[i] = third;
                array[i + 1] = first;
                array[i + 2] = second;
                occurrenceSorted = true;
            }
            
            // If sorted,break loop
            if (occurrenceSorted) {
                break;
            }
        }
        
        return occurrenceSorted;
    }
}
