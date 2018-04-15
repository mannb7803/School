import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Ben on 3/1/2018.
 */
public class Fileio {
    private static Scanner kb = new Scanner(System.in);
    private static String usersFile, userOutPutFileOneName, userOutPutFileTwoAppName, tempString;
    public static void main (String args[]) throws IOException
    {
        System.out.print("Enter input filename: ");
        usersFile = kb.nextLine();
        System.out.print("Enter output filename: ");
        userOutPutFileOneName = kb.nextLine();
        System.out.print("Enter another output filename(Append): ");
        userOutPutFileTwoAppName = kb.nextLine();
        System.out.println("Please check your files -- " + userOutPutFileOneName + ", " + userOutPutFileTwoAppName);

        File file = new File(usersFile);
        Scanner inputFile = new Scanner(file);
        PrintWriter userOutPutFileOne = new PrintWriter(userOutPutFileOneName);
        FileWriter userOutPutFileTwo= new FileWriter(userOutPutFileTwoAppName, true);
        PrintWriter userOutPutFileTwoAppend = new PrintWriter(userOutPutFileTwo);
        do {
            tempString = inputFile.nextLine().toUpperCase();
            userOutPutFileOne.println(tempString);
            userOutPutFileTwoAppend.println(tempString);
        }while(inputFile.hasNext());
        userOutPutFileOne.close();
        userOutPutFileTwo.close();
    }
}
