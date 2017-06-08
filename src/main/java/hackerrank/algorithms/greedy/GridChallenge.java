/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 11 May 2016
 *
 */
package hackerrank.algorithms.greedy;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class GridChallenge {

    // https://www.hackerrank.com/challenges/flipping-bits
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = GridChallenge.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            int size = scanner.nextInt();
            scanner.nextLine();
            char[][] grid = new char[size][size];
            for (int j = 0; j < size; j++) {
                String line = scanner.nextLine();
                int index = 0;
                for (char letter : line.toCharArray()) {
                    grid[j][index++] = letter;
                }
            }
            
            output.append(isLexicographicallySorted(grid) ? "YES" : "NO");
            output.append("\n");
        }
        
        scanner.close();
        System.out.print(output.toString());
    }

    /**
     * Checks if grid is lexicographically sorted
     * 
     * @param grid
     *      Grid to be checked
     * @return Boolean indicating if it is lexicographically sorted or not
     */
    private static boolean isLexicographicallySorted(char[][] grid) {
        // Tries to sort array with operations permitted
        sort(grid);
        
        // Checks if array is sorted
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j < grid[i].length - 1 && grid[i][j] > grid[i][j + 1]) {
                    return false;
                }
                if (i < grid.length - 1 && grid[i][j] > grid[i + 1][j]) {
                    return false;
                }
            }
        }
        
        // Passes all validations
        return true;
    }

    /**
     * Sorts array just by swapping adjacent values in the same row
     * 
     * @param grid
     *      Grid to be sorted
     */
    private static void sort(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            // Sorts lines with the only operation permitted
            char[] line = grid[i];
            boolean lineSorted;
            do {
                lineSorted = false;
                for (int j = 0; j < line.length - 1; j++) {
                    if (line[j] > line[j + 1]) {
                        lineSorted = true;
                        char aux = line[j];
                        line[j] = line[j + 1];
                        line[j + 1] = aux;
                    }
                }
            } while (lineSorted);
        }
    }
}
