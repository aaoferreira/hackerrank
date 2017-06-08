/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TwoArrays {

    // https://www.hackerrank.com/challenges/two-arrays
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TwoArrays.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int value = scanner.nextInt();
            
            // Fill array A
            int[] arrayA = new int[size];
            for (int i = 0; i < arrayA.length; i++) {
                arrayA[i] = scanner.nextInt();
            }
            
            // Fill array B
            int[] arrayB = new int[size];
            for (int i = 0; i < arrayB.length; i++) {
                arrayB[i] = scanner.nextInt();
            }
            
            output.append(
                    hasPermutation(arrayA, arrayB, value) ? "YES" : "NO");
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Checks if arrays have a possible permutation where
     *  <code>arrayA[i] + arrayB[i] &gt;= value</code> for all positions
     * 
     * @param arrayA
     *      Array A
     * @param arrayB
     *      Array B
     * @param value
     *      Value
     * @return A boolean indicating the array have a permutation or not
     */
    private static boolean hasPermutation(int[] arrayA, int[] arrayB, int value) {
        // Sorts arrays
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        // Checks sum in reversal
        boolean valid = true;
        for (int i = 0; i < arrayA.length; i++) {
            int sum = arrayA[i] + arrayB[arrayB.length - i - 1];
            valid = sum >= value;
            if (!valid) {
                break;
            }
        }
        
        return valid;
    }
}
