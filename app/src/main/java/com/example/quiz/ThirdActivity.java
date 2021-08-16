package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
    TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        resultView = findViewById(R.id.resultID);
        Intent mygetIntent = getIntent();
        int number = mygetIntent.getIntExtra(SecondActivity.TotalMarksData, 0);
        resultView.setText("You got " + number + " out of 30");
    }

    public void tryAgainFunction(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);
    }

}