/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 26 May 2016
 *
 */
package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class FindPoint {

    // https://www.hackerrank.com/challenges/find-point
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = FindPoint.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int pX = scanner.nextInt();
            int pY = scanner.nextInt();
            int qX = scanner.nextInt();
            int qY = scanner.nextInt();
            
            output.append(2 * qX - pX);
            output.append(" ");
            output.append(2 * qY - pY);
            output.append("\n");
        }
        scanner.close();
        System.out.print(output.toString());
    }
}
