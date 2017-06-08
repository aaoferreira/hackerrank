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
public class SherlockAndTheBeast {

    // https://www.hackerrank.com/challenges/sherlock-and-the-beast
    
    public static void main(String[] args) {
        // Gets values from standard in
//      Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndTheBeast.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        // Loops through test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int digits = scanner.nextInt();
            String number = "-1";
            if (digits < 3 || digits == 4) {
                output.append(number);
                output.append("\n");
                continue;
            }
            
            // If it can be all 3 digits
            if (digits % 3 == 0) {
                number = new String(new char[digits]).replace("\0", "5");
            } else {
                // Finds the biggest possible value for 5s and 3s
                int fiveDigits = (digits / 3) * 3;
                int threeDigits = digits % 3;
                boolean keepSearching = true;
                while (true) {
                    keepSearching = fiveDigits >= 0
                            && threeDigits <= digits
                            && (threeDigits % 5 != 0 || fiveDigits % 3 != 0);
                    
                    if (!keepSearching) {
                        break;
                    }
                    
                    fiveDigits -= 1;
                    threeDigits += 1;
                }
                
                if (fiveDigits >= 0 && threeDigits <= digits) {
                    number = new String(new char[fiveDigits])
                            .replace("\0", "5");
                    number += new String(new char[threeDigits])
                            .replace("\0", "3");
                }
            }

            // Prints number
            output.append(number);
            output.append("\n");
        }
        scanner.close();
        
        System.out.println(output.toString());
    }
}

