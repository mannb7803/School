/**
 * Created by Ben on 4/11/2018.
 */
public class Grades {
    private int grade;
    private  String assignment;
    public Grades(int grade, String assignment) {
        this.grade = grade;
        this.assignment = assignment;
    }
    public int getGrade() {
        return grade;
    }
    public String getAssignment() {
        return assignment;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public String toString() {
        String returnString = " Assignment: " + this.getAssignment() + " Grade: " +  this.getGrade() + " ";
        return returnString;
    }
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
