/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 20 May 2016
 *
 */
package hackerrank.datastructures.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SwapNodesAlgo {
    
    // https://www.hackerrank.com/challenges/arrays-ds
    
    private final static String EMPTY = "";
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SwapNodesAlgo.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        // Builds tree
        Node root = new Node(1);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        int nodes = scanner.nextInt();
        for (int i = 0; i < nodes; i++) {
            Node currentNode = queue.poll();
            
            int leftValue = scanner.nextInt();
            if (leftValue != -1) {
                currentNode.left = new Node(leftValue);
                queue.offer(currentNode.left);
            }
            
            int rightValue = scanner.nextInt();
            if (rightValue != -1) {
                currentNode.right = new Node(rightValue);
                queue.offer(currentNode.right);
            }
        }
        
        int swaps = scanner.nextInt();
        while (swaps-- > 0) {
            swap(root, scanner.nextInt());
            output.append(inOrderToString(root));
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }
    
    /**
     * Swaps tree nodes starting at level specified
     * 
     * @param root
     *      Root node of the tree
     * @param level
     *      Start level from root of the tree passed to swap values
     */
    private static void swap(Node root, int level) {
        Queue<Node> queue = new LinkedList<>();
        List<Node> swapList = new LinkedList<>();
        queue.offer(root);
        
        int currentLevel = 1;
        while (queue.peek() != null) {
            Queue<Node> newQueue = new LinkedList<>();
            while (queue.peek() != null) {
                Node node = queue.poll();
                if (currentLevel % level == 0) {
                    swapList.add(node);
                }
                
                if (node.left != null) {
                    newQueue.offer(node.left);
                }
                if (node.right != null) {
                    newQueue.offer(node.right);
                }
            }
            queue = newQueue;
            currentLevel++;
        }
        
        for (Node node : swapList) {
            Node aux = node.left;
            node.left = node.right;
            node.right = aux;
        }
    }
    
    /**
     * Gets String in order representation of tree
     * 
     * @param root
     *      Root node of the tree
     * @return
     */
    private static String inOrderToString(Node root) {
        if (root == null) {
            return EMPTY;
        }
        
        StringBuilder output = new StringBuilder();
        output.append(inOrderToString(root.left));
        output.append(root.data);
        output.append(" ");
        output.append(inOrderToString(root.right));
        
        return output.toString();
    }
    
    static class Node {
        int data;
        Node left;
        Node right;
        
        Node(int data) {
            this.data = data;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Node [data=" + data + "]";
        }
    }
}
