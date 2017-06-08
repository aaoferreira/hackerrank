/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TaumAndBDay {

    // https://www.hackerrank.com/challenges/taum-and-bday
    
    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TaumAndBDay.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int black = scanner.nextInt();
            int white = scanner.nextInt();
            
            int blackCost = scanner.nextInt();
            int whiteCost = scanner.nextInt();
            int convertCost = scanner.nextInt();
            
            // Checks what is better cost for each color
            long totalCost = 0;
            totalCost += (long) black * Math.min(blackCost, whiteCost + convertCost);
            totalCost += (long) white * Math.min(whiteCost, blackCost + convertCost);
            
            output.append(totalCost + "\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
