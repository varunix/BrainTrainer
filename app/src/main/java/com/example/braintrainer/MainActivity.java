package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button startButton;
    TextView resultTextView;
    TextView scoreTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAns;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView sumTextView;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout constraintLayout;

    public void playAgain(View view){
        constraintLayout.setVisibility(View.VISIBLE);
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText("0/0");
        resultTextView.setText("");
        playAgainButton.setVisibility(View.INVISIBLE);
        generateQuestions();
        new CountDownTimer(30100,1000){

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText(String.valueOf(millisUntilFinished/1000)+"s");
            }

            @Override
            public void onFinish() {
                constraintLayout.setVisibility(View.INVISIBLE);
                resultTextView.setVisibility(View.VISIBLE);
                playAgainButton.setVisibility(View.VISIBLE);
                resultTextView.setText("Your Score:"+Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
            }
        }.start();
    }

    public void generateQuestions(){
        Random random = new Random();
        int a = random.nextInt(21);
        int b = random.nextInt(21);
        sumTextView.setText(Integer.toString(a)+"+"+Integer.toString(b));
        int incorrectAns;
        locationOfCorrectAns = random.nextInt(4);
        answers.clear();
        for(int i = 0; i < 4; i++){
            if(i == locationOfCorrectAns){
                answers.add(a+b);
            }else{
                incorrectAns = random.nextInt(41);
                while(incorrectAns == (a+b)){
                    incorrectAns = random.nextInt(41);
                }
                answers.add(incorrectAns);
            }
        }
        if(answers.get(0) <= 9){
            button0.setText("0"+Integer.toString(answers.get(0)));
        }else{
            button0.setText(Integer.toString(answers.get(0)));
        }
        if(answers.get(1) <= 9){
            button1.setText("0"+Integer.toString(answers.get(1)));
        }else{
            button1.setText(Integer.toString(answers.get(1)));
        }
        if(answers.get(2) <= 9){
            button2.setText("0"+Integer.toString(answers.get(2)));
        }else{
            button2.setText(Integer.toString(answers.get(2)));
        }
        if(answers.get(3) <= 9){
            button3.setText("0"+Integer.toString(answers.get(3)));
        }
        else{
            button3.setText(Integer.toString(answers.get(3)));
        }
    }

    public void chooseAnswer(View view){
        if(view.getTag().toString().equals(Integer.toString(locationOfCorrectAns))){
            score++;
            resultTextView.setText("CORRECT!");
        }else{
            resultTextView.setText("WRONG!");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        generateQuestions();
    }

    public void start(View view){
        startButton.setVisibility(View.INVISIBLE);
        constraintLayout.setVisibility(View.VISIBLE);
        playAgain(findViewById(R.id.playAgainButton));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.startButton);
        button0 = findViewById(R.id.button2);
        button1 = findViewById(R.id.button3);
        button2 = findViewById(R.id.button4);
        button3 = findViewById(R.id.button5);
        playAgainButton = findViewById(R.id.playAgainButton);
        resultTextView = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        sumTextView = (TextView) findViewById(R.id.sumTextView);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        constraintLayout = findViewById(R.id.constraintLayout);
        Toast.makeText(this, "By Varun Chaubey", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {

    }
}