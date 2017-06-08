/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 30 Mar 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ServiceLane {

    // https://www.hackerrank.com/challenges/service-lane

    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ServiceLane.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();

        // Gets inputs
        int freewayLength = scanner.nextInt();
        int testCases = scanner.nextInt();
        int[] segments = new int[freewayLength];
        for (int i = 0; i < freewayLength; i++) {
            segments[i] = scanner.nextInt();
        }
        
        // Creates last seen arrays
        int[] lastSeenBike = new int[freewayLength];
        int[] lastSeenCar = new int[freewayLength];
        
        // Sets default value for first row
        lastSeenBike[0] = -1;
        lastSeenCar[0] = -1;
        switch (segments[0]) {
            case 1:
                lastSeenBike[0] = 0;
                break;
            case 2:
                lastSeenCar[0] = 0;
                break;
            default:
                break;
        }
        
        // Sets last seen values
        for (int i = 1; i < freewayLength; i++) {
            switch (segments[i]) {
                case 1:
                    lastSeenBike[i] = i;
                    lastSeenCar[i] = lastSeenCar[i - 1];
                    break;
                case 2:
                    lastSeenCar[i] = i;
                    lastSeenBike[i] = lastSeenBike[i - 1];
                    break;
                default:
                    lastSeenBike[i] = lastSeenBike[i - 1];
                    lastSeenCar[i] = lastSeenCar[i - 1];
                    break;
            }
        }
        
        // Loops through test cases
        for (int i = 0; i < testCases; i++) {
            // Checks what is the largest vehicle possible
            int start = scanner.nextInt();
            int end = Math.min(scanner.nextInt(), start + 999);
            
            if (lastSeenBike[end] >= start) {
                output.append("1\n");
            } else if (lastSeenCar[end] >= start) {
                output.append("2\n");
            } else {
                output.append("3\n");
            }
        }
        
        scanner.close();
        System.out.println(output.toString());
    }
}
