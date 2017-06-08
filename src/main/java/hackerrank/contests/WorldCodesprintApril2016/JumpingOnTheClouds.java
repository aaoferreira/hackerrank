/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 29 Apr 2016
 *
 */
package hackerrank.contests.WorldCodesprintApril2016;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class JumpingOnTheClouds {

    // https://www.hackerrank.com/contests/world-codesprint-april/challenges/jumping-on-the-clouds
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = JumpingOnTheClouds.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int numberOfClouds = scanner.nextInt();
        int[] clouds = new int[numberOfClouds];
        for (int i = 0; i < clouds.length; i++) {
            clouds[i] = scanner.nextInt();
        }
        scanner.close();
        
        System.out.println(calculateJumps(clouds));
    }

    /**
     * Calculates how many jumps are necessary to jump through all clouds
     * 
     * @param clouds
     *      Clouds to be jumped
     * @return Jumps necessary to go through all clouds
     */
    private static int calculateJumps(int[] clouds) {
        int jumps = 0;
        int lastCloud = 0;
        for (int i = 1; i < clouds.length - 1; i++) {
            if (clouds[i + 1] == 0) {
                i++;
            }
            jumps++;
            lastCloud = i;
        }
        if (lastCloud < clouds.length - 1) {
            jumps++;
        }
        
        return jumps;
    }
}
