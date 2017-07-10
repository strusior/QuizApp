package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    // when check button is touched
    public void onCheckButtonClicked(View view) {

        // question1 with user input
        EditText answer1 = (EditText) findViewById(R.id.question1);
        String answered1 = answer1.getText().toString();

        // question2 with radio button
        RadioButton answer2yes = (RadioButton) findViewById(R.id.question2_yes);
        boolean answered2yes = answer2yes.isChecked();

        // question3 with radio button
        RadioButton answer3yes = (RadioButton) findViewById(R.id.question3_yes);
        boolean answered3yes = answer3yes.isChecked();

        // question4 with 3 checkboxes
        CheckBox answer4A = (CheckBox) findViewById(R.id.question4_check_box1);
        boolean answered4A = answer4A.isChecked();

        CheckBox answer4B = (CheckBox) findViewById(R.id.question4_check_box2);
        boolean answered4B = answer4B.isChecked();

        CheckBox answer4C = (CheckBox) findViewById(R.id.question4_check_box3);
        boolean answered4C = answer4C.isChecked();

        // check if all answers were correct
        if (answered1.equals("Udacity") &&
                answered2yes &&
                answered3yes &&
                answered4A &&
                answered4B &&
                !answered4C
                )
            // inform user about his nice result
            Toast.makeText(this, "All answers are correct", Toast.LENGTH_LONG).show();
        else {
            // check if the user didn't forget to use capital letters
            if (answered1.equals("udacity") &&
                    answered2yes &&
                    answered3yes &&
                    answered4A &&
                    answered4B &&
                    !answered4C
                    )
                // remind user about importance of correct spelling
                Toast.makeText(this, "All answers are correct but please remember\n" +
                        "to write names with capital letters", Toast.LENGTH_LONG).show();
        }

        // code in each "if" is executed if given question was answered wrong
        // variable for storing info on which question was answered wrong
        String whatIsWrong = "";

        // variable for counting points
        int pointCount = 4;

        // if question1 is wrong subtract 1 point
        if (!answered1.equalsIgnoreCase("Udacity")) {
            whatIsWrong = "\nanswer1";
            pointCount--;
        }
        // if question2 is wrong subtract 1 point
        if (!answered2yes) {
            whatIsWrong = whatIsWrong + "\nanswer2";
            pointCount--;
        }
        // if question3 is wrong subtract 1 point
        if (!answered3yes) {
            whatIsWrong = whatIsWrong + "\nanswer3";
            pointCount--;
        }
        // if question4 is wrong subtract 1 point
        if (!answered4A || !answered4B || answered4C) {
            whatIsWrong = whatIsWrong + "\nanswer4";
            pointCount--;
        }

        // if one or more questions were answered wrong inform the user
        if (pointCount < 4)
        Toast.makeText(this, "You earned " + pointCount + " points\n" +
                "You got these answers wrong: " + whatIsWrong, Toast.LENGTH_LONG).show();

    }

}
