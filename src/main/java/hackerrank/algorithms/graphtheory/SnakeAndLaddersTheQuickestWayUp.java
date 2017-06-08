/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 2 Jun 2016
 *
 */
package hackerrank.algorithms.graphtheory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class SnakeAndLaddersTheQuickestWayUp {

    // https://www.hackerrank.com/challenges/the-quickest-way-up
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = SnakeAndLaddersTheQuickestWayUp.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int numberOfLadders = scanner.nextInt();
            Map<Integer, Integer> ladders = new HashMap<>();
            for (int i = 0; i < numberOfLadders; i ++) {
                int start = scanner.nextInt();
                ladders.put(start, scanner.nextInt());
            }
            
            int numberOfSnakes = scanner.nextInt();
            Map<Integer, Integer> snakes = new HashMap<>();
            for (int i = 0; i < numberOfSnakes; i++) {
                int start = scanner.nextInt();
                snakes.put(start, scanner.nextInt());
            }
            
            Tile[] board = buildBoard(100, ladders, snakes);
            output.append(getDiePlaysToWin(board));
            output.append("\n");
        }
        scanner.close();
        
        System.out.print(output.toString());
    }

    /**
     * Creates a game board with ladders and snakes passed
     * 
     * @param ladders
     *      Game board ladders
     * @param snakes
     *      Game board snakes
     * @return A game board with ladders and snakes
     */
    private static Tile[] buildBoard(
            int boardSize,
            Map<Integer, Integer> ladders,
            Map<Integer, Integer> snakes) {
        Tile[] board = new Tile[boardSize + 1];
        for (int i = 1; i < board.length; i++) {
            Tile current = new Tile(i);
            board[i] = current;

            // Skips if current tile is a snake or ladder
            if (snakes.get(i) != null || ladders.get(i) != null) {
                continue;
            }
            
            // Calculates all possible die plays for tile
            for (int j = i + 1; j <= i + 6 && j < board.length; j++) {
                LinkedList<Integer> adjacencyList = current.getAdjacencyList();
                
                // Checks if there's a snake to be added
                Integer snake = snakes.get(j);
                if (snake != null) {
                    adjacencyList.addFirst(snake);
                    continue;
                }
                
                // Checks if there's a ladder to be added
                Integer ladder = ladders.get(j);
                if (ladder != null) {
                    adjacencyList.addFirst(ladder);
                    continue;
                }
                
                adjacencyList.addFirst(j);
            }
        }
        
        return board;
    }
    
    /**
     * Calculates minimum plays of the die to win the game
     * 
     * @param board
     *      Snakes and Ladders board
     * @return Minimum die plays to win the game or -1 if not possible
     */
    private static int getDiePlaysToWin(Tile[] board) {
        int[] parent = new int[board.length];
        int[] level = new int[board.length];
        boolean[] visited = new boolean[board.length];
        
        // Tile processing queue
        Queue<Tile> processingQueue = new LinkedList<Tile>();
        processingQueue.offer(board[1]);
        
        while (!processingQueue.isEmpty()) {
            Tile tile = processingQueue.poll();
            int tileValue = tile.getValue();
            
            LinkedList<Integer> adjacencyList = tile.getAdjacencyList();
            Iterator<Integer> adjacentIterator = adjacencyList.iterator();
            
            // Processes adjacent tiles
            int currentLevel = level[tileValue] + 1;
            while (adjacentIterator.hasNext()) {
                Tile adjacentTile = board[adjacentIterator.next()];
                int adjacentTileValue = adjacentTile.getValue();
                if (visited[adjacentTileValue]) {
                    continue;
                }
                visited[adjacentTileValue] = true;
                
                // Sets level and parent
                level[adjacentTileValue] = currentLevel;
                parent[adjacentTileValue] = tileValue;
                
                // If last tile already found, skips processing
                if (adjacentTileValue == board.length - 1) {
                    break;
                }
                
                // Adds adjacent tiles to processing queue
                processingQueue.offer(board[adjacentTileValue]);
            }
        }
        
        int plays = level[board.length - 1];
        return plays == 0 ? -1 : plays;
    }
    
    /**
     *
     * @author Alfredo Ferreira
     *
     */
    static class Tile {
        /** Tile value */
        int value;
        
        /** Tile adjacency list */
        LinkedList<Integer> adjacencyList = new LinkedList<>();
        
        /**
         * Creates new Tile
         * 
         * @param value
         *      Tile value
         */
        public Tile(int value) {
            this.value = value;
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
            return "Tile [value=" + value + ", adjacencyList=" + adjacencyList + "]";
        }
    }
}
