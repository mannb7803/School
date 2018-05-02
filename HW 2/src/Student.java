import java.awt.datatransfer.StringSelection;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ben on 4/11/2018.
 */
public class Student {
    private int ID;
    private ArrayList<Grades> gradeObjects;
    private String name;
    public Student(String fN, String  lN, String IDs, ArrayList<String> givenValuesArraylist)
    {
        this.name = lN + " "  + fN;
        this.ID = Integer.parseInt(IDs);
        for(int i = 0; i < 3; i++)
        {
            givenValuesArraylist.remove(0);
        }
        while(!(givenValuesArraylist.isEmpty()))
        {
            if((givenValuesArraylist.size() >= 1))
            {
                addGrade(new Grades(Integer.parseInt(givenValuesArraylist.get(1)), givenValuesArraylist.get(0)));
                givenValuesArraylist.remove(0);
                givenValuesArraylist.remove(0);
            }
        }
    }
    public String getName()
    {
        return this.name;
    }
    public int getID()
    {
        return this.ID;
    }
    public void addGrade(Grades grade)
    {
        if(gradeObjects == null)
        {
            gradeObjects =  new ArrayList<Grades>();
        }
        gradeObjects.add(grade);
    }
    public String toString()
    {
        String returnString = "\nStudent Name: " + this.getName() + " Student ID: " + this.getID() + getArrayList() + " ";
        return returnString;
    }
    public ArrayList<Grades> getArrayList()
    {
        return gradeObjects;
    }
}
