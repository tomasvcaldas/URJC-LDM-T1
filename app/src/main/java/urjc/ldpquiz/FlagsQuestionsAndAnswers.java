package urjc.ldpquiz;

import android.graphics.drawable.Drawable;

import java.util.Vector;

public class FlagsQuestionsAndAnswers {

    private String question = "Which country has this flag?";

    private String flags [] = {"portugal_flag", "spain_flag"};

    private String answers [][] = {
            {"Portugal", "Italy", "Spain", "Poland"},
            {"France", "Italy", "Spain", "Australia"}
    };

    private String correctAnswers [] = {"Portugal", "Spain"};

    private Vector<Integer> alreadySelectedQuestions = new Vector<>();

    public String getQuestion(){
        return question;
    }

    public String getQuestionFlag(int i) { return flags[i]; }

    public String getAnswer1(int i){
        return answers[i][0];
    }

    public String getAnswer2(int i){
        return answers[i][1];
    }

    public String getAnswer3(int i){
       return answers[i][2];
    }

    public String getAnswer4(int i){
        return answers[i][3];
    }

    public String getCorrectAnswer(int i){
        return correctAnswers[i];
    }

    public int getNumberOfQuestions(){
        return flags.length;
    }

    public void addQuestionToSelectedOnes(int i){
        alreadySelectedQuestions.add(i);
    }

    public boolean checkForAlreadySelectedQuestion(int i){
        return alreadySelectedQuestions.contains(i)? true: false;
    }

    public boolean endOfGame(){
        return alreadySelectedQuestions.size() == flags.length ? true : false;
    }
}
