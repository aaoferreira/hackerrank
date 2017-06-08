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
public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ModifiedKaprekarNumbers.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        boolean found = false;
        
        for (int i = start; i <= end; i++) {
            long square = (long) i * i;
            int digits = (int) (Math.log10((double) square) + 1);
            int[] squareArray = new int[digits];
            for (int j = digits - 1; square > 0; j--) {
                squareArray[j] = (int) (square % 10);
                square /= 10;
            }
            
            int midIndex = (digits / 2) - 1;
            int left = getValueFromArray(squareArray, 0, midIndex);
            int right =
                    getValueFromArray(squareArray, midIndex + 1, digits - 1);
            
            if (left + right == i) {
                found = true;
                output.append(i + " ");
            }
        }
        
        scanner.close();
        System.out.println(found ? output.toString() : "INVALID RANGE");
    }
    
    /**
     * Get value from array determined by start index and end index, both
     *  inclusive 
     * 
     * @param array
     *      Array with number to be summed
     * @param startIndex
     *      Inclusive start index for sum
     * @param endIndex
     *      Inclusive end index for sum
     * @return Sum for the number between indexes passed
     */
    private static int getValueFromArray(int[] array, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += (array[i] * Math.pow(10, endIndex - i));
        }
        
        return sum;
    }
}
