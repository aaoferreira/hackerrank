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
public class QuicksortInPlace {

    // https://www.hackerrank.com/challenges/quicksort3
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = QuicksortInPlace.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Quick sorts copy of array
        quickSort(array.clone());
    }

    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     */
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
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
     */
    private static void quickSort(int[] array, int startIndex, int endIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return;
        }
        
        int pivot = array[endIndex];
        int pivotIndex = startIndex;
        
        // Checks pivot position
        for (int i = pivotIndex; i < endIndex; i++) {
            if (array[i] <= pivot) {
                // Swaps to create partitions
                swap(array, pivotIndex, i);
                
                // Increases operations and pivot index counters
                pivotIndex++;
            }
        }
        // Swaps pivot to its position
        swap(array, pivotIndex, endIndex);
        
        // Prints array
        printArray(array);
        
        // Recursive calls for left and right partitions
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
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
     * Prints array
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
