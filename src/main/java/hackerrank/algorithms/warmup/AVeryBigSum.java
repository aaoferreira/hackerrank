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
public class AVeryBigSum {

    // https://www.hackerrank.com/challenges/a-very-big-sum
    
    public static void main(String[] args) {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AVeryBigSum.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array size and skips to next line
        int arraySize = scanner.nextInt();
        scanner.nextLine(); 
        int[] array = new int[arraySize];
        
        // Gets array values
        for (int i = 0; scanner.hasNextInt() && i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        System.out.println(sumArray(array));
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
