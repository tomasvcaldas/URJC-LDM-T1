package urjc.ldpquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Arrays;
import java.util.Random;

public class CountryFlagActivity extends AppCompatActivity {

    private CountryFlagQuestionsAndAnswers questionsAndAnswers= new CountryFlagQuestionsAndAnswers();

    private TextView scoreView;
    private TextView stepView;
    private TextView questionView;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;

    private String correctAnswer;
    private int correctAnswerIndex;
    private int score = 3;
    private int questionNumber = 0;
    private ImageView restartGame;

    private Resources resources;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        scoreView = (TextView)findViewById(R.id.score);
        questionView = (TextView)findViewById(R.id.question);
        answer1 = (Button) findViewById(R.id.answer_1);
        answer2 = (Button)findViewById(R.id.answer_2);
        answer3 = (Button)findViewById(R.id.answer_3);
        answer4 = (Button)findViewById(R.id.answer_4);
        stepView = (TextView) findViewById(R.id.step);
        restartGame = (ImageView) findViewById(R.id.restart);

        restartGame.setVisibility(View.INVISIBLE);

        resources = this.getResources();

        updateQuestion();

        // Answer Button clicks handler
        answer1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(0);}
        });

        answer2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(1);}
        });

        answer3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(2);}
        });

        answer4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){checkAnswer(3);}
        });

        restartGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(CountryFlagActivity.this, CountryFlagActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    private void checkAnswer(int buttonIndex){

        if(buttonIndex == correctAnswerIndex){
            Toast.makeText(CountryFlagActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();
            score=score+3;
            updateScore(score);

            if(questionsAndAnswers.endOfGame()){
                Toast.makeText(CountryFlagActivity.this,"End Of Game",Toast.LENGTH_SHORT).show();
                endGame();
            }
            else updateQuestion();

        } else {
            restartGame.setVisibility(View.VISIBLE);
            Toast.makeText(CountryFlagActivity.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
            score-=2;
            updateScore(score);

        }
    }

    private void endGame(){
        Intent intent = new Intent(CountryFlagActivity.this, EndGameActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    private void updateQuestion(){
        generateRandomQuestionNumber();

        questionView.setText(questionsAndAnswers.getQuestion(questionNumber));

        String[] answers = questionsAndAnswers.getShuffledAnswers(questionNumber);

        answer1.setCompoundDrawablesWithIntrinsicBounds(null, resources.getDrawable(resources.getIdentifier(answers[0],
                "mipmap", this.getPackageName())) , null, null);

        answer2.setCompoundDrawablesWithIntrinsicBounds(null, resources.getDrawable(resources.getIdentifier(answers[1],
                "mipmap", this.getPackageName())) , null, null);

        answer3.setCompoundDrawablesWithIntrinsicBounds(null, resources.getDrawable(resources.getIdentifier(answers[2],
                "mipmap", this.getPackageName())) , null, null);

        answer4.setCompoundDrawablesWithIntrinsicBounds(null, resources.getDrawable(resources.getIdentifier(answers[3],
                "mipmap", this.getPackageName())) , null, null);

        correctAnswer = questionsAndAnswers.getCorrectAnswer(questionNumber);
        correctAnswerIndex = Arrays.asList(answers).indexOf(correctAnswer);
    }
    private void updateScore(int score){
        if(score <= 0)
            endGame();
        scoreView.setText("" + score);
    }

    private void generateRandomQuestionNumber(){
        Random r = new Random();
        int low = 0;
        int high = questionsAndAnswers.getNumberOfQuestions();
        questionNumber = r.nextInt(high-low) + low;

        // Verification to disable repeated questions
        if (!questionsAndAnswers.checkForAlreadySelectedQuestion(questionNumber)){
            questionsAndAnswers.addQuestionToSelectedOnes(questionNumber);
            int newStep = Integer.parseInt(stepView.getText().toString()) + 1;
            stepView.setText(Integer.toString(newStep));
        } else {
            generateRandomQuestionNumber();
        }
    }
}
