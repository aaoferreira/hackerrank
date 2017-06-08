/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 13 Jun 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ConnectedCellInAGrid {

    // https://www.hackerrank.com/challenges/connected-cell-in-a-grid
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ConnectedCellInAGrid.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        
        System.out.print(findLargestRegionLength(matrix));
    }

    /**
     * Finds length of largest region in matrix
     * 
     * @param matrix
     *      Matrix to be searched
     * @return Largest region length
     */
    private static int findLargestRegionLength(int[][] matrix) {
        int maxCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // Checks largest region starting from every position
                maxCount = Math.max(maxCount,
                        findLargestRegionLength(
                                matrix,
                                new boolean[matrix.length][matrix[0].length],
                                i,
                                j)
                        );
            }
        }
        return maxCount;
    }

    /**
     * Finds largest region length from row and column passed
     * 
     * @param matrix
     *      Matrix to be searched
     * @param row
     *      Start row
     * @param col
     *      Start column
     * @return Count of the largest region
     */
    private static int findLargestRegionLength(
            int[][] matrix,
            boolean[][] visited,
            int row,
            int col) {
        boolean outOfBounds = row < 0
                || col < 0
                || row >= matrix.length
                || col >= matrix[0].length;
        
        if (outOfBounds || visited[row][col] || matrix[row][col] == 0) {
            return 0;
        }
        
        // Current position count
        int count = 1;
        int maxCount = 0;
        visited[row][col] = true;
        
        // UP
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row - 1, col));
        
        // LEFT-UP DIAGONAL
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row - 1, col - 1));
        
        // LEFT
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row, col - 1));
        
        // LEFT-DOWN DIAGONAL
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row + 1, col - 1));
        
        // DOWN
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row + 1, col));
        
        // RIGHT-DOWN DIAGONAL
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row + 1, col + 1));
        
        // RIGHT
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row, col + 1));
        
        // UP-RIGHT DIAGONAL
        maxCount = Math.max(maxCount,
                findLargestRegionLength(matrix, visited, row - 1, col + 1));
        
        // Unflags visited
        visited[row][col] = false;
        return count + maxCount;
    }
}
