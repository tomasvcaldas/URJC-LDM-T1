package urjc.ldpquiz;

import android.graphics.drawable.Drawable;
import android.util.Log;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CapitalsQuestionsAndAnswers {

    private String questions [] = {
            "What is the national capital of Portugal?",
            "What is the national capital of Spain?",
            "What is the national capital of Poland?",
            "What is the national capital of Belgium?",
            "What is the national capital of France?",
    };

    private String answers [][] = {
            {"Porto","Lisbon","Viana do Castelo","Coimbra"},
            {"Madrid","Barcelona","Sevilha","Murcia"},
            {"Warsaw","Krakow","Wroclaw","Poznan"},
            {"Bruges","Brussels","Liège","Tielt"},
            {"Lyon","Nantes","Bordéus","Paris"}
    };

    private String correctAnswers [] = {
            "Lisbon","Madrid","Warsaw","Brussels","Paris",
    };

    private Vector<Integer> alreadySelectedQuestions = new Vector<>();

    public String getQuestion(int i){
        return questions[i];
    }

    public String[] getSuffledAnswers(int i){
        List<String> list = Arrays.asList(answers[i]);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

    public String getCorrectAnswer(int i){
        return correctAnswers[i];
    }

    public int getNumberOfQuestions(){
        return questions.length;
    }

    public void addQuestionToSelectedOnes(int i){
        alreadySelectedQuestions.add(i);
    }

    public boolean checkForAlreadySelectedQuestion(int i){
        return alreadySelectedQuestions.contains(i)? true: false;
    }

    public boolean endOfGame(){
        return alreadySelectedQuestions.size() == questions.length ? true : false;
    }
}
