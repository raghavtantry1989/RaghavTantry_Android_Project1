package com.example.tantryr.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Question4 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.tantryr.myquizapp.MESSAGE";
    int score;
    boolean is_score_given = false;
    int score_incrementer = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);

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
        RadioGroup answer = (RadioGroup) findViewById(R.id.answerRadioGroup);
        int answerId = answer.getCheckedRadioButtonId();

        if(answerId == -1){
            messageResource = R.string.select_an_option;
        }
        else{
            if(answerId == R.id.option1){
                messageResource = R.string.success;
                incrementScore();
            }
            else{
                messageResource = R.string.try_again;
            }
        }
        showToastMessages(messageResource);
    }

    private void incrementScore(){
        if(!is_score_given){
            score = score + score_incrementer;
            setScore();
            is_score_given = true;
        }
    }

    public void showNextQuestion(View view){
        Intent intent = new Intent(this,Question5.class);
        String message = "" + score;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void showToastMessages(int resource){
        Toast message = Toast.makeText(this,resource,Toast.LENGTH_SHORT);
        message.show();
    }
}
