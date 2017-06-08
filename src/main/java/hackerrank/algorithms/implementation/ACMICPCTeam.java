/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 6 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class ACMICPCTeam {

    // https://www.hackerrank.com/challenges/acm-icpc-team
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = ACMICPCTeam.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        int people = scanner.nextInt();
        int topics = scanner.nextInt();
        scanner.nextLine();
        
        // Gets number of teams
        int teams = people - 1;
        for (int i = teams - 1; i > 0; i--) {
            teams += i;
        }
        int[] teamsMax = new int[teams];
        
        // Gets topics for people
        String[] peopleTopics = new String[people];
        for (int i = 0; i < people; i++) {
            peopleTopics[i] = scanner.nextLine();
        }
        scanner.close();
        
        // Calculates team values and max value
        int max = 0;
        int teamIndex = 0;
        for (int i = 0; i < people - 1; i++) {
            char[] personTopics = peopleTopics[i].toCharArray();
            for (int j = i + 1; j < people; j++) {
                char[] pairTopics = peopleTopics[j].toCharArray();
                int teamCount = 0;
                for (int k = 0; k < topics; k++) {
                    if (personTopics[k] == '1' || pairTopics[k] == '1') {
                        teamCount++;
                    }
                }
                max = Math.max(max, teamCount);
                teamsMax[teamIndex++] = teamCount;
            }
        }
        
        // Retrieves team max count
        int teamMaxCount = 0;
        for (int teamMax : teamsMax) {
            if (teamMax == max) {
                teamMaxCount++;
            }
        }
        
        System.out.println(max);
        System.out.println(teamMaxCount);
    }
}
