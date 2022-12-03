package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lettersBtn, colorsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lettersBtn = (Button) findViewById(R.id.learn_letters_btn);
        lettersBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LearnLettersStart.class);
            startActivity(intent);
        });

        colorsBtn = (Button) findViewById(R.id.learn_colors_btn);
        colorsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LearnColorsStart.class);
            startActivity(intent);
        });
    }
}