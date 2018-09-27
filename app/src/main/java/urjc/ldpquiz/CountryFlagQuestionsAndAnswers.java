package urjc.ldpquiz;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class CountryFlagQuestionsAndAnswers {

    private String question [] = {
            "Which of these is the Portuguese Flag?",
            "Which of these is the Spanish Flag?",
            "Which of these is the Italian Flag?"
    };

    private String answers [][] = {
            {"portugal_flag", "italy_flag", "spain_flag", "france_flag"},
            {"finland_flag", "greece_flag", "lithuania_flag", "spain_flag"},
            {"latvia_flag", "italy_flag", "lithuania_flag", "spain_flag"}
    };

    private String correctAnswers [] = {"portugal_flag", "spain_flag", "italy_flag"};

    private Vector<Integer> alreadySelectedQuestions = new Vector<>();

    public String getQuestion(int i){
        return question[i];
    }

    public String[] getShuffledAnswers(int i){
        List<String> list = Arrays.asList(answers[i]);
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

    public String getCorrectAnswer(int i){
        return correctAnswers[i];
    }

    public int getNumberOfQuestions(){
        return question.length;
    }

    public void addQuestionToSelectedOnes(int i){
        alreadySelectedQuestions.add(i);
    }

    public boolean checkForAlreadySelectedQuestion(int i){
        return alreadySelectedQuestions.contains(i)? true: false;
    }

    public boolean endOfGame(){
        return alreadySelectedQuestions.size() == question.length ? true : false;
    }
}
