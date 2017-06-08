/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Jun 2016
 *
 */
package hackerrank.algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TheMaximumSubarray {
    
    // https://www.hackerrank.com/challenges/maxsubarray
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheMaximumSubarray.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            output.append(getMaximumContiguousSum(array));
            output.append(" ");
            output.append(getMaximumSum(array));
            output.append("\n");
        }
        
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Gets maximum contiguous sum in the array
     * 
     * @param array
     *      Array to be checked
     * @return Maximum contiguous sum value
     */
    private static int getMaximumContiguousSum(int[] array) {
        int maxSum = array[0];
        int maxHere = array[0];
        for (int i = 1; i < array.length; i++) {
            maxHere = Math.max(array[i], maxHere + array[i]);
            maxSum = Math.max(maxHere, maxSum);
        }
        
        return maxSum;
    }

    /**
     * Gets maximum sum between independent elements in the array
     * 
     * @param array
     *      Array to be checked
     * @return Maximum sum value
     */
    private static int getMaximumSum(int[] array) {
        int maxSum = 0;
        int currSum = 0;
        int maxValue = Integer.MIN_VALUE;
        
        // Loops through array calculating values
        for (int value : array) {
            
            // Calculates sum
            if (value > 0) {
                currSum += value;
                maxSum = Math.max(maxSum, currSum);
            }
            maxValue = Math.max(maxValue, value);
        }
        
        // Checks if there weren't any positive numbers
        if (maxSum <= 0) {
            maxSum = maxValue;
        }
        
        return maxSum;
    }
}
