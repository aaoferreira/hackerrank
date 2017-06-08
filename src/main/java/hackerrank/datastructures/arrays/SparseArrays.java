/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 19 May 2016
 *
 */
package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SparseArrays {

    // https://www.hackerrank.com/challenges/sparse-arrays
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SparseArrays.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int stringsSize = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[stringsSize];
        for (int i = 0; i < stringsSize; i++) {
            strings[i] = scanner.nextLine();
        }
        
        int queriesSize = scanner.nextInt();
        scanner.nextLine();
        String[] queries = new String[queriesSize];
        for (int i = 0; i < queriesSize; i++) {
            queries[i] = scanner.nextLine();
        }
        scanner.close();
        
        // Checks occurrences per query
        for (String query : queries) {
            int occur = 0;
            for (String string : strings) {
                if (query.equals(string)) {
                    occur++;
                }
            }
            output.append(occur);
            output.append("\n");
        }
        
        System.out.print(output.toString());
    }
}
