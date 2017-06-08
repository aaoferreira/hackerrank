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
public class UtopianTree {

    // https://www.hackerrank.com/challenges/utopian-tree
    
    public static void main(String[] args) {
        // Gets values from standard in
//      Scanner scanner = new Scanner(System.in);
        Class<?> clazz = UtopianTree.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Loops through test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int height = 1;
            int cycles = scanner.nextInt();
            for (int j = 1; j <= cycles; j++) {
                if (j % 2 == 0) {
                    height++;
                } else {
                    height *= 2;
                }
            }
            
            // Prints new height of the end of the cycle
            System.out.println(height);
        }
        scanner.close();
    }
}
