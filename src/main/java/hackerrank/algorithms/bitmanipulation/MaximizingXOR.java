/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Jun 2016
 *
 */
package hackerrank.algorithms.bitmanipulation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MaximizingXOR {

    // https://www.hackerrank.com/challenges/maximizing-xor
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MaximizingXOR.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        scanner.close();
        
        int maxValue = 0;
        for (int i = l; i <= r; i++) {
            for (int j = i; j <= r; j++) {
                maxValue = Math.max(maxValue, i ^ j);
            }
        }
        
        System.out.print(maxValue);
    }
}
