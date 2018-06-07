package com.shiv.connect4;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int activePlayer = 0;
    // initial state nothing in the blocks
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int[][] winningPositions = {{0,1,2},
                                {3,4,5},
                                {6,7,8},
                                {0,3,6},
                                {1,4,7},
                                {2,5,8},
                                {0,4,8},
                                {2,4,6}};

    String[] winning = {"012","345","678","036","147","258","048","246"};

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
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
