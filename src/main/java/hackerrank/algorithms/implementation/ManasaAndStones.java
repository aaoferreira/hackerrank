/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 5 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ManasaAndStones {

    // https://www.hackerrank.com/challenges/manasa-and-stones
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ManasaAndStones.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            Set<Integer> values = new TreeSet<>();
            
            int stones = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            
            // Calculates values
            for (int j = 0; j < stones; j++) {
                values.add((a * j) + (b * (stones - 1 - j)));
            }
            
            // Builds output
            for (Integer value : values) {
                output.append(value + " ");
            }
            output.append("\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
