package com.example.dinesh.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayer = 0;
     //0 for yellow and 1 for red
    boolean gameIsActive = true ;
    //2 means unplayed
    int[] gamestate ={2,2,2,2,2,2,2,2,2};
    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1000f);
        int tappedcounter = Integer.parseInt(counter.getTag().toString());
        if(gamestate[tappedcounter]==2 && gameIsActive) {
            gamestate[tappedcounter] = activeplayer;
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activeplayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activeplayer = 0;
            }
            for(int [] winningPosition : winningPositions){
                if(gamestate[winningPosition[0]]==gamestate[winningPosition[1]]
                        &&gamestate[winningPosition[1]]==gamestate[winningPosition[2]]
                        &&gamestate[winningPosition[0]]!=2){

                    gameIsActive= false;

                    //someone has won
                     String winner = "RED";
                     if (gamestate[winningPosition[0]]==0){
                         winner = "YELLOW";
                     }

                    TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage) ;
                     winnerMessage.setText(winner+"  has won!");
                    LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
                else{

                    boolean gameIsOver= true;
                    for(int counterState : gamestate){
                       if(counterState==2)
                           gameIsOver=false;

                    }
                    if(gameIsOver){

                        TextView winnerMessage = (TextView) findViewById(R.id.winnerMessage) ;
                        winnerMessage.setText(" Its a Draw!");
                        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(300);

        }
    }
    public void playAgain(View view){
        gameIsActive=true;
        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
        layout.setVisibility(View.INVISIBLE);
        activeplayer = 0;
        for(int i=0; i<gamestate.length;i++){
            gamestate[i]=2;
        }
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int i=0;i<gridLayout.getChildCount();i++){
            ((ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
