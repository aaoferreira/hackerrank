package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * @author alfredo.ferreira
 */
public class Kangaroo {

    // https://www.hackerrank.com/challenges/kangaroo

    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = Kangaroo.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        int x1 = scanner.nextInt();
        int v1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int v2 = scanner.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }

    private static String kangaroo(int x1, int v1, int x2, int v2) {
        if ((x1 < x2 && v1 <= v2) || (x2 < x1 && v2 <= v1)) {
            return NO;
        }

        int first = x1 <= x2 ? x1 : x2;
        final int firstJump = x1 <= x2 ? v1 : v2;
        int second = x1 > x2 ? x1 : x2;
        final int secondJump = x1 > x2 ? v1 : v2;

        while (first <= second) {
            if (first == second) {
                return YES;
            }
            first += firstJump;
            second += secondJump;
        }
        return NO;
    }
}
