package com.example.quizprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int score;
    private questions BigArray[];
    private int currentPosition;
    //These are placeholders for now because I don't have the id's or values already assigned
    private String guess;

    //Arrays to populate class instances
    private int[] PictureArray = {
     // All of these will be the photos for each of the questions
            //R.drawable.star_00,
            //R.drawable.star_01,
            //R.drawable.star_02,
    };
    private String hints[]={
            //This will be an array of hints for each of the questions
    };
    private String answers[]={
            //This will be an array of answers
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //For loop for the length of hints
//        in for for loop create a new instance of the questions class
            // instanceOfClass = new Questions
//        create a setter for the items in the class
            // instanceOfClass.setters(PicturesArray[i],hints[i],answers[i]);
            // BigArray[i]= instanceOfClass;

    }


    //Function to check the answer & iterate to next item in the array
    private void checkAnswer(View view){
        //get guess from text view
        //if textview === BigArray[currentPosition].answer;
            //current position +1
            //change image
            //score + 1
    }

    //Function will display hint to the text display to help the user guess the answer
    private void clickHint(View view){
        //load in the hint into displayed text
    }

    //functions to skip the current question
    private void skip(){
        //currentPostion+1
        //set the next image as the current displayed item

    }

    //Need to send current guess, current position, score when rotating the phone
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("userGuess", guess);
        outState.putInt("pos", currentPosition);
        outState.putInt("currentCore", score);

    }

}
