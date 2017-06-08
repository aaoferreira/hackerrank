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
public class AngryProfessor {

    // https://www.hackerrank.com/challenges/angry-professor
    
    public static void main(String[] args) {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AngryProfessor.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array size and skips to next line
        int testCases = Integer.parseInt(scanner.nextLine());
        
        // Loops through test cases
        String[] values;
        for (int i = 0; i < testCases; i++) {
            values = scanner.nextLine().split(" ");
            int students = Integer.parseInt(values[0]);
            int threshold = Integer.parseInt(values[1]);
            
            // Counts students in on time and prints if class started or not
            values = scanner.nextLine().split(" ");
            int studentsIn = 0;
            for (int j = 0; j < students; j++) {
                if (Integer.parseInt(values[j]) <= 0) {
                    studentsIn++;
                    if (studentsIn == threshold) {
                        System.out.println("NO");
                        break;
                    }
                }
            }
            if (studentsIn < threshold) {
                System.out.println("YES");
            }
        }
        scanner.close();
    }

}
