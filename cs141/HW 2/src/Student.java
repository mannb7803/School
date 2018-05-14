import java.util.ArrayList;

//Ben Mann
//CS141
//Assignment 3
//04/24/18
public class Student {
    private int ID;
    private ArrayList<Grades> gradeObjects;
    private String name;
    //constructor that takes in strings for names, IDs, and the arrayList
    public Student(String fN, String  lN, String IDs, ArrayList<String> givenValuesArraylist)
    {
        this.name = lN + " "  + fN;
        this.ID = Integer.parseInt(IDs);
        //remove the FN/LN/ID index so that the remaining arrayList is purely the grades of each studentObject
        for(int i = 0; i < 3; i++)
        {
            givenValuesArraylist.remove(0);
        }
        while(!(givenValuesArraylist.isEmpty()))
        {
            //calls addGrade with that parses a string to an int and the assignment's String and then removes the two variables from the arrayList
            addGrade(new Grades(Integer.parseInt(givenValuesArraylist.get(1)), givenValuesArraylist.get(0)));
            givenValuesArraylist.remove(0);
            givenValuesArraylist.remove(0);

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
    public void setName(String name)
    {
        this.name = name;
    }
    public void setID(int ID)
    {
        this.ID = ID;
    }
    //adds grade to gradeObjects arrayList
    public void addGrade(Grades grade)
    {
        if(gradeObjects == null)
        {
            gradeObjects =  new ArrayList<Grades>();
        }
        gradeObjects.add(grade);
    }
    //converts the object to a string when called
    public String toString()
    {
        String returnString = "\n" + this.getName() + ", " + this.getID();
        for(Grades G : getArrayList())
        {
            returnString += G;
        }
        return returnString;
    }
    public ArrayList<Grades> getArrayList()
    {
        return gradeObjects;
    }
}
