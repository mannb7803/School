import java.util.Scanner;

/**
 * Created by Ben on 5/21/2018.
 */
public class act19 {
    private static Scanner sc =  new Scanner(System.in);
    private static int[] intArray = new int[5];
    public static void main(String args[])
    {
        enterNumbers();
        printIntArray();
    }
    public static void  enterNumbers()
    {
        for(int i =  0; i <= intArray.length; i++)
        {
            try{
                System.out.println("Enter a number");
                int userInput = sc.nextInt();
                try{
                    checkDuplicate(userInput);
                    intArray[i] = userInput;
                }
                catch(DuplicateValueException a)
                {
                    System.out.println(a.getMessage());
                }


            }
            catch(ArrayIndexOutOfBoundsException a)
            {
                System.out.println("The array is full");
            }
        }
    }
    public  static void printIntArray()
    {
        for(int x : intArray)
        {
            System.out.println(x + " ");
        }
    }
    public static void checkDuplicate(int val) throws DuplicateValueException
    {
       for(int i = 0; i < intArray.length; i++)
       {
           if(intArray[i] == val)
           {
               throw new DuplicateValueException();
           }
       }
    }
}
