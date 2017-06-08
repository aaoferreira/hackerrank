/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LonelyInteger {

    // https://www.hackerrank.com/challenges/lonely-integer
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LonelyInteger.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int numbers = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < numbers; i++) {
            result = result ^ scanner.nextInt();
        }
        scanner.close();
        
        System.out.print(result);
    }
}
