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
public class AlternatingCharacters {

    // https://www.hackerrank.com/challenges/alternating-characters
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AlternatingCharacters.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            // Reads line
            String line = scanner.nextLine();
            int deletions = 0;
            char[] chars = line.toCharArray();
            boolean previousA = chars[0] == 'A';
            
            // Compares each char to see if it needs to be deleted or not
            for (int j = 1; j < chars.length; j++) {
                char currChar = chars[j];
                if (currChar == 'A' && previousA) {
                    deletions++;
                } else if (currChar == 'B' && !previousA) {
                    deletions++;
                }
                
                // Updates a char flag
                previousA = currChar == 'A';
            }
            output.append(deletions + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
