package com.example.android.quizappproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    String correct_ans_color = "#FF03FC49";
    String wrong_ans_color = "#FFF2060A";
    public static String totalMarks = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    /**
     * Question two
     * The method check if a choice is checked and turn it color appropriately
     *
     * @param choiceId - id for a radio button
     * @return - boolean whether is checked or not
     */

    public boolean getRadioButtonStatus(int choiceId, String correctAns) {
        RadioButton radioButton = findViewById(choiceId);
        String radioText = radioButton.getText().toString();
        boolean correct = radioButton.isChecked();
        if (correct && radioText.equals(correctAns)) {
            radioButton.setTextColor(Color.parseColor(correct_ans_color));
        } else if (correct && !radioText.equals(correctAns)) {
            radioButton.setTextColor(Color.parseColor(wrong_ans_color));
        } else if (radioText.equals(correctAns)) {
            radioButton.setTextColor(Color.parseColor(correct_ans_color));
        }
        return correct;
    }


    /**
     * Question one and Four
     * The method check if a choice is checked and turn it color appropriately
     *
     * @param choiceId - id for a CheckBox
     * @return - boolean whether is checked or not
     */
    public boolean getCheckBoxStatus(int choiceId, String correctAns) {
        CheckBox checkBox = findViewById(choiceId);
        String checkBoxText = checkBox.getText().toString();
        boolean correct = checkBox.isChecked();
        if (correct && checkBoxText.equals(correctAns)) {
            checkBox.setTextColor(Color.parseColor(correct_ans_color));
        } else if (correct && !checkBoxText.equals(correctAns)) {
            checkBox.setTextColor(Color.parseColor(wrong_ans_color));
        } else if (checkBoxText.equals(correctAns)) {
            checkBox.setTextColor(Color.parseColor(correct_ans_color));
        }
        return correct;
    }

    /**
     * The function check which checkBoxes are checked(quiz 1) and if allocate marks appropriately
     * That is:-
     * if only correct answer is checked one get full 5 points
     * if the right with any other only scores 2 points out 5
     *
     * @return the points scored from the quiz 0ne
     */
    public int markQuizOne() {
        String correctAnsQuizOne = getString(R.string.quiz_one_e);
        boolean isAChecked = getCheckBoxStatus(R.id.quiz_one_choice_a, correctAnsQuizOne);
        boolean isBChecked = getCheckBoxStatus(R.id.quiz_one_choice_b, correctAnsQuizOne);
        boolean isCChecked = getCheckBoxStatus(R.id.quiz_one_choice_c, correctAnsQuizOne);
        boolean isDChecked = getCheckBoxStatus(R.id.quiz_one_choice_d, correctAnsQuizOne);
        boolean isEChecked = getCheckBoxStatus(R.id.quiz_one_choice_e, correctAnsQuizOne);

        int quiz_score = 0;

        if ((!isAChecked && !isBChecked && !isCChecked && !isDChecked) && (isEChecked)) {
            quiz_score = 5;
        } else if ((isEChecked) && (!isAChecked | !isBChecked | !isCChecked | !isDChecked)) {
            quiz_score = 2;
        }
        return quiz_score;
    }

    /**
     * The function get the radio box checked and if match the right answer maximum 5 points given
     *
     * @return the points scored from quiz 2
     */
    public int markQuizTwo() {
        String correctAnswerQuizTwo = getString(R.string.quiz_two_b);
        boolean isCChecked = getRadioButtonStatus(R.id.quiz_two_choice_c, correctAnswerQuizTwo);
        int quiz_score = 0;
        if (isCChecked) {
            quiz_score = 5;
        }
        return quiz_score;
    }

    /**
     * The function get the answer from the editText and compare it with the right answer
     * That is:-
     * if right 5 points are allocated
     * else 0 points and the right answer is returned instead
     *
     * @return the score points from quiz 3
     */
    public int markQuizThree() {
        String correctAns = getString(R.string.quiz_three_ans);
        String correctAnsA = getString(R.string.quiz_three_ans_a);
        EditText quizThreeAnswer = findViewById(R.id.quiz_three_ans);
        String givenAns = quizThreeAnswer.getText().toString();

        int quiz_score = 0;

        if (givenAns.equals(correctAns) | givenAns.equals(correctAnsA)) {
            quizThreeAnswer.setTextColor(Color.parseColor(correct_ans_color));
            quiz_score = 5;
        } else {
            quizThreeAnswer.setText(givenAns + " should be\n" + correctAns);
            quizThreeAnswer.setTextColor(Color.parseColor(wrong_ans_color));
        }
        return quiz_score;
    }

    /**
     * The function check which checkBoxes are checked(quiz 4) and if allocate marks appropriately
     * That is:-
     * if only correct answer is checked one get full 5 points
     * if the right with any other only scores 3 points out 5
     * if all are checked 0 points out 5
     * if the only one right with any other only scores 1 points out 5
     *
     * @return the points scored from the quiz 4
     */
    public int markQuizFour() {
        String correctAnsQuizOne = getString(R.string.quiz_four_d);
        String correctAnsBQuizOne = getString(R.string.quiz_four_g);
        boolean isAChecked = getCheckBoxStatus(R.id.quiz_four_choice_a, correctAnsQuizOne);
        boolean isBChecked = getCheckBoxStatus(R.id.quiz_four_choice_b, correctAnsQuizOne);
        boolean isCChecked = getCheckBoxStatus(R.id.quiz_four_choice_c, correctAnsQuizOne);
        boolean isDChecked = getCheckBoxStatus(R.id.quiz_four_choice_d, correctAnsQuizOne);
        boolean isEChecked = getCheckBoxStatus(R.id.quiz_four_choice_e, correctAnsQuizOne);
        boolean isFChecked = getCheckBoxStatus(R.id.quiz_four_choice_f, correctAnsQuizOne);
        boolean isGChecked = getCheckBoxStatus(R.id.quiz_four_choice_g, correctAnsBQuizOne);

        int quiz_score = 0;

        if ((!isAChecked && !isBChecked && !isCChecked && !isEChecked && !isFChecked) && (isDChecked && isGChecked)) {
            quiz_score = 5;
        } else if ((!isAChecked || !isBChecked || !isCChecked || !isEChecked || !isFChecked) && (isDChecked && isGChecked)) {
            quiz_score = 3;
        } else if (isAChecked && isBChecked && isCChecked && isDChecked && isEChecked && isFChecked && isGChecked) {
            quiz_score = 2;
        } else if (((!isDChecked && isGChecked) || (isDChecked && !isGChecked)) &&
                (!isAChecked || !isBChecked || !isCChecked || !isEChecked || !isFChecked)) {
            quiz_score = 1;
        }
        return quiz_score;
    }

    /**
     * The function is called when you click submit button
     * It call functions above to calculate marks from each question the add the total
     * Call the display function to display the results
     * Also set the submit button inactive once clicked
     * It also display a Toast message to congratulates for completing the test
     * @param V- view
     */
    public void submitTest(View V) {
        String userName = PersonalActivity.firstName + " " + PersonalActivity.lastName;

        float marks = markQuizOne();
        marks += markQuizTwo();
        marks += markQuizThree();
        marks += markQuizFour();
        marks = (marks / 20) * 100;
        totalMarks = Float.toString((int) marks);
        String result = "Hi " + userName;
        result = result + "\n"+getString(R.string.report_message_view) + marks;

        Button submitButton = findViewById(R.id.submit_button);
        submitButton.setClickable(false);

        displayResult(result);
        Toast.makeText(this, "Congrats for completing the test", Toast.LENGTH_SHORT).show();

    }

    /**
     * the function take a string and display it on the screen
     *
     * @param results - Return the message inputted as an argument
     */
    public void displayResult(String results) {
        TextView resultTextView = findViewById(R.id.result_text_view);
        resultTextView.setText(results);
    }

    /**
     * The function is called when report button is clicked
     * If the submit button is inactive it start the ReportActivity
     *
     * @param V - View
     */
    public void reportButton(View V) {
        Button submitButton = findViewById(R.id.submit_button);
        if (!submitButton.isClickable()) {
            Intent intent = new Intent(this, ReportActivity.class);
            startActivity(intent);
        }
    }
}

