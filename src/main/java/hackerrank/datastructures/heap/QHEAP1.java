/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 24 May 2016
 *
 */
package hackerrank.datastructures.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class QHEAP1 {

    // https://www.hackerrank.com/challenges/qheap1
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = QHEAP1.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        int queries = scanner.nextInt();
        while (queries-- > 0) {
            int query = scanner.nextInt();
            if (query == 1) {
                heap.add(scanner.nextInt());
            } else if (query == 2) {
                heap.remove(scanner.nextInt());
            } else if (query == 3) {
                output.append(heap.peek());
                output.append("\n");
            }
        }
        scanner.close();
        System.out.println(output.toString());
    }
}
