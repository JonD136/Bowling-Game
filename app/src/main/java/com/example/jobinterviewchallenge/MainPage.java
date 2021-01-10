package com.example.jobinterviewchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainPage extends AppCompatActivity {

    EditText playerOneInput;
    Button btnBeginBowling;

    String playerOnePass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Input player one name
        playerOneInput = (EditText) findViewById(R.id.enterPlayerOneName);

        // Submitting button info
        btnBeginBowling = (Button) findViewById(R.id.btnBeginBowling);


        //onClick it goes to next page
        btnBeginBowling.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(playerOneInput.getText())) {

                    playerOneInput.setError("Enter a name!");

                } else {

                    startActivity(new Intent(MainPage.this, BowlingGame.class));


                    Intent i = new Intent(MainPage.this, BowlingGame.class);

                    playerOnePass = playerOneInput.getText().toString();

                    i.putExtra("valueOne", playerOnePass);

                    startActivity(i);

                    finish();
                }
            }

        });

    }


    public void showToast(String text) {
        Toast.makeText(MainPage.this, text, Toast.LENGTH_SHORT).show();
    }


}
