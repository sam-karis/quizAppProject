package com.example.android.quizappproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PersonalActivity extends AppCompatActivity {

    public static String firstName;
    public static String lastName;
    public static String userNameEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
    }

    public void startButton(View view) {
        EditText firstNameEditText = findViewById(R.id.firstName_editText);
        firstName = firstNameEditText.getText().toString();
        EditText lastNameEditText = findViewById(R.id.lastName_editText);
        lastName = lastNameEditText.getText().toString();
        EditText emailNameEditText = findViewById(R.id.userEmail_editText);
        userNameEmail = emailNameEditText.getText().toString();

        if (TextUtils.isEmpty(firstName) || TextUtils.isEmpty(lastName) || TextUtils.isEmpty(userNameEmail)) {
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        }
    }
}
