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
public class GameOfThronesI {

    // https://www.hackerrank.com/challenges/game-of-thrones
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = GameOfThronesI.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        boolean validKey = true;
        String key = scanner.nextLine();
        scanner.close();
        
        // Gets char count
        int[] chars = new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
        for (char character : key.toCharArray()) {
            chars[character - MIN_ASCII_LOWER]++;
        }
        
        // Odd flag
        boolean odd = key.length() % 2 != 0;
        boolean oneOddOccurrence = false;
        
        // Checks if all chars occur even times and if total length is odd,
        //  only one char occurs odd times
        for (int occurrence : chars) {
            if (occurrence % 2 != 0) {
                if (odd && !oneOddOccurrence) {
                    oneOddOccurrence = true;
                } else {
                    validKey = false;
                    break;
                }
            }
        }
        
        System.out.println(validKey ? "YES" : "NO");
    }
}
