/**
 * IBM Confidential
 * 
 * IBM Ireland
 * Software Group - Cloud & Smarter Infrastructure
 *
 * Created-Date: 21 Mar 2016
 * Created-By: Alfredo Ferreira
 *
 * (C) COPYRIGHT IBM CORP. 2016
 *
 * SVN FILE: $HeadURL$
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author $Author$
 * @version
 *      $LastChangedDate$
 *      $Revision$
 *
 */
public class FindDigits {

    // https://www.hackerrank.com/challenges/find-digits
    
    public static void main(String[] args) {
     // Gets values from standard in
//      Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FindDigits.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        // Loops through test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int number = scanner.nextInt();
            int divisibleCount = 0;
            int temp = number;
            do {
                int divisor = temp % 10;
                if (divisor > 0 && number % divisor == 0) {
                    divisibleCount++;
                }
                temp /= 10;
            } while (temp > 0);
            output.append(divisibleCount);
            output.append("\n");
        }
        scanner.close();
        
        System.out.println(output.toString());
    }
}
