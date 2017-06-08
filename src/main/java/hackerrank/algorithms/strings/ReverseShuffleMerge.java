/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 26 May 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ReverseShuffleMerge {

    // https://www.hackerrank.com/challenges/reverse-shuffle-merge
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ReverseShuffleMerge.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        String input = scanner.next();
        scanner.close();
        
        // Gets letter occurrence
        char minLetter = MAX_ASCII_LOWER + 1;
        int[] letters = new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
        for (char letter : input.toCharArray()) {
            letters[letter - MIN_ASCII_LOWER]++;
            minLetter = (char) Math.min(minLetter, letter);
        }

        // Creates word string builder
        int wordSize = input.length() / 2;
        StringBuilder word = new StringBuilder(wordSize);
        
        // Loops through letters storing letters that already appeared
        int[] seenLetters = new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
        Queue<Character> buffer = new LinkedList<>();
        for (int i = input.length() - 1; i >= 0; i--) {
            char letter = input.charAt(i);
            int letterIndex = letter - MIN_ASCII_LOWER;
            
            seenLetters[letterIndex] += 2;
            if (letter == minLetter) {
                // Prints minimum letter as soon as it appears and is still
                //  missing from word
                if (seenLetters[letterIndex] <= letters[letterIndex]) {
                    word.append(letter);
                }
            } else if (seenLetters[letterIndex] > letters[letterIndex]) {
                // Prints other letters only when inevitable
                while (!buffer.isEmpty()) {
                    char temp = buffer.poll();
                    if (temp < letter) {
                        word.append(temp);
//                        seenLetters[temp - MIN_ASCII_LOWER] -= 2;
                    }
                }
                word.append(letter);
            } else {
                // Sends letter to buffer
                if (seenLetters[letterIndex] < letters[letterIndex]) {
                    buffer.offer(letter);
                }
            }
        }
        
        System.out.print(word.toString());
    }
}
