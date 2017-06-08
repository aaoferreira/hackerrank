/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class FibonacciModified {

    // https://www.hackerrank.com/challenges/fibonacci-modified
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FibonacciModified.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int firstTerm = scanner.nextInt();
        int secondTerm = scanner.nextInt();
        int lastTerm = scanner.nextInt();
        scanner.close();
        
        BigInteger[] terms = new BigInteger[lastTerm];
        terms[0] = BigInteger.valueOf(firstTerm);
        terms[1] = BigInteger.valueOf(secondTerm);
        for (int i = 2; i < terms.length; i++) {
            terms[i] = 
                    terms[i - 1].multiply(terms[i - 1]) // power 2 previous term
                                .add(terms[i - 2]); // add previous previous term
        }
        
        System.out.print(terms[terms.length - 1]);
    }
}
