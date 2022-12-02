package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Intent intent;
    Bundle extras;
    Button mainMenuBtn;
    Button showAnswerBtn;
    Button topLeftBtn, topRightBtn, bottomLeftBtn, bottomRightBtn;
    TextView pointsLabel, answerLabel;
    ImageView colorSquare;
    int points = 0;
    String quizType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        intent = getIntent();
        extras = intent.getExtras();
        quizType = extras.getString("quizType");

        pointsLabel = (TextView) findViewById(R.id.points_label);
        answerLabel = (TextView) findViewById(R.id.answer_label);
        answerLabel.setVisibility(View.INVISIBLE);

        colorSquare = (ImageView) findViewById(R.id.color_square);

        showAnswerBtn = (Button) findViewById(R.id.show_answer);
        showAnswerBtn.setOnClickListener(view -> {
            answerLabel.setVisibility(View.VISIBLE);
        });

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

        if (quizType.equals("colors")) {
            selectColor();
        } else {
            selectLetter();
        }
    }

    private void changePoints(String buttonText) {
        String answer = answerLabel.getText().toString();
        if (answer.equals(buttonText)) {
            points++;
        }
        pointsLabel.setText("Points: " + points);
        answerLabel.setVisibility(View.INVISIBLE);
        if (quizType.equals("colors")) {
            selectColor();
        } else {
            selectLetter();
        }
    }

    private void selectLetter() {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] chosen = new String[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rng = random.nextInt(26);
            if (i != 0) {
                while (chosen[i - 1] == letters[rng]) {
                    rng = random.nextInt(26);
                }
            }
            chosen[i] = letters[rng];
        }
        int rng = random.nextInt(4);
        String answer = chosen[rng];
        answerLabel.setText(answer);
        topLeftBtn.setText(chosen[0]);
        topRightBtn.setText(chosen[1]);
        bottomLeftBtn.setText(chosen[2]);
        bottomRightBtn.setText(chosen[3]);
    }

    private void selectColor() {
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
        String[] chosen = new String[4];
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rng = random.nextInt(6);
            if (i != 0) {
                while (chosen[i - 1] == colors[rng]) {
                    rng = random.nextInt(6);
                }
            }
            chosen[i] = colors[rng];
        }
        int rng = random.nextInt(4);
        String answer = chosen[rng];
        switch (answer) {
            case "red":
                colorSquare.setBackgroundResource(R.color.custom_red);
                break;
            case "orange":
                colorSquare.setBackgroundResource(R.color.custom_orange);
                break;
            case "yellow":
                colorSquare.setBackgroundResource(R.color.custom_yellow);
                break;
            case "green":
                colorSquare.setBackgroundResource(R.color.custom_green);
                break;
            case "blue":
                colorSquare.setBackgroundResource(R.color.custom_blue);
                break;
            case "purple":
                colorSquare.setBackgroundResource(R.color.custom_purple);
                break;
            default:
                break;
        }
        answerLabel.setText(answer);
        topLeftBtn.setText(chosen[0]);
        topRightBtn.setText(chosen[1]);
        bottomLeftBtn.setText(chosen[2]);
        bottomRightBtn.setText(chosen[3]);
    }
}