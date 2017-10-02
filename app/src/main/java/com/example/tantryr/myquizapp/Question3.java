package com.example.tantryr.myquizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.tantryr.myquizapp.MESSAGE";
    int score = 0;
    int score_incrementer = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);

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
        int messageResource;
        EditText answer = (EditText) findViewById(R.id.answerText);

        if(answer.getText().toString().isEmpty()){
            messageResource = R.string.enter_value;
        }
        else{
            if(answer.getText().toString().toLowerCase().equals("layout")){
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
        score = score + score_incrementer;
        setScore();
    }

    public void showNextQuestion(View view){
        Intent intent = new Intent(this,Question4.class);
        String message = "" + score;
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void showToastMessages(int resource){
        Toast message = Toast.makeText(this,resource,Toast.LENGTH_LONG);
        message.show();
    }
}
