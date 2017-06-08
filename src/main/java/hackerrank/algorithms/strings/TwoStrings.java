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
public class TwoStrings {

    // https://www.hackerrank.com/challenges/two-strings
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TwoStrings.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String firstLine = scanner.nextLine();
            String secondLine = scanner.nextLine();
            
            // Flags existing characters for first line
            boolean[] firstLineChars =
                    new boolean[MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1];
            for (char character : firstLine.toCharArray()) {
                firstLineChars[character - MIN_ASCII_LOWER] = true;
            }
            
            // Checks if second line contains any character from first line
            boolean contains = false;
            for (char character : secondLine.toCharArray()) {
                contains = firstLineChars[character - MIN_ASCII_LOWER];
                if (contains) {
                    break;
                }
            }
            
            output.append(contains ? "YES" : "NO");
            output.append("\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
