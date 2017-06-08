/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 12 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Pangrams {

    // https://www.hackerrank.com/challenges/pangrams
    
    private static final short MIN_ASCII_UPPER = 'A';
    private static final short MAX_ASCII_UPPER = 'Z';
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Pangrams.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Creates alphabet array
        int size = (MAX_ASCII_UPPER - MIN_ASCII_UPPER) + 1;
        boolean[] lettersRecord = new boolean[size];
        
        // Difference between chars because case doesn't matter
        int lowerUpperDiff = MIN_ASCII_LOWER - MIN_ASCII_UPPER;
        
        // Goes through sentence chars
        String sentence = scanner.nextLine();
        scanner.close();
        for (char character : sentence.toCharArray()) {
            // Checks if character is a letter
            if ((character > MAX_ASCII_UPPER && character < MIN_ASCII_LOWER)
                    || character < MIN_ASCII_UPPER
                    || character > MAX_ASCII_LOWER) {
                continue;
            }
            
            if (character > MAX_ASCII_UPPER) {
                character = (char) (character - lowerUpperDiff);
            }
            lettersRecord[character - MIN_ASCII_UPPER] = true;
        }
        
        // Checks if all letters are used
        for (boolean letterUsed : lettersRecord) {
            if (!letterUsed) {
                System.out.print("not ");
                break;
            }
        }
        
        System.out.println("pangram");
    }
}
