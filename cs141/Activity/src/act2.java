
import java.util.ArrayList;
import java.util.Scanner;
public class act2 {
    private static Scanner kb = new Scanner(System.in);
    private static int s1,  s2, s3, s4, s5;
    public static void main (String args[])
    {
        ArrayList<Integer> sales = new ArrayList<Integer>();
        System.out.print("Please enter today's sales for store 1: ");
        s1 = kb.nextInt();
        System.out.print("Please enter today's sales for store 2: ");
        s2 = kb.nextInt();
        System.out.print("Please enter today's sales for store 3: ");
        s3 = kb.nextInt();
        System.out.print("Please enter today's sales for store 4: ");
        s4 = kb.nextInt();
        System.out.print("Please enter today's sales for store 5: ");
        s5 = kb.nextInt();

        sales.add(s1);
        sales.add(s2);
        sales.add(s3);
        sales.add(s4);
        sales.add(s5);

        for(int i = 0; i < sales.size(); i++)
        {
            System.out.print("Store " + (i+1) + " sale's: ");
            while(sales.get(i) / 100 >= 1)
            {
                sales.set(i, sales.get(i)-100);
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
