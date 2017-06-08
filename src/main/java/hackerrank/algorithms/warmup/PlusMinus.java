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
package hackerrank.algorithms.warmup;

import java.util.Scanner;

/**
 *
 * @author $Author$
 * @version
 *      $LastChangedDate$
 *      $Revision$
 *
 */
public class PlusMinus {

    // https://www.hackerrank.com/challenges/plus-minus
    
    public static void main(String[] args) {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = PlusMinus.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array size and skips to next line
        int arraySize = scanner.nextInt();
        scanner.nextLine();
        
        // Creates counter
        int positiveCount = 0;
        int negativeCount = 0;
        
        // Gets array values
        for (int i = 0; scanner.hasNextInt() && i < arraySize; i++) {
            int value = scanner.nextInt();
            if (value > 0) {
                positiveCount++;
            } else if (value < 0) {
                negativeCount++;
            }
        }
        scanner.close();

        int zeroCount = arraySize - positiveCount - negativeCount;
        
        // Prints out values
        System.out.println((double) positiveCount / arraySize);
        System.out.println((double) negativeCount / arraySize);
        System.out.println((double) zeroCount / arraySize);
    }
}
