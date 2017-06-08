/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 4 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CaesarCipher {

    // https://www.hackerrank.com/challenges/caesar-cipher-1
    
    private static final short MIN_ASCII_UPPER = 'A';
    private static final short MAX_ASCII_UPPER = 'Z';
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CaesarCipher.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int length = scanner.nextInt();
        scanner.nextLine();
        
        String value = scanner.nextLine();
        int rotations = scanner.nextInt();
        char[] characters = value.toCharArray();
        for (int i = 0; i < length; i++) {
            output.append(rotateChar(characters[i], rotations));
        }
        
        scanner.close();
        System.out.println(output.toString());
    }

    /**
     * Rotates char with number of rotations passed
     * 
     * @param character
     *      char to be rotated
     * @param rotations
     *      Number of rotations to rotate char
     * @return Rotated char
     */
    private static char rotateChar(char character, int rotations) {
        char newChar = character;
        int sum = character + rotations;
        int minAsciiValue = 0;
        int maxAsciiValue = 0;
        boolean rotateChar = false;
        
        // Checks if char should be rotated on lower cases
        if (character >= MIN_ASCII_LOWER
                && character <= MAX_ASCII_LOWER) {
            minAsciiValue = MIN_ASCII_LOWER;
            maxAsciiValue = MAX_ASCII_LOWER;
            rotateChar = true;
        } else if (character >= MIN_ASCII_UPPER
                && character <= MAX_ASCII_UPPER) {
            minAsciiValue = MIN_ASCII_UPPER;
            maxAsciiValue = MAX_ASCII_UPPER;
            rotateChar = true;
        }
        
        // Rotates character
        if (rotateChar) {
            if (sum > maxAsciiValue) {
                int diff = maxAsciiValue - minAsciiValue + 1;
                int over = sum - maxAsciiValue;
                sum -= (diff * (over / diff));
                if (over % diff > 0) {
                    sum -= diff;
                }
            }
            newChar = (char) sum;
        }
        
        return newChar;
    }
}
