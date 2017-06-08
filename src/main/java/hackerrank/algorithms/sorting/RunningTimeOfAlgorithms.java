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
public class RunningTimeOfAlgorithms {

    // https://www.hackerrank.com/challenges/runningtime
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = RunningTimeOfAlgorithms.class;
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
        System.out.println(insertionSort(array));
    }

    /**
     * Insert sorts array
     * 
     * @param array
     *      Array to be insertion sorted
     * @return Number of times the array was shifted
     */
    private static int insertionSort(int[] array) {
        int size = array.length;
        int timesShifted = 0;
        
        // Loops through array sorting elements
        for (int i = 1; i < size; i++) {
            for (int currIndex = i; currIndex > 0; currIndex--)  {
                int prevIndex = currIndex - 1;
                if (array[currIndex] < array[prevIndex]) {
                    int temp = array[currIndex];
                    array[currIndex] = array[prevIndex];
                    array[prevIndex] = temp;
                    timesShifted++;
                }
            }
        }
        
        return timesShifted;
    }
}
