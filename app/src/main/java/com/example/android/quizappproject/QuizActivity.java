package com.example.android.quizappproject;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    String correct_ans_color = "#FF03FC49";
    String wrong_ans_color = "#FFF2060A";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }


    public int markQuizOne() {
        CheckBox choiceACheckBox = findViewById(R.id.quiz_one_choice_a);
        boolean isAChecked = choiceACheckBox.isChecked();
        if (isAChecked) {
            choiceACheckBox.setTextColor(Color.parseColor(wrong_ans_color));
        }

        CheckBox choiceBCheckBox = findViewById(R.id.quiz_one_choice_b);
        boolean isBChecked = choiceBCheckBox.isChecked();
        if (isBChecked) {
            choiceBCheckBox.setTextColor(Color.parseColor(wrong_ans_color));
        }

        CheckBox choiceCCheckBox = findViewById(R.id.quiz_one_choice_c);
        boolean isCChecked = choiceCCheckBox.isChecked();
        if (isCChecked) {
            choiceCCheckBox.setTextColor(Color.parseColor(wrong_ans_color));
        }

        CheckBox choiceDCheckBox = findViewById(R.id.quiz_one_choice_d);
        boolean isDChecked = choiceDCheckBox.isChecked();
        if (isDChecked) {
            choiceDCheckBox.setTextColor(Color.parseColor(wrong_ans_color));
        }

        CheckBox choiceECheckBox = findViewById(R.id.quiz_one_choice_e);
        boolean isEChecked = choiceECheckBox.isChecked();
        choiceECheckBox.setChecked(true);
        choiceECheckBox.setTextColor(Color.parseColor(correct_ans_color));

        int quiz_score = 0;

        if ((!isAChecked && !isBChecked && !isCChecked && !isDChecked) && (isEChecked)) {
            quiz_score = 5;
        } else if ((isEChecked) && (!isAChecked | !isBChecked | !isCChecked | !isDChecked)) {
            quiz_score = 2;
        }
        return quiz_score;
    }

    public int markQuizThree() {
        String correctAns = "String userName = 'Joan';";
        EditText quizThreeAnswer = findViewById(R.id.quiz_three_ans);
        String givenAns = quizThreeAnswer.getText().toString();

        int quiz_score = 0;

        if (givenAns.equals(correctAns)) {
            quizThreeAnswer.setTextColor(Color.parseColor(correct_ans_color));
            quiz_score = 2;
        } else {
            quizThreeAnswer.setText(correctAns);
            quizThreeAnswer.setTextColor(Color.parseColor(wrong_ans_color));
        }
        return quiz_score;
    }

    public void submitTest(View View) {
        EditText userNameEditText = findViewById(R.id.firstName_editText);
        String userName = PersonalActivity.firstName + " " + PersonalActivity.lastName;

        int marks = markQuizOne();
        marks += markQuizThree();
        String result = "Hi " + userName;
        result = result + "\nYou Score is " + marks;
        result = result + "\nOut of 25 points";

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setClickable(false);

        displayResult(result);
        Toast.makeText(this, "Cograts for completing the test", Toast.LENGTH_SHORT).show();

    }

    public void displayResult(String results) {
        TextView resultTextView = findViewById(R.id.result_text_view);
        resultTextView.setText(results);
    }
}

