package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button lettersBtn, colorsBtn, coloringBookBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lettersBtn = (Button) findViewById(R.id.learn_letters_btn);
        lettersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LearnLettersStart.class);
                startActivity(intent);
            }
        });
        colorsBtn = (Button) findViewById(R.id.learn_colors_btn);
        colorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LearnColorsStart.class);
                startActivity(intent);
            }
        });
        coloringBookBtn = (Button) findViewById(R.id.coloring_book_btn);
        coloringBookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ColoringBookHome.class);
                startActivity(intent);
            }
        });
    }
}