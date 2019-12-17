package com.example.labeight;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private Spinner themeSpinner;
    private shareFortune myFortune = new shareFortune();
    private RadioGroup RadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        themeSpinner =findViewById(R.id.spinner);
        button = findViewById(R.id.button);
        //RADIO GROUP
        RadioGroup = findViewById(R.id.radiogroup);


        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createFortune(v);
            }
        };
        button.setOnClickListener(onclick);
    }

    private void createFortune(View view){
        //GET SELECTED RADIO BUTTON
        int numberId = RadioGroup.getCheckedRadioButtonId();

        Integer theme = themeSpinner.getSelectedItemPosition();
        myFortune.setFortune(theme);
        String realFortune = myFortune.getFortune();
        String realURL = myFortune.getShareURL();

        Intent intent = new Intent(this,fortuneActivity.class);

        if(numberId == R.id.radioButton){
            intent.putExtra("radio",numberId );
        }
        intent.putExtra("fortune", realFortune);
        intent.putExtra("url", realURL);
        startActivity(intent);


    }
}
