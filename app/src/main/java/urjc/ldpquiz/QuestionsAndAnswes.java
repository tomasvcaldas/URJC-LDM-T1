package urjc.ldpquiz;

import android.util.Log;

import java.util.Vector;

public class QuestionsAndAnswes {

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
        String question = questions[i];
        return question;
    }

    public String getAnswer1(int i){
        String answer1 = answers[i][0];
        return answer1;
    }

    public String getAnswer2(int i){
        String answer2 = answers[i][1];
        return answer2;
    }

    public String getAnswer3(int i){
        String answer3 = answers[i][2];
        return answer3;
    }

    public String getAnswer4(int i){
        String answer4 = answers[i][3];
        return answer4;
    }

    public String getCorrectAnswer(int i){
        String correctAnswer = correctAnswers[i];
        return correctAnswer;
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
