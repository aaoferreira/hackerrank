/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 9 Jun 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class AlmostSorted {

    // https://www.hackerrank.com/challenges/almost-sorted
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AlmostSorted.class;
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
        
        // Finds if swap or reverse of elements will sort the array
        boolean inDecrease = false;
        boolean swapped = false;
        boolean reversed = false;
        int decreaseLength = 0;
        int left = 0;
        int right = 0;
        
        // Loops through array
        for (int i = 0; i < array.length - 1; i++) {
            if (!inDecrease && array[i] > array[i + 1]) {
                // Decreasing value occurrence
                inDecrease = true;
                
                // Checks if it's first time or not
                if (decreaseLength > 0 || i == array.length - 2) {
                    right = i + 1;
                    swap(array, left, right);
                    swapped = true;
                    break;
                } else {
                    left = i;
                }
                decreaseLength++;
            } else if (array[i] > array[i + 1]) {
                // Still decreasing
                decreaseLength++;
            } else if (array[i] < array[i + 1]) {
                // Stopped decreasing
                inDecrease = false;
                if (decreaseLength > 1) {
                    // Found a reverse sequence
                    right = i;
                    reverse(array, left, right);
                    reversed = true;
                    break;
                } else if (decreaseLength == 1 && i == array.length - 2) {
                    right = left + 1;
                    swap(array, left, right);
                    swapped = true;
                    break;
                }
            }
        }
        
        // Checks if it's sorted and builds output
        boolean sorted = isSorted(array);
        if (sorted) {
            output.append("yes");
            if (swapped || reversed) {
                output.append("\n");
                output.append(swapped ? "swap" : "reverse");
                output.append(" ");
                output.append(left + 1);
                output.append(" ");
                output.append(right + 1);
            }
        } else {
            output.append("no");
        }
        
        System.out.print(output.toString());
    }
    
    /**
     * Checks if array is sorted
     * 
     * @param array
     *      Array to be checked
     * @return A boolean indicating if array is sorted or not
     */
    private static boolean isSorted(int[] array) {
        boolean sorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            sorted = sorted && array[i] <= array[i + 1];
            if (!sorted) {
                break;
            }
        }
        
        return sorted;
    }
    
    /**
     * Swaps array positions
     * 
     * @param array
     *      Array to have positions swapped
     * @param leftIndex
     *      Index of left position
     * @param rightIndex
     *      Index of right position
     */
    private static void swap(int[] array, int leftIndex, int rightIndex) {
        int tmp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = tmp;
    }
    
    /**
     * Reverse array positions
     * 
     * @param array
     *      Array to have positions reversed
     * @param startIndex
     *      Start index of reverse
     * @param endIndex
     *      End index of reverse
     */
    private static void reverse(int[] array, int startIndex, int endIndex) {
        int maxIndex = startIndex + ((endIndex - startIndex) / 2);
        for (int i = endIndex; i > maxIndex; i--) {
            int newIndex = startIndex + (endIndex - i);
            int tmp = array[newIndex];
            array[newIndex] = array[i];
            array[i] = tmp;
        }
    }
}
