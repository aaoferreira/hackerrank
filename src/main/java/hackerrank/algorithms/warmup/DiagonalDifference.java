/**
 * IBM Confidential
 * 
 * IBM Ireland
 * Software Group - Cloud & Smarter Infrastructure
 *
 * Created-Date: 21 Mar 2016
 * Created-By: Alfredo Ferreira
 *
 * (C) COPYRIGHT IBM CORP. 2016
 *
 * SVN FILE: $HeadURL$
 */
package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 *
 * @author $Author$
 * @version
 *      $LastChangedDate$
 *      $Revision$
 *
 */
public class DiagonalDifference {

    // https://www.hackerrank.com/challenges/diagonal-difference
    
    public static void main(String[] args) {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = DiagonalDifference.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets matrix size and skips to next line
        int matrixSize = scanner.nextInt();
        scanner.nextLine(); 
        int[] leftDiagonal = new int[matrixSize];
        int[] rightDiagonal = new int[matrixSize];
        
        // Gets array values
        for (int i = 0, j = matrixSize - 1; i < matrixSize; i++, j--){
            for (int k = 0; k < matrixSize; k++) {
                int value = scanner.nextInt();
                if (k == i) {
                    leftDiagonal[i] = value;
                }
                if (k == j) {
                    rightDiagonal[i] = value;
                }
            }
        }
        scanner.close();
        
        System.out.println(
                Math.abs(sumArray(leftDiagonal) - sumArray(rightDiagonal)));
    }
    
    /**
     * Sums the values in the array
     * 
     * @param array
     *      Array to be summed
     * @return The sum of all array values
     */
    private static long sumArray(int[] array) {
        long result = 0;
        for (int value : array) {
            result += value;
        }
        return result;
    }
}
