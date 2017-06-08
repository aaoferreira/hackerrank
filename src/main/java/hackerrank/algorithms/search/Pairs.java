/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 15 Jun 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Pairs {

    // https://www.hackerrank.com/challenges/pairs
    
    public static void main(String[] args) throws Exception {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Pairs.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array and difference
        int size = scanner.nextInt();
        int difference = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sorts array
        Arrays.sort(array);
        
        System.out.print(countPairsWithDifference(array, difference));
    }

    /**
     * Counts number of pairs with difference equals difference passed assuming
     *  the array passed is sorted
     * 
     * @param array
     *      Sorted array
     * @param difference
     *      Difference to look for
     * @return Count of pairs with difference equals to difference passed
     */
    private static int countPairsWithDifference(int[] array, int difference) {
        int pairsCount = 0;
        int startIndex = 0;
        int endIndex = startIndex + 1;
        while (startIndex < array.length - 1 && endIndex < array.length) {
            int currDiff = array[endIndex] - array[startIndex];
            if (currDiff == difference) {
                pairsCount++;
                endIndex++;
            } else if (currDiff < difference) {
                endIndex++;
            } else {
                startIndex++;
                if (startIndex == endIndex) {
                    endIndex++;
                }
            }
        }
        
        return pairsCount;
    }
}
