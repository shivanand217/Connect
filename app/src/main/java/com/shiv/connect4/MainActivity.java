package com.shiv.connect4;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int activePlayer = 0;
    // initial state nothing in the blocks
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    String[] winning = {"012","345","678","036","147","258","048","246"};

    String p = "";
    int a = 0, b = 0, c = 0;

    public void dropIn(View view) {
        ImageView counter = (ImageView) view;

        String tag = counter.getTag().toString();
        int Tag = Integer.parseInt(tag);
        System.out.println(Tag);

        Toast.makeText(this, "This tag is "+tag+" !!!", Toast.LENGTH_LONG).show();

        if(gameState[Tag] == 2) {
            gameState[Tag] = activePlayer;

            counter.setTranslationY(1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1 - activePlayer;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 1 - activePlayer;
            }

            counter.animate()
                    .translationYBy(-1000f)
                    .rotation(1000f)
                    .setDuration(500);

            for(int i=0; i < winning.length; i++) {
                p = winning[i];
                a = Integer.parseInt(String.valueOf(p.charAt(0)));
                b = Integer.parseInt(String.valueOf(p.charAt(1)));
                c = Integer.parseInt(String.valueOf(p.charAt(2)));

                if(gameState[a] == gameState[b] && gameState[b] == gameState[c] && gameState[a] != 2) {

                    // someone has won
                    if(gameState[a] == 0) {
                        Toast.makeText(this, "yellow wins", Toast.LENGTH_LONG).show();

                        TextView wins = (TextView) findViewById(R.id.textView2);
                        wins.setText("Yellow wins");
                        wins.setAlpha(1);

                        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                        playAgainButton.setAlpha(1);

                    } else {
                        Toast.makeText(this, "red wins", Toast.LENGTH_SHORT).show();

                        TextView wins = (TextView) findViewById(R.id.textView2);
                        wins.setText("Red wins");
                        wins.setAlpha(1);

                        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                        playAgainButton.setAlpha(1);
                    }
                }
            }
        }
    }

    /** Reset the board **/
    public void playAgainClicked(View view) {

        TextView wins = (TextView) findViewById(R.id.textView2);
        wins.setText("");
        wins.setAlpha(0);

        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        playAgainButton.setAlpha(0);

        activePlayer = 0;

        for(int i=0; i < gameState.length; i++) {
            gameState[i]=2;
        }

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        for(int i=0; i < gridLayout.getChildCount(); i++) {
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
