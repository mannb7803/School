import java.util.ArrayList;

/**
 * Created by Ben on 4/29/2018.
 */
public class test {
    public static void main (String args[])
    {
        int total = 0;
        int[][] numbers = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        for(int[] y: numbers)
        {
            for(int z : y)
            {
                total += z;
            }
        }
        System.out.println(total);
    }
}
