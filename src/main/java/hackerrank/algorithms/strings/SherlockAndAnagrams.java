/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 20 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SherlockAndAnagrams {

    // https://www.hackerrank.com/challenges/sherlock-and-anagrams
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndAnagrams.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            // Reads line and calculates repeating letters
            String line = scanner.nextLine();
            int[] letterOccurrences = 
                   new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
            for (char character : line.toCharArray()) {
                letterOccurrences[character - MIN_ASCII_LOWER]++;
            }
            
            // Finds anagrams
            output.append(getAnagramCount(line) + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }

    /**
     * Gets count for all anagrams in value
     * 
     * @param value
     *      String to be checked for anagrams
     * @return Count of anagrams found
     */
    private static int getAnagramCount(String value) {
        int anagrams = 0;
        
        // Calculates anagrams for single letters
        int[] occurrences = new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
        for (char letter : value.toCharArray()) {
            occurrences[letter - MIN_ASCII_LOWER]++;
        }
        for (int occurrence : occurrences) {
            if (occurrence > 1) {
                anagrams += ((occurrence - 1) * occurrence) / 2;
            }
        }
        
        // Calculates all possible anagram with size greater than 1
        int length = value.length();
        for (int size = 2; size <= length; size++) {
            // Checks all possibles anagrams starting at index i
            for (int i = 0; i + size <= length; i++) {
                String source = value.substring(i, i + size);
                for (int j = i + 1; j + size <= length; j++) {
                    String target = value.substring(j, j + size);
                    if (areAnagrams(source, target)) {
                        anagrams++;
                    }
                }
            }
        }
        
        return anagrams;
    }

    /**
     * Checks if strings are anagrams
     * 
     * @param valueA
     *      String A
     * @param valueB
     *      String B
     * @return Flag indicating whether the strings are anagram or not
     */
    private static boolean areAnagrams(String valueA, String valueB) {
        if (valueA.equals(valueB)) {
            return true;
        }
        
        int size = MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1;
        
        int[] occurrencesA = new int[size];
        for (char letter : valueA.toCharArray()) {
            occurrencesA[letter - MIN_ASCII_LOWER]++;
        }
        
        int[] occurrencesB = new int[size];
        for (char letter : valueB.toCharArray()) {
            occurrencesB[letter - MIN_ASCII_LOWER]++;
        }
        
        boolean anagrams = true;
        for (int i = 0; i < size; i++) {
            if (occurrencesA[i] != occurrencesB[i]) {
                anagrams = false;
                break;
            }
        }
        
        return anagrams;
    }
}
