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
public class Quicksort2Sorting {

    // https://www.hackerrank.com/challenges/quicksort2
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Quicksort2Sorting.class;
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
        quickSort(array);
    }

    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     */
    private static void quickSort(int[] array) {
        // If less then two elements, already sorted
        if (array.length < 2) {
            return;
        }
        
        int pivot = array[0];
        
        // Gets left and right partition counts
        int leftCount = 0;
        int rightCount = 0;
        for (int value : array) {
            if (value < pivot) {
                leftCount++;
            } else if (value > pivot) {
                rightCount++;
            }
        }
        
        // Creates left, right and equal arrays
        int[] left = new int[leftCount];
        int[] right = new int[rightCount];
        int[] equal = new int[array.length - leftCount - rightCount];
        
        // Fill arrays
        int leftIndex = 0;
        int rightIndex = 0;
        int equalIndex = 0;
        for (int value : array) {
            if (value < pivot) {
                left[leftIndex++] = value;
            } else if (value == pivot) {
                equal[equalIndex++] = value;
            } else {
                right[rightIndex++] = value;
            }
        }
        
        // Recursive calls
        if (left.length > 0) {
            quickSort(left);
        }
        if (equal.length > 0) {
            quickSort(equal);
        }
        if (right.length > 0) {
            quickSort(right);
        }
        
        // Reorders array as specified
        for (int i = 0; i < array.length; i++) {
            if (i < left.length) {
                array[i] = left[i];
            } else if (i < left.length + equal.length) {
                array[i] = equal[i - left.length];
            } else {
                array[i] = right[i - left.length - equal.length];
            }
        }
        
        // Prints array
        printArray(array);
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
