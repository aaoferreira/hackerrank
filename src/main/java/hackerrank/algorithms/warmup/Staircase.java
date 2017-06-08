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
public class Staircase {

    // https://www.hackerrank.com/challenges/staircase
    
    public static void main(String[] args) {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Staircase.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array size and skips to next line
        int length = scanner.nextInt();
        scanner.close();
        
        // Builds staircase
        StringBuilder stringBuilder;
        for (int i = 1; i <= length; i++) {
            stringBuilder = new StringBuilder(length);
            for (int j = 0; j < length; j++) {
                if (j < length - i) {
                    stringBuilder.append(' ');
                } else {
                    stringBuilder.append('#');
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
