package com.example.labeight;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class fortuneActivity extends AppCompatActivity {
    private String RealFortune;
    private String RealShareURL;
    private Integer RadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//GETTING FAB INFORMATION
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadShareSite(view);
            }
        });

        Intent intent = getIntent();
        RealFortune = intent.getStringExtra("fortune");
        RealShareURL = intent.getStringExtra("url");
        RadioButton = intent.getIntExtra("radio",1); //this will use a default value if no number is passed through

        Log.i("shop received", RealFortune);
        Log.i("url received", RealShareURL);

        TextView messageView = findViewById(R.id.fortune);
        messageView.setText(RealFortune + RadioButton);

    }

    //Implicit Intent
    private void loadShareSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(RealShareURL));
        startActivity(intent);
    }

}
