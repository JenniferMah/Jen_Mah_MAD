package com.example.labeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner themeSpinner;
    private shareFortune myFortune = new shareFortune();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themeSpinner =findViewById(R.id.spinner);
        button = findViewById(R.id.button);

        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFortune(v);
            }
        };
        button.setOnClickListener(onclick);
    }

    private void createFortune(View view){
        Integer theme = themeSpinner.getSelectedItemPosition();
        myFortune.setFortune(theme);
        String realFortune = myFortune.getFortune();
        String realURL = myFortune.getShareURL();

        Intent intent = new Intent(this,fortuneActivity.class);


        intent.putExtra("fortune", realFortune);
        intent.putExtra("url", realURL);
        startActivity(intent);


    }
}
