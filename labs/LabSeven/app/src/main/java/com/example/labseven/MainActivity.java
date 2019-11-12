package com.example.labseven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.file.StandardWatchEventKinds;

public class MainActivity extends AppCompatActivity {
//    private vars
    private EditText petName;
    private TextView dogBreed;
    private ImageView dogPhoto;
    private Spinner location;
    private RadioGroup cost;
    private CheckBox play;
    private CheckBox loyal;
    private CheckBox affection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get all the views
        petName = findViewById(R.id.editText);
        dogBreed = findViewById(R.id.dogBreed);
        dogPhoto = findViewById(R.id.dogPhoto);
        location = findViewById(R.id.location);
        cost = findViewById(R.id.cost);
        play = findViewById(R.id.play);
        loyal = findViewById(R.id.loyal);
        affection = findViewById(R.id.affection);


    }

    public void findDog(View view){
        //name of pet
        String name = petName.getText().toString();
        //Type of house you live in
        String homeLocation = String.valueOf(location.getSelectedItem());

        //cost
        int costID = cost.getCheckedRadioButtonId();

        //checkboxes
        Boolean playCheck = play.isChecked();
        Boolean loyalCheck = loyal.isChecked();
        Boolean affectionCheck = affection.isChecked();

        //string for dog breed
        String perfectDog;

        //radio buttons
        if (costID == -1 ||name.equals("")){
            //toast error
            Context context = getApplicationContext();
            CharSequence text = "Please fill out all of the questions above!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else{
            if (costID == R.id.threeDollar){
                switch (homeLocation) {
                    case "House":
                        perfectDog = "bernese mountain dog";
                        dogPhoto.setImageResource(R.drawable.bernese);
                        if( playCheck == true){
                            perfectDog = "dalmatian";
                            dogPhoto.setImageResource(R.drawable.dal);
                        }
                        break;
                    case "Apartment":
                        perfectDog = "french bulldog";
                        dogPhoto.setImageResource(R.drawable.french);
                        break;
                    case "Town Home":
                        perfectDog = "bull terrier";
                        dogPhoto.setImageResource(R.drawable.bull);
                        break;
                    default:
                        perfectDog = "bernese mountain dog";
                        dogPhoto.setImageResource(R.drawable.bernese);
                }
            }
            else if (costID == R.id.twoDollar){
                switch (homeLocation) {
                    case "House":
                        perfectDog = "shiba inu";
                        dogPhoto.setImageResource(R.drawable.shiba);
                        if (loyalCheck){
                            perfectDog = "rottweiler";
                            dogPhoto.setImageResource(R.drawable.rot);
                        }
                        break;
                    case "Apartment":
                        perfectDog = "pug";
                        dogPhoto.setImageResource(R.drawable.pug);
                        break;
                    case "Town Home":
                        perfectDog = "West Highland White Terrier";
                        dogPhoto.setImageResource(R.drawable.white);
                        if(affectionCheck == true & loyalCheck==true ){
                            perfectDog = "cocker spaniel";
                            dogPhoto.setImageResource(R.drawable.cocker);
                        }
                        break;
                    default:
                        perfectDog = "shiba inu";
                        dogPhoto.setImageResource(R.drawable.shiba);
                }
            }
            else{
                switch (homeLocation) {
                    case "House":
                        perfectDog = "yellow lab";
                        dogPhoto.setImageResource(R.drawable.lab);
                        break;
                    case "Apartment":
                        perfectDog = "chihuahua";
                        dogPhoto.setImageResource(R.drawable.chi);
                        if(affectionCheck == true){
                            perfectDog = "cocker spaniel";
                            dogPhoto.setImageResource(R.drawable.cocker);
                        }
                        break;
                    case "Town Home":
                        perfectDog = "schnauzer";
                        dogPhoto.setImageResource(R.drawable.schnauzer);
                        break;
                    default:
                        perfectDog = "yellow lab";
                        dogPhoto.setImageResource(R.drawable.lab);
                }
            }
            dogBreed.setText("Since you and " + name +" will live in a "+ homeLocation.toLowerCase()  +" you should get a " + perfectDog +"!");
        }


    }


}
