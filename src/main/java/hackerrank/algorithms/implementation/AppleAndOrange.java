package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 * @author alfredo.ferreira
 */
public class AppleAndOrange {

    // https://www.hackerrank.com/challenges/apple-and-orange

    public static void main(String[] args) {
        // Gets values from standard in
        //Scanner scanner = new Scanner(System.in);
        Class<?> clazz = AppleAndOrange.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int houseStart = scanner.nextInt();
        int houseEnd = scanner.nextInt();
        int appleTree = scanner.nextInt();
        int orangeTree = scanner.nextInt();
        int numberOfApples = scanner.nextInt();
        int numberOfOranges = scanner.nextInt();

        int[] apples = new int[numberOfApples];
        for(int i = 0; i < numberOfApples; i++){
            apples[i] = scanner.nextInt();
        }

        int[] oranges = new int[numberOfOranges];
        for(int i = 0; i < numberOfOranges; i++){
            oranges[i] = scanner.nextInt();
        }

        System.out.println(
                new StringBuilder()
                        .append(countInHouse(apples, appleTree, houseStart, houseEnd))
                        .append("\n")
                        .append(countInHouse(oranges, orangeTree, houseStart, houseEnd))
                        .toString());
    }

    private static int countInHouse(int[] fruits, int tree, int houseStart, int houseEnd) {
        int count = 0;
        for (int fruit : fruits) {
            final int fruitPosition = tree + fruit;
            if (fruitPosition >= houseStart && fruitPosition <= houseEnd) {
                count++;
            }
        }
        return count;
    }
}
