package com.example.finalapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class activity_mexicanFood extends AppCompatActivity {
    private String Place;
    private String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mexican_food);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadSite(view);
            }
        });



        Intent intent = getIntent();
        Place = intent.getStringExtra("location");
        URL = intent.getStringExtra("url");

        Log.i("shop received", Place);
        Log.i("url received", URL);

        TextView messageView = findViewById(R.id.rest);
        messageView.setText("You should check out "+ Place);


    }

    private void loadSite(View view){
        Intent intent = new Intent((Intent.ACTION_VIEW));
        intent.setData(Uri.parse(URL));
        startActivity(intent);
    }

}
