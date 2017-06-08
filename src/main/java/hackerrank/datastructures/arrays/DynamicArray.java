/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 19 May 2016
 *
 */
package hackerrank.datastructures.arrays;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class DynamicArray {

    // https://www.hackerrank.com/challenges/dynamic-array
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = DynamicArray.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int size = scanner.nextInt();
        NodeList[] sequences = new NodeList[size];
        int queries = scanner.nextInt();
        int lastAns = 0;
        while (queries-- > 0) {
            int queryType = scanner.nextInt();
            int sequenceIndex = scanner.nextInt();
            int value = scanner.nextInt();
            
            int index = (sequenceIndex ^ lastAns) % size;
            NodeList sequence = sequences[index];
            if (sequence == null) {
                sequence = new NodeList();
                sequences[index] = sequence;
            }
            if (queryType == 1) {
                sequence.addNode(new Node(value));
            } else if (queryType == 2) {
                lastAns = sequence.getNode(value % sequence.size()).getValue();
                output.append(lastAns);
                output.append("\n");
            }
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
    
    /**
     *
     * @author Alfredo Ferreira
     *
     */
    static class NodeList {
        /** Size */
        private int size = 0;
        
        /** Head */
        private Node head = null;
        
        /** Tail */
        private Node tail = null;
        
        /**
         * Gets size
         * 
         * @return Size
         */
        public int size() {
            return size;
        }
        
        /**
         * Adds node
         * 
         * @param node
         *      Node to be added
         */
        public void addNode(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.setNext(node);
                tail = node;
            }
            size++;
        }
        
        /**
         * Gets node in index specified
         * 
         * @param index
         *      Index of node to be retrieved
         * @return Node at specified index or null if not available
         */
        public Node getNode(int index) {
            if (index >= size) {
                return null;
            }
            
            Node node = head;
            for (int i = 0; i < index && node != null; i++) {
                node = node.getNext();
            }
            return node;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "NodeList [size=" + size + ", head=" + head + ", tail=" + tail + "]";
        }
    }

    /**
     *
     * @author Alfredo Ferreira
     *
     */
    static class Node {
        /** Value */
        private int value;
        
        /** Next node */
        private Node next;
        
        /**
         * Default constructor
         */
        public Node() { }
        
        /**
         * Constructor with value
         * 
         * @param value
         *      Node value to be set
         */
        public Node(int value) {
            setValue(value);
        }
        
        /**
         * Sets value
         * 
         * @param value
         *      Value to be set
         */
        public void setValue(int value) {
            this.value = value;
        }
        
        /**
         * Gets value
         * @return
         */
        public int getValue() {
            return value;
        }
        
        /**
         * Sets next node
         * 
         * @param next
         *      Node to be set
         */
        public void setNext(Node next) {
            this.next = next;
        }
        
        /**
         * Gets next node
         * 
         * @return Next node
         */
        public Node getNext() {
            return next;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Node [value=" + value + ", next=" + next + "]";
        }
    }
}
