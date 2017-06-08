/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 25 May 2016
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
public class SimpleTextEditor {

    // https://www.hackerrank.com/challenges/simple-text-editor
    
    private static final int APPEND = 1;
    private static final int DELETE = 2;
    private static final int PRINT = 3;
    
    private static final Deque<Operation> operationStack =
            new LinkedList<>();
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SimpleTextEditor.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        StringBuilder builder = new StringBuilder();
        int numberOfOperations = scanner.nextInt();
        while (numberOfOperations-- > 0) {
            int operation = scanner.nextInt();
            if (operation == APPEND) {
                append(builder, scanner.next());
            } else if (operation == DELETE) {
                delete(builder, scanner.nextInt());
            } else if (operation == PRINT) {
                output.append(builder.charAt(scanner.nextInt() - 1));
                output.append("\n");
            } else {
                undo(builder);
            }
        }
        
        scanner.close();
        System.out.print(output.toString());
    }
    
    /**
     * Appends value to string builder and adds operation to stack
     * 
     * @param builder
     *      Builder to have value appended to
     * @param value
     *      Value to be appended
     */
    private static void append(StringBuilder builder, String value) {
        append(builder, value, false);
    }
    
    /**
     * Appends value to string builder
     * 
     * @param builder
     *      Builder to have value appended to
     * @param value
     *      Value to be appended
     * @param undoOperation
     *      Indicates if operation should be added to operation stack
     */
    private static void append(
            StringBuilder builder, String value, boolean undoOperation) {
        builder.append(value);
        if (!undoOperation) {
            operationStack.push(new Operation(APPEND, value));
        }
    }
    
    /**
     * Deletes characters from the builder as specified by value and adds to
     *  operation stack
     * 
     * @param builder
     *      Builder to have characters deleted from
     * @param value
     *      Number of characters to be deleted from the end of builder
     */
    private static void delete(StringBuilder builder, int value) {
        delete(builder, value, false);
    }
    
    /**
     * Deletes characters from the builder as specified by value
     * 
     * @param builder
     *      Builder to have characters deleted from
     * @param value
     *      Number of characters to be deleted from the end of builder
     * @param undoOperation
     *      Indicates if operation should be added to operation stack
     */
    private static void delete(
            StringBuilder builder, int value, boolean undoOperation) {
        String toBeDeleted = builder.substring(builder.length() - value);
        int last = builder.length() - 1;
        while (value-- > 0) {
            builder.deleteCharAt(last--);
        }
        if (!undoOperation) {
            operationStack.push(new Operation(DELETE, toBeDeleted));
        }
    }
    
    /**
     * Undo last operation on operation stack
     * 
     * @param builder
     *      Builder to have the operation undone to
     */
    private static void undo(StringBuilder builder) {
        if (operationStack.isEmpty()) {
            return;
        }
        
        Operation lastOperation = operationStack.pop();
        if (lastOperation.getType() == APPEND) {
            delete(builder, lastOperation.getValue().length(), true);
        } else if (lastOperation.getType() == DELETE) {
            append(builder, lastOperation.getValue(), true);
        }
    }
    
    /**
     *
     * @author Alfredo Ferreira
     *
     * @param <T>
     *      Type of value
     */
    static class Operation {
        /** Type attribute */
        int type;
        
        /** Value attribute */
        String value;
        
        /**
         * Creates new operation
         * 
         * @param type
         * @param value
         */
        public Operation(int type, String value) {
            setType(type);
            setValue(value);
        }

        /**
         * Getter for the type attribute
         * 
         * @return The type
         */
        public int getType() {
            return type;
        }

        /**
         * Setter for the type attribute
         * 
         * @param type
         *      The type to be set
         */
        public void setType(int type) {
            this.type = type;
        }

        /**
         * Getter for the value attribute
         * 
         * @return The value
         */
        public String getValue() {
            return value;
        }

        /**
         * Setter for the value attribute
         * 
         * @param value
         *      The value to be set
         */
        public void setValue(String value) {
            this.value = value;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Operation [type=" + type + ", value=" + value + "]";
        }
    }
}
