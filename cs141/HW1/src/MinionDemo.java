//Ben Mann
//CS141
//Assignment 1
//03/26/18

public class MinionDemo {
    public static void main (String []args)
    {
        System.out.println("HW1: Minion Demo\n");
        //initializing 3 Minion objects with set user inputs
        Minion m1 = new Minion(2, "BANANA!", "Kevin");
        Minion m2 = new Minion(2, "BABOI!", "Bob");
        Minion m3 = new Minion(1, "SA LA KA!", "Stuart");

        //form of .toString(); that takes in a string for what number the minion is
        System.out.println(m1.printMinion("first"));
        System.out.println(m2.printMinion("second"));
        System.out.println(m3.printMinion("third") + "\n");

        //printing all the minions catchphrase
        m1.printCatchPhrase();
        m2.printCatchPhrase();
        m3.printCatchPhrase();
    }
}