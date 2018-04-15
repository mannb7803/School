    /***************************************************************
 * file: StringMethods.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Lab2
 * date last modified: 2/1/18
 *
 * purpose: Takes user input, then uses methods to convert and manipulate strings in order to get the desired outputs
 *
 *
 ****************************************************************/
import java.util.Scanner;
public class StringMethods {
    private static Scanner kb = new Scanner(System.in);
    private static String firstName,  middleName, lastName, color;
    private static int age, luckyNumber;
    //Main method
    //user input and printing
    public static void main (String args[])
    {
        //takes user input for all strings and ints that are required for the program
        System.out.println("Please enter your first name");
        firstName = kb.nextLine();
        System.out.println("Please enter your middle name");
        middleName = kb.nextLine();
        System.out.println("Please enter your last name");
        lastName = kb.nextLine();
        System.out.println("Pleas enter your age");
        age = kb.nextInt();
        System.out.println("Please enter your favorite number");
        luckyNumber = kb.nextInt();
        //clears input steam so the color does not take the enter from after the int
        kb.nextLine();
        System.out.println("Please enter your favorite color");
        color = kb.nextLine();
        //test
        //System.out.println(getOneInitial(0) + getOneInitial(1) + getOneInitial(2));

        //print statmenets that print the desired word configurations by calling the methods made and described below
        //using " " to act as spaces was a not the best idea, i probably should have made the methods return stringReturn += " "; or use printf sorry Mr. TA
        System.out.println("A story about " + stringFirstLetterUpercase(firstName) + " "+ stringFirstLetterUpercase(middleName) +" "+ stringFirstLetterUpercase(lastName) +":");
        System.out.println("  " + firstName.toUpperCase() + " "+ middleName.toUpperCase() + " "+ lastName.toUpperCase() + " is " + getAllInitials() + ".");
        System.out.println("  " + getAllInitials() + "\'s favorite color is " + color.toLowerCase() + ", and " + stringFirstLetterUpercase(firstName) + " " + getOneInitial(2) + " is " + age + ".");
        System.out.println("  The lucky number of " + stringFirstLetterUpercase(firstName) + " " + getOneInitial(1) + " " + stringFirstLetterUpercase(lastName) + " is " + luckyNumber + ".");
    }
    //Method stringFirstLetterUpercase
    //Purpose: to take the first letter in a string at index 0 and capitalize it while making the rest of the string lowercase
    public static String stringFirstLetterUpercase(String s)
    {
        String stringReturn = "";
        stringReturn = s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
        return stringReturn;
    }
    //Method getAllInitials
    //Purpose: Takes thef irst letters of a string at index 0, concatenates them into one string, and capitalizes them
    public static String getAllInitials()
    {
        String stringReturn = "";
        stringReturn = firstName.substring(0,1).toUpperCase() + middleName.substring(0, 1).toUpperCase() + lastName.substring(0,1).toUpperCase();
        return stringReturn;
    }
    //Method getOneInitial
    //Purpose: Uses a switch statement to test a given int, it then returns the first initial depending on what number is given.
    //0- first name, 1- middle name, 2- last name
    //it also adds  a period at the end
    public static String getOneInitial(int n)
    {
        String stringReturn = "";
        switch(n)
        {
            case 0: stringReturn = firstName.substring(0, 1).toUpperCase() +".";
                break;
            case 1: stringReturn = middleName.substring(0, 1).toUpperCase() + ".";
                break;
            case 2: stringReturn = lastName.substring(0, 1).toUpperCase() + ".";
                break;
        }
        return  stringReturn;

    }
}
