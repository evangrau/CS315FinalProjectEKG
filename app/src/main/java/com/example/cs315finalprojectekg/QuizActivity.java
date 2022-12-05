package com.example.cs315finalprojectekg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    Intent intent;
    Bundle extras;
    Button mainMenuBtn;
    Button showAnswerBtn;
    Button topLeftBtn, topRightBtn, bottomLeftBtn, bottomRightBtn;
    TextView pointsLabel, answerLabel;
    ImageView colorSquare;
    int points = 0, balance = 0, numClicks = 0;
    String quizType;
    MediaPlayer aSound, bSound, cSound, dSound, eSound, fSound, gSound, hSound, iSound, jSound, kSound, lSound, mSound,
            nSound, oSound, pSound, qSound, rSound, sSound, tSound, uSound, vSound, wSound, xSound, ySound, zSound;
    MediaPlayer cheer;

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

        aSound = MediaPlayer.create(this, R.raw.a_audio);
        bSound = MediaPlayer.create(this, R.raw.b_audio);
        cSound = MediaPlayer.create(this, R.raw.c_audio);
        dSound = MediaPlayer.create(this, R.raw.d_audio);
        eSound = MediaPlayer.create(this, R.raw.e_audio);
        fSound = MediaPlayer.create(this, R.raw.f_audio);
        gSound = MediaPlayer.create(this, R.raw.g_audio);
        hSound = MediaPlayer.create(this, R.raw.h_audio);
        iSound = MediaPlayer.create(this, R.raw.i_audio);
        jSound = MediaPlayer.create(this, R.raw.j_audio);
        kSound = MediaPlayer.create(this, R.raw.k_audio);
        lSound = MediaPlayer.create(this, R.raw.l_audio);
        mSound = MediaPlayer.create(this, R.raw.m_audio);
        nSound = MediaPlayer.create(this, R.raw.n_audio);
        oSound = MediaPlayer.create(this, R.raw.o_audio);
        pSound = MediaPlayer.create(this, R.raw.p_audio);
        qSound = MediaPlayer.create(this, R.raw.q_audio);
        rSound = MediaPlayer.create(this, R.raw.r_audio);
        sSound = MediaPlayer.create(this, R.raw.s_audio);
        tSound = MediaPlayer.create(this, R.raw.t_audio);
        uSound = MediaPlayer.create(this, R.raw.u_audio);
        vSound = MediaPlayer.create(this, R.raw.v_audio);
        wSound = MediaPlayer.create(this, R.raw.w_audio);
        xSound = MediaPlayer.create(this, R.raw.x_audio);
        ySound = MediaPlayer.create(this, R.raw.y_audio);
        zSound = MediaPlayer.create(this, R.raw.z_audio);

        cheer = MediaPlayer.create(this, R.raw.cheering);

        showAnswerBtn = (Button) findViewById(R.id.show_answer);
        showAnswerBtn.setOnClickListener(view -> {
            if (answerLabel.getVisibility() == View.INVISIBLE) {
                answerLabel.setVisibility(View.VISIBLE);
                showAnswerBtn.setText(R.string.hide_answer);
                points--;
                if (numClicks > 1) {
                    balance++;
                }
            } else {
                answerLabel.setVisibility(View.INVISIBLE);
                showAnswerBtn.setText(R.string.show_answer);
            }
            numClicks++;
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
        if (quizType.equals("letters")) {
            answer = String.valueOf(answer.charAt(1));
        }
        if (answer.equals(buttonText)) {
            points++;
            points += balance;
        }
        balance = 0;
        numClicks = 0;
        pointsLabel.setText("Points: " + points);
        if (points == 20) {
            cheer.start();
        }
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
        Map<String,String> chosenMap = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rng = random.nextInt(26);
            while (chosenMap.containsKey(letters[rng])) {
                rng = random.nextInt(6);
            }
            chosenMap.put(letters[rng],letters[rng]);
            chosen[i] = letters[rng];
        }
        int rng = random.nextInt(4);
        String answer = chosen[rng];
        answerLabel.setText(answer.toUpperCase() + answer);
        topLeftBtn.setText(chosen[0]);
        topRightBtn.setText(chosen[1]);
        bottomLeftBtn.setText(chosen[2]);
        bottomRightBtn.setText(chosen[3]);
        playSound(answer);
    }

    private void selectColor() {
        String[] colors = {"red", "orange", "yellow", "green", "blue", "purple"};
        String[] chosen = new String[4];
        Map<String,String> chosenMap = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int rng = random.nextInt(6);
            while (chosenMap.containsKey(colors[rng])) {
                rng = random.nextInt(6);
            }
            chosenMap.put(colors[rng],colors[rng]);
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

    private void playSound(String answer) {
        switch (answer) {
            case "a":
                aSound.start();
                break;
            case "b":
                bSound.start();
                break;
            case "c":
                cSound.start();
                break;
            case "d":
                dSound.start();
                break;
            case "e":
                eSound.start();
                break;
            case "f":
                fSound.start();
                break;
            case "g":
                gSound.start();
                break;
            case "h":
                hSound.start();
                break;
            case "i":
                iSound.start();
                break;
            case "j":
                jSound.start();
                break;
            case "k":
                kSound.start();
                break;
            case "l":
                lSound.start();
                break;
            case "m":
                mSound.start();
                break;
            case "n":
                nSound.start();
                break;
            case "o":
                oSound.start();
                break;
            case "p":
                pSound.start();
                break;
            case "q":
                qSound.start();
                break;
            case "r":
                rSound.start();
                break;
            case "s":
                sSound.start();
                break;
            case "t":
                tSound.start();
                break;
            case "u":
                uSound.start();
                break;
            case "v":
                vSound.start();
                break;
            case "w":
                wSound.start();
                break;
            case "x":
                xSound.start();
                break;
            case "y":
                ySound.start();
                break;
            case "z":
                zSound.start();
                break;
            default:
                break;
        }
    }
}