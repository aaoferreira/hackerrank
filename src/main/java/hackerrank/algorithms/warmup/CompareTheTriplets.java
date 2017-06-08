package hackerrank.algorithms.warmup;

import java.util.Scanner;

/** @author alfredo.ferreira */
public class CompareTheTriplets {

    // https://www.hackerrank.com/challenges/compare-the-triplets

    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CompareTheTriplets.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int[][] triplets = new int[2][3];
        int[] scores = new int[2];
        for (int i = 0; i < 2; i++) {
            int[] triplet = triplets[i];
            for (int j = 0; j < 3; j++) {
                triplet[j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < 3; i++) {
            int a = triplets[0][i];
            int b = triplets[1][i];
            if (a > b) {
                scores[0]++;
            } else if (b > a) {
                scores[1]++;
            }
        }

        System.out.print(scores[0] + " " + scores[1]);
    }
}
