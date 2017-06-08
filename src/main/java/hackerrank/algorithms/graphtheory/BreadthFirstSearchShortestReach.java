/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 8 Jun 2016
 *
 */
package hackerrank.algorithms.graphtheory;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class BreadthFirstSearchShortestReach {

    // https://www.hackerrank.com/challenges/bfsshortreach
    
    private static final int EDGE_LENGTH = 6;
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = BreadthFirstSearchShortestReach.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfNodes = scanner.nextInt();
            int numberOfEdges = scanner.nextInt();
            
            // Gets edges
            int[][] edges = new int[numberOfEdges][2];
            for (int i = 0; i < numberOfEdges; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            
            // Creates graph
            Node[] graph = createGraph(numberOfNodes, edges);
            
            // Performs breadth first search from starting node
            int startingNode = scanner.nextInt();
            breadthFirstSearch(graph, startingNode);
            
            // Prints node reaches after breadth first search
            for (Node node : graph) {
                if (node == null || node.getValue() == startingNode) {
                    continue;
                }
                int level = node.getLevel();
                output.append(level == -1 ? level : level * EDGE_LENGTH);
                output.append(" ");
            }
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Performs breadth first search on graph passed
     * 
     * @param graph
     *      Graph to be searched
     * @param startingNode
     *      Starting node for searching
     */
    private static void breadthFirstSearch(Node[] graph, int startingNode) {
        Queue<Node> processingQueue = new LinkedList<>();
        
        // Gets starting node and adds to processing queue
        Node root = graph[startingNode];
        root.setLevel(0);
        processingQueue.offer(root);
        
        // Processes queued nodes
        while (!processingQueue.isEmpty()) {
            Node node = processingQueue.poll();
            LinkedList<Integer> adjacencyList = node.getAdjacencyList();
            for (Integer adjacentNodeId : adjacencyList) {
                Node adjacentNode = graph[adjacentNodeId];
                
                // Skips already processed
                if (adjacentNode.getLevel() >= 0) {
                    continue;
                }
                
                // Sets parent, level and queue for processing
                adjacentNode.setParent(node);
                adjacentNode.setLevel(node.getLevel() + 1);
                processingQueue.offer(adjacentNode);
            }
        }
    }


    /**
     * Creates graph with size and edges passed
     * 
     * @param numberOfNodes
     *      Number of nodes in graph
     * @param edges
     *      Edges in graph
     * @return A populated graph
     */
    private static Node[] createGraph(int numberOfNodes, int[][] edges) {
        // Creates graph and populates it
        Node[] graph = new Node[numberOfNodes + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new Node(i);
        }
        
        // Populates edges
        for (int i = 0; i < edges.length; i++) {
            Node nodeA = graph[edges[i][0]];
            Node nodeB = graph[edges[i][1]];
            
            // Adds adjacent nodes
            nodeA.getAdjacencyList().addFirst(nodeB.getValue());
            nodeB.getAdjacencyList().addFirst(nodeA.getValue());
        }
        
        return graph;
    }


    /**
     *
     * @author Alfredo Ferreira
     *
     */
    static class Node {
        /** Node value */
        int value;
        
        /** Node level */
        int level = -1;
        
        /** Node parent */
        Node parent;
        
        /** Node adjacency list */
        LinkedList<Integer> adjacencyList = new LinkedList<>();

        /**
         * Creates a new Node
         * 
         * @param value
         *      Node value
         */
        public Node(int value) {
            this.value = value;
        }
        
        /**
         * Getter for the level attribute
         * 
         * @return The level
         */
        public int getLevel() {
            return level;
        }

        /**
         * Setter for the level attribute
         * 
         * @param level
         *      The level to be set
         */
        public void setLevel(int level) {
            this.level = level;
        }

        /**
         * Getter for the parent attribute
         * 
         * @return The parent
         */
        public Node getParent() {
            return parent;
        }

        /**
         * Setter for the parent attribute
         * 
         * @param parent
         *      The parent to be set
         */
        public void setParent(Node parent) {
            this.parent = parent;
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
                    ", level=" + level +
                    ", parent=" + parent +
                    ", adjacencyList=" + adjacencyList + "]";
        }
    }
}
