/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 12 May 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BeautifulPairs {

    // https://www.hackerrank.com/challenges/beautiful-pairs
    
    private static final int MAX_VALUE = 1_000;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BeautifulPairs.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Fills arrays and gets occurrences
        int size = scanner.nextInt();
        int[] arrayA = new int[size];
        int[] arrayAOccurrences = new int[MAX_VALUE];
        int[] arrayB = new int[size];
        int[] arrayBOccurrences = new int[MAX_VALUE];
        for (int i = 0; i < size; i++) {
            arrayA[i] = scanner.nextInt();
            arrayAOccurrences[arrayA[i] - 1]++;
        }
        for (int i = 0; i < size; i++) {
            arrayB[i] = scanner.nextInt();
            arrayBOccurrences[arrayB[i] - 1]++;
        }
        scanner.close();
        
        int indexCount = beautifulDisjointIndexCount(
                arrayAOccurrences, arrayBOccurrences);
        
        System.out.print(indexCount);
    }

    /**
     * Counts beautiful disjoint indexes after one substitution in array B
     * 
     * @param arrayAOccurrences
     *      Values occurrence count in array A
     * @param arrayBOccurrences
     *      Values occurrence count in array B
     * @return Beautiful disjoint indexes count after one substitution in
     *  array B
     */
    private static int beautifulDisjointIndexCount(
            int[] arrayAOccurrences, int[] arrayBOccurrences) {
        int indexCount = 0;
        
        // Counts beautiful disjoint indexes before substitution in B
        for (int i = 0; i < arrayAOccurrences.length; i++) {
            int occurA = arrayAOccurrences[i];
            int occurB = arrayBOccurrences[i];
            
            if (occurA == 0 || occurB == 0) {
                continue;
            }
            
            int diff = Math.max(occurA, occurB) - Math.min(occurA, occurB);
            if (occurA > occurB) {
                indexCount += occurB;
                arrayBOccurrences[i] = 0;
                arrayAOccurrences[i] = occurA - diff;
            } else if (occurB > occurA) {
                indexCount += occurA;
                arrayAOccurrences[i] = 0;
                arrayBOccurrences[i] = occurB - diff;
            } else {
                indexCount += occurA;
                arrayAOccurrences[i] = 0;
                arrayBOccurrences[i] = 0;
            }
        }
        
        // Checks if there's an optimal substitution for B
        boolean hasStandingOccurA = false;
        for (int i = 0; i < arrayAOccurrences.length; i++) {
            if (arrayAOccurrences[i] > 0) {
                hasStandingOccurA = true;
                break;
            }
        }
        
        // If has standing value in A, index count might be increased
        //  If not, index count might be decreased
        if (hasStandingOccurA) {
            for (int i = 0; i < arrayBOccurrences.length; i++) {
                if (arrayBOccurrences[i] > 0) {
                    indexCount++;
                    break;
                }
            }
        } else {
            boolean hasStandingOccurB = false;
            for (int i = 0; i < arrayBOccurrences.length; i++) {
                if (arrayBOccurrences[i] > 0) {
                    hasStandingOccurB = true;
                    break;
                }
            }
            
            // If not value is standing in B, needs to break a current pair
            if (!hasStandingOccurB) {
                indexCount--;
            }
        }
        
        return indexCount;
    }
}
