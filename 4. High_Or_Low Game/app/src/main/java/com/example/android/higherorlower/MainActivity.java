package com.example.android.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int  GeneratedNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rand = new Random();
        GeneratedNumber = rand.nextInt(30) + 1;

    }
    public void Submit(View view) {
        EditText ed = findViewById(R.id.Edit1);
        int UserGuess = Integer.parseInt(ed.getText().toString());
        if (GeneratedNumber > UserGuess)
            Toast.makeText(MainActivity.this, "Sorry, I'm Higher", Toast.LENGTH_SHORT).show();
        else if (GeneratedNumber < UserGuess)
            Toast.makeText(MainActivity.this, "Sorry, I'm Lower", Toast.LENGTH_SHORT).show();
        else {
            Toast.makeText(MainActivity.this, "HUraayyy!!..YOU GOT IT CORRECT!!", Toast.LENGTH_SHORT).show();
            Random rand = new Random();
            GeneratedNumber = rand.nextInt(30) + 1;

        }
    }
}
