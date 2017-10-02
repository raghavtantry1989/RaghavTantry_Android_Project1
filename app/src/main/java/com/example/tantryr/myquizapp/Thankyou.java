package com.example.tantryr.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Thankyou extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.tantryr.myquizapp.MESSAGE";
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        score = Integer.parseInt(message);
        setScore();
    }

    private void setScore(){
        TextView scoreId = (TextView) findViewById(R.id.scoreId);
        String scoreResourceText = getString(R.string.final_score);
        scoreId.setText( scoreResourceText +" "+score);
    }
}
