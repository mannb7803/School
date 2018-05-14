
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.asList;

//Ben Mann
//CS141
//Assignment 3
//04/24/18

public class GradeBook {
   private ArrayList<Student> studentObjects;
    public GradeBook(String s) throws IOException
    {
        //takes in csv file
        File f  = new File(s);
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            //takes in the lines of the csv file into string tempString
            String tempString = sc.nextLine();
            //splits tempString into array givenValuesArray using commas and .split
            String[] givenValuesArray = tempString.split(",");
            //takes givenValuesArray and translates it to givenValuesArraylist
            ArrayList<String> givenValuesArraylist = new ArrayList<>(Arrays.asList(givenValuesArray));
            if(givenValuesArraylist.size()-1 >= 2)
            {
                //calls add student with the index 0,1,2 containing names/ID and passes the Array to the studentObject so all students have their respective grades arrayList
                addStudent(new Student(givenValuesArraylist.get(0), givenValuesArraylist.get(1), givenValuesArraylist.get(2), givenValuesArraylist));
            }
        }
    }
    //removes student with given student ID in studentObjects arrayList
    public void removeStudent(int ID)
    {
        int tempIndex = 0;
        boolean remove = false;
        for(Student s : studentObjects)
        {
            if(s.getID() == ID)
            {
                //avoiding ConcurrentModificationException
               tempIndex = studentObjects.indexOf(s);
               remove = true;
            }
        }
        if(remove)
        {
            studentObjects.remove(tempIndex);
        }
        else
        {
            System.out.println("A student with the ID of " + ID + " does not exist.");
        }
    }
    //adds student objects to studentObjects arrayList
    public void addStudent(Student student)
    {
        if(studentObjects == null)
        {
            studentObjects = new ArrayList<Student>();
        }
        studentObjects.add(student);
    }
    //prints all objects in the studentObjects arrayList
    public String toString()
    {
        String returnString = "";
        for(Student x : studentObjects)
        {
            returnString = returnString + x;
        }
        return returnString;
    }
    public static void main (String args[])  throws IOException
    {
        //csv file
        GradeBook gb1 = new GradeBook("cs141grades.csv");

        //method tests
//        Grades grade1 = new Grades(1000000000, "this is a test");
//        gb1.studentObjects.get(5).addGrade(grade1);
//        gb1.removeStudent(1282712757);
        System.out.println(gb1 + " \n");
    }
}
