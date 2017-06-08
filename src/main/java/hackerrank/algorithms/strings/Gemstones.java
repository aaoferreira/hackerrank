/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 13 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Gemstones {

    // https://www.hackerrank.com/challenges/gem-stones
    
    private static final short MIN_ASCII_LOWER = 'a';
    private static final short MAX_ASCII_LOWER = 'z';
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Gemstones.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Creates rock record to store compositions
        int componentsSize = MAX_ASCII_LOWER - MIN_ASCII_LOWER + 1;
        int[] componentRecord = new int[componentsSize];
        
        // Loops through rocks storing components
        int rocks = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < rocks; i++) {
            String composition = scanner.nextLine();
            boolean[] currComponentRecord = new boolean[componentsSize];
            for (char component : composition.toCharArray()) {
                currComponentRecord[component - MIN_ASCII_LOWER] = true;
            }
            
            // Updates component record with current components
            for (int j = 0; j < componentsSize; j++) {
                if (currComponentRecord[j]) {
                    componentRecord[j]++;
                }
            }
        }
        scanner.close();
        
        // Counts gem rocks
        int gemRocks = 0;
        for (int rockComponent : componentRecord) {
            if (rockComponent == rocks) {
                gemRocks++;
            }
        }
        
        System.out.println(gemRocks);
    }
}
