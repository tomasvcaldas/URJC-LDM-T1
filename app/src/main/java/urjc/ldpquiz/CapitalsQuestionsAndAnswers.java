package urjc.ldpquiz;
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
            "What is the national capital of Germany?",
            "What is the national capital of Austria?",
            "What is the national capital of Slovakia?",
            "What is the national capital of Hungary?",
    };

    private String answers [][] = {
            {"Porto","Lisbon","Viana do Castelo","Coimbra"},
            {"Madrid","Barcelona","Sevilha","Murcia"},
            {"Warsaw","Krakow","Wroclaw","Poznan"},
            {"Bruges","Brussels","Liège","Tielt"},
            {"Lyon","Nantes","Bordéus","Paris"},
            {"Munich","Frankfurt","Hamburg","Berlin"},
            {"Vienna","Gras","Zurich","Milan"},
            {"Ljubljana","Bratislava","Berlin","Budapeste"},
            {"Budapest","Bratislava","Ljubljana","Zurich"},

    };

    private String correctAnswers [] = {
            "Lisbon","Madrid","Warsaw","Brussels","Paris","Berlin","Vienna", "Bratislava", "Budapest"
    };

    private Vector<Integer> alreadySelectedQuestions = new Vector<>();

    public String getQuestion(int i){
        return questions[i];
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
