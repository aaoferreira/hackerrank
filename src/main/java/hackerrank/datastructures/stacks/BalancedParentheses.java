/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 23 May 2016
 *
 */
package hackerrank.datastructures.stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BalancedParentheses {

    // https://www.hackerrank.com/challenges/balanced-parentheses
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BalancedParentheses.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        scanner.nextLine();
        while (testCases-- > 0) {
            output.append(isBalanced(scanner.nextLine()) ? "YES" : "NO");
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
    
    /**
     * Checks if passed value has balanced parentheses
     * 
     * @param value
     *      Value to be checked
     * @return A boolean indicating whether the parentheses are balanced or not
     */
    private static boolean isBalanced(String value) {
        if (value.length() % 2 != 0) {
            return false;
        }
        
        Deque<Character> openingStack = new LinkedList<>();
        for (char parenthesis : value.toCharArray()) {
            if (parenthesis == '{'
                    || parenthesis == '['
                    || parenthesis == '(') {
                openingStack.push(parenthesis);
            } else {
                if (openingStack.isEmpty()) {
                    return false;
                }
                char stackTop = openingStack.pop();
                if ((stackTop == '(' && parenthesis != ')')
                        || (stackTop == '[' && parenthesis != ']')
                        || (stackTop == '{' && parenthesis != '}')) {
                    return false;
                }
            }
        }
        
        return openingStack.isEmpty(); 
    }
}
