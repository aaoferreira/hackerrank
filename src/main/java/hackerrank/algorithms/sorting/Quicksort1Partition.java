/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Quicksort1Partition {

    // https://www.hackerrank.com/challenges/quicksort1
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Quicksort1Partition.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        // Gets array
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        
        // Gets pivot and creates lists
        int pivot = array[0];
        List<Integer> left = new LinkedList<>();
        List<Integer> equal = new LinkedList<>();
        List<Integer> right = new LinkedList<>();
        
        // Fills lists
        for (int value : array) {
            if (value < pivot) {
                left.add(value);
            } else if (value == pivot) {
                equal.add(value);
            } else {
                right.add(value);
            }
        }
        
        // Builds output
        for (int value : left) {
            output.append(value + " ");
        }
        for (int value : equal) {
            output.append(value + " ");
        }
        for (int value : right) {
            output.append(value + " ");
        }
        
        // Insert sort last value
        System.out.println(output.toString());
    }
}
