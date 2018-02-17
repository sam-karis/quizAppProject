package com.example.android.quizappproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * The function create an intent that start the personal activity
     *
     * @param view - view
     */
    public void nextButton(View view) {
        Intent intent = new Intent(this, PersonalActivity.class);
        startActivity(intent);
    }

}
