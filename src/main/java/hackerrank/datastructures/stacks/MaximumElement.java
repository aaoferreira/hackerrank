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
public class MaximumElement {

    // https://www.hackerrank.com/challenges/maximum-element
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MaximumElement.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        Deque<StackMax> stack = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int query = scanner.nextInt();
            if (query == 1) {
                int value = scanner.nextInt();
                max = Math.max(max, value);
                stack.push(new StackMax(value, max));
            } else if (query == 2) {
                stack.pop();
                
                if (!stack.isEmpty()) {
                    max = stack.peek().getCurrentMax();
                } else {
                    max = Integer.MIN_VALUE;
                }
            } else {
                output.append(stack.peek().getCurrentMax());
                output.append("\n");
            }
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
    
    static class StackMax {
        private int value;
        private int currentMax;
        
        public StackMax(int value, int currentMax) {
            setValue(value);
            setCurrentMax(currentMax);
        }
        
        /**
         * Getter for the value attribute
         * 
         * @return The value
         */
        public int getValue() {
            return value;
        }
        
        /**
         * Setter for the value attribute
         * 
         * @param value
         *      The value to be set
         */
        public void setValue(int value) {
            this.value = value;
        }
        
        /**
         * Getter for the currentMax attribute
         * 
         * @return The currentMax
         */
        public int getCurrentMax() {
            return currentMax;
        }
        
        /**
         * Setter for the currentMax attribute
         * 
         * @param currentMax
         *      The currentMax to be set
         */
        public void setCurrentMax(int currentMax) {
            this.currentMax = currentMax;
        }
    }
}
