import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Ben on 3/30/2018.
 */
public class test {
    public static void main (String args[]) throws IOException
    {
        File f1 = new File("files/queries-70s.dat");
        Scanner sc = new Scanner(f1);
        System.out.println(sc.nextLine());
    }
}
