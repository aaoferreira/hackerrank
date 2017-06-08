/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 2 May 2016
 *
 */
package hackerrank.contests.ProjectEuler;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ProjectEuler001 {

    // https://www.hackerrank.com/contests/projecteuler/challenges/euler001
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ProjectEuler001.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int number = scanner.nextInt();
            long sum = 0;
            
            // Calculates multiples of 3
            long multiplesOf3 = (number - 1) / 3;
            sum += (3 * multiplesOf3 * (multiplesOf3 + 1)) / 2;
            
            // Calculates multiples of 5
            long multiplesOf5 = (number - 1) / 5;
            sum += (5 * multiplesOf5 * (multiplesOf5 + 1)) / 2;
            
            // Removes multiples of 15 sum, because 15 is the least common
            //  multiple of 3 and 5, so removes duplicates
            long multiplesOf15 = (number - 1) / 15;
            sum -= (15 * multiplesOf15 * (multiplesOf15 + 1)) / 2;
            
            output.append(sum);
            output.append("\n");
        }
        scanner.close();
        System.out.print(output.toString());
    }
}
