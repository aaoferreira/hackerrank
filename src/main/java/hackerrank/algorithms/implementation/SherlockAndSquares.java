/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 30 Mar 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SherlockAndSquares {

    // https://www.hackerrank.com/challenges/sherlock-and-squares
    
    public static void main(String[] args) {
     // Gets values from standard in
//      Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndSquares.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        // Loops through test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int fromNumber = scanner.nextInt();
            int toNumber = scanner.nextInt();
            int sqrtCount = 0;
            
            // Gets closest integer from square root of numbers passed
            int fromNumberSqrt = (int) Math.ceil(Math.sqrt(fromNumber));
            int toNumberSqrt = (int) Math.ceil(Math.sqrt(toNumber));
            
            // Loops through numbers values starting at minimum value possible.
            //  Minimum value possible might be number passed or smallest
            //  square root
            int j = Math.min(fromNumber, fromNumberSqrt);
            while (j <= toNumberSqrt) {
                if (Math.pow(j, 2) > toNumber) {
                    break;
                }
                sqrtCount++;
                j++;
            }

            // Prints number
            output.append(sqrtCount);
            output.append("\n");
        }
        scanner.close();
        
        System.out.println(output.toString());
    }
}
