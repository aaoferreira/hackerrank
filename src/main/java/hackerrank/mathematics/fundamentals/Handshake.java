/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 30 May 2016
 *
 */
package hackerrank.mathematics.fundamentals;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Handshake {

    // https://www.hackerrank.com/challenges/handshake
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Handshake.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int directors = scanner.nextInt();
            int handshakes = (directors - 1) * directors / 2;
            output.append(handshakes);
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
}
