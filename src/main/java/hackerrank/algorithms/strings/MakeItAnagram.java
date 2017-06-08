/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 19 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MakeItAnagram {

    // https://www.hackerrank.com/challenges/make-it-anagram
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MakeItAnagram.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int deletions = 0;
        String stringA = scanner.nextLine();
        String stringB = scanner.nextLine();
        scanner.close();
        
        // Gets char count
        int size = MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1;
        int[] charsA = new int[size];
        for (char character : stringA.toCharArray()) {
            charsA[character - MIN_ASCII_LOWER]++;
        }
        int[] charsB = new int[size];
        for (char character : stringB.toCharArray()) {
            charsB[character - MIN_ASCII_LOWER]++;
        }
        
        // Checks how many deletions are needed to make both string anagrams
        for (int i = 0; i < size; i++) {
            int charAOccurrence = charsA[i];
            int charBOccurrence = charsB[i];
            if (charAOccurrence > charBOccurrence) {
                deletions += charAOccurrence - charBOccurrence;
            } else if (charAOccurrence < charBOccurrence) {
                deletions += charBOccurrence - charAOccurrence;;
            }
        }
        
        System.out.println(deletions);
    }
}
