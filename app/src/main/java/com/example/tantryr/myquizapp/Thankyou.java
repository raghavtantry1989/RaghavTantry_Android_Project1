package com.example.tantryr.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Thankyou extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.tantryr.myquizapp.MESSAGE";
    int score;

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
        String scoreResourceText = getString(R.string.final_score);
        showToastMessages(scoreResourceText +" "+score);
    }

    private void showToastMessages(String message){
        Toast final_score = Toast.makeText(this,message,Toast.LENGTH_LONG);
        final_score.show();
    }
}
