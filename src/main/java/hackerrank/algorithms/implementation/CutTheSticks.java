/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 31 Mar 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CutTheSticks {

    // https://www.hackerrank.com/challenges/cut-the-sticks

    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CutTheSticks.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();

        // Gets sticks sizes
        int numberOfSticks = scanner.nextInt();
        int[] sticks = new int[numberOfSticks];
        for (int i = 0; i < numberOfSticks; i++) {
            sticks[i] = scanner.nextInt();
        }
        
        // Sorts array of sticks
        Arrays.sort(sticks);
        
        int minSize;
        int sticksLeft = numberOfSticks;
        do {
            // Sets minimal size to max size + 1
            minSize = 1001;
            output.append(sticksLeft + "\n");
            for (int i = 0; i < sticks.length; i++) {
                int stickSize = sticks[i];
                
                if (stickSize > 0) {
                    // Updates minimum size if necessary
                    if (minSize > stickSize) {
                        minSize = stickSize;
                    }
                    
                    stickSize -= minSize;
                    sticks[i] = stickSize;
                    
                    // If new size is still greater than zero, increase sticks
                    //  left count
                    if (stickSize == 0) {
                        sticksLeft--;
                    }
                }
            }
        } while (sticksLeft > 0);
        
        scanner.close();
        System.out.println(output.toString());
    }
}
