/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 5 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LibraryFine {

    // https://www.hackerrank.com/challenges/library-fine
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LibraryFine.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets dates
        int actualDay = scanner.nextInt();
        int actualMonth = scanner.nextInt();
        int actualYear = scanner.nextInt();
        
        int expectedDay = scanner.nextInt();
        int expectedMonth = scanner.nextInt();
        int expectedYear = scanner.nextInt();
        
        scanner.close();
        
        // Calculates fine
        int fine = 0;
        if (actualYear > expectedYear) {
            fine = 10_000;
        } else if (actualYear == expectedYear
                && actualMonth > expectedMonth) {
            fine = 500 * (actualMonth - expectedMonth);
        } else if (actualYear == expectedYear
                && actualMonth == expectedMonth
                && actualDay > expectedDay) {
            fine = 15 * (actualDay - expectedDay);
        }
        
        System.out.println(fine);
    }
}
