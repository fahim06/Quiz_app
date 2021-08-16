package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Signup extends AppCompatActivity {
    EditText textUsername, textEmail, textPassword, textConfirmPassword;
    Button signup;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        textUsername = findViewById(R.id.username);
        textEmail = findViewById(R.id.email);
        textPassword = findViewById(R.id.password);
        textConfirmPassword = findViewById(R.id.confirmPassword);
        signup = findViewById(R.id.signup);
        mAuth = FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = textEmail.getText().toString().trim();
                String email = textEmail.getText().toString().trim();
                String password = textPassword.getText().toString().trim();
                String confirmPassword = textConfirmPassword.getText().toString().trim();


                if (TextUtils.isEmpty(username)) {

                    Toast.makeText(Signup.this, "Please Enter Username", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(email)) {

                    Toast.makeText(Signup.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(password)) {

                    Toast.makeText(Signup.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (TextUtils.isEmpty(confirmPassword)) {

                    Toast.makeText(Signup.this, "Please Enter Confirm Password", Toast.LENGTH_SHORT).show();
                    return;

                }

                if (password.length() < 6) {

                    Toast.makeText(Signup.this, "Password too short", Toast.LENGTH_SHORT).show();

                }

                if (password.equals(confirmPassword)) {
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Signup.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (task.isSuccessful()) {
                                        Toast.makeText(Signup.this, "Sign UP Successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));

                                    } else {
                                        Toast.makeText(Signup.this, "Error", Toast.LENGTH_SHORT).show();

                                    }


                                }
                            });


                }

            }

        });

    }
}