import java.util.Scanner;

public class  DriverTest
{
    private static Scanner kb = new Scanner(System.in);
    private static final int MAXINPUTS = 20;
    public  static void main (String args[])
    {
        char[] answers = {'A', 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'B', 'C', 'C', 'C', 'C', 'C', 'D', 'D', 'D', 'D', 'D'};
        char[] userInput = new  char[MAXINPUTS];
        for(int i = 0; i < MAXINPUTS; i++)
        {
            userInput[i] = kb.nextLine().charAt(0);
        }

        int testGrade =  gradeExam(answers, userInput);
        if(testGrade >= 15)
        {
            System.out.println("Correct answers: " + testGrade + "\nIncorrect answers: " + (20-testGrade) + "\nYou passed the exam.");
        }
        else
        {
            System.out.println("Correct answers: " + testGrade + "\nIncorrect answers: " + (20-testGrade) + "\nYou failed the exam.");
        }

        int[] missedArray = makeMissedArray(answers,  userInput, 20-testGrade);
        System.out.println("You missed the following questions");
        for(int x : missedArray)
        {
            System.out.print(x+1 + " ");
        }

    }
    public static int gradeExam(char[] answerKey, char[] studentAnswers)
    {
        int answerTotal = 0;
        for(int i = 0; i < answerKey.length; i++)
        {
            if(Character.toLowerCase(answerKey[i]) == Character.toLowerCase(studentAnswers[i]))
            {
                answerTotal++;
            }
        }
        return answerTotal;
    }
    public  static int[] makeMissedArray(char[] answerKey, char[] studentAnswers, int numberIncorrect)
    {
        int[] returnArray = new int[numberIncorrect];
        int indexer =  0;
        for(int i = 0; i < answerKey.length; i++)
        {
            if(Character.toLowerCase(answerKey[i]) != Character.toLowerCase(studentAnswers[i]))
            {
                returnArray[indexer] = i;
                        indexer++;
            }
        }
        return returnArray;
    }

}