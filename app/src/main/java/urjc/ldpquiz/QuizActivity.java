package urjc.ldpquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private CapitalsQuestionsAndAnswers questionsAndAnswes = new CapitalsQuestionsAndAnswers();

    private TextView scoreView;
    private TextView stepView;
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
        stepView = (TextView) findViewById(R.id.step);

       updateQuestion();

        // Answer Button clicks handler
        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(answer1);}
        });

        answer2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(answer2);}
        });

        answer3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(answer3);}
        });

        answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(answer4);}
        });

    }

    private void checkAnswer(Button answer){
        if(answer.getText() == correctAnswer){
            Toast.makeText(QuizActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();
            score++;
            updateScore(score);

            if(questionsAndAnswes.endOfGame()){
                Toast.makeText(QuizActivity.this,"End Of Game",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(QuizActivity.this, EndGameActivity.class);
                intent.putExtra("score", score);
                startActivity(intent);
                finish();
            }
            else updateQuestion();

        } else {
            Toast.makeText(QuizActivity.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
            score-=2;
            updateScore(score);

        }
    }

    private void updateQuestion(){
        generateRandomQuestionNumber();

        questionView.setText(questionsAndAnswes.getQuestion(questionNumber));
        answer1.setText(questionsAndAnswes.getAnswer1(questionNumber));
        answer2.setText(questionsAndAnswes.getAnswer2(questionNumber));
        answer3.setText(questionsAndAnswes.getAnswer3(questionNumber));
        answer4.setText(questionsAndAnswes.getAnswer4(questionNumber));
        correctAnswer = questionsAndAnswes.getCorrectAnswer(questionNumber);

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
        if (!questionsAndAnswes.checkForAlreadySelectedQuestion(questionNumber)){
            questionsAndAnswes.addQuestionToSelectedOnes(questionNumber);
            int newStep = Integer.parseInt(stepView.getText().toString()) + 1;
            stepView.setText(Integer.toString(newStep));
        } else {
            generateRandomQuestionNumber();
        }
    }
}
