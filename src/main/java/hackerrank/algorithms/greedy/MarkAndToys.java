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
public class MarkAndToys {

    // https://www.hackerrank.com/challenges/mark-and-toys
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MarkAndToys.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int numberOfToys = scanner.nextInt();
        int money = scanner.nextInt();
        int[] toyPrices = new int[numberOfToys];
        for (int i = 0; i < toyPrices.length; i++) {
            toyPrices[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sorts toy prices
        Arrays.sort(toyPrices);
        
        // Calculates how many toys can be bought
        int toysBought = 0;
        for (int toyPrice : toyPrices) {
            money -= toyPrice;
            if (money < 0) {
                break;
            }
            toysBought++;
        }
        
        System.out.print(toysBought);
    }
}
