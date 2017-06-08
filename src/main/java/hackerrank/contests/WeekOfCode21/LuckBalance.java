/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Jul 2016
 *
 */
package hackerrank.contests.WeekOfCode21;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LuckBalance {

    // https://www.hackerrank.com/contests/w21/challenges/luck-balance
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LuckBalance.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        PriorityQueue<Integer> important = new PriorityQueue<>();
        int luckCount = 0;
        int numberOfContests = scanner.nextInt();
        int possibleImportantLosses = scanner.nextInt();
        
        while (numberOfContests-- > 0) {
            int luck = scanner.nextInt();
            boolean isImportant = scanner.nextInt() == 1;
            if (isImportant) {
                important.add(luck);
            } else {
                luckCount += luck;
            }
        }
        scanner.close();
        
        int importantWins = important.size() - possibleImportantLosses;
        while (importantWins-- > 0) {
            luckCount -= important.poll();
        }
        while (!important.isEmpty()) {
            luckCount += important.poll();
        }
        
        System.out.print(luckCount);
    }
}
