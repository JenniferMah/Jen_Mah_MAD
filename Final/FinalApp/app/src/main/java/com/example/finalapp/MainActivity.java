package com.example.finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private String Name;
    private Button BuildButton;
    private RadioGroup RadioGroup;
    private Spinner spinner;
    private TextView DesText;
    private ImageView Image;
    private String item;
    private String Type;
    private ToggleButton toggle;
    private Switch switchitem;
    private String tortilla;
    private Button NewActivityButton;
    private mexicanFood myMex = new mexicanFood();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BuildButton = findViewById(R.id.button);
        DesText = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);
        RadioGroup =findViewById(R.id.radioGroup2);
        Image = findViewById(R.id.imageView);
        toggle = findViewById(R.id.toggleButton);
        switchitem = findViewById(R.id.switch1);
        NewActivityButton = findViewById(R.id.button2);



        View.OnClickListener onclick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeFood(v);
            }
        };
        BuildButton.setOnClickListener(onclick);


        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(v);
            }
        };
        NewActivityButton.setOnClickListener(click);


    }
    private void newActivity(View view){
        Integer locationIndex = spinner.getSelectedItemPosition();

        myMex.setLocation(locationIndex);
        String realLocation = myMex.getlocation();
        String realURL = myMex.getShareURL();
        Log.i("shop suggested", realLocation);
        Log.i("url suggested", realURL);
        Intent intent = new Intent(this,activity_mexicanFood.class);

        intent.putExtra("location", realLocation);
        intent.putExtra("url", realURL);


        startActivity(intent);


    }

    private void MakeFood(View view){
//        NAME
        EditText nameReference = findViewById(R.id.Name);
        Name = nameReference.getText().toString();
//        LOCATION
        String Location = String.valueOf(spinner.getSelectedItem());

//        RADIO BUTTON
        int TorB = RadioGroup.getCheckedRadioButtonId();
        if (TorB == -1 ||Name.equals("")){
//          TOAST
            Context context = getApplicationContext();
            CharSequence text = "Please fill out all of the questions above!";
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }else {
            if (TorB == R.id.burrito){
                item="burrito";
                Image.setImageResource(R.drawable.burrito);
            }else if (TorB == R.id.taco){
                item="taco";
                Image.setImageResource(R.drawable.taco);
            }
//        Toggle button
            boolean veggie = toggle.isChecked(); //if false then veggie if true then meat
            if (veggie == false){
                Type = "veggie";
            }else {
                Type="meat";
            }
//      SWITCH ITEM
            boolean ifOn = switchitem.isChecked(); //false if not on
            if(ifOn == false){
                tortilla = "flour tortilla";
            }else{
                tortilla = "corn tortilla";
            }

            DesText.setText(Name +" wants to order a "+ tortilla + " " +Type +" "+ item+ " on "+ Location );

        }

    }

}
