import java.util.Scanner;
public class Receipt
{
    public static void main (String args[])
    {
        Receipt run = new Receipt();
        Double price1, price2, price3;
        String item1, item2, item3;

        Scanner kb = new Scanner(System.in);
        System.out.println("Please enter item 1");
        item1 = kb.nextLine();
        System.out.println("Please enter the price of item 1");
        price1 = kb.nextDouble();
        kb.nextLine();
        System.out.println("Please enter item 2");
        item2 = kb.nextLine();
        System.out.println("Please enter the price of item 2");
        price2 = kb.nextDouble();
        kb.nextLine();
        System.out.println("Please enter item 3");
        item3 = kb.nextLine();
        System.out.println("Please enter the price of item 3");
        price3 = kb.nextDouble();
        double subtotal = price1+price2+price3;
        double tax = subtotal * 0.0625;
        double total = tax + subtotal;

        System.out.println("<<<<<<<<<<<<<<<<<<__Receipt__>>>>>>>>>>>>>>>>>");
        run.form(item1,price1);
        run.form(item2,price2);
        run.form(item3,price3);
        System.out.println("\n");
        run.form("Subtotal:", subtotal);
        run.form("Tax:", tax);
        run.form("Total:", total);
        System.out.println("\n__________________________________________");
        System.out.println("\n       * Thanks for your support *");
    }

    public void form (String item, double price)
    {
            System.out.printf("\n*%15s ........ %10.2f", item, price);
    }
}