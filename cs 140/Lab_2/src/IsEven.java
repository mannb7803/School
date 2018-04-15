/***************************************************************
 * file: IsEven.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Lab2
 * date last modified: 2/1/18
 *
 * purpose: Takes user input, checks to make sure the input is within the given range and then determine if the number is even or odd
 *
 *
 ****************************************************************/
import java.util.Scanner;
public class IsEven
{
    public static void main(String[] args)
    {
        boolean evenOdd=false;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter an integer from 0-10: ");
        int n = keyboard.nextInt();
        //tests to make sure user input within possible range
        if(n > 10 || n < 0)
        {
            System.out.println("Error: Input value outside of given range(1 - 10)");
            System.exit(0);
        }
        //runs when the previous if statement does not meaning the input value is 1-10
        else
        {
            //calls method testEvenOdd given the int n and sets evenOdd equal to a returned boolean
            evenOdd = testEvenOdd(n);
        }
        System.out.println("Is that number even? "+evenOdd);
    }
    //method testEvenOdd
    //purpose: tests the input n, and determine if it's even or odd and returns the result
    public static boolean testEvenOdd(int n)
    {
        if(n % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}