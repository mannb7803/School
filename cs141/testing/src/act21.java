/**
 * Created by Ben on 5/21/2018.
 */
public class act21 {
    public  static  void main (String args[])
    {
        message(10);
    }
    public static void message(int i)
    {
        if(i == 3)
        {
            System.out.println("The recursion has ended");
        }
        else {


            System.out.println("This is a recursive method.");
            message(i - 1);
        }
    }
}
