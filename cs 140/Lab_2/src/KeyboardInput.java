/***************************************************************
 * file: KeyboardInput
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Lab2
 * date last modified: 2/1/18
 *
 * purpose: This program prints out data gathered from the user/
 *
 *
 ****************************************************************/
import java.util.Scanner;
public class KeyboardInput {
    //declaring instance variables
    private  static Scanner kb  = new Scanner(System.in);
    private static String  name, companyString;
    private static int age;
    public static void main(String args[])
    {
        //user prompted for input, takes input
        System.out.println("Please enter your name");
        name = kb.nextLine();
        //user prompted for input, takes input
        System.out.println("Please enter your age");
        age = kb.nextInt();
        //clears kb
        kb.nextLine();
        //user prompted for input, takes input
        System.out.println("Please enter your Company's name");
        companyString = kb.nextLine();
        // print statement using escape characters
        System.out.println("My name is " + name + ", my age is " + age + " and\nI hope to work for " + companyString);

    }
}
