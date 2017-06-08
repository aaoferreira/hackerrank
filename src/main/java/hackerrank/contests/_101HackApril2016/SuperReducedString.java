/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 20 Apr 2016
 *
 */
package hackerrank.contests._101HackApril2016;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SuperReducedString {

    // https://www.hackerrank.com/contests/101hack36/challenges/reduced-string
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SuperReducedString.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Gets input string
        String input = scanner.nextLine();
        scanner.close();
        
        boolean replaced;
        StringBuilder output;
        do {
            replaced = false;
            output = new StringBuilder();
            for (int i = 0; i < input.length() - 1; i++) {
                char currChar = input.charAt(i);
                char nextChar = input.charAt(i + 1);
                if (currChar == nextChar) {
                    i += 2;
                    replaced = true;
                } else if (i == input.length() - 2) {
                    output.append(input.charAt(i));
                    i++;
                }
                
                // Appends if still inside string boundaries
                if (i < input.length()) {
                    output.append(input.charAt(i));
                }
            }
            input = output.toString();
        } while (replaced);
        
        System.out.println(output.length() == 0
                ? "Empty String" 
                : output.toString());
    }
}
