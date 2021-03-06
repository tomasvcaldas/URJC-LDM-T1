package urjc.ldpquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    private TextView score;
    private Button menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        score = (TextView) findViewById(R.id.score);

        int userScore = getIntent().getIntExtra("score",0);

        if(userScore<=0)
            score.setText("You lost");
        else score.setText(Integer.toString(userScore));

        menu = (Button) findViewById(R.id.menu);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndGameActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
