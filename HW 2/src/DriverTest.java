package cs140;
import java.util.Scanner;

public class DriverTest {
    public static int main (String[] args) {
        char[] answers = {'A', 'A', 'A', 'A', 'A',
                        'B', 'B', 'B', 'B', 'B',
                        'C', 'C', 'C', 'C', 'C',
                        'D', 'D', 'D', 'D', 'D'};
        int passingScore = 15;
        studentAns = new char[answers.length];
        Scanner key = new Scanner(System.in);
        String input;
        //getting answers from student
        for(int i = 0; i < answers.length; i++){
            System.out.print("Question " + (i+1) + ": ");
            input = key.nextLine();
            studentAns = input.charAt(0);
        }
        // execute method correctExam(total correct)
        System.out.println("** Correct answers: " + correctExam(studentAns, answers));
        //execute method gradeExam (total incorrect)
        System.out.println("** Incorrect answers: " + gradeExam(studentAns, answers));

        //execute method makeMissedArray(total questions missed)
        int[] missedQuestions = questionMissed(studentAns, answers);
        printmakeMissedArray(missedQuestions);

        //execute passed() function (does student pass?)
        if (passed) {
            System.out.print("** You passed the exam");
        else{
                System.out.println("** You failed the exam");
            }
        }

        // method for determining correct answers
        public static int correctExam ( char[] answersKey, char[] studentAnswers){
            int totalCorrect = 0;
            for (int i = 0; i < answersKey.length; i++) {
                if (studentAnswers[i] == Character.toUpperCase(answersKey[i]) ||
                        (studentAnswers[i] == Character.toLowerCase(answersKey[i]))){
                    totalCorrect++;
                }
            }
            return totalCorrect;
        }
        // method for determining incorrect answers
        public static int gradeExam ( char[]answersKey, char[]studentAnswers){
            int totalIncorrect = 0;
            for (int i = 0; i < answersKey.length; i++) {
                if (!(studentAnswers[i] == Character.toUpperCase(answersKey[i]) ||
                        (studentAnswers[i] == Character.toLowerCase(answersKey[i])))) {
                    totalIncorrect++;
                }
            }
            return totalIncorrect;

        }
        //check if student has passed the test
        public boolean passed(int passingScore){
            if (totalCorrect >= passingScore){
                return true;
            }
            return false;
        }
        //prints the values in a char array
        public static void printArray(char[] answersKey) {
            for (int row = 0; row < answersKey.length; row++) {
                System.out.print(answersKey[row] + " ");
            }
        }
        //check how many questions missed and print them
        public static int[] makeMissedArray(char[] answersKey, char[] studentAnswers, int numIncorrect){
            System.out.print("Questions missed: ");
            for(int row = 0; row < numIncorrect.length; row++){
                if (numIncorrect[row] != 0){
                    System.out.print(numIncorrect[row] + ",");
                }
            }

            System.out.println();

        }
    }
}



//        for (int i = 0; i < 20; i++) {
//            studentAnswers[i] = "";
//        }
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Enter your answers to the exam questions. ");
//
//        int rightAnswers = gradeExam(studentAnswers, answersKey);
//        System.out.println("Correct answers: " + rightAnswers);
//        System.out.println("Incorrect answers: " + (answersKey.length - rightAnswers));
//        boolean passFail = passed(rightAnswers, passGrade);
//        if (passFail) {
//            System.out.println("You passed the exam.");
//        } else {
//            System.out.println("You failed the exam.");
//        }
//        System.out.println("You missed the following questions: ");
//        int[] missed = makeMissedArray(studentAnswers, answerKey, (answerKey.length - rightAnswers));
//        for (int i = 0; i < missed.length; i++) {
//            System.out.println("Question " + (missed[i]) + " " + "Correct answer was " + (answerKey[missed[i] - 1]));
//        }
