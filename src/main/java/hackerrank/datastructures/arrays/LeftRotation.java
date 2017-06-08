/**
 *
 * Created-By: alfredo.ferreira
 * Created-Date: Jul 26, 2016
 *
 */
package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 *
 * @author alfredo.ferreira
 *
 */
public class LeftRotation {

    // https://www.hackerrank.com/challenges/array-left-rotation
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LeftRotation.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        // Gets array and rotations (minimum needed for correct result)
        int size = scanner.nextInt();
        int rotations = scanner.nextInt() % size;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Performs all the rotations necessary, one by one
        for (int i = 0; rotations > 0 && i < rotations; i++) {
            int firstValue = array[0];
            for (int j = 1; j < array.length; j++) {
                int newPos = j - 1;
                array[newPos] = array[j];
            }
            array[array.length - 1] = firstValue;
        }
        
        for (int element : array) {
            output.append(element);
            output.append(" ");
        }
        
        System.out.print(output.toString());
    }
}
