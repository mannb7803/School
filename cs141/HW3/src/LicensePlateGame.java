//Ben MAnn
//CS141
//Assignment 4
//05/09/18

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LicensePlateGame {
    private static String userInput;
    private static Scanner kb = new Scanner(System.in);
    public static void main(String args[]) throws IOException
    {
        //sets words to returnArray from fillArray method
        ArrayList<String> words = fillArray("wordsEn.txt");
        //calls static runGame method
        runGame(words);
    }
    public static ArrayList<String> fillArray(String name) throws IOException
    {
        ArrayList<String> returnArray = new ArrayList<String>();
        File inputFile = new File(name);
        Scanner inputFileScanner = new Scanner(inputFile);
        while(inputFileScanner.hasNextLine())
        {
            returnArray.add(inputFileScanner.nextLine());
        }
        System.out.println(returnArray.get(returnArray.size()-1));
        return returnArray;
    }
    public static void runGame(ArrayList<String> words)
    {
        System.out.print("Please enter a 3 letter word: ");
        userInput = kb.nextLine().toLowerCase();
        System.out.print("Words that contain " + userInput + ": ");
        //tests for exit case
        if(userInput.equalsIgnoreCase("exit"))
        {
            System.exit(0);
        }
        //splits the string into 3 strings that are really should just be chars but i'm lazy and don't want to convert chars for comparison
        String[] userInputArray = userInput.split("");
        //for all strings in words arrayList
        for(String aWord : words)
        {
            //tests to make sure given user input was equal to 3
            if(userInputArray.length == 3)
            {
                //creates temp string tempString equal to current aWord
                String tempString = aWord;
                //tests to see if  tempString has the first of the 3 letters
                if(tempString.contains(userInputArray[0]))
                {
                    //sets tempString  to a new string without the previous letter as it exists
                    tempString = tempString.substring(0, tempString.indexOf(userInputArray[0])) + tempString.substring(tempString.indexOf(userInputArray[0])+1);
                    if(tempString.contains(userInputArray[1]))
                    {
                        //same as previous if statement
                        tempString = tempString.substring(0, tempString.indexOf(userInputArray[1])) + tempString.substring(tempString.indexOf(userInputArray[1])+1);
                        if(tempString.contains(userInputArray[2]))
                        {
                            //checks to see order of the letters occurring
                            if(aWord.indexOf(userInputArray[0]) <= aWord.indexOf(userInputArray[1]) && aWord.indexOf(userInputArray[1]) <= aWord.indexOf(userInputArray[2]))
                            {
                                System.out.print(aWord + " ");
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        //calls runGame with the words arrayList so that it continues to run
        runGame(words);
    }
}
