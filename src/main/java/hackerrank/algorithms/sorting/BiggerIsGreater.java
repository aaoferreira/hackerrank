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
public class BiggerIsGreater {

    // https://www.hackerrank.com/challenges/bigger-is-greater
    
    // https://www.nayuki.io/page/next-lexicographical-permutation-algorithm
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BiggerIsGreater.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testCases; i++) {
            String word = scanner.nextLine();
            char[] letters = word.toCharArray();
            
            // Find suffix index
            int index = letters.length - 1;
            while (index > 0 && letters[index - 1] >= letters[index]) {
                index--;
            }
            
            // If not found, breaks
            if (index <= 0) {
                output.append("no answer\n");
                continue;
            }
            
            // Find successor to pivot and swap
            int successorIndex = letters.length - 1;
            while (letters[successorIndex] <= letters[index - 1]) {
                successorIndex--;
            }
            swap(letters, successorIndex, index - 1);
            
            // Reverse suffix
            for (int j = letters.length - 1; index < j; j--, index++) {
                swap(letters, j, index);
            }
            
            // Appends modified word
            output.append(new String(letters) + "\n");
        }
        
        scanner.close();
        System.out.print(output.toString());
    }
    
    /**
     * Swaps values in the array
     * 
     * @param array
     *      Array to have values swapped
     * @param a
     *      Index of value a to be swapped with value b
     * @param b
     *      Index of value b to be swapped with value a
     */
    private static void swap(char[] array, int a, int b) {
        // Swaps
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
