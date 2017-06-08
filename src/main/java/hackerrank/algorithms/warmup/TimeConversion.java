/**
 * IBM Confidential
 * 
 * IBM Ireland
 * Software Group - Cloud & Smarter Infrastructure
 *
 * Created-Date: 21 Mar 2016
 * Created-By: Alfredo Ferreira
 *
 * (C) COPYRIGHT IBM CORP. 2016
 *
 * SVN FILE: $HeadURL$
 */
package hackerrank.algorithms.warmup;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author $Author$
 * @version
 *      $LastChangedDate$
 *      $Revision$
 *
 */
public class TimeConversion {

    // https://www.hackerrank.com/challenges/time-conversion
    
    public static void main(String[] args) throws ParseException {
        // Gets values from standard in
//        Scanner scanner = new Scanner(System.in);
        Class<?> clazz = TimeConversion.class;
        Scanner scanner = new Scanner(
                clazz.getResourceAsStream(clazz.getSimpleName() + ".txt"));
        
        // Gets array size and skips to next line
        String timeInput = scanner.nextLine();
        scanner.close();
        
        // Gets input format and puts into a Date object
        SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm:ssa");
        Date date = inputFormat.parse(timeInput);
        
        // Sets output format and writes from date object
        SimpleDateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(outputFormat.format(date));
    }

}
