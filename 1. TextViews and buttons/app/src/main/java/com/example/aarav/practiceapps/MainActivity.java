package com.example.aarav.practiceapps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textToChange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textToChange = findViewById(R.id.textToManupulate);

    }


    public void buttonOnePressed(View variable){

        textToChange.setText("Button One is Pressed");
    }


    public void buttonTwoPressed(View varible){
        textToChange.setText("Button two is Pressed");

    }


    public void Reset(View var){

        textToChange.setText("Nothing Pressed Yet");

    }







}
