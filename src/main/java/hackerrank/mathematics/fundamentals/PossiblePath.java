/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 26 May 2016
 *
 */
package hackerrank.mathematics.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class PossiblePath {

    // https://www.hackerrank.com/challenges/possible-path
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = PossiblePath.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            output.append(canReach(a, b, x, y) ? "YES" : "NO");
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Checks if it is possible to reach point (x,y) from point (a,b)
     *  with movements allowed
     * 
     * @param a
     *      Point (a,b) a coordinate
     * @param b
     *      Point (a,b) b coordinate
     * @param x
     *      Point (x,y) x coordinate
     * @param y
     *      Point (x,y) y coordinate
     * @return Flag indicating if it is possible to reach or not
     */
    private static boolean canReach(int a, int b, int x, int y) {
        int abGcd =
                BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
        int xyGcd =
                BigInteger.valueOf(x).gcd(BigInteger.valueOf(y)).intValue();
        
        return abGcd == xyGcd;
    }
}
