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

    String[] winning = {"012","345","678","036","147","258","048","246"};

    String p = "";
    int a=0,b=0,c=0;

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
                a = Integer.parseInt(p[0]);
                b = Integer.parseInt(p[1]);
                c = Integer.parseInt(p[2]);

                if(gameState[a] == gameState[b] && gameState[b] == gameState[c] && gameState[a] != 2) {
                    if(gameState[a] == 0) {
                        Toast.makeText(this, "red wins", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(this, "yellow wins", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}
