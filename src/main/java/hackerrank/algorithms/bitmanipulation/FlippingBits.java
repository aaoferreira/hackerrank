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
public class FlippingBits {

    // https://www.hackerrank.com/challenges/flipping-bits
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FlippingBits.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int numbers = scanner.nextInt();
        long maxValue = (long) Math.pow(2, 32) - 1;
        for (int i = 0; i < numbers; i++) {
            long number = scanner.nextLong();
            output.append(number ^ maxValue);
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
}
