/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class PriyankaAndToys {

    // https://www.hackerrank.com/challenges/priyanka-and-toys
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = PriyankaAndToys.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Gets toy weights
        int numberOfToys = scanner.nextInt();
        int[] toyWeights = new int[numberOfToys];
        for (int i = 0; i < toyWeights.length; i++) {
            toyWeights[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sorts weights
        Arrays.sort(toyWeights);
        
        // Calculates how many units need to be bought
        int units = 1;
        int current = toyWeights[0];
        for (int i = 1; i < toyWeights.length; i++) {
            if (toyWeights[i] > current + 4) {
                units++;
                current = toyWeights[i];
            }
        }
        
        System.out.print(units);
    }
}
