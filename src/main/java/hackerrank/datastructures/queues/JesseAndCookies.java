/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 23 May 2016
 *
 */
package hackerrank.datastructures.queues;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class JesseAndCookies {

    // https://www.hackerrank.com/challenges/jesse-and-cookies
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = JesseAndCookies.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets cookies and sorts them
        int numberOfCookies = scanner.nextInt();
        int minSweetness = scanner.nextInt();
        int[] cookies = new int[numberOfCookies];
        for (int i = 0; i < numberOfCookies; i++) {
            cookies[i] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(cookies);
        
        // Initial sorted cookies queue
        Queue<Integer> cookieQueue = new LinkedList<>();
        for (int cookie : cookies) {
            cookieQueue.offer(cookie);
        }
        
        // Combined cookies queue
        Queue<Integer> sweetCookieQueue = new LinkedList<>();
        
        int operations = 0;
        int latestCookie = 0;
        while (!cookieQueue.isEmpty()) {
            // Gets cookie and finds combination that is sweet enough
            int currCookie = cookieQueue.poll();
            while (currCookie < minSweetness) {
                if (cookieQueue.isEmpty() && sweetCookieQueue.isEmpty()) {
                    break;
                }
                
                // Gets next least sweet cookie
                int nextCookie = 0;
                if (cookieQueue.isEmpty()) {
                    nextCookie = sweetCookieQueue.poll();
                } else if (sweetCookieQueue.isEmpty()) {
                    nextCookie = cookieQueue.poll();
                } else {
                    nextCookie = cookieQueue.peek() < sweetCookieQueue.peek()
                            ? cookieQueue.poll() : sweetCookieQueue.poll();
                }
                
                // Combines current cookie with next least sweet
                currCookie = Math.min(nextCookie, currCookie) +
                        Math.max(nextCookie, currCookie) * 2;
                operations++;
                
                // Checks which cookie should be the current one
                if (!cookieQueue.isEmpty() && !sweetCookieQueue.isEmpty()) {
                    if (currCookie > cookieQueue.peek()
                            || currCookie > sweetCookieQueue.peek()) {
                        sweetCookieQueue.offer(currCookie);
                        if (cookieQueue.peek() < sweetCookieQueue.peek()) {
                            currCookie = cookieQueue.poll();
                        } else {
                            currCookie = sweetCookieQueue.poll();
                        }
                    }
                } else if (!cookieQueue.isEmpty()) {
                    if (cookieQueue.peek() < currCookie) {
                        sweetCookieQueue.offer(currCookie);
                        currCookie = cookieQueue.poll();
                    }
                } else if (!sweetCookieQueue.isEmpty()) {
                    if (sweetCookieQueue.peek() < currCookie) {
                        sweetCookieQueue.offer(currCookie);
                        currCookie = sweetCookieQueue.poll();
                    }
                }
            }
            latestCookie = currCookie;
        }
        
        System.out.print(latestCookie >= minSweetness ? operations : -1);
    }
}
