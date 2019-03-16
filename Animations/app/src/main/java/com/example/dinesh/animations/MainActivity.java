package com.example.dinesh.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void fade (View view){
        ImageView bart  = findViewById(R.id.bart);
        ImageView homer  = findViewById(R.id.homer);
        bart.animate().alpha(1f).setDuration(2000);
        homer.animate().alpha(0f).setDuration(2000);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
