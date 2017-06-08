/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class IceCreamParlor {

    // https://www.hackerrank.com/challenges/icecream-parlor
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = IceCreamParlor.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int money = scanner.nextInt();
            int flavors = scanner.nextInt();
            int[][] prices = new int[flavors][2];
            for (int j = 0; j < flavors; j++) {
                prices[j][0] = scanner.nextInt();
                prices[j][1] = j;
            }
            
            // Sorts prices
            quickSort(prices);
            
            // Finds flavors
            int[] firstFlavor = null;
            int[] secondFlavor = null;
            for (int j = 1; j < money; j++) {
                firstFlavor = binarySearch(prices, j);
                if (firstFlavor == null) {
                    continue;
                }
                int firstFlavorIndex = firstFlavor[1];
                firstFlavor[1] = -1;
                
                secondFlavor =
                        binarySearch(prices, money - j);
                firstFlavor[1] = firstFlavorIndex;
                if (secondFlavor != null) {
                    break;
                }
            }
            
            output.append(Math.min(firstFlavor[1], secondFlavor[1]) + 1);
            output.append(" ");
            output.append(Math.max(firstFlavor[1], secondFlavor[1]) + 1);
            output.append("\n");
        }
        
        scanner.close();
        System.out.print(output.toString());
    }

    /**
     * Binary searches array for value. Array must be sorted prior to this
     *  method call
     * 
     * @param array
     *      Array to be searched
     * @param value
     *      Value to be found
     * @param startIndex
     *      Start index to start searching
     * @return Index of value found or -1 if not found
     */
    private static int[] binarySearch(int[][] array, int value) {
        // With sorted array, divide and search
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int medium = (low + high) / 2;
            int[] result = array[medium];
            if (result[0] == value) {
                if (result[1] != -1) {
                    return result;
                } else {
                    // Value already returned, searches for one not used
                    for (int i = medium - 1; i >= 0; i--) {
                        result = array[i];
                        if (result[0] == value && result[1] != -1) {
                            return result;
                        }
                    }
                    for (int i = medium + 1; i < array.length; i++) {
                        result = array[i];
                        if (result[0] == value && result[1] != -1) {
                            return result;
                        }
                    }
                    break;
                }
            } else if (result[0] < value) {
                low = medium + 1;
            } else {
                high = medium - 1;
            }
        }
        
        // If not found
        return null;
    }
    


    /**
     * Performs quick sort of the array provided and stores original indexes
     * 
     * @param array
     *      Array to be quick sorted
     */
    private static void quickSort(int[][] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Performs quick sort of the array provided and stores original indexes
     *  within indexes boundaries passed
     * 
     * @param array
     *      Array to be quick sorted
     * @param startIndex
     *      Start index of sub array to be sorted
     * @param endIndex
     *      End index of sub array to be sorted
     */
    private static void quickSort(int[][] array, int startIndex, int endIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return;
        }
        
        int pivot = array[endIndex][0];
        int pivotIndex = startIndex;
        
        // Checks pivot position
        for (int i = pivotIndex; i < endIndex; i++) {
            if (array[i][0] <= pivot) {
                // Swaps to create partitions
                swap(array, pivotIndex, i);
                
                // Increases operations and pivot index counters
                pivotIndex++;
            }
        }
        // Swaps pivot to its position
        swap(array, pivotIndex, endIndex);
        
        // Recursive calls for left and right partitions
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }
    
    /**
     * Swaps values in the array and its stored indexes
     * 
     * @param array
     *      Array to have values swapped
     * @param a
     *      Index of value a to be swapped with value b
     * @param b
     *      Index of value b to be swapped with value a
     */
    private static void swap(int[][] array, int a, int b) {
        // If swapping for same value, skips
        if (a == b) {
            return;
        }
        
        int temp;
        
        // Swaps values
        temp = array[a][0];
        array[a][0] = array[b][0];
        array[b][0] = temp;
        
        // Swaps old indexes
        temp = array[a][1];
        array[a][1] = array[b][1];
        array[b][1] = temp;
    }
}
