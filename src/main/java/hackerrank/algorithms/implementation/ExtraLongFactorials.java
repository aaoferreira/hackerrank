/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 10 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ExtraLongFactorials {

    // https://www.hackerrank.com/challenges/extra-long-factorials
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ExtraLongFactorials.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        String number = scanner.nextLine();
        scanner.close();
        
        BigInteger factorial = factorial(new BigInteger(number));
        
        System.out.println(factorial.toString());
    }

    /**
     * Calculates factorial for big integer passed
     * 
     * @param number
     *      Number to have factorial calculated
     * @return Factorial of number passed
     */
    private static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) > 0) {
            number = number.multiply(
                    factorial(number.subtract(BigInteger.ONE)));
        }
        return number;
    }
}
