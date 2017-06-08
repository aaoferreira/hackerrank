/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 3 Jun 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class NewYearChaos {

    // https://www.hackerrank.com/challenges/new-year-chaos
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = NewYearChaos.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int peopleQueued = scanner.nextInt();
            int[] queue = new int[peopleQueued];
            for (int i = 0; i < peopleQueued; i++) {
                queue[i] = scanner.nextInt();
            }
            
            int peopleBribed = peopleBribed(queue);
            output.append(peopleBribed == -1 ? "Too chaotic" : peopleBribed);
            output.append("\n");
        }
        scanner.close();
        
        System.out.println(output.toString());
    }

    /**
     * Calculates how many people were bribed in the queue
     * 
     * @param queue
     *      Queue to have people bribed calculated
     * @return Number of people bribed in the queue or -1 if one person bribed
     *  more than two people
     */
    private static int peopleBribed(int[] queue) {
        int peopleBribed = 0;
        for (int i = queue.length - 1; i > 0; i--) {
            int lookingFor = i + 1;
            int currBribed = 0;
            
            // Checks how many were bribed for position
            for (int j = 0; j <= i; j++) {
                // If more than two, not possible
                if (currBribed > 2) {
                    return -1;
                }
                
                // Checks if value is found
                int currIndex = i - j;
                int curr = queue[currIndex];
                if (curr == lookingFor) {
                    peopleBribed += currBribed;
                    
                    // Moves if needed
                    if (currBribed > 0) {
                        moveRight(queue, currIndex, currBribed);
                    }
                    break;
                } else {
                    currBribed++;
                }
            }
        }
        
        return peopleBribed;
    }

    /**
     * Moves position specified to the right
     * 
     * @param array
     *      Array to be changed
     * @param position
     *      Position of value to be moved
     * @param moves
     *      Number of times to be moved to the right
     */
    private static void moveRight(int[] array, int position, int moves) {
        for (int i = position; i < position + moves; i++) {
            int aux = array[i];
            array[i] = array[i + 1];
            array[i + 1] = aux;
        }
    }
}
