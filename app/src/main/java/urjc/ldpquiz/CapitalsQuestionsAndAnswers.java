package urjc.ldpquiz;

import android.graphics.drawable.Drawable;
import android.util.Log;

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
