/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 13 Jun 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SherlockAndPairs {

    // https://www.hackerrank.com/challenges/sherlock-and-pairs
    
    private static final int MAX_VALUE = 1_000_000;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndPairs.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int size = scanner.nextInt();
            int[] array = new int[size];
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
            }
            
            int[] occurrences = new int[MAX_VALUE];
            for (int value : array) {
                occurrences[value - 1]++;
            }
            
            long pairCount = 0;
            for (int occurrence : occurrences) {
                pairCount += occurrence > 1 ? (long) occurrence * (occurrence - 1) : 0;
            }
            
            output.append(pairCount);
            output.append("\n");
        }
        scanner.close();
        System.out.print(output.toString());
    }
}
