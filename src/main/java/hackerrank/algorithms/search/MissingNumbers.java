/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 13 Jun 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MissingNumbers {

    // https://www.hackerrank.com/challenges/missing-numbers
    
    private static final int MAX_VALUE = 10_000;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MissingNumbers.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int aSize = scanner.nextInt();
        int[] arrayA = new int[aSize];
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = scanner.nextInt();
        }
        
        int bSize = scanner.nextInt();
        int[] arrayB = new int[bSize];
        for (int i = 0; i < arrayB.length; i++) {
            arrayB[i] = scanner.nextInt();
        }
        scanner.close();
        
        int[] aOccurrences = getOccurrences(arrayA);
        int[] bOccurrences = getOccurrences(arrayB);
        
        for (int i = 0; i < aOccurrences.length; i++) {
            if (aOccurrences[i] < bOccurrences[i]) {
                output.append(i + 1);
                output.append(" ");
            }
        }
        
        System.out.print(output.toString());
    }

    /**
     * Gets value occurrences for array
     * 
     * @param array
     *      Array to have occurrences counted
     * @return Occurrences array
     */
    private static int[] getOccurrences(int[] array) {
        int[] occurrences = new int[MAX_VALUE];
        for (int value : array) {
            occurrences[value - 1]++;
        }
        return occurrences;
    }
}
