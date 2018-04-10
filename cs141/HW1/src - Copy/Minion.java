//Ben Mann
//CS141
//Assignment 1
//03/26/18
public class Minion {
    private int eyes;
    private String catchPhrase, name;
    //empty constructor;
    public Minion()
    {

    }
    //constructor with int, String, String
    public Minion(int e, String c, String n)
    {
        catchPhrase = c;
        eyes = e;
        name = n;
    }
    //getters that return their given values
    public String getName()
    {
        return name;
    }
    public int getEyes()
    {
        return eyes;
    }
    public String getCatchPhrase()
    {
       return catchPhrase;
    }

    //setters that set their given values to a given variable
    public void setName(String n)
    {
        name = n;
    }
    public void setEyes(int e)
    {
        eyes = e;
    }
    public void setCatchPhrase(String c)
    {
        catchPhrase = c;
    }

    //prints the catch phrase of a given Minion object
    public void printCatchPhrase()
    {
        System.out.println(this.getName() + "\'s catchphrase is: " + this.getCatchPhrase());
    }
    //i would have used .toString() but i needed the minionNumber and i think it's a convention to have toString take in nothing
    public String printMinion(String minionNumber)
    {
        return "The " + minionNumber +" minion is called " + this.getName() + ", and he has " + this.getEyes() + " eyes.";
    }
}
