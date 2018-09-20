package urjc.ldpquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    private Button capitalsGame;
    private Button flagsGame;
    private Button mixGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_quiz);

        capitalsGame = (Button) findViewById(R.id.capitals);
        flagsGame = (Button) findViewById(R.id.flags);
        mixGame = (Button) findViewById(R.id.mix);

        capitalsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myTag", "Play Capitals Game");
                Intent intent = new Intent(MenuActivity.this, CapitalsActivity.class);
                startActivity(intent);
                finish();
            }
        });

        flagsGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("myTag", "Play Flags Game");
                Intent intent = new Intent(MenuActivity.this, FlagsActivity.class);
                startActivity(intent);
                finish();

            }
        });

        mixGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("myTag", "Play Mix Game");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
