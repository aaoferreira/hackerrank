/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 27 May 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SherlockAndValidString {

    // https://www.hackerrank.com/challenges/sherlock-and-valid-string
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndValidString.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        System.out.print(canBeValid(scanner.next()) ? "YES" : "NO");
        scanner.close();
    }

    /**
     * Checks if it is possible to make string valid with only one operation
     * 
     * @param string
     *      String to be checked
     * @return Flag indicating if string is or can be made valid
     */
    private static boolean canBeValid(String string) {
        boolean valid = true;
        
        // Gets letter occurrence
        int[] letterOccurrence =
                new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
        for (char letter : string.toCharArray()) {
            letterOccurrence[letter - MIN_ASCII_LOWER]++;
        }
        
        // Checks if already valid and get two distinct values present in array
        int occurA = 0;
        int occurACount = 0;
        int occurB = 0;
        int occurBCount = 0;
        for (int occurrence : letterOccurrence) {
            if (occurrence > 0) {
                if (occurA == 0 || occurA == occurrence) {
                    // Sets occurA
                    occurA = occurrence;
                    occurACount++;
                } else if (occurB == 0 || occurB == occurrence) {
                    // Sets occurB
                    occurB = occurrence;
                    occurBCount++;
                } else if (occurrence != occurA && occurrence != occurB) {
                    // If different occurrence than A and B, not possible
                    valid = false;
                    break;
                }
                
                // If both occurrences occur more then once, no possible
                if (occurACount > 1 && occurBCount > 1) {
                    valid = false;
                    break;
                }
            }
        }
        
        // If still valid, checks if adjusting any of the occurrences
        if (valid) {
            if (occurA > 1 && occurB > 1) {
                valid = Math.abs(occurA - occurB) <= 1;
            }
        }
        
        return valid;
    }
}
