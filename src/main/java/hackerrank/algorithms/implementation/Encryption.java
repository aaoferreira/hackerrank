/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 11 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Encryption {

    // https://www.hackerrank.com/challenges/encryption
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Encryption.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        // Gets message and calculates grid size
        String message = scanner.nextLine();
        int length = message.length();
        double lengthSqrt = Math.sqrt(length);
        int floor = (int) Math.floor(lengthSqrt);
        int ceil = (int) Math.ceil(lengthSqrt);
        
        // Checks if it accommodates
        if (floor * ceil < length) {
            floor++;
        }
        
        // Creates grid
        char[][] grid = new char[floor][ceil];
        int charIndex = 0;
        for (int i = 0; i < floor; i++) {
            for (int k = 0; k < ceil && charIndex < length; k++) {
                grid[i][k] = message.charAt(charIndex++);
            }
        }
        
        // Creates encrypted message
        for (int i = 0; i < ceil; i++) {
            for (int k = 0; k < floor; k++) {
                char currChar = grid[k][i];
                if (currChar != '\0') {
                    output.append(currChar);
                }
            }
            output.append(" ");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
