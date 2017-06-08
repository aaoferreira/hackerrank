/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 13 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Anagram {

    // https://www.hackerrank.com/challenges/anagram

    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Anagram.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            int length = line.length();
            
            // Odd lengths can't have anagrams
            if (length % 2 == 1) {
                output.append("-1\n");
                continue;
            }
            
            // Gets strings
            String left = line.substring(0, length / 2);
            String right = line.substring(length / 2);
            
            int[] leftCharCount =
                    new int[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
            for (char character : left.toCharArray()) {
                leftCharCount[character - MIN_ASCII_LOWER]++;
            }
            
            // Checks how many changes are required to create an anagram
            int changesRequired = 0;
            for (char character : right.toCharArray()) {
                int index = character - MIN_ASCII_LOWER;
                int count = leftCharCount[index];
                if (count > 0) {
                    leftCharCount[index]--;
                } else {
                    changesRequired++;
                }
            }
            
            output.append(changesRequired + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
