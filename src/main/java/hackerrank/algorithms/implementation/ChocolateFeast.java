/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 31 Mar 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ChocolateFeast {

    // https://www.hackerrank.com/challenges/chocolate-feast
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ChocolateFeast.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        // Gets test cases
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            // Gets inputs
            int money = scanner.nextInt();
            int cost = scanner.nextInt();
            int wrappersNeeded = scanner.nextInt();
            
            // Checks how many chocolates can be bought
            int chocolates = money / cost;
            
            // If enough quantity of chocolates, checks how many can be traded
            //  with the wrappers from the bought ones
            int wrappersLeft = chocolates;
            do {
                if (wrappersLeft >= wrappersNeeded) {
                    int traded = wrappersLeft / wrappersNeeded;
                    chocolates += traded;
                    wrappersLeft -= traded * wrappersNeeded;
                    wrappersLeft += traded;
                }
            } while (wrappersLeft >= wrappersNeeded);
            
            output.append(chocolates + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
