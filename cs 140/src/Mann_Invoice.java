import java.util.Scanner;

/***************************************************************
 * file: Mann_Invoice.java
 * author: Ben  Mann
 * class: CS 140 – Introduction to Computer Science
 *
 * assignment: Lab2
 * date last modified: 1/27/18
 *
 * purpose: Takes user input on member status, quality of gas, and the amount of gas sold. It then calculates the sell price of gas,
 * subtotal of gas sold, amount of city taxx and county tax, add it all up to equal total and prints it using a method to format and print the data
 *
 *
 *
 ****************************************************************/
public class Mann_Invoice {
    //instance variables declaration
    private  static Scanner sc = new Scanner(System.in);
    private static final double GAS87 =  2.85, GAS89 = 3.05, GAS91 = 3.15, MEMBERDISCOUNT = .10, COUNTYTAXRATE =  .07, CITYTAXRATE = 0.0375;
    private static  String member;
    private static int quality;
    private static double  total, subtotal, countyTax,  cityTax, gallons, gasSellPrice;
    public static void main (String args[])
    {
        System.out.print("Are you a member? ");
        member = sc.nextLine();
        //sets fist letter to capital, following letters to lower case
        member = member.substring(0, 1).toUpperCase() + member.substring(1).toLowerCase();
        System.out.print("Quality of gas: ");
        quality = sc.nextInt();
        System.out.print("Gallons sold: ");
        gallons = sc.nextDouble();
        //checks if the user is a member ignoring the case of the input to prevent errors
        if(member.equalsIgnoreCase("yes"))
        {
            //gets gas price  per gallon for members
            gasSellPrice = getGasPrice() - MEMBERDISCOUNT;
            //sets subtotal = to the price of gas * amount
            subtotal = gasSellPrice * gallons;
            //county tax
            countyTax = subtotal * COUNTYTAXRATE;
            //city tax
            cityTax = subtotal * CITYTAXRATE;
            //total  is calculated with subtotal and taxes
            total = subtotal + cityTax + countyTax;
            //formats and prints
            formatTotalAndTax();
        }
        //checks if the user is a member ignoring the case of the input to prevent errors
        else if(member.equalsIgnoreCase("no"))
        {
            //gets gas price per gallon for members
            gasSellPrice = getGasPrice();
            //subtotal = price per gallon * amount
            subtotal = gasSellPrice * gallons;
            //county tax
            countyTax = subtotal * COUNTYTAXRATE;
            //city tax
            cityTax = subtotal * CITYTAXRATE;
            //total is calculated with subtotal and taxes
            total = subtotal + cityTax + countyTax;
            //formats and prints
            formatTotalAndTax();
        }
        // unnecessary check to make sure the data entered into String member is either yes or no.
        // Could call main with recension but we have not learned that so the program exits
        else
        {
            //lazy man recursion
            System.out.println("Invalid quality or member input, please run again and use \"yes\" and \"no\" inputs or 87, 91, and 89 gas qualities");
            System.exit(0);
        }
    }
        //method getGasPrice
        //purpose check what quality of gas the user is buying and returns the double
        public static double getGasPrice()
        {
            if(quality == 87)
            {
                return GAS87;
            }
            else if(quality == 89)
            {
                return GAS89;
            }
            else if(quality == 91)
            {
                return GAS91;
            }
            return 0.0;
        }
        //method formatTotalAndTax
        //Purpose: To take in the data calculatd in the main method and format and print it. This method is used
        //to prevent repeated data from within the main as a result of the if statements.
        public static void formatTotalAndTax()
        {
            System.out.printf("\n\t\t%20s", "INVOICE FOR GASOLINE");
            System.out.printf("\n%20s %s", "Member Status:", member);
            System.out.printf("\n%20s %d @ %.2f", "Gasoline Sold/Price:", (int)gallons, gasSellPrice);
            System.out.printf("\n\n%20s $  %5.2f", "Subtotal:", subtotal);
            System.out.printf("\n%20s $  %5.2f", "County Tax:", countyTax);
            System.out.printf("\n%20s $  %5.2f", "City Tax:", cityTax);
            System.out.println("\n\t\t-------------");
            System.out.printf("%20s $  %5.2f", "Total:", total);
            System.out.println();
        }
}
