package urjc.ldpquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private QuestionsAndAnswes questionsAndAnswes = new QuestionsAndAnswes();

    private TextView scoreView;
    private TextView questionView;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    private String correctAnswer;
    private int score = 3;
    private int questionNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreView = (TextView)findViewById(R.id.score);
        questionView = (TextView)findViewById(R.id.question);
        answer1 = (Button)findViewById(R.id.answer_1);
        answer2 = (Button)findViewById(R.id.answer_2);
        answer3 = (Button)findViewById(R.id.answer_3);
        answer4 = (Button)findViewById(R.id.answer_4);

        updateQuestion();

        // Answer Button clicks handler
        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer1.getText() == correctAnswer){
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                    score++;
                    updateScore(score);
                    updateQuestion();

                } else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    score--;
                    updateScore(score);

                }
            }
        });

        answer2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer2.getText() == correctAnswer){
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                    score++;
                    updateScore(score);
                    updateQuestion();

                } else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    score--;
                    updateScore(score);

                }
            }
        });

        answer3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer3.getText() == correctAnswer){
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                    score++;
                    updateScore(score);
                    updateQuestion();

                } else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    score--;
                    updateScore(score);

                }
            }
        });

        answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(answer4.getText() == correctAnswer){
                    Toast.makeText(QuizActivity.this,"Correct",Toast.LENGTH_SHORT).show();
                    score++;
                    updateScore(score);
                    updateQuestion();

                } else {
                    Toast.makeText(QuizActivity.this,"Wrong",Toast.LENGTH_SHORT).show();
                    score--;
                    updateScore(score);

                }
            }
        });

    }

    private void updateQuestion(){
        questionView.setText(questionsAndAnswes.getQuestion(questionNumber));
        answer1.setText(questionsAndAnswes.getAnswer1(questionNumber));
        answer2.setText(questionsAndAnswes.getAnswer2(questionNumber));
        answer3.setText(questionsAndAnswes.getAnswer3(questionNumber));
        answer4.setText(questionsAndAnswes.getAnswer4(questionNumber));

        correctAnswer = questionsAndAnswes.getCorrectAnswer(questionNumber);
        generateRandomQuestionNumber();


    }
    private void updateScore(int score){
        scoreView.setText("" + score);
    }

    private void generateRandomQuestionNumber(){
        Random r = new Random();
        int low = 0;
        int high = questionsAndAnswes.getNumberOfQuestions();
        questionNumber = r.nextInt(high-low) + low;

        // Verification to disable repeated questions
        /*if (!questionsAndAnswes.checkForAlreadySelectedQuestion(result)){
            questionsAndAnswes.addQuestionToSelectedOnes(result);
            questionNumber = result;
        } else {
            generateRandomQuestionNumber();
        }*/
    }
}
