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
public class FunnyString {

    // https://www.hackerrank.com/challenges/funny-string
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FunnyString.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            char[] characters = line.toCharArray();
            boolean funny = true;
            for (int j = 0; j < characters.length - 1; j++) {
                int diff = Math.abs(characters[j + 1] - characters[j]);
                int reverseDiff = Math.abs(
                        characters[characters.length - 2 - j]
                        - characters[characters.length - 1 - j]);
                
                // Updates funny flag
                funny = funny && (diff == reverseDiff);
                if (!funny) {
                    output.append("Not ");
                    break;
                }
            }
            output.append("Funny\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
