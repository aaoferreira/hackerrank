/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.gametheory;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class GameOfStones {

    // https://www.hackerrank.com/challenges/game-of-stones-1
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = GameOfStones.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfStones = scanner.nextInt();
            
            // Based on discussion
            // https://www.hackerrank.com/challenges/game-of-stones-1/forum/comments/141279
            // https://www.hackerrank.com/challenges/game-of-stones-1/forum/comments/140085
            output.append(numberOfStones % 7 > 1 ? "First" : "Second");
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
}
