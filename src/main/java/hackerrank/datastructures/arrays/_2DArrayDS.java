/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 19 May 2016
 *
 */
package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class _2DArrayDS {

    // https://www.hackerrank.com/challenges/2d-array
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = _2DArrayDS.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int size = 6;
        int array[][] = new int[size][size];
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        
        int maxHourGlassSum = Integer.MIN_VALUE;
        for (int i = 0; i < size - 2; i++) {
            int currHourGlassSum = 0;
            for (int j = 0; j < size - 2; j++) {
                currHourGlassSum = 
                        array[i][j] + array[i][j + 1] + array[i][j + 2] +
                        array[i + 1][j + 1] +
                        array[i + 2][j] + array[i + 2][j + 1] + array[i + 2][j + 2];
                maxHourGlassSum = Math.max(maxHourGlassSum, currHourGlassSum);
            }
        }
        
        System.out.print(maxHourGlassSum);
    }
}
