/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 14 Jun 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CountLuck {

    // https://www.hackerrank.com/challenges/count-luck
    
    private static final char FREE = '.';
    private static final char USED = '-';
    private static final char FINAL = '*';
    private static final char START = 'M';
    private static final String FREE_OR_FINAL = FREE + "" + FINAL;
    
    public static void main(String[] args) throws Exception {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CountLuck.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            // Builds forest
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            scanner.nextLine();
            
            char[][] forest = new char[rows][cols];
            int startRow = 0;
            int startCol = 0;
            for (int i = 0; i < forest.length; i++) {
                String line = scanner.nextLine();
                for (int j = 0; j < forest[i].length; j++) {
                    char currCell = line.charAt(j);
                    forest[i][j] = currCell;
                    if (currCell == START) {
                        startRow = i;
                        startCol = j;
                    }
                }
            }
            
            // Gets guesses
            int guesses = scanner.nextInt();
            int orientationsNeeded =
                    countOrientationsNeeded(forest, startRow, startCol);
            output.append(
                    guesses == orientationsNeeded ? "Impressed" : "Oops!");
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Counts how many orientations are needed to get to the end
     * 
     * @param forest
     *      Forest
     * @param row
     *      Row position to start counting
     * @param col
     *      Column position to start counting
     * @return Count of orientations
     * @throws Exception
     *      If there are no moves left in position passed
     */
    private static int countOrientationsNeeded(
            char[][] forest,
            int row,
            int col)
                throws Exception{
        // Checks if it's in final position
        if (forest[row][col] == FINAL) {
            return 0;
        }
        
        int possiblePaths = 0;
        int orientations = 0;
        forest[row][col] = USED;
        
        // UP
        boolean upDeadEnd = true;
        if (row > 0
                && FREE_OR_FINAL.indexOf(forest[row - 1][col]) >= 0) {
            possiblePaths++;
            try {
                orientations += countOrientationsNeeded(
                        forest, row - 1, col);
                upDeadEnd = false;
            } catch (Exception e) {}
        }
        
        // RIGHT
        boolean rightDeadEnd = true;
        if (col < forest[row].length - 1
                && FREE_OR_FINAL.indexOf(forest[row][col + 1]) >= 0) {
            possiblePaths++;
            try {
                orientations += countOrientationsNeeded(
                        forest, row, col + 1);
                rightDeadEnd = false;
            } catch (Exception e) {}
        }
        
        // DOWN
        boolean downDeadEnd = true;
        if (row < forest.length - 1
                && FREE_OR_FINAL.indexOf(forest[row + 1][col]) >= 0) {
            possiblePaths++;
            try {
                orientations += countOrientationsNeeded(
                        forest, row + 1, col);
                downDeadEnd = false;
            } catch (Exception e) {}
        }
        
        // LEFT
        boolean leftDeadEnd = true;
        if (col > 0
                && FREE_OR_FINAL.indexOf(forest[row][col - 1]) >= 0) {
            possiblePaths++;
            try {
                orientations += countOrientationsNeeded(
                        forest, row, col - 1);
                leftDeadEnd = false;
            } catch (Exception e) {}
        }

        // Unflags path walked
        forest[row][col] = FREE;
        
        // Checks if no moves are possible
        boolean allDeadEnds =
                upDeadEnd
                && rightDeadEnd
                && downDeadEnd
                && leftDeadEnd;
        if (possiblePaths == 0 || allDeadEnds) {
            throw new Exception("No moves possible");
        }
        
        // Checks if an orientation was necessary
        if (possiblePaths > 1) {
            orientations++;
        }
        return orientations;
    }
}
