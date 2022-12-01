package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Button mainMenuBtn;
    Button topLeftBtn, topRightBtn, bottomLeftBtn, bottomRightBtn;
    TextView pointsLabel, answerLabel;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pointsLabel = (TextView) findViewById(R.id.points_label);
        answerLabel = (TextView) findViewById(R.id.answer_label);

        mainMenuBtn = (Button) findViewById(R.id.main_menu_btn);
        mainMenuBtn.setOnClickListener(view -> {
            Intent intent = new Intent(QuizActivity.this, MainActivity.class);
            startActivity(intent);
        });
        topLeftBtn = (Button) findViewById(R.id.top_left);
        topLeftBtn.setOnClickListener(view -> {
            System.out.println("This is the top left button");
            changePoints(topLeftBtn.getText().toString());
        });
        topRightBtn = (Button) findViewById(R.id.top_right);
        topRightBtn.setOnClickListener(view -> {
            System.out.println("This is the top right button");
            changePoints(topRightBtn.getText().toString());
        });
        bottomLeftBtn = (Button) findViewById(R.id.bottom_left);
        bottomLeftBtn.setOnClickListener(view -> {
            System.out.println("This is the bottom left button");
            changePoints(bottomLeftBtn.getText().toString());
        });
        bottomRightBtn = (Button) findViewById(R.id.bottom_right);
        bottomRightBtn.setOnClickListener(view -> {
            System.out.println("This is the bottom right button");
            changePoints(bottomRightBtn.getText().toString());
        });
    }

    private void changePoints(String buttonText) {
        if (pointsLabel.getText().toString().equals(buttonText)) {
            points++;
        } else {
            points--;
        }
        pointsLabel.setText("Points: " + points);
        selectLetter();
    }

    private void selectLetter() {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] chosen = new char[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rng = random.nextInt(26);
            chosen[i] = letters[rng];
        }
        int rng = random.nextInt(4);
        String answer = String.valueOf(chosen[rng]);
        answerLabel.setText(answer);
        topLeftBtn.setText(chosen[0]);
        topRightBtn.setText(chosen[1]);
        bottomLeftBtn.setText(chosen[2]);
        bottomRightBtn.setText(chosen[3]);
    }

//    private void selectColor() {
//        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
//        String[] chosen = new String[4];
//        Random random = new Random();
//        for (int i = 0; i < 4; i++) {
//            int rng = random.nextInt(26);
//            chosen[i] = colors[rng];
//        }
//        int rng = random.nextInt(4);
//        String answer = chosen[rng];
//        answerLabel.setText(answer);
//        topLeftBtn.setText(chosen[0]);
//        topRightBtn.setText(chosen[1]);
//        bottomLeftBtn.setText(chosen[2]);
//        bottomRightBtn.setText(chosen[3]);
//    }
}