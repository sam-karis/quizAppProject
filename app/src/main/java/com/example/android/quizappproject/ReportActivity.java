package com.example.android.quizappproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReportActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        setTextViewValue(R.id.report_first_name, PersonalActivity.firstName);
        setTextViewValue(R.id.report_last_name, PersonalActivity.lastName);
        setTextViewValue(R.id.report_marks_view, QuizActivity.totalMarks);
    }

    /**
     * The function takes a TextView id and set the value given
     *
     * @param textViewId - Target TextView id
     * @param valueToSet - Value to set
     */
    public void setTextViewValue(int textViewId, String valueToSet) {
        TextView textView = findViewById(textViewId);
        textView.setText(valueToSet);
    }
}