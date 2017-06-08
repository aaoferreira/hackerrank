/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 30 Jun 2016
 *
 */
package hackerrank.contests.WeekOfCode21;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class Kangaroo {

    // https://www.hackerrank.com/contests/w21/challenges/kangaroo
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Kangaroo.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // First kangaroo
        int k1Start = scanner.nextInt();
        int k1Jump = scanner.nextInt();
        
        // Second kangaroo
        int k2Start = scanner.nextInt();
        int k2Jump = scanner.nextInt();
        scanner.close();
        
        int startDiff = k2Start - k1Start;
        int jumpDiff = k1Jump - k2Jump;
        
        boolean willMeet = false;
        if (jumpDiff > 0) {
            willMeet = startDiff % jumpDiff == 0;
        }
        
        System.out.print(willMeet ? "YES" : "NO");
    }
}
