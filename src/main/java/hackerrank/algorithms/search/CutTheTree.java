/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 14 Jun 2016
 *
 */
package hackerrank.algorithms.search;

import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class CutTheTree {

    // https://www.hackerrank.com/challenges/cut-the-tree
    
    public static void main(String[] args) throws Exception {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = CutTheTree.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Creates tree
        int numberOfVertices = scanner.nextInt();
        Node[] tree = new Node[numberOfVertices + 1];
        for (int i = 1; i < tree.length; i++) {
            tree[i] = new Node(i, scanner.nextInt());
        }
        
        // Creates adjacent nodes
        for (int i = 0; i < numberOfVertices - 1; i++) {
            Node nodeA = tree[scanner.nextInt()];
            Node nodeB = tree[scanner.nextInt()];
            nodeA.getAdjacencyList().addFirst(nodeB.getId());
            nodeB.getAdjacencyList().addFirst(nodeA.getId());
        }
        scanner.close();
        
        System.out.print(minimumTreeDifference(tree));
    }
    
    /**
     * Calculates minimum difference of cut subtree
     * 
     * @param tree
     *      Tree
     * @return Minimum difference of cut subtree
     */
    private static int minimumTreeDifference(Node[] tree) {
        // Calculates tree values from root node
        calculateTreeValues(tree);
        
        // Calculates minimum difference from root
        boolean[] visited = new boolean[tree.length];
        return minimumTreeDifference(tree, visited, 1);
    }

    /**
     * Calculates minimum difference of cut subtree of node specified
     * 
     * @param tree
     *      Tree
     * @param visited
     *      Visited cache
     * @param nodeId
     *      Node id
     * @return Minimum difference of cut subtree of node
     */
    private static int minimumTreeDifference(
            Node[] tree,
            boolean[] visited,
            int nodeId) {
        int minDiff = Integer.MAX_VALUE;
        visited[nodeId] = true;
        Node node = tree[nodeId];
        for (Integer adjacentId : node.getAdjacencyList()) {
            if (!visited[adjacentId]) {
                minDiff = Math.min(
                        minDiff,
                        minimumTreeDifference(tree, visited, adjacentId)
                        );
            }
        }
        

        // Updates difference
        int treeMax = tree[1].getTreeValue();
        int currTree = node.getTreeValue();
        int treeLeft = treeMax - currTree;
        int currDiff =
                Math.max(treeLeft, currTree) - Math.min(treeLeft, currTree);
        
        return Math.min(currDiff, minDiff);
    }
    
    /**
     * Calculates tree value for all nodes in tree
     * 
     * @param tree
     *      Tree
     */
    private static void calculateTreeValues(Node[] tree) {
        // Calculate tree values from root
        boolean[] visited = new boolean[tree.length];
        calculateTreeValues(tree, visited, 1);
    }

    /**
     * Calculates tree value for node
     * 
     * @param tree
     *      Tree
     * @param visited
     *      Visited nodes cache
     * @param nodeId
     *      Node id
     */
    private static void calculateTreeValues(
            Node[] tree,
            boolean[] visited,
            int nodeId) {
        visited[nodeId] = true;
        Node node = tree[nodeId];
        for (Integer adjacentId : node.getAdjacencyList()) {
            if (!visited[adjacentId]) {
                calculateTreeValues(tree, visited, adjacentId);
                
                // Updates tree value
                Node adjacentNode = tree[adjacentId];
                node.setTreeValue(
                        node.getTreeValue() + adjacentNode.getTreeValue());
            }
        }  
    }

    /**
    *
    * @author Alfredo Ferreira
    *
    */
   static class Node {
       /** Node id */
       int id;
       
       /** Node value */
       int value;
       
       /** Node tree value */
       int treeValue;
       
       /** Node adjacency list */
       LinkedList<Integer> adjacencyList = new LinkedList<>();

       /**
        * Creates a new Node
        * 
        * @param value
        *      Node value
        */
       public Node(int id, int value) {
           this.id = id;
           this.value = value;
           this.treeValue = value;
       }

       /**
        * Getter for the id attribute
        * 
        * @return The id
        */
       public int getId() {
           return id;
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
        * Getter for the treeValue attribute
        * 
        * @return The treeValue
        */
       public int getTreeValue() {
           return treeValue;
       }
        
       /**
        * Setter for the treeValue attribute
        * 
        * @param treeValue
        *      The treeValue to be set
        */
       public void setTreeValue(int treeValue) {
           this.treeValue = treeValue;
       }
    
       /**
        * Getter for the adjacencyList attribute
        * 
        * @return The adjacencyList
        */
       public LinkedList<Integer> getAdjacencyList() {
           return adjacencyList;
       }
        
       /* (non-Javadoc)
        * @see java.lang.Object#toString()
        */
       @Override
       public String toString() {
           return "Node [value=" + value +
                   ", treeValue=" + treeValue +
                   ", adjacencyList=" + adjacencyList + "]";
       }
   }
}
