package urjc.ldpquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class EndGameActivity extends AppCompatActivity {

    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_game);

        score = (TextView) findViewById(R.id.score);
        score.setText(Integer.toString(getIntent().getIntExtra("score",0)));
    }
}
