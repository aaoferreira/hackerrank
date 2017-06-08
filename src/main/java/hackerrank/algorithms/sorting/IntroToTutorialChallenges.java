/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 Apr 2016
 *
 */
package hackerrank.algorithms.sorting;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class IntroToTutorialChallenges {

    // https://www.hackerrank.com/challenges/tutorial-intro
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = IntroToTutorialChallenges.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int value = scanner.nextInt();
        int size = scanner.nextInt();
        int index = -1;
        
        for (int i = 0; i < size; i++) {
            if (scanner.nextInt() == value) {
                index = i;
                break;
            }
        }
        scanner.close();
        
        System.out.println(index);
    }
}
