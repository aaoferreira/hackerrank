/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 22 Apr 2016
 *
 */
package hackerrank.algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CommonChild {

    // https://www.hackerrank.com/challenges/common-child
    
    private static final short MIN_ASCII_UPPER = 'A';
    private static final short MAX_ASCII_UPPER = 'Z';
    private static final short SIZE = MAX_ASCII_UPPER - MIN_ASCII_UPPER + 1;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CommonChild.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        // Gets string values
        String valueA = scanner.nextLine();
        String valueB = scanner.nextLine();
        scanner.close();
        
        // Finds shortest substitution
//        System.out.println(
//                findLongestChildLength(valueA, valueB, valueA.length()));
        System.out.println(
                findLongestChildLength2(valueA, valueB, valueA.length()));
    }
    
//    /**
//     * Finds longest substring that is a child of both values
//     * 
//     * @param valueA
//     *      Value A
//     * @param valueB
//     *      Value B
//     * @param length
//     *      length of values to find longest child substring
//     * @return Maximum length of substring that is a child of both values
//     */
//    private static int findLongestChildLength(
//            String valueA, String valueB, int length) {
//        int maxChildLength = 0;
//        
//        // Gets char occurrences for strings
//        int[][] valueAOccurrences = getCharOccurrences(valueA);
//        
//        // Dictionary for indexes of chars in valueA
//        Map<String, Set<Integer>> valueAIndexes = getCharIndexes(valueA);
//        
//        // Loops through valueB chars checking common strings within
//        //  valueA and builds maximum length
//        for (int i = 0; i < length; i++) {
//            // Gets current char in valueB and checks if it occurs in valueA
//            char currChar = valueB.charAt(i);
//            Set<Integer> currSet = valueAIndexes.get(currChar + "");
//            if (currSet == null) {
//                continue;
//            }
//            
//            int currMaxChildLength =
//                    findMaxCommonFromIndex(
//                            valueB,
//                            i,
//                            valueAOccurrences,
//                            valueAIndexes);
//        }
//        
//        return maxChildLength;
//    }
//
//    /**
//     * @param valueB
//     * @param i
//     * @param valueAOccurrences
//     * @param valueAIndexes
//     * @return
//     */
//    private static int findMaxCommonFromIndex(
//            String target,
//            int index,
//            int[][] sourceOccurrences,
//            Map<String, Set<Integer>> sourceIndexes) {
//        // Gets target char for index
//        char currChar = target.charAt(index);
//        
//        // Gets index on source
//        Set<Integer> currSet = sourceIndexes.get(currChar + "");
//        int sourceIndex = currSet.iterator().next();
//        
//        int length = target.length();
//        int maxChildLength = 1;
//        
//        for (int j = index + 1; j < length; j++) {
//            // Calculates current child string size
//            int currMaxChildLength = 1;
//            int currSourceIndex = sourceIndex;
//        
//            for (int k = j; k < length; k++) {
//                
//                // Gets next char
//                char nextChar = target.charAt(k);
//                int nextCharIndex = nextChar - MIN_ASCII_UPPER;
//                
//                // Checks if there is an occurrence for char in remaining
//                //  valueA
//                int sourceMaxIndex = sourceOccurrences.length - 1;
//                int nextCharOccurrences =
//                        sourceOccurrences[sourceMaxIndex][nextCharIndex] - 
//                        sourceOccurrences[currSourceIndex + 1][nextCharIndex];
//                if (nextCharOccurrences == 0) {
//                    continue;
//                }
//                
//                // Get where is next occurrence
//                Set<Integer> nextSet = sourceIndexes.get(nextChar + "");
//                for (Integer currIndex : nextSet) {
//                    if (currIndex > currSourceIndex) {
//                        currSourceIndex = currIndex;
//                        currMaxChildLength++;
//                        break;
//                    }
//                }
//            }
//            
//            maxChildLength = Math.max(maxChildLength, currMaxChildLength);
//        }
//        return maxChildLength;
//    }
//
//    /**
//     * Creates char indexes dictionary
//     * 
//     * @param value
//     *      String to have char indexes counted
//     * @return Char indexes dictionary
//     */
//    private static Map<String, Set<Integer>> getCharIndexes(String value) {
//        Map<String, Set<Integer>> charIndexes = new HashMap<>(SIZE);
//        char[] chars = value.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            // Creates dictionary for valueA
//            String currCharString = chars[i] + "";
//            Set<Integer> currSet = charIndexes.get(currCharString);
//            if (currSet == null) {
//                currSet = new LinkedHashSet<>();
//                charIndexes.put(currCharString, currSet);
//            }
//            currSet.add(i);
//        }
//        
//        return charIndexes;
//    }
//
//    /**
//     * Creates char occurrences dictionary
//     * 
//     * @param value
//     *      String to have char occurrences counted 
//     * @return Char occurrence dictionary
//     */
//    private static int[][] getCharOccurrences(String value) {
//        // Creates array
//        char[] chars = value.toCharArray();
//        int[][] occurrences = new int[chars.length][SIZE];
//        
//        occurrences[0][chars[0] - MIN_ASCII_UPPER]++;
//        for (int i = 1; i < chars.length; i++) {
//            occurrences[i] = occurrences[i - 1].clone();
//            occurrences[i][chars[i] - MIN_ASCII_UPPER]++;
//        }
//        
//        return occurrences;
//    }

    /**
     * Finds longest substring that is a child of both values
     * 
     * @param valueA
     *      Value A
     * @param valueB
     *      Value B
     * @param length
     *      length of values to find longest child substring
     * @return Maximum length of substring that is a child of both values
     */
    private static int findLongestChildLength2(
            String valueA, String valueB, int length) {
        int maxChildLength = 0;
        
        // Dictionary for last index of chars in valueA and valueB
        int[] valueADict = new int[SIZE];
        int[] valueBDict = new int[SIZE];
        Arrays.fill(valueADict, -1);
        Arrays.fill(valueBDict, -1);
        int lettersFound = 0;
        for (int i = length - 1; i >= 0; i--) {
            // valueA
            int indexA = valueA.charAt(i) - MIN_ASCII_UPPER;
            int currIndexA = valueADict[indexA];
            if (currIndexA < 0) {
                valueADict[indexA] = i;
                lettersFound++;
            }
            
            // valueB
            int indexB = valueB.charAt(i) - MIN_ASCII_UPPER;
            int currIndexB = valueBDict[indexB];
            if (currIndexB < 0) {
                valueBDict[indexB] = i;
                lettersFound++;
            }
            
            // Checks if all letters were already found
            if (lettersFound == SIZE * 2) {
                break;
            }
        }
        
        // Loops through valueB chars checking common strings within
        //  valueA and builds maximum length
        int[] valueAOccurrences = new int[SIZE];
        for (int i = 0; i < length; i++) {
            int valueBCharIndex = valueB.charAt(i) - MIN_ASCII_UPPER;
            int valueAIndex = valueADict[valueBCharIndex];
            if (valueAIndex < 0 || length - valueAIndex <= maxChildLength) {
                continue;
            }
            
            int currMaxChildLength = 0;
            int valueBIndex = i;
            while (valueBIndex < length || valueAIndex < length) {
                // Increments valueA char index if possible
                if (valueAIndex < length) {
                    // Sets char for valueA occurrences
                    int valueACharIndex =
                            valueA.charAt(valueAIndex) - MIN_ASCII_UPPER;
                    valueAOccurrences[valueACharIndex]++;
                    valueAIndex++;
                }

                if (valueBIndex < length) {
                    valueBCharIndex =
                            valueB.charAt(valueBIndex) - MIN_ASCII_UPPER;
                    valueBIndex++;
                }
                if (valueAOccurrences[valueBCharIndex] > 0) {
                    currMaxChildLength++;
                    Arrays.fill(valueAOccurrences, 0);
                }
            }
            
            maxChildLength = Math.max(maxChildLength, currMaxChildLength);
        }
        
        return maxChildLength;
    }
}
