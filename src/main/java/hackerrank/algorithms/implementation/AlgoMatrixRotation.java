/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 12 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class AlgoMatrixRotation {

    // https://www.hackerrank.com/challenges/matrix-rotation-algo
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AlgoMatrixRotation.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        // Gets matrix size and rotations
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int rotations = scanner.nextInt();
        
        boolean distinctValues = false;
        int next = scanner.nextInt();
        int previous = next;
        
        // Builds matrix
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = next;
                
                // Sets distinct values flag
                if (next != previous) {
                    distinctValues = true;
                }
                
                previous = next;
                if (scanner.hasNextInt()) {
                    next = scanner.nextInt();
                }
            }
        }
        
        // Rotates matrix if there are distinct values
        if (distinctValues) {
            rotate(matrix, rotations);
        }
        
        // Prints matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output.append(matrix[i][j] + " ");
            }
            output.append("\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }

    /**
     * Rotates matrix counter-clockwise as many times as passed
     * 
     * @param matrix
     *      Matrix to be rotated
     * @param rotations
     *      Number of rotations
     */
    private static void rotate(int[][] matrix, int rotations) {
        // Rotates matrix one ring at a time
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        while (startRow < rows / 2 && startCol < cols / 2) {
            int endRow = rows - startRow - 1;
            int endCol = cols - startCol - 1;
            
            // Gets minimum rotations possible to achieve same result
            int minRotations = 
                    rotations % (((endRow - startRow) + (endCol - startCol)) * 2);
            
            // Rotates ring
            rotateRing(
                    matrix,
                    startRow,
                    startCol,
                    endRow,
                    endCol,
                    minRotations);
            
            startRow++;
            startCol++;
        }
    }

    /**
     * Rotates ring specified by start/end row/column
     * 
     * @param matrix
     *      Matrix to be rotated
     * @param startRow
     *      Row start index
     * @param startCol
     *      Column start index
     * @param endRow
     *      Row end index
     * @param endCol
     *      Column end index
     * @param rotations
     *      Number of rotations
     */
    private static void rotateRing(
            int[][] matrix,
            int startRow,
            int startCol,
            int endRow,
            int endCol,
            int rotations) {
        // Recursive call to rotate matrix ring
        if (rotations > 1) {
            rotateRing(
                    matrix,
                    startRow,
                    startCol,
                    endRow,
                    endCol,
                    rotations - 1);
        }
        
        // If rotations is zero or less, returns
        if (rotations <= 0) {
            return;
        }
        
        int cache = 0;
        int temp = 0;
        
        // Rotates left column
        cache = matrix[startRow][startCol];
        for (int i = startRow + 1; i <= endRow; i++) {
            temp = matrix[i][startCol];
            matrix[i][startCol] = cache; 
            cache = temp;
        }
        
        // Rotates bottom column
        for (int i = startCol + 1; i < endCol; i++) {
            temp = matrix[endRow][i];
            matrix[endRow][i] = cache;
            cache = temp;
        }
        
        // Rotates right column
        for (int i = endRow; i > startRow; i--) {
            temp = matrix[i][endCol];
            matrix[i][endCol] = cache;
            cache = temp;
        }
        
        // Rotates top column
        for (int i = endCol; i > startCol; i--) {
            temp = matrix[startRow][i];
            matrix[startRow][i] = cache;
            cache = temp;
        }
        
        // Sets remaining first value
        matrix[startRow][startCol] = cache;
    }
}
