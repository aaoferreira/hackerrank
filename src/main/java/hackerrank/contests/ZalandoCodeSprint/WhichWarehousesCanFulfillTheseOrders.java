/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 5 Jun 2016
 *
 */
package hackerrank.contests.ZalandoCodeSprint;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class WhichWarehousesCanFulfillTheseOrders {

    // https://www.hackerrank.com/contests/zalando-codesprint/challenges/which-warehouses-can-fullfill-these-orders
    
    // TODO Maybe implement weight on warehouses to fulfill all order optimally?
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = WhichWarehousesCanFulfillTheseOrders.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        // Gets metadata
        int warehouseCount = scanner.nextInt();
        int orderCount = scanner.nextInt();
        int productCount = scanner.nextInt();
        
        // Builds products total and stock
        long[] productsTotal = new long[productCount];
        long[][][] productsStock = new long[productCount][warehouseCount][2];
        for (int i = 0; i < warehouseCount; i++) {
            for (int j = 0; j < productCount; j++) {
                long productQty = scanner.nextLong();
                productsTotal[j] += productQty;
                productsStock[j][i][0] = productQty;
                productsStock[j][i][1] = i;
            }
        }
        
        // Sorts stocks
        for (int i = 0; i < productCount; i++) {
            quickSort(productsStock[i]);
        }
        
        // Processes orders
        while (orderCount-- > 0) {
            int minWarehouses = 0;
            boolean[] warehouseVisited = new boolean[warehouseCount];
            for (int i = 0; i < productCount; i++) {
                long productQty = scanner.nextLong();
                
                // Checks if product should be checked
                if (productQty == 0) {
                    continue;
                }
                
                // Checks if there is enough stock
                if (productQty > productsTotal[i]) {
                    minWarehouses = -1;
                    scanner.nextLine();
                    break;
                }
                
                long currCount = 0;
                for (int j = warehouseCount - 1; j >= 0; j--) {
                    int warehouse = (int) productsStock[i][j][1];
                    if (!warehouseVisited[warehouse]) {
                        minWarehouses++;
                        warehouseVisited[warehouse] = true;
                    }
                    currCount += productsStock[i][j][0];
                    if (currCount >= productQty) {
                        break;
                    }
                }
            }
            
            output.append(minWarehouses);
            output.append("\n");
        }
        
        scanner.close();
        System.out.print(output.toString());
    }
    

    /**
     * Performs quick sort of the array provided
     * 
     * @param array
     *      Array to be quick sorted
     */
    private static void quickSort(long[][] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * Performs quick sort of the array provided within indexes boundaries
     *  passed
     * 
     * @param array
     *      Array to be quick sorted
     * @param startIndex
     *      Start index of sub array to be sorted
     * @param endIndex
     *      End index of sub array to be sorted
     */
    private static void quickSort(long[][] array, int startIndex, int endIndex) {
        // If less then three elements, already sorted
        if (endIndex - startIndex + 1 < 2) {
            return;
        }
        
        long pivot = array[endIndex][0];
        int pivotIndex = startIndex;
        
        // Checks pivot position
        for (int i = pivotIndex; i < endIndex; i++) {
            if (array[i][0] <= pivot) {
                // Swaps to create partitions
                swap(array, pivotIndex, i);
                
                // Increases operations and pivot index counters
                pivotIndex++;
            }
        }
        // Swaps pivot to its position
        swap(array, pivotIndex, endIndex);
        
        // Recursive calls for left and right partitions
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }
    
    /**
     * Swaps values in the array
     * 
     * @param array
     *      Array to have values swapped
     * @param a
     *      Index of value a to be swapped with value b
     * @param b
     *      Index of value b to be swapped with value a
     */
    private static void swap(long[][] array, int a, int b) {
        // Swaps
        long[] temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
