/***************************************************************
 * file: Mann_Program2a.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Program2a
 * date last modified: 1/11/18
 *
 * purpose: Converts miles, inches, and feet to meters and then uses print f to cut down the decimals
 *
 *
 ****************************************************************/


import java.util.Scanner;
public class Mann_Program2a {
    private static Scanner kB = new Scanner(System.in);
    private static double miles, feet, inches, metersTotal;
    // i used doubles to prevent errors from user input i don't know if you care
    public static void main(String args[])
    {
        System.out.print("Enter Miles: ");
        miles = kB.nextDouble();
        System.out.print("Enter feet: ");
        feet = kB.nextDouble();
        System.out.print("Enter inches: ");
        inches = kB.nextDouble();
        metersTotal += feet / 3.3;
        metersTotal += (miles*5280) / 3.3;
        metersTotal += (inches/12) / 3.3;
        System.out.printf( (int)miles + " mile(s), " + (int)feet + " feet, "+ (int)inches + " inche(s) converts to %.1f meter(s)", metersTotal);
    }
}
