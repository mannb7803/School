//Ben Mann
//CS141
//Assignment 3
//04/24/18
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
    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
    public String toString() {
        String returnString = ", "+ this.getAssignment() + ", " +  this.getGrade();
        return returnString;
    }
}
