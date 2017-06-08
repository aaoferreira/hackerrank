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
public class ProjectEuler002 {

    // https://www.hackerrank.com/contests/projecteuler/challenges/euler002
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ProjectEuler002.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            long number = scanner.nextLong();
            long sum = 0;
            
            long previous = 0;
            long current = 1;
            do {
                long value = current + previous;
                previous = current;
                current = value;
                if (value < number && value % 2 == 0) {
                    sum += value;
                }
            } while (current < number);
            
            output.append(sum);
            output.append("\n");
        }
        scanner.close();
        System.out.print(output.toString());
    }
}
