package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    final static String TotalMarksData = "From second activity";
    int totalMarks = 0;
    RadioGroup radioGroup4, radioGroup5, radioGroup6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent myintent = getIntent();
        totalMarks = myintent.getIntExtra(SecondActivity.TotalMarksData, 0);
        radioGroup4 = findViewById(R.id.question4RadioGroup);
        radioGroup5 = findViewById(R.id.question5RadioGroup);
        radioGroup6 = findViewById(R.id.question6RadioGroup);
    }

    public void PreviousFunction(View view) {
        Intent myIntent = new Intent(this, MainActivity.class);
        startActivity(myIntent);

    }

    public void finalSubmission(View view) {
        if (radioGroup4.getCheckedRadioButtonId() == R.id.question4option2) {
            totalMarks += 5;
        }
        if (radioGroup5.getCheckedRadioButtonId() == R.id.question5option3) {
            totalMarks += 5;
        }
        if (radioGroup6.getCheckedRadioButtonId() == R.id.question6option1) {
            totalMarks += 5;
        }
        Intent myIntent = new Intent(this, ThirdActivity.class);
        myIntent.putExtra(TotalMarksData, totalMarks);
        startActivity(myIntent);

    }
}