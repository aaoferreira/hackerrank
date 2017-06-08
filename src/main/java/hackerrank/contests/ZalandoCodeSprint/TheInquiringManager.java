/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 5 Jun 2016
 *
 */
package hackerrank.contests.ZalandoCodeSprint;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TheInquiringManager {

    // https://www.hackerrank.com/contests/zalando-codesprint/challenges/the-inquiring-manager
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheInquiringManager.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        StringBuilder output = new StringBuilder();
        
        // Gets events
        PriorityQueue<Event> events = new PriorityQueue<>();
        int numberfOfEvents = scanner.nextInt();
        while (numberfOfEvents-- > 0) {
            int eventType = scanner.nextInt();
            if (eventType == 1) {
                long price = scanner.nextLong();
                long time = scanner.nextLong();
                events.offer(new Event(eventType, time, price));
            } else if (eventType == 2) {
                long time = scanner.nextLong();
                events.offer(new Event(eventType, time));
            }
        }
        
        // Process events
        PriorityQueue<Event> orders = new PriorityQueue<>(
                new Comparator<Event>() {
                    @Override
                    public int compare(Event e1, Event e2) {
                        // Descending price order
                        long diff = e2.getPrice() - e1.getPrice();
                        int compare = 0;
                        if (diff > 0) {
                            compare = 1;
                        } else if (diff < 0) {
                            compare = -1;
                        }
                        return compare;
                    }
                });
        
        Event currEvent = null;
        while (!events.isEmpty()) {
            Event event = events.poll();
            if (event.getType() == 1) {
                orders.offer(event);
            } else if (event.getType() == 2) {
                long eventTime = event.getTime();
                long timeLimit = Math.max(eventTime, 59) - 59;
                
                // Checks if current event is still valid
                if (currEvent != null
                        && currEvent.getTime() < timeLimit) {
                    currEvent = null;
                }
                
                // Checks if there's a new better priced order
                while (!orders.isEmpty()) {
                    Event order = orders.peek();
                    if (order.getTime() >= timeLimit
                            && (currEvent == null || order.getPrice() >= currEvent.getPrice())) {
                        currEvent = order;
                        break;
                    }
                    orders.poll();
                }
                
                output.append(currEvent == null ? -1 : currEvent.getPrice());
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
    static class Event implements Comparable<Event> {
        
        /** Order type */
        private int type;
        
        /** Order price */
        private long price;
        
        /** Order time */
        private long time;
        
        /**
         * Creates a new order
         * 
         * @param type
         *      Order type
         * @param time
         *      Order time
         */
        public Event(int type, long time) {
            this.type = type;
            this.time = time;
        }

        /**
         * Creates a new order
         * 
         * @param type
         *      Order type
         * @param price
         *      Order price
         * @param time
         *      Order time
         */
        public Event(int type, long time, long price) {
            this.type = type;
            this.time = time;
            this.price = price;
        }
        
        /* (non-Javadoc)
         * @see java.lang.Comparable#compareTo(java.lang.Object)
         */
        @Override
        public int compareTo(Event event) {
            long diff = 0;
            
            diff = getTime() - event.getTime();
            if (diff == 0) {
                diff = getType() - event.getType();
            }
            if (diff == 0) {
                diff = event.getPrice() - event.getPrice();
            }
            
            int compare = 0;
            if (diff > 0) {
                compare = 1;
            } else if (diff < 0) {
                compare = -1;
            }
            return compare;
        }

        /**
         * Getter for the type attribute
         * 
         * @return The type
         */
        public int getType() {
            return type;
        }

        /**
         * Getter for the price attribute
         * 
         * @return The price
         */
        public long getPrice() {
            return price;
        }

        /**
         * Setter for the price attribute
         * 
         * @param price
         *      The price to be set
         */
        public void setPrice(long price) {
            this.price = price;
        }

        /**
         * Getter for the time attribute
         * 
         * @return The time
         */
        public long getTime() {
            return time;
        }

        /**
         * Setter for the time attribute
         * 
         * @param time
         *      The time to be set
         */
        public void setTime(long time) {
            this.time = time;
        }

        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "Event [type=" + type + ", time=" + time + ", price=" + price + "]";
        }
    }
}
