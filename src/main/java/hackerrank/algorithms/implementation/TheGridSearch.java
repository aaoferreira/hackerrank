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
public class TheGridSearch {

    // https://www.hackerrank.com/challenges/the-grid-search
    
    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheGridSearch.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        for (int i = 0; i < testCases; i++) {
            // Gets grid values
            int gridRows = scanner.nextInt();
            int gridCols = scanner.nextInt();
            scanner.nextLine();
            
            // Builds grid 
            int[][] grid = new int[gridRows][gridCols];
            for (int j = 0; j < gridRows; j++) {
                String line = scanner.nextLine();
                for (int k = 0; k < gridCols; k++) {
                    grid[j][k] = Integer.parseInt(line.charAt(k) + "");
                }
            }
            
            // Gets pattern values
            int patternRows = scanner.nextInt();
            int patternCols = scanner.nextInt();
            scanner.nextLine();
            
            // Builds pattern grid 
            int[][] patternGrid = new int[patternRows][patternCols];
            for (int j = 0; j < patternRows; j++) {
                String line = scanner.nextLine();
                for (int k = 0; k < patternCols; k++) {
                    patternGrid[j][k] = Integer.parseInt(line.charAt(k) + "");
                }
            }
            
            // Checks for pattern on grid
            boolean patternMatches = false;
            checkPatterns:
            for (int j = 0; j <= gridRows - patternRows; j++) {
                for (int k = 0; k <= gridCols - patternCols; k++) {
                    patternMatches = hasPattern(grid, patternGrid, j, k);
                    if (patternMatches) {
                        break checkPatterns;
                    }
                }
            }
            output.append(patternMatches ? "YES" : "NO");
            output.append("\n");
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
    
    /**
     * Validates if pattern is within grid
     * 
     * @param grid
     *      Grid to be checked
     * @param pattern
     *      Pattern to be tested
     * @param startRowIndex
     *      Grid row index to start searching
     * @param startColIndex
     *      Grid column index to start searching
     * @return Flag indicating whether patter is within grid or not
     */
    private static boolean hasPattern(
            int[][] grid,
            int[][] pattern,
            int startRowIndex,
            int startColIndex) {
        boolean patternMatches = true;
        
        int gridRowIndex = startRowIndex;
        int gridColIndex = startColIndex;
        int patternRowIndex = 0;
        int patternColIndex = 0;
        
        checkPattern:
        while (gridRowIndex < grid.length) {
            int[] gridLine = grid[gridRowIndex];
            int[] patternLine = pattern[patternRowIndex];
            
            while (gridColIndex < gridLine.length) {
                // Exits if it doesn't match
                if (gridLine[gridColIndex] != patternLine[patternColIndex]) {
                    patternMatches = false;
                    break checkPattern;
                } else if (patternColIndex == patternLine.length - 1) {
                    // If pattern column index is last one,
                    //  current pattern line matches
                    gridColIndex = startColIndex;
                    patternColIndex = 0;
                    break;
                }
                
                gridColIndex++;
                patternColIndex++;
            }
            
            // If pattern row index is last one, pattern is found
            if (patternRowIndex == pattern.length - 1) {
                break;
            }
            
            gridRowIndex++;
            patternRowIndex++;
        }
        
        return patternMatches;
    }
}
