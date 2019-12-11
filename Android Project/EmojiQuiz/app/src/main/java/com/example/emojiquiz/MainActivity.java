package com.example.emojiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    //PRIVATE VARS
    private int score; //my current index is also the score
    private int currentQuestionIndex;
    private questions questionsClass = new questions();
    private TextView referenceToHint;
    private TextView referenceToScore;
    private boolean hintPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentQuestionIndex = 0;
        score = 0;

        Button guessButton = findViewById(R.id.guessButton);
        Button hintButton = findViewById(R.id.hintButton);
        Button skipButton = findViewById(R.id.skipButton);
        referenceToHint = findViewById(R.id.hint);
        referenceToScore = findViewById(R.id.score);

        //create listener & add listener to button
        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess(v);
            }
        };
        guessButton.setOnClickListener(onclick);
        //create listener & add listener to button
        View.OnClickListener hintClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addHint(v);
            }
        };
        hintButton.setOnClickListener(hintClick);
        //create listener & add listener to button
        View.OnClickListener skipClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip(v);
            }
        };
        skipButton.setOnClickListener(skipClick);

        //THIS IS WHERE WE ADD THE IF STATEMENT for the bundle on the on save instance
        if (savedInstanceState !=null){
            score = savedInstanceState.getInt("score");
            currentQuestionIndex = savedInstanceState.getInt("currentIndex");
            hintPressed = savedInstanceState.getBoolean("hintPress");
            String stringScore= Integer.toString(score);
            referenceToScore.setText(stringScore);
            setImageDynamic();
            if(hintPressed){
                String hint = questionsClass.getHint();
                referenceToHint.setText(hint);
            }
        }
    }

    private void checkGuess(View view){
        referenceToHint.setText("");
        //get the guess from user
        EditText GuessReference = findViewById(R.id.guess);
        String UserGuess = GuessReference.getText().toString().toLowerCase();

        //Set the questions for quiz and get current answer
        questionsClass.setQuestions(currentQuestionIndex);
        String answer = questionsClass.getAnswer();

        if (UserGuess.equals(answer)){
            hintPressed = false;
            currentQuestionIndex = currentQuestionIndex + 1;
            score = score + 1;
            String stringScore= Integer.toString(score);
            referenceToScore.setText(stringScore);

            if (currentQuestionIndex == 8){
                endGame();
            }else {
                setImageDynamic();
                //clear text
                GuessReference.getText().clear();
            }
        }else {
            //Add in toast that it was incorrect.
            Context context = getApplicationContext();
            CharSequence text = "INCORRECT";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    private void addHint(View view){
        questionsClass.setQuestions(currentQuestionIndex);
        String hint = questionsClass.getHint();
        referenceToHint.setText(hint);
        hintPressed=true;
    }

    private void skip(View view){
        referenceToHint.setText("");
        currentQuestionIndex = currentQuestionIndex+1;
//        String stringScore= Integer.toString(score);
        if (currentQuestionIndex == 8){
            endGame();
        } else {
            setImageDynamic();
        }
    }
    private void endGame(){
        String stringScore= Integer.toString(score);
        Intent intent = new Intent(this,endGame.class);
        intent.putExtra("score", stringScore);
        startActivity(intent);
    }

    // To change the photo dynamically I used this stack overflow post to help me: https://stackoverflow.com/questions/11737607/how-to-set-the-image-from-drawable-dynamically-in-android
    private void setImageDynamic(){
        questionsClass.setQuestions(currentQuestionIndex);
        String movieName = questionsClass.getPhotoName();
        ImageView ReferenceToMovieImage = findViewById(R.id.Movie);
        int imageResource = getResources().getIdentifier(movieName, null, getPackageName());
        Drawable img = getResources().getDrawable(imageResource);
        ReferenceToMovieImage.setImageDrawable(img);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentIndex", currentQuestionIndex);
        outState.putInt("score", score);
        outState.putBoolean("hintPress", hintPressed);
    }
}

