
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.util.Arrays.asList;

/**
 * Created by Ben on 4/11/2018.
 */
public class GradeBook {
   private ArrayList<Student> studentObjects;
    public GradeBook(String s) throws IOException
    {
        File f  = new File(s);
        Scanner sc = new Scanner(f);
        while(sc.hasNextLine())
        {
            String tempString = sc.nextLine();
            String[] givenValuesArray = tempString.split(",");
            ArrayList<String> givenValuesArraylist = new ArrayList<>(Arrays.asList(givenValuesArray));
            if(givenValuesArraylist.size()-1 >= 2)
            {
                addStudent(new Student(givenValuesArraylist.get(0), givenValuesArraylist.get(1), givenValuesArraylist.get(2), givenValuesArraylist));
            }
        }
    }
    public void removeStudent(int index)
    {
        if(studentObjects.size()-1 < index)
        {
            System.out.println("This index does not exist");
        }
        studentObjects.remove(index);
    }
    public void addStudent(Student student)
    {
        if(studentObjects == null)
        {
            studentObjects = new ArrayList<Student>();
        }
        studentObjects.add(student);
    }
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
        GradeBook gb1 = new GradeBook("1.csv");
        Grades grade1 = new Grades(1000000000, "this is a test");
        gb1.studentObjects.get(5).addGrade(grade1);
        gb1.removeStudent(0);
        System.out.println(gb1 + " \n");
    }
}
