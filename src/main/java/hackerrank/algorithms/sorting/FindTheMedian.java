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
public class FindTheMedian {

    // https://www.hackerrank.com/challenges/find-median
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FindTheMedian.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Quick sorts array
        System.out.println(findMedian(array));
    }

    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     * @return Operations performed
     */
    private static int findMedian(int[] array) {
        return findMedian(array, 0, array.length - 1, array.length / 2);
    }

    /**
     * Finds median value in array
     * 
     * @param array
     *      Array to have median value found
     * @param startIndex
     *      Start index of sub array to have median value found
     * @param endIndex
     *      End index of sub array to have median value found
     * @param medianIndex
     *      Index that median must be when balanced
     * @return Median value
     */
    private static int findMedian(
            int[] array,
            int startIndex,
            int endIndex,
            int medianIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return array[startIndex];
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
        
        // Checks if pivot is already in median position
        if (pivotIndex == medianIndex) {
            return array[pivotIndex];
        } else if (pivotIndex < medianIndex) {
            return findMedian(array, pivotIndex + 1, endIndex, medianIndex);
        } else {
            return findMedian(array, startIndex, pivotIndex - 1, medianIndex);
        }
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
}
