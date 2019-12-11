package com.example.emojiquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class endGame extends AppCompatActivity {
    private TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);

        Intent intent = getIntent();
        String scores = intent.getStringExtra("score");

        TextView messageView = findViewById(R.id.Message);
        int numberScore = Integer.parseInt(scores);
        if(numberScore > 5){
            messageView.setText("You win! Your final score is: "+ scores );
            messageView.setTextColor(Color.GREEN);


        }else{
            messageView.setText("You lose! Your final score is: "+ scores );
            messageView.setTextColor(Color.RED);

        }

    }

}
