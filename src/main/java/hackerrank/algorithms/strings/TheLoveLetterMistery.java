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
public class TheLoveLetterMistery {

    // https://www.hackerrank.com/challenges/the-love-letter-mystery
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheLoveLetterMistery.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            int reductions = 0;
            for (int j = 0; j < chars.length; j++) {
                int forwardIndex = j;
                int backwardIndex = chars.length - 1 - j;
                
                char forward = chars[forwardIndex];
                char backward = chars[backwardIndex];
                
                // Checks how many reductions are necessary
                int reduction = 0;
                if (forward > backward) {
                    reduction += forward - backward;
                    chars[forwardIndex] = (char) (forward - reduction);
                } else if (backward > forward) {
                    reduction += backward - forward;
                    chars[backwardIndex] = (char) (backward - reduction);
                }
                
                // Updates reductions
                reductions += reduction;
            }
            
            // Appends number of reductions necessary
            output.append(reductions + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
