/**
 * Created by Ben on 4/11/2018.
 */
public class Student {
    private int grade;
    private String hwAssignment;
    public Student(String s, int i)
    {
        hwAssignment = s;
        grade = i;
    }
    public int getGrade()
    {
        return this.grade;
    }
    public String getHwAssignment()
    {
        return this.hwAssignment;
    }
    public  void  setGradE(int i)
    {
        grade = i;
    }
    public void setHwAssignment(String s)
    {
        hwAssignment = s;
    }
}
