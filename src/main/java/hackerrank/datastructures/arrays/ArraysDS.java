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
public class ArraysDS {

    // https://www.hackerrank.com/challenges/arrays-ds
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ArraysDS.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        for (int i = size - 1; i >= 0; i--) {
            output.append(array[i]);
            output.append(" ");
        }
        
        System.out.print(output.toString());
    }
}
