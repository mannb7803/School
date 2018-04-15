
/**
 * Created by Ben on 3/1/2018.
 */
public class Pattern {
    public static void main (String args[])
    {
        int print = 7;
        for(int i = 0; i < 6; i++)
        {
            for(int j = 1; j < print ; j++)
            {
                System.out.print(j + " ");
            }
            System.out.println();
            print--;
        }
    }
}
