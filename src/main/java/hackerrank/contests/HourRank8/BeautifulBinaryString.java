/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 2 May 2016
 *
 */
package hackerrank.contests.HourRank8;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BeautifulBinaryString {

    // https://www.hackerrank.com/contests/hourrank-8/challenges/beautiful-binary-string
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BeautifulBinaryString.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int length = scanner.nextInt();
        int[] binary = new int[length];
        scanner.nextLine();
        String line = scanner.nextLine();
        scanner.close();
        
        for (int i = 0; i < length; i++) {
            binary[i] = line.charAt(i) - '0';
        }
        
        int changeCount = 0;
        for (int i = 1; i < length - 1; i++) {
            boolean needChange = binary[i - 1] == 0
                    && binary[i] == 1
                    && binary[i + 1] == 0;
            if (needChange) {
                binary[i + 1] = 1;
                changeCount++;
            }
        }
        
        System.out.println(changeCount);
    }
}
