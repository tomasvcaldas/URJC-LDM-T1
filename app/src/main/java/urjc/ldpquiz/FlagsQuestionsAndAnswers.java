package urjc.ldpquiz;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class FlagsQuestionsAndAnswers {

    private String question = "Which country has this flag?";

    private String flags [] = {"portugal_flag", "spain_flag", "italy_flag"};

    private String answers [][] = {
            {"Portugal", "Italy", "Spain", "Poland"},
            {"France", "Italy", "Spain", "Australia"},
            {"Peru", "Italy", "Spain", "Mexico"},
    };

    private String correctAnswers [] = {"Portugal", "Spain", "Italy"};

    private Vector<Integer> alreadySelectedQuestions = new Vector<>();

    public String getQuestion(){
        return question;
    }

    public String getQuestionFlag(int i) { return flags[i]; }

    public String[] getSuffledAnswers(int i){
        List<String> list = Arrays.asList(answers[i]);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
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
