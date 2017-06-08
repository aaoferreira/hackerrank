/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Jun 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class JimAndTheOrders {

    // https://www.hackerrank.com/challenges/jim-and-the-orders
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = JimAndTheOrders.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        // Gets orders, saves combined time and customer number
        int numberOfOrders = scanner.nextInt();
        int[][] orders = new int[numberOfOrders][2];
        for (int i = 0; i < numberOfOrders; i++) {
            int orderTime = scanner.nextInt();
            int orderProcessTime = scanner.nextInt();
            orders[i][0] = orderTime + orderProcessTime;
            orders[i][1] = i + 1;
        }
        scanner.close();
        
        // Sorts based on combined time to fulfill order
        quickSort(orders);
        
        // Builds output
        for (int[] order : orders) {
            output.append(order[1]);
            output.append(" ");
        }
        
        System.out.print(output.toString());
    }
    
    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     */
    private static void quickSort(int[][] array) {
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
    private static void quickSort(int[][] array, int startIndex, int endIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return;
        }
        
        int pivot = array[endIndex][0];
        int pivotValue = array[endIndex][1];
        int pivotIndex = startIndex;
        
        // Checks pivot position
        for (int i = pivotIndex; i < endIndex; i++) {
            if (array[i][0] <= pivot) {
                if (array[i][0] == pivot && array[i][1] > pivotValue) {
                    continue;
                }
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
     * Swaps values in the array
     * 
     * @param array
     *      Array to have values swapped
     * @param a
     *      Index of value a to be swapped with value b
     * @param b
     *      Index of value b to be swapped with value a
     */
    private static void swap(int[][] array, int a, int b) {
        // Swaps
        int[] temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
