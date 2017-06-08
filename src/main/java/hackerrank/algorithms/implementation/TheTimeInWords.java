/**
 *
 * Created-By: Alfredo Ferreira
 * Created-Date: 10 Apr 2016
 *
 */
package hackerrank.algorithms.implementation;

import java.util.Scanner;

/**
 *
 * @author Alfredo Ferreira
 *
 */
public class TheTimeInWords {

    // https://www.hackerrank.com/challenges/the-time-in-words
    
    public static void main(String[] args) {
        // Gets values from standard in
        // Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TheTimeInWords.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));

        StringBuilder output = new StringBuilder();
        
        int hours = scanner.nextInt();
        int minutes = scanner.nextInt();
        scanner.close();
        
        if (minutes == 0) {
            output.append(translateNumber(hours) + " o'clock");
        } else {
            boolean minutesHandled = false;
            
            // Checks if it's past or to
            boolean past = true;
            if (minutes > 30) {
                past = false;
            }

            
            // Checks if it's half
            if (minutes == 30) {
                output.append("half");
                minutesHandled = true;
            } else if (minutes % 15 == 0) {
                // Checks if it's quarter
                output.append("quarter");
                minutesHandled = true;
            }
            
            // Gets values for past and to
            if (past) {
                if (!minutesHandled) {
                    output.append(translateNumber(minutes) + " minutes" );
                }
                output.append(" past " + translateNumber(hours));
            } else {
                // Increases hours and checks if it's nor overflowed
                hours++;
                if (hours > 12) {
                    hours -= 12;
                }
                
                if (!minutesHandled) {
                    output.append(translateNumber(60 - minutes) + " minutes");
                }
                output.append(" to " + translateNumber(hours));
            }
        }
        
        System.out.println(output.toString());
    }

    /**
     * Translates number up to 29
     * 
     * @param number
     *      Number to be translated
     * @return Translated number
     */
    private static String translateNumber(int number) {
        String translated = null;
        
        if (number < 30) {
            switch (number) {
                case 1:
                    translated = "one";
                    break;
                case 2:
                    translated = "two";
                    break;
                case 3:
                    translated = "three";
                    break;
                case 4:
                    translated = "four";
                    break;
                case 5:
                    translated = "five";
                    break;
                case 6:
                    translated = "six";
                    break;
                case 7:
                    translated = "seven";
                    break;
                case 8:
                    translated = "eight";
                    break;
                case 9:
                    translated = "nine";
                    break;
                case 10:
                    translated = "ten";
                    break;
                case 11:
                    translated = "eleven";
                    break;
                case 12:
                    translated = "twelve";
                    break;
                case 13:
                    translated = "thirteen";
                    break;
                case 14:
                    translated = "fourteen";
                    break;
                case 15:
                    translated = "fifteen";
                    break;
                case 16:
                    translated = "sixteen";
                    break;
                case 17:
                    translated = "seventeen";
                    break;
                case 18:
                    translated = "eighteen";
                    break;
                case 19:
                    translated = "nineteen";
                    break;
                case 20:
                    translated = "twenty";
                    break;
                default:
                    translated = translateNumber(20)
                            + " " + translateNumber(number % 20);
                    break;
            }
        }
        
        return translated;
    }
}
