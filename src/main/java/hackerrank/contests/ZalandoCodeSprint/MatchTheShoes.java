/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 5 Jun 2016
 *
 */
package hackerrank.contests.ZalandoCodeSprint;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class MatchTheShoes {

    // https://www.hackerrank.com/contests/zalando-codesprint/challenges/match-the-shoes
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = MatchTheShoes.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        int suggestions = scanner.nextInt();
        @SuppressWarnings("unused")
        int distinctShoes = scanner.nextInt();
        int numberOfOrders = scanner.nextInt();
        
        Map<Integer, Shoe> shoes = new HashMap<>();
        while (numberOfOrders-- > 0) {
            int orderedShoe = scanner.nextInt();
            Shoe shoe = shoes.get(orderedShoe);
            if (shoe == null) {
                shoe = new Shoe(orderedShoe);
                shoes.put(orderedShoe, shoe);
            }
            shoe.increaseOrderQuantity();
        }
        scanner.close();
        
        List<Shoe> orderedShoeList = 
                shoes.values().stream()
                        .sorted()
                        .collect(Collectors.toList());
        StringBuilder output = new StringBuilder();
        int count = 0;
        for (Shoe shoe : orderedShoeList) {
            if (count >= suggestions) {
                break;
            }
            output.append(shoe.getId());
            output.append("\n");
            count++;
        }
        
        System.out.print(output.toString());
    }
    
    /**
     *
     * @author Alfredo Ferreira
     *
     */
    static class Shoe implements Comparable<Shoe>{
        
        /** Id */
        private int id;
        
        /** Order quantity */
        private int orderQuantity = 0;

        /**
         * Creates new Shoe
         * 
         * @param id
         *      Shoe id
         */
        public Shoe(int id) {
            this.id = id;
        }
        
        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Shoe shoe) {
            int compare = shoe.getOrderQuantity() - getOrderQuantity();
            if (compare == 0) {
                compare = getId() - shoe.getId();
            }
            return compare;
        }
        
        /**
         * Getter for the orderQuantity attribute
         * 
         * @return The orderQuantity
         */
        public int getOrderQuantity() {
            return orderQuantity;
        }

        /**
         * Increases order quantity
         */
        public void increaseOrderQuantity() {
            orderQuantity++;
        }

        /**
         * Getter for the id attribute
         * 
         * @return The id
         */
        public int getId() {
            return id;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Shoe [id=" + id + ", orderQuantity=" + orderQuantity + "]";
        }
    }
}
