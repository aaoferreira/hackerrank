/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 2 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CavityMap {
    
    // https://www.hackerrank.com/challenges/cavity-map

    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CavityMap.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int mapSize = scanner.nextInt();
        scanner.nextLine();
        int[] previousCellLine = getCellsFromString(scanner.nextLine());
        // Prints first line
        printCellLine(previousCellLine, output);
        
        int[] nextCellLine = null;
        if (mapSize > 1) {
            nextCellLine = getCellsFromString(scanner.nextLine());
        }
        
        for (int i = 1; i < mapSize - 1; i++) {
            // Gets new current cell line
            int[] currCellLine = nextCellLine;
            output.append(currCellLine[0]);
            
            // Gets next cell line
            nextCellLine = getCellsFromString(scanner.nextLine());
            
            for (int j = 1; j < mapSize - 1; j++) {
                // Check if it's Cavity
                int currValue = currCellLine[j];
                if (currValue > currCellLine[j - 1]
                        && currValue > currCellLine[j + 1]
                        && currValue > previousCellLine[j]
                        && currValue > nextCellLine[j]) {
                    output.append('X');
                    // Already knows next one can't be a Cavity, so skips
                    if (j < currCellLine.length - 3) {
                        output.append(currCellLine[j + 1]);
                        j++;
                    }
                } else {
                    output.append(currCellLine[j]);
                }
            }
            output.append(currCellLine[currCellLine.length - 1] + "\n");
            
            // Sets current cell line as previous after processing
            previousCellLine = currCellLine;
        }
        
        // If next cell line is present, prints it
        if (nextCellLine != null) {
            printCellLine(nextCellLine, output);
        }
        
        scanner.close();
        System.out.println(output.toString());
    }

    /**
     * Prints cell line values
     * 
     * @param cellLine
     *      Cell line to be printed
     * @param output
     *      StringBuilder to append values to
     */
    private static void printCellLine(int[] cellLine, StringBuilder output) {
        for (int i = 0; i < cellLine.length; i++) {
            output.append(cellLine[i]);
        }
        output.append("\n");
    }

    /**
     * Gets cell int array from String line
     * 
     * @param line
     *      String to be parsed to int array
     * @return Cells int array
     */
    private static int[] getCellsFromString(String line) {
        char[] array = line.toCharArray();
        int[] cells = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            cells[i] = Character.getNumericValue(array[i]);
        }
        return cells;
    }
}
