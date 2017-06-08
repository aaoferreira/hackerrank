/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LargestPermutation {

    // https://www.hackerrank.com/challenges/largest-permutation
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LargestPermutation.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int size = scanner.nextInt();
        int swapsAllowed = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Performs swaps allowed
        for (int i = 0; i < array.length && swapsAllowed > 0; i++) {
            if (array[i] != size - i) {
                swap(array, size - i, i);
                swapsAllowed--;
            }
        }
        
        // Prints array
        StringBuilder output = new StringBuilder();
        for (int value : array) {
            output.append(value);
            output.append(" ");
        }
        System.out.print(output.toString());
    }

    /**
     * Swaps value with value on index
     * 
     * @param array
     *      Array
     * @param value
     *      Value to be found and swapped
     * @param index
     *      Index to be swapped with value
     */
    private static void swap(int[] array, int value, int index) {
        for (int i = index + 1; i < array.length; i++) {
            int tmp = array[i];
            if (tmp == value) {
                array[i] = array[index];
                array[index] = tmp;
                break;
            }
        }
    }
}
