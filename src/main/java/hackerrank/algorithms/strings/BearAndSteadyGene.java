/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 21 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BearAndSteadyGene {

    // https://www.hackerrank.com/challenges/bear-and-steady-gene
    
    private static final String GENES = "ACGT";
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BearAndSteadyGene.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Gets size
        int size = scanner.nextInt();
        scanner.nextLine();
        
        // Gets dna
        String dna = scanner.nextLine();
        scanner.close();
        
        // Finds shortest substitution
        System.out.println(findShortestSubstitution(dna, size));
    }

    /**
     * Find shortest substitution to make DNA steady
     * 
     * @param dna
     *      DNA to be balanced
     * @param size
     *      DNA size
     * @return Shortest substring to make DNA steady
     */
    private static int findShortestSubstitution(String dna, int size) {
        // Sets minimum size and steady count needed to make dna steady
        int minSize = size;
        int steadyCount = size / 4;
        
        // Gets occurrences per gene
        int[] occurrences = new int[GENES.length()];
        for (char gene : dna.toCharArray()) {
            occurrences[GENES.indexOf(gene)]++;
        }
        
        // Gets genes that need to be replaced
        int[] toBeReplaced = new int[GENES.length()];
        for (int i = 0; i < occurrences.length; i++) {
            toBeReplaced[i] = Math.max(occurrences[i] - steadyCount, 0);
        }
        
        // Checks if it's already steady
        boolean steady = true;
        for (int i = 0; i < occurrences.length - 1; i++) {
            steady = steady && occurrences[i] == occurrences[i + 1];
        }
        if (steady) {
            return 0;
        }
        
        // Gets minimum end index that contains all necessary genes
        occurrences = new int[GENES.length()];
        int endIndex = 0;
        for (; endIndex < dna.length(); endIndex++) {
            occurrences[GENES.indexOf(dna.charAt(endIndex))]++;
            
            // Checks if all necessary genes are there
            boolean neededGenesPresent = true;
            for (int i = 0; i < occurrences.length; i++) {
                neededGenesPresent = neededGenesPresent
                        && occurrences[i] >= toBeReplaced[i];
            }
            if (neededGenesPresent) {
                break;
            }
        }
        
        // Sets minimum size using end index found and start of dna
        minSize = endIndex + 1;
        
        // Find shortest substring from start
        int startIndex = 0;
        while (true) {
            while (true) {
                occurrences[GENES.indexOf(dna.charAt(startIndex++))]--;
                
                boolean allReplaced = true;
                for (int i = 0; i < occurrences.length; i++) {
                    allReplaced = allReplaced
                            && occurrences[i] >= toBeReplaced[i];
                }
                if (allReplaced) {
                    minSize = endIndex - startIndex + 1;
                } else {
                    break;
                }
            }
            
            // If current substring doesn't satisfy anymore, moves end index to
            //  check new substring
            endIndex++;
            
            // All substrings checked
            if (endIndex >= size) {
                break;
            }
            
            // Updates occurrences
            occurrences[GENES.indexOf(dna.charAt(endIndex))]++;
        }
        
        return minSize;
    }
}
