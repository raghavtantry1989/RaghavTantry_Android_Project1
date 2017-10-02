package com.example.tantryr.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.tantryr.myquizapp.MESSAGE";
    int score = 0;
    int score_incrementer = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        score = Integer.parseInt(message);
        setScore();
    }

    private void setScore(){
        TextView scoreId = (TextView) findViewById(R.id.scoreId);
        String scoreResourceText = getString(R.string.score);
        scoreId.setText( scoreResourceText +" "+score);
    }

    public void submitAnswer(View view){
        int messageResource = 0;
        CheckBox option1 = (CheckBox) findViewById(R.id.option1);
        CheckBox option2 = (CheckBox) findViewById(R.id.option2);
        CheckBox option3 = (CheckBox) findViewById(R.id.option3);
        CheckBox option4 = (CheckBox) findViewById(R.id.option4);

        if(option1.isChecked() || option2.isChecked() || option3.isChecked() || option4.isChecked()){
            if(option1.isChecked() && option4.isChecked()){
                messageResource = R.string.success;
                incrementScore();
            }
            else{
                messageResource = R.string.try_again;
            }
        }
        else{
            messageResource = R.string.select_an_option;
        }
        showToastMessages(messageResource);
    }

    private void incrementScore(){
        score = score + score_incrementer;
        setScore();
    }

    public void showNextQuestion(View view){
        Intent intent = new Intent(this,Question3.class);
        String message = "" + score;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void showToastMessages(int resource){
        Toast message = Toast.makeText(this,resource,Toast.LENGTH_LONG);
        message.show();
    }
}
