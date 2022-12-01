package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    Button mainMenuBtn;
    Button topLeftBtn, topRightBtn, bottomLeftBtn, bottomRightBtn;
    TextView pointsLabel;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pointsLabel = (TextView) findViewById(R.id.points_label);

        mainMenuBtn = (Button) findViewById(R.id.main_menu_btn);
        mainMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuizActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        topLeftBtn = (Button) findViewById(R.id.top_left);
        topLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is the top left button");
                changePoints(true);
            }
        });
        topRightBtn = (Button) findViewById(R.id.top_right);
        topRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is the top right button");
                changePoints(true);
            }
        });
        bottomLeftBtn = (Button) findViewById(R.id.bottom_left);
        bottomLeftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is the bottom left button");
                changePoints(false);
            }
        });
        bottomRightBtn = (Button) findViewById(R.id.bottom_right);
        bottomRightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("This is the bottom right button");
                changePoints(false);
            }
        });
    }

    private void changePoints(boolean correct) {
        if (correct) {
            points++;
        } else {
            points--;
        }
        pointsLabel.setText("Points: " + points);
    }
}