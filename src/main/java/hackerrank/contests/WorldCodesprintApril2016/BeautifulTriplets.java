/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 29 Apr 2016
 *
 */
package hackerrank.contests.WorldCodesprintApril2016;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BeautifulTriplets {

    // https://www.hackerrank.com/contests/world-codesprint-april/challenges/beautiful-triplets
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BeautifulTriplets.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int length = scanner.nextInt();
        int beatifulDiff = scanner.nextInt();
        int[] sequence = new int[length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = scanner.nextInt();
        }
        scanner.close();
        
        int tripletsCount = countBeautifulTriplets(sequence, beatifulDiff);
        
        System.out.println(tripletsCount);
    }
    /**
     * Counts beautiful triplets in sequence
     * 
     * @param sequence
     *      Sequence to have beautiful triplets count
     * @param beatifulDiff
     *      Difference that classifies triplet as beautiful
     * @return Beautiful triplets occurrence in sequence
     */
    private static int countBeautifulTriplets(
            int[] sequence, int beatifulDiff) {
        int beautifulTripletCount = 0;
        // Loops through possible triplets first values
        for (int i = 0; i < sequence.length - 2; i++) {
            int firstValue = sequence[i];
            for (int j = i + 1; j < sequence.length - 1; j++) {
                int secondValue = sequence[j];
                
                // Loops through possible triplets second values
                if (secondValue - firstValue == beatifulDiff) {
                    
                    // Loops through possible triplets third values
                    for (int k = j + 1; k < sequence.length; k++) {
                        int thirdValue = sequence[k];
                        if (thirdValue - secondValue == beatifulDiff) {
                            beautifulTripletCount++;
                        }
                    }
                }
            }
        }
        
        return beautifulTripletCount;
    }
}
