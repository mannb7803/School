/***************************************************************
 * file: Mann_Program2b.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Program2b
 * date last modified: 1/11/18
 *
 * purpose: Converts meters to feet using 3.3 meters = 1 feet and then convert the feet to either miles or inches
 *
 *
 ****************************************************************/
import java.util.Scanner;
public class Mann_Program2b {;
    private static double inches, feet, miles, meters;
    private static Scanner kb = new Scanner(System.in);
    public static void main (String args[])
    {
        System.out.print("Enter Meter(s): ");
        meters = kb.nextDouble();
        feet =  meters * 3.3;
        while (feet  >= 5280)
        {
            feet-=5280;
            miles++;
        }
        inches = Math.round(feet % 1 * 12 * 10.0) / 10.0;
        System.out.println((int)meters + " meter(s) converts to " + (int)miles + " mile(s), " + (int)feet + " feet, " + inches + " inch(es)");

    }
}
