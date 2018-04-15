/***************************************************************
 * file: Mann_Grading.java
 * author: B. Mann
 * class: CS 140 – Intro to cs
 *
 * assignment: program 5
 * date last modified: 3/2/2018
 *
 * purpose: This program takes a file input and splits it up into three files ids.txt, gpa.txt, ec.txt for each of the 3 different data types.
 * it does this to save the data to be accessed later through the methods that caluclate certain values based on the saved data
 * it then prints out all the data using printF
 *
 * Note: I used local scanners when calling the 3 storage files to reset their respective contents every time
 ****************************************************************/
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
public class Mann_Grading_BB{
    //declaring instance variables
    private static double mean, mode, min, max, gpa;
    private static Scanner inputFileScanner, idScanner, ecScanner, gpaScanner;
    private static PrintWriter idWriter, ecWriter, gpaWriter;
    private static int id, ec, numberOfValids, minID, maxID;
    private static boolean ignoring;
    private static File idFile, ecFile, gpaFile;
    public static void main (String args[]) throws IOException
    {
        //file names
        File fileName = new File("gradeInput.txt");
        //the 3 files below were used to store data in place of arrays, arraylists, lists, or an object!
        idFile = new File("ids.txt");
        ecFile = new File("ec.txt");
        gpaFile = new File("gpa.txt");
        idScanner = new Scanner(idFile);
        ecScanner = new Scanner(ecFile);
        gpaScanner = new Scanner(gpaFile);
        //calls validateFile with fileName passed through
        validateFile(fileName);
        //calls validateData with fileName passed through
        validateData(fileName);

        //uses printf to print
        printData();
    }
    //method validateFile
    //Purpose: checks if all the files that the program will use are present
    public static void validateFile(File inputFile)
    {
        //if all the files exist do nothing
        if(inputFile.exists() && idFile.exists() && ecFile.exists() && gpaFile.exists())
        {
           // System.out.println(inputFile.toString());
        }
        //if one of the files does not exist exit and print an error
        else
        {
            System.out.println("A file is missing, check given files");
            System.exit(0);
        }
    }
    //method validateData
    //Purpose: Check all the given data from the gradeInput.txt file to make sure it's the correct type and within the correct range and then saves it to its respective file
    public static void validateData(File inputFile) throws IOException
    {
        //numberOfValids is used to track how many inputs were valid
        numberOfValids = 0;
        inputFileScanner = new Scanner(inputFile);
        //Printerwiters for my 3 data storage classes
        idWriter = new PrintWriter(idFile);
        ecWriter = new PrintWriter(ecFile);
        gpaWriter = new PrintWriter(gpaFile);
        //do while loop to prevent the code from out of bounds erroring out
        do {
            //ignoring is used to see if the given line of input from inputFile should or should not be saved
            //any failure of data input results in ignoring being true which will skip saving the data
            ignoring = false;
            //temp values that are set equal to the inputs from inputFile and reset everytime the loop runs
            id = 0;
            ec = 0;
            gpa = 0.0;
            //this finds any letters in student IDs
            if(inputFileScanner.hasNextInt())
            {
                //sets id to the int, uses parse int to protect against data overflow or mismatch errors
                id = parseInt(inputFileScanner.next());
                //checks the bounds of ID
                if(id < 0 || id > 99999)
                {
                    System.out.println("Ignoring student with invalid ID number " + id);
                    ignoring = true;
                }
                //this finds any letters or incorrect data types in ec(extra credit)
                else if(inputFileScanner.hasNextInt())
                {
                    //checks the bounds of ec
                    ec = parseInt(inputFileScanner.next());
                    if(ec < 0 || ec > 5)
                    {
                        ignoring = true;
                        System.out.println("Ignoring student " + id + " with invalid extra credit " + ec);
                    }
                    //checks if gpa is a double to prevent similarly to the previous 2
                    else if(inputFileScanner.hasNextDouble())
                    {
                        gpa = Double.parseDouble(inputFileScanner.next());
                        //checks the bounds of GPA
                        if(gpa < 0.0 || gpa > 100.00)
                        {
                            System.out.println("Ignoring student " + id + " with invalid grade " + gpa);
                            ignoring = true;
                        }
                    }
                    //else statements for the above ifs
                    else
                    {
                        ignoring = true;
                        System.out.println("Ignoring student " + id + " with invalid grade " + gpa);
                    }
                }
                //else statements for the above ifs
                else
                {
                    ignoring = true;
                    System.out.println("Ignoring student " + id + " with invalid extra credit " + ec);
                }
            }
            //else statements for the above ifs
            else
            {
                ignoring = true;
              System.out.println("Ignoring student with invalid ID number " + inputFileScanner.next());
            }
                //moves the program forward, in if statement to prevent out of bounds
            if(inputFileScanner.hasNextLine())
            {
                inputFileScanner.nextLine();
            }
            //checks ignoring, if true then adds one to number of valid input as this is a vlid input and prints the current id, ec, and gpa values to their respective files
            if(ignoring == false)
            {
               // System.out.println(ignoring);
                numberOfValids++;
                   idWriter.println(id);
                   ecWriter.println(ec);
                   gpaWriter.println(gpa);
            }
          //  System.out.println(id + " " + ec + " " + gpa); testing
        }while(inputFileScanner.hasNextLine());
        idWriter.close();
        ecWriter.close();
        gpaWriter.close();
        //cloes the PrintWriters used to save the data
    }
    //method mean
    //purpose: To calculate the mean of either the normal or enhanced gpas of students and return in
    public static double mean(Boolean gradeType) throws IOException
    {
        //resets value of mean
        mean = 0;
        //if true calculate normal grade
        if(gradeType)
        {
            //local scanners reads the gpaFile which was printed to by the validate data file
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            //while has nextDouble in the file gpaFile
            while(gpaScannerLocal.hasNextDouble())
            {
                //totals all valid gpas
                mean += gpaScannerLocal.nextDouble();
            }
            //divides gpas by the total number of valid inputs
            mean /= numberOfValids;
            //closes the local scanner used for gpaFile
            gpaScannerLocal.close();
        }
        //else calculate enhanced grade
        //same as above but uses another scanner for the extracredit file and adds it to the total mean before dividing
        else
        {   Scanner ecScannerLocal = new Scanner(ecFile);
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            while(gpaScannerLocal.hasNextDouble())
            {
                mean += gpaScannerLocal.nextDouble() + ecScannerLocal.nextInt();
            }
            gpaScannerLocal.close();
            ecScannerLocal.close();
            mean /= numberOfValids;
        }
        return mean;
    }
    //method mode
    //purpose: calculate the mode of either the normal or enahnced gpas of students and return it
    public static double mode(Boolean gradeType) throws IOException
    {
        //resets mode value to 0
        mode = 0;
        //currentModetemp is the current mode's times of occurrence
        int currentModeTemp =0;
        //testMode is the current test mode
        double testMode;
        //local scanners for the ecFile and gpaFile
        Scanner ecScannerLocal = new Scanner(ecFile);
        Scanner gpaScannerLocal = new Scanner(gpaFile);
        if(gradeType)
        {
            //this while loop uses gpaScannerLocal
            //nested while loops
            while(gpaScannerLocal.hasNextDouble())
            {
                //temp is current test values times of occurrence
                int temp = 0;
                //sets the current mode to
                testMode = gpaScannerLocal.nextDouble();
                Scanner gpaScannerLocalTwo = new Scanner(gpaFile);
                //this while loop uses gpaScannerLocalTwo to prevent data loss
                //runs through all values to gpa
                while(gpaScannerLocalTwo.hasNextDouble())
                {
                    //compares the current test mode to all values of gpa counting the amount of times it occurs
                    if(testMode == gpaScannerLocalTwo.nextDouble())
                    {
                        temp++;
                    }
                    //if the current tested mode has occured more than the current mode did replace mode with test mode a nd currentModeTemp with temp
                    if(temp > currentModeTemp)
                    {
                       currentModeTemp = temp;
                        mode = testMode;
                    }
                }
                //closes local scanners
                gpaScannerLocalTwo.close();
            }
            gpaScannerLocal.close();
            ecScannerLocal.close();
        }
        //same as above but includes the ec scanner and adds it to test mode
        else
        {
            while(gpaScannerLocal.hasNextDouble())
            {
                int temp = 0;
                testMode = gpaScannerLocal.nextDouble() + ecScannerLocal.nextInt();
                Scanner gpaScannerLocalTwo = new Scanner(gpaFile);
                Scanner ecScannerLocalTwo = new Scanner(ecFile);
                while(gpaScannerLocalTwo.hasNextDouble())
                {
                    if(testMode == (gpaScannerLocalTwo.nextDouble() + ecScannerLocalTwo.nextInt()))
                    {
                        temp++;
                    }
                    if(temp > currentModeTemp)
                    {
                        currentModeTemp = temp;
                        mode = testMode;
                    }
                }
                gpaScannerLocalTwo.close();
                ecScannerLocalTwo.close();
            }
            gpaScannerLocal.close();
            ecScannerLocal.close();
        }
        return mode;
    }
    //method min
    //purpose compare all GPAS to each other to find the lowest GPA and the student with the lowest grades id
    public static double min(Boolean gradeType) throws IOException
    {
        //sets min to a higher value than any possible gpa
        min = 1000;
        //currentMinIDused is an instanced int used to track the ID of the current lowest gpa and will be called when printfing in the printData() method
        int currentMinID = 0;
        //currentMin is used to store the current test GPA to see if it's lower than the current value of min
        double currentMin;
        if(gradeType)
        {
            //again uses local scanners to have a complete data set
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            Scanner idScannerLocal = new Scanner(idFile);
            while(gpaScannerLocal.hasNextDouble())
            {
                currentMin = gpaScannerLocal.nextDouble();
                currentMinID = idScannerLocal.nextInt();
                if(currentMin < min)
                {
                    //sets min and minID
                    min = currentMin;
                    minID = currentMinID;
                }
            }
            //closes local
            gpaScannerLocal.close();
            idScannerLocal.close();
        }
        //same as above but includes ec scanner and adds it to the current min
        else
        {
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            Scanner idScannerLocal = new Scanner(idFile);
            Scanner ecScannerLocal = new Scanner(ecFile);
            while(gpaScannerLocal.hasNextDouble())
            {
                currentMin = gpaScannerLocal.nextDouble() + ecScannerLocal.nextInt();
                currentMinID = idScannerLocal.nextInt();
                if(currentMin < min)
                {
                    min = currentMin;
                    minID = currentMinID;
                }
            }
            gpaScannerLocal.close();
            idScannerLocal.close();
            ecScannerLocal.close();
        }
        return min;
    }
    //method max
    //purpose: compare all GPAS to each other to find the highest GPA and the student with the highest grades id
    public static double max(Boolean gradeType) throws IOException
    {
        //exact same as min but the math is reversed instead of currentMin < min it's currentMax > max
        max = 0;
        int currentMaxID = 0;
        double currentMax;
        if(gradeType)
        {
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            Scanner idScannerLocal = new Scanner(idFile);
            while(gpaScannerLocal.hasNextDouble())
            {
                currentMax = gpaScannerLocal.nextDouble();
                currentMaxID = idScannerLocal.nextInt();
                if(currentMax > max)
                {
                    max = currentMax;
                    maxID = currentMaxID;
                }
            }
            gpaScannerLocal.close();
            idScannerLocal.close();

        }
        else
        {
            Scanner gpaScannerLocal = new Scanner(gpaFile);
            Scanner idScannerLocal = new Scanner(idFile);
            Scanner ecScannerLocal = new Scanner(ecFile);
            while(gpaScannerLocal.hasNextDouble())
            {
                currentMax = gpaScannerLocal.nextDouble() + ecScannerLocal.nextInt();
                currentMaxID = idScannerLocal.nextInt();
                if(currentMax > max)
                {
                    max = currentMax;
                    maxID = currentMaxID;
                }
            }
            gpaScannerLocal.close();
            idScannerLocal.close();
            ecScannerLocal.close();
        }
        return max;
    }
    //method printData
    //purpose Use printf and data from calling the above methods to produce a clear report
    public static void printData() throws IOException {
        //new line -> 25space string -> float to the hundredths place
        System.out.printf("\n%25s %.2f","Mean Earned Grade:",mean(true));
        System.out.printf("\n%25s %.2f","Mean Enhanced Grade:",mean(false));
        System.out.printf("\n\n%25s %.2f","Mode Earned Grade:",mode(true));
        System.out.printf("\n%25s %.2f","Mode Enhanced Grade:",mode(false));
        //new line -> 25space string -> float to the hundredths place -> student ID of the min/max grade
        System.out.printf("\n\n%25s %.2f (Student %5d)", "Minimum Earned Grade:", min(true),minID);
        System.out.printf("\n%25s %.2f (Student %5d)", "Minimum Enhanced Grade:", min(false),minID);
        System.out.printf("\n\n%25s %.2f (Student %5d)", "Maximum Earned Grade:", max(true),maxID);
        System.out.printf("\n%25s %.2f (Student %5d)\n", "Maximum Enhanced Grade:", max(false),maxID);
    }
}
