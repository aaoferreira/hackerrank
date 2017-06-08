/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 17 May 2016
 *
 */
package hackerrank.contests._101HackMay2016;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MaximumPerimeterTriangle {

    // https://www.hackerrank.com/contests/101hack37/challenges/maximum-perimeter-triangle
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MaximumPerimeterTriangle.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int size = scanner.nextInt();
        int[] sticks = new int[size];
        for (int i = 0; i < size; i++) {
            sticks[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Sorts array
        Arrays.sort(sticks);
        
        // Loops through values, testing triangles from maximum value to minimum
        int maxSize = 0;
        int minSize = 0;
        int medSize = 0;
        boolean triangleFound = false;
        for (int i = size - 1; i > 1 && !triangleFound; i--) {
            maxSize = sticks[i];
            for (int j = i - 1; j > 0 && !triangleFound; j--) {
                medSize = sticks[j];
                for (int k = j - 1; k >= 0; k--) {
                    minSize = sticks[k];
                    if (minSize + medSize > maxSize) {
                        triangleFound = true;
                        break;
                    }
                }
            }
        }
        
        if (triangleFound) {
            System.out.format("%d %d %d", minSize, medSize, maxSize);
        } else {
            System.out.println(-1);
        }
    }
}
