/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 26 May 2016
 *
 */
package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MaximumDraws {

    // https://www.hackerrank.com/challenges/maximum-draws
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MaximumDraws.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int pairs = scanner.nextInt();
            output.append(pairs + 1);
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
}
