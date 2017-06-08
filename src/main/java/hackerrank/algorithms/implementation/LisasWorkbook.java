/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 1 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class LisasWorkbook {

    // https://www.hackerrank.com/challenges/bear-and-workbook
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = LisasWorkbook.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets how many chapters and maximum problems per page
        int chapters = scanner.nextInt();
        int maxProblems = scanner.nextInt();
        int pageCount = 0;
        int specialProblems = 0;
        for (int i = 1; i <= chapters; i++) {
            pageCount++;
            int problems = scanner.nextInt();
            int currPageCount = 0;
            
            // If problems are less than page count, skip
            if (problems < pageCount) {
                if (problems > maxProblems) {
                    pageCount += problems / maxProblems;
                }
                continue;
            }
            
            // Calculates starting problem
            int problem = 1;
            if (pageCount > maxProblems) {
                int skipPages = pageCount / maxProblems;
                problem += skipPages * maxProblems;
                pageCount += skipPages;
            }
            
            // Checks problems
            for (; problem <= problems; problem++) {
                currPageCount++;
                
                // If it it's special problem or problem is greater than page
                if (pageCount == problem || problem > pageCount) {
                    if (pageCount == problem) {
                        // Checks if current page count is equal problem id
                        specialProblems++;
                    }
                    
                    // Already iterates until next page
                    if (currPageCount < maxProblems) {
                        problem += maxProblems - currPageCount;
                        currPageCount = maxProblems;
                    }
                }
                
                // If maximum problems reached for page and still has problems
                //  to evaluate, count new
                if (problem < problems && currPageCount == maxProblems) {
                    pageCount++;
                    currPageCount = 0;
                }
            }
        }
        
        scanner.close();
        System.out.println(specialProblems);
    }
}
