package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * @author alfredo.ferreira
 */
public class GradingStudents {

    // https://www.hackerrank.com/challenges/grading

    static int[] solve(int[] grades){
        final int[] roundedGrades = new int[grades.length];
        for (int i = 0; i < grades.length; i++) {
            final int currGrade = grades[i];
            final int remainder = currGrade % 5;

            if (currGrade < 38 || remainder == 0 || remainder < 3) {
                roundedGrades[i] = currGrade;
            } else {
                roundedGrades[i] = currGrade + (5 - remainder);
            }
        }

        return roundedGrades;
    }

    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = GradingStudents.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int n = scanner.nextInt();
        int[] grades = new int[n];
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = scanner.nextInt();
        }
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
        System.out.println("");
    }
}
