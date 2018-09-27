package urjc.ldpquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button capitalsGame;
    private Button flagsGame;
    private Button flagsGameII;
    private Button mixGame;
    private Button exitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_quiz);

        capitalsGame = (Button) findViewById(R.id.capitals);
        flagsGame = (Button) findViewById(R.id.flags);
        mixGame = (Button) findViewById(R.id.mix);
        exitGame = (Button) findViewById(R.id.exit);
        flagsGameII = (Button) findViewById(R.id.flags2);

        capitalsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CapitalsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        flagsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, FlagsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        flagsGameII.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, CountryFlagActivity.class);
                startActivity(intent);
                finish();
            }
        });

        mixGame.setOnClickListener(new View.OnClickListener() {
                @Override
            public void onClick(View v){
                    Intent intent = new Intent(MenuActivity.this, MixQuestionsActivity.class);
                    startActivity(intent);
                    finish();
                }
        });

        exitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


    }
}
