
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Ben on 4/11/2018.
 */
public class GradeBook {
    public GradeBook(String s) throws IOException
    {
        File f  = new File(s);
        Scanner sc = new Scanner(f);
        int newLine = 0;
        while(sc.hasNext())
        {
            System.out.println(sc.nextLine());
        }
    }
    public static void main (String args[])  throws IOException
    {
        GradeBook gb1 = new GradeBook("1.csv");
    }
}
