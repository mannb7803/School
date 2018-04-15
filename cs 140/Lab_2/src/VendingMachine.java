/***************************************************************
 * file: VendingMachine.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Lab2
 * date last modified: 2/1/18
 *
 * purpose: User inputs the price of a snack, pays in 1$, and is returned change depending on the price of the item purchased
 *
 *
 ****************************************************************/
import java.util.Scanner;
public class VendingMachine
{
    //Declaring instance variables
        private static Scanner kb = new Scanner(System.in);
        private static int itemPrice, changeDue, quarters, dimes, nickels;
    public static void main (String args[])
    {
        System.out.print("Enter price of the item: ");
        itemPrice = kb.nextInt();
        changeDue = 100-itemPrice;
        //while change due is greater than 25, take away 25 and add 1 to quarters count
        while(changeDue >= 25)
        {
        quarters++;
        changeDue-=25;
        }
        //while change due is greater than 10, take away 10 and add 1 to dime count
        while(changeDue >= 10)
        {
            dimes++;
            changeDue-=10;
        }
        //while change due is greater than 5, take away 5 and add 1 to nickel count
        while(changeDue >= 5)
        {
            nickels++;
            changeDue-=5;
        }
        //prints using println
        System.out.println("You bought an item for " + itemPrice + " cents and you gave a dollar,\nSo your change is,\n" + quarters + " quarters,\n" + dimes + " dimes, and\n" + nickels + " nickels");
    }
}
