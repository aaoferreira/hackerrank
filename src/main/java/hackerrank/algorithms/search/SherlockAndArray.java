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
public class SherlockAndArray {

    // https://www.hackerrank.com/challenges/sherlock-and-array
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndArray.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int length = scanner.nextInt();
            int[] array = new int[length];
            for (int j = 0; j < length; j++) {
                array[j] = scanner.nextInt();
            }
            
            output.append(hasEqualSums(array) ? "YES" : "NO");
            output.append("\n");
        }
        scanner.close();
        System.out.print(output.toString());
    }

    /**
     * Checks if there's an equal sum between a left and right side separated
     *  by a pivot
     * 
     * @param array
     *      Array to have sums checked
     * @return A boolean whether it has equals sums or not
     */
    private static boolean hasEqualSums(int[] array) {
        boolean equalSums = false;
        long[] prefixSum = prefixSum(array);
        
        // If it only has one element, returns true
        if (array.length == 1) {
            return true;
        }
        
        // Loops through prefix sums checking if left and right sums are equal
        long lastSum = prefixSum[prefixSum.length - 1];
        for (int i = 1; i < prefixSum.length - 1; i++) {
            // Gets current (left) sum excluding pivot and compares to
            //  remaining (right) sum excluding pivot
            long currSum = prefixSum[i - 1];
            if (lastSum - prefixSum[i] == currSum) {
                equalSums = true;
                break;
            }
        }
        
        return equalSums;
    }

    /**
     * Calculates prefix sum for array
     * 
     * @param array
     *      Array to have prefix sums calculated
     * @return Array with the prefixes summed
     */
    private static long[] prefixSum(int[] array) {
        // Prefix sum array values
        long[] prefixSum = new long[array.length];
        long previousValue = 0;
        for (int i = 0; i < prefixSum.length; i++) {
            previousValue += (long) array[i];
            prefixSum[i] = previousValue;
        }
        return prefixSum;
    }
}
