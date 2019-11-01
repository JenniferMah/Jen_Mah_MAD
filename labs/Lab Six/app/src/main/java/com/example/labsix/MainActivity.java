package com.example.labsix;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("ResourceAsColor")
    public void checkRiddle(View view){
        EditText ReferenceToInput =findViewById(R.id.userAnswer);
        String guess = ReferenceToInput.getText().toString().toLowerCase();



        ImageView ReferenceToImageView = findViewById(R.id.imageView);
        TextView ReferenceToNote=findViewById(R.id.note);

        if (guess.equals("see o double you")){
            ReferenceToImageView.setImageResource(R.drawable.right);
            ReferenceToNote.setText("Correct");
            ReferenceToNote.setTextColor(Color.GREEN);
        }else{
            ReferenceToImageView.setImageResource(R.drawable.sad);
            ReferenceToNote.setText("Incorrect");
            ReferenceToNote.setTextColor(Color.RED);
        }

    }



}
