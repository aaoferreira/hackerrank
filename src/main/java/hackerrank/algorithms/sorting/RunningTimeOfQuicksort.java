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
public class RunningTimeOfQuicksort {

    // https://www.hackerrank.com/challenges/quicksort4
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = RunningTimeOfQuicksort.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Insertion sorts copy of array
        int insertionOperations = insertionSort(array.clone());
        
        // Quick sorts copy of array
        int quicksortOperations = quickSort(array.clone());
        
        System.out.println(insertionOperations - quicksortOperations);
    }

    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     * @return Operations performed
     */
    private static int quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    /**
     * Performs quick sort of the array provided within indexes boundaries
     *  passed
     * 
     * @param array
     *      Array to be quick sorted
     * @param startIndex
     *      Start index of sub array to be sorted
     * @param endIndex
     *      End index of sub array to be sorted
     * @return Operations performed
     */
    private static int quickSort(int[] array, int startIndex, int endIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return 0;
        }
        
        int operations = 0;
        int pivot = array[endIndex];
        int pivotIndex = startIndex;
        
        // Checks pivot position
        for (int i = pivotIndex; i < endIndex; i++) {
            if (array[i] <= pivot) {
                // Swaps to create partitions
                swap(array, pivotIndex, i);
                
                // Increases operations and pivot index counters
                operations++;
                pivotIndex++;
            }
        }
        // Swaps pivot to its position
        swap(array, pivotIndex, endIndex);
        operations++;
        
        // Recursive calls for left and right partitions
        operations += quickSort(array, startIndex, pivotIndex - 1);
        operations += quickSort(array, pivotIndex + 1, endIndex);
        
        return operations;
    }
    
    /**
     * Swaps values in the array
     * 
     * @param array
     *      Array to have values swapped
     * @param a
     *      Index of value a to be swapped with value b
     * @param b
     *      Index of value b to be swapped with value a
     */
    private static void swap(int[] array, int a, int b) {
        // Swaps
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * Insert sorts array
     * 
     * @param array
     *      Array to be insertion sorted
     * @return Operations performed
     */
    private static int insertionSort(int[] array) {
        int size = array.length;
        int operations = 0;
        
        // Loops through array sorting elements
        for (int i = 1; i < size; i++) {
            for (int currIndex = i; currIndex > 0; currIndex--)  {
                int prevIndex = currIndex - 1;
                if (array[currIndex] < array[prevIndex]) {
                    int temp = array[currIndex];
                    array[currIndex] = array[prevIndex];
                    array[prevIndex] = temp;
                    operations++;
                }
            }
        }
        
        return operations;
    }
}
