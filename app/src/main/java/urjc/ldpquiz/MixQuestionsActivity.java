package urjc.ldpquiz;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MixQuestionsActivity extends AppCompatActivity {

    private CapitalsQuestionsAndAnswers capitalsQuestionsAndAnswers = new CapitalsQuestionsAndAnswers();
    private FlagsQuestionsAndAnswers flagsQuestionsAndAnswers = new FlagsQuestionsAndAnswers();


    private TextView scoreView;
    private TextView stepView;
    private TextView questionView;
    private Button answer1;
    private Button answer2;
    private Button answer3;
    private Button answer4;
    private ImageView flag;

    private String correctAnswer;
    private int score = 3;
    private int questionNumber = 0;
    private int currentQuestion = 0;

    Resources resources;
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
        flag = (ImageView) findViewById(R.id.flagIcon);
        stepView = (TextView) findViewById(R.id.step);
        resources = this.getResources();

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
            Toast.makeText(MixQuestionsActivity.this,"Correct Answer",Toast.LENGTH_SHORT).show();
            score++;
            updateScore(score);

            if(currentQuestion == 10){
                Toast.makeText(MixQuestionsActivity.this,"End Of Game",Toast.LENGTH_SHORT).show();
                endGame();
            }
            else {
                updateQuestion();
            }

        } else {
            Toast.makeText(MixQuestionsActivity.this,"Wrong Answer",Toast.LENGTH_SHORT).show();
            score-=2;
            updateScore(score);

        }
    }

    private void endGame(){
        Intent intent = new Intent(MixQuestionsActivity.this, EndGameActivity.class);
        intent.putExtra("score", score);
        startActivity(intent);
        finish();
    }

    private void updateQuestion(){
        String[] answers;
        if(currentQuestion % 2 == 0){
            generateRandomCapitalsQuestionNumber();
            questionView.setText(capitalsQuestionsAndAnswers.getQuestion(questionNumber));
            answers = capitalsQuestionsAndAnswers.getShuffledAnswers(questionNumber);
            flag.setVisibility(ImageView.INVISIBLE);
            currentQuestion++;
            correctAnswer = capitalsQuestionsAndAnswers.getCorrectAnswer(questionNumber);
        } else {
            generateRandomFlagsQuestionNumber();
            questionView.setText(flagsQuestionsAndAnswers.getQuestion());
            answers = flagsQuestionsAndAnswers.getShuffledAnswers(questionNumber);
            flag.setVisibility(ImageView.VISIBLE);
            final int resourceId = resources.getIdentifier(flagsQuestionsAndAnswers.getQuestionFlag(questionNumber),
                    "mipmap", this.getPackageName());


            flag.setImageDrawable(resources.getDrawable(resourceId));
            currentQuestion++;
            correctAnswer = flagsQuestionsAndAnswers.getCorrectAnswer(questionNumber);
        }
        answer1.setText(answers[0]);
        answer2.setText(answers[1]);
        answer3.setText(answers[2]);
        answer4.setText(answers[3]);

    }
    private void updateScore(int score){
        if(score <= 0)
            endGame();
        scoreView.setText("" + score);
    }

    private void generateRandomCapitalsQuestionNumber(){
        Random r = new Random();
        int low = 0;
        int high = capitalsQuestionsAndAnswers.getNumberOfQuestions();
        questionNumber = r.nextInt(high-low) + low;

        // Verification to disable repeated questions
        if (!capitalsQuestionsAndAnswers.checkForAlreadySelectedQuestion(questionNumber)){
            capitalsQuestionsAndAnswers.addQuestionToSelectedOnes(questionNumber);
            int newStep = Integer.parseInt(stepView.getText().toString()) + 1;
            stepView.setText(Integer.toString(newStep));
        } else {
            generateRandomCapitalsQuestionNumber();
        }
    }

    private void generateRandomFlagsQuestionNumber(){
        Random r = new Random();
        int low = 0;
        int high =flagsQuestionsAndAnswers.getNumberOfQuestions();
        questionNumber = r.nextInt(high-low) + low;

        // Verification to disable repeated questions
        if (!flagsQuestionsAndAnswers.checkForAlreadySelectedQuestion(questionNumber)){
            flagsQuestionsAndAnswers.addQuestionToSelectedOnes(questionNumber);
            int newStep = Integer.parseInt(stepView.getText().toString()) + 1;
            stepView.setText(Integer.toString(newStep));
        } else {
            generateRandomFlagsQuestionNumber();
        }
    }

}
