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
public class PalindromeIndex {

    // https://www.hackerrank.com/challenges/palindrome-index
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = PalindromeIndex.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int index = -1;
            
            // Only checks if length >= 3
            if (chars.length >= 3) {
                for (int j = 0; j < chars.length / 2; j++) {
                    int forwardIndex = j;
                    int backwardIndex = chars.length - 1 - j;
                    
                    char forward = chars[forwardIndex];
                    char backward = chars[backwardIndex];
                    
                    // Checks if any change is necessary for a palindrome
                    if (forward != backward) {
                        boolean removeBackwardIndex = 
                                chars[forwardIndex] == chars[backwardIndex - 1]
                                && chars[forwardIndex + 1] == chars[backwardIndex - 2]
                                && chars[forwardIndex + 2] == chars[backwardIndex - 3];
                        index = removeBackwardIndex
                                ? backwardIndex
                                : forwardIndex;
                        break;
                    }
                }
            }
            
            // Appends number of reductions necessary
            output.append(index + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
