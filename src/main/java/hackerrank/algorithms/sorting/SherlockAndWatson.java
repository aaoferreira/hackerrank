/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SherlockAndWatson {

    // https://www.hackerrank.com/challenges/sherlock-and-watson
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SherlockAndWatson.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int size = scanner.nextInt();
        int rotations = scanner.nextInt();
        int queries = scanner.nextInt();
        
        // Fills array
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        
        // Performs queries
        for (int i = 0; i < queries; i++) {
            int queryIndex = scanner.nextInt();
            output.append(query(array, rotations, queryIndex));
            output.append("\n");
        }
        
        scanner.close();
        System.out.print(output.toString());
    }

    /**
     * Queries value in index after clockwise rotations are applied
     * 
     * @param array
     *      Array to be queried
     * @param rotations
     *      Clockwise rotations to be applied
     * @param queryIndex
     *      Index to be queried after rotation
     * @return Value in index after rotation
     */
    private static int query(int[] array, int rotations, int queryIndex) {
        // Calculates actual index to be returned
        int length = array.length;
        
        // Sets rotations to maximum allowed
        rotations = rotations % length;
        
        // Rotates index backwards and fix if it's negative
        queryIndex -= rotations;
        if (queryIndex < 0) {
            queryIndex += length;
        }
        
        return array[queryIndex];
    }
}
