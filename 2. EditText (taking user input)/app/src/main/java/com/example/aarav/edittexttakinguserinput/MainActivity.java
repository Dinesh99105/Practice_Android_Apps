package com.example.aarav.edittexttakinguserinput;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    TextView messageDisplay;
    EditText getInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add your code below
        getInput=findViewById(R.id.input);
        messageDisplay =findViewById(R.id.message);

    }


    public void show(View v){

        String message;

        message=getInput.getText().toString();// geting text and converting the text into the string
        if(message!=null) {

         message="The name You Entered is " + message;

         messageDisplay.setText(message);

        }

    }

}
