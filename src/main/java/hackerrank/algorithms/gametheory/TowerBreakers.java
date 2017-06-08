/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Jun 2016
 *
 */
package hackerrank.algorithms.gametheory;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TowerBreakers {

    // https://www.hackerrank.com/challenges/tower-breakers-1
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TowerBreakers.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfTowers = scanner.nextInt();
            int towerHeights = scanner.nextInt();
            
            if (towerHeights == 1) {
                output.append(2);
            } else {
                output.append(numberOfTowers % 2 == 0 ? 2 : 1);
            }
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
}
