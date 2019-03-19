package com.example.dinesh.braintrainer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button0;
    Button button1;
    Button button2;
    Button button3;

    TextView sumTextView;

    Button startButton;

    ArrayList <Integer> answers = new ArrayList<Integer>();

    int score=0;

    int numberOfQuestion=0;

    TextView resultTextView;

    TextView pointsTextView;

    int locationOfCorrectAnswer;

    TextView timerTextView;

    Button playAgainButton;

    RelativeLayout gameRelativeLayout;



    public void playAgain(View view){

        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestion();
        score =0;
        numberOfQuestion=0;
        timerTextView.setText("30s");
        pointsTextView.setText("0/0");
        resultTextView.setText("");

        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                playAgainButton.setVisibility(View.VISIBLE);
                timerTextView.setText("0s");
                resultTextView.setText("Your Score : " + Integer.toString(score) + "/" + Integer.toString(numberOfQuestion) );
            }
        }.start();
    }

    public void chooseAnswer(View view){

        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAnswer))){

            score++;
            resultTextView.setText("Correct!");

        }
        else{
            resultTextView.setText("Wrong!");
        }
        numberOfQuestion++;
        pointsTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        generateQuestion();
    }

    public void generateQuestion(){

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a)+ " + "+Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        int incorrectanswers;

        for(int i =0;i<4;i++){
            if(i==locationOfCorrectAnswer){
                answers.add(a+b);
            }
            else{
                incorrectanswers= rand.nextInt(41);
                while(incorrectanswers == a+b){
                    incorrectanswers = rand.nextInt(41);
                }
                answers.add(incorrectanswers);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }

    public void start(View view) {

        startButton.setVisibility(View.INVISIBLE);

        gameRelativeLayout.setVisibility(RelativeLayout.VISIBLE);

        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = (Button) findViewById(R.id.startButton);

        sumTextView = (TextView) findViewById(R.id.sumTextView);

        resultTextView= (TextView)  findViewById(R.id.resultTextView);

        pointsTextView= (TextView)  findViewById(R.id.pointsTextView);

        playAgainButton = (Button)  findViewById(R.id.playAgainButton);

        gameRelativeLayout = (RelativeLayout) findViewById(R.id.gameRelativeLayout);

        timerTextView = (TextView) findViewById(R.id.timerTextView) ;

         button0 = (Button) findViewById(R.id.button0);
         button1 = (Button) findViewById(R.id.button1);
         button2 = (Button) findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);

    }


}